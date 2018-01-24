package me.roy.upload;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.leo618.zip.IZipCallback;
import com.leo618.zip.ZipManager;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "zip~doing";

  String url = "http://192.168.3.13:8081/obpm/FaceRecognitionUploadServlet";
  public String sourcePath =
      Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_DOWNLOADS;
  String destPath = Environment.getExternalStorageDirectory().getAbsolutePath();
  String zipName = destPath + "/zipfile.zip";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void zip(View view) {
    Log.d(TAG, "sourcePath: " + sourcePath);
    Log.d(TAG, "zipName: " + zipName);
    ZipManager.zip(sourcePath, zipName, new IZipCallback() {
      @Override
      public void onStart() {
        loadingShow(-1);
      }

      @Override
      public void onProgress(int percentDone) {
        loadingShow(percentDone);
      }

      @Override
      public void onFinish(boolean success) {
        toast(success ? "true" : "false");
        loadingHide();

      }
    });
  }

  public void upload(View view) {
    Log.d(TAG, "upload: " + "点击了.");
    final File file = new File(zipName);

    if (!file.exists()) {
      Toast.makeText(this, "文件不存在", Toast.LENGTH_SHORT).show();
    } else {
      OkHttpClient.Builder builder = new OkHttpClient.Builder()
          .connectTimeout(300, TimeUnit.SECONDS).readTimeout(300, TimeUnit.SECONDS)
          .writeTimeout(300, TimeUnit.SECONDS);
      final OkHttpClient client = builder.build();

      RequestBody requestBody = new Builder().setType(MultipartBody.FORM)
          .addFormDataPart("file", file.getName(),
              RequestBody.create(MediaType.parse("application/octet-stream"), file)).build();

      Request request = new Request.Builder().url(url).post(requestBody).build();

      try {
        Log.d(TAG, "contentLength: " + requestBody.contentLength());
      } catch (IOException e) {
        e.printStackTrace();
      }
      client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
          Log.d(TAG, "onFailure: " + e.getMessage());
          client.connectTimeoutMillis();
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
          Log.d(TAG, "onResponse: " + response.code());
          file.delete();
        }
      });
    }

  }


  private ProgressDialog mLoading;

  private void loadingShow(int percent) {
    if (mLoading == null) {
      mLoading = new ProgressDialog(this);
      mLoading.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
      mLoading.setMax(100);
    }
    if (percent > 0) {
      mLoading.setProgress(percent);
      mLoading.setMessage(String.valueOf(percent) + "%");
    }
    if (!mLoading.isShowing()) {
      mLoading.show();
    }
  }

  private void loadingHide() {
    if (mLoading != null && mLoading.isShowing()) {
      mLoading.dismiss();
      mLoading = null;
    }
  }

  private void toast(String text) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
  }

}
