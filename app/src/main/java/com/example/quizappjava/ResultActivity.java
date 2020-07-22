package com.example.quizappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private String userName;
    private String marks;
    private String totalQuestions;
    private TextView tv_name,tv_score;
    private Button btn_finsh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        Intent i =getIntent();
        userName=i.getStringExtra(QuetionsList.USER_NAME);
        marks=i.getStringExtra("marks");
        totalQuestions=i.getStringExtra("total_questions");

        tv_name=findViewById(R.id.tv_name);
        tv_score=findViewById(R.id.tv_score);
        btn_finsh=findViewById(R.id.btn_finish);

        tv_name.setText(userName);
        tv_score.setText("Your Score is "+marks+" out of "+totalQuestions);

        btn_finsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this,MainActivity.class));
                finish();
            }
        });



    }
}
