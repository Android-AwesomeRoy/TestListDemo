package com.example.testreadcard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements TextWatcher, View.OnFocusChangeListener {
    private static final String TAG = "MainActivity";
    private CharSequence temp;
    private EditText mEditText;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.et_read);
//        mButton = findViewById(R.id.button);

        mEditText.setInputType(InputType.TYPE_NULL);

        mEditText.addTextChangedListener(this);
        mEditText.setOnFocusChangeListener(this);

    }
    
    


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        temp = s;
        Log.d(TAG, "beforeTextChanged: temp == " + temp);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d(TAG, "onTextChanged: read == " + s);
        //        mEditText.setText(s);
    }

    @Override
    public void afterTextChanged(Editable s) {
        String s1 = mEditText.getText().toString();
        int selectionStart = mEditText.getSelectionStart();
        int selectionEnd = mEditText.getSelectionEnd();

        Log.d(TAG, "afterTextChanged:  == " + s1);
        if (temp.length() >= 10) {
            Log.d(TAG, "afterTextChanged: > 10 , temp == " + temp);
            s.delete(selectionStart - 1, selectionEnd);
            temp = "";
            mEditText.setText(temp);
            Log.d(TAG, "afterTextChanged:  temp == null ? " + temp);

        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            Log.d(TAG, "onFocusChange: " + hasFocus);
        } else {
            Log.d(TAG, "onFocusChange: "+ hasFocus);
            mEditText.requestFocus();
            mEditText.setFocusable(true);
            mEditText.setFocusableInTouchMode(true);
        }
    }
}
