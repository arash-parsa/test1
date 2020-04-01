package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        String fullname = getIntent().getStringExtra(MainActivity.EXTRA_KEY_FULLNAME);


        final EditText editText =findViewById(R.id.et_editProfile);
        editText.setText(fullname);
        Button btn_done = findViewById(R.id.btn_done);
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = editText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(MainActivity.EXTRA_KEY_FULLNAME,fullname);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
