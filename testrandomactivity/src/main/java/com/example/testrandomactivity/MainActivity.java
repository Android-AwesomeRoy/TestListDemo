package com.example.testrandomactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int mKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.click);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mKey = (int) (new Random().nextInt(100) % 3);
                Log.d("msg", Integer.toString(mKey));
                changeActivity(mKey);

            }
        });


    }

    private void changeActivity(int key) {
        switch (key) {
            case 0:
                startActivity(new Intent(this, Main2Activity.class));
                break;
            case 1:
                startActivity(new Intent(this, Main3Activity.class));
                break;
            case 2:
                startActivity(new Intent(this, Main4Activity.class));
                break;
            default:
                Toast.makeText(this, String.format(Locale.getDefault(), "key == %d", key),
                               Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

