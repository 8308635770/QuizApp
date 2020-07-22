package com.example.quizappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_start;
    private EditText et_user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        btn_start=findViewById(R.id.btn_start);
        et_user_name=findViewById(R.id.et_name);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,QuetionsActivity.class);
                if(et_user_name.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter User Name", Toast.LENGTH_SHORT).show();
                }else{
                    intent.putExtra(QuetionsList.USER_NAME,et_user_name.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
}
