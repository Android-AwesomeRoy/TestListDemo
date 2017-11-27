package com.example.killandretart;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.syc.usbrfidreader.ICReaderApi;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ICReaderApi mApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsbDevice device = getIntent().getParcelableExtra(UsbManager.EXTRA_DEVICE);
        UsbManager manager = (UsbManager) this.getSystemService(USB_SERVICE);
        mApi = new ICReaderApi(device, manager);

        findViewById(R.id.button).setOnClickListener(v -> readCard());
    }

    @Override
    protected void onResume() {
        super.onResume();
        readCard();
    }

    private void readCard() {

    }


}
