package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_KEY_FULLNAME = "fullname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button saveInformationButton = findViewById(R.id.btn_main_saveInformation);
        saveInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "User Clicked on save Information Button", Toast.LENGTH_SHORT).show();
            }
        });

        CheckBox checkBox = findViewById(R.id.checkBox_main_android);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Android Skill is Checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Android Skill is not Checked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        CheckBox checkBox_ui = findViewById(R.id.checkBox_main_ui);
        checkBox_ui.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "UI design is Checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "UI design is not Checked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        CheckBox checkBox_deepLearning = findViewById(R.id.checkBox_main_deepLearning);
        checkBox_deepLearning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Deep Learning is Checked", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Deep Learning is not Checked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        RadioGroup radioGroup = findViewById(R.id.radiogroup_main);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButton_main_tehran:
                        Toast.makeText(MainActivity.this, "Tehran RadioButton is Checked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_main_gilan:
                        Toast.makeText(MainActivity.this, "Gilan RadioButton is Checked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_main_alborz:
                        Toast.makeText(MainActivity.this, "Alborz RadioButton is Checked", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        Button btn_editProfile = findViewById(R.id.btn_main_editProfile);
        btn_editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EditProfileActivity.class);
                TextView fullnameTv = findViewById(R.id.tv_main_fullName);
                intent.putExtra(EXTRA_KEY_FULLNAME,fullnameTv.getText());
                startActivityForResult(intent,1001);
            }
        });

        Button viewWebsiteBtn = findViewById(R.id.btn_main_viewWebsite);
        viewWebsiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/arash-parsa"));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1001 && resultCode == Activity.RESULT_OK && data != null){
            String fullName = data.getStringExtra(EXTRA_KEY_FULLNAME);
            TextView textView = findViewById(R.id.tv_main_fullName);
            textView.setText(fullName);
        }
    }
}
