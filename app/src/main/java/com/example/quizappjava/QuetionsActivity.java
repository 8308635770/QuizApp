package com.example.quizappjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuetionsActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView tv_questions;
    private Button next_questions;
    private TextView option1;
    private TextView option2;
    private TextView option3;
    private TextView option4;
    private ImageView flag_image;
    private ProgressBar progressBar;
    private TextView tv_progress;


    private int position = 1;
    private int mSelectedOption=0;
    private int marks;
    private String userName;

    private List<QuetionData> quetionData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quetions);

        Intent i=getIntent();
        userName=i.getStringExtra(QuetionsList.USER_NAME);



        quetionData = QuetionsList.getQuetionsList();


        Log.i("Quetions", quetionData.get(position - 1).getQuestion());

        tv_questions = findViewById(R.id.tv_question);
        flag_image = findViewById(R.id.iv_image);
        option1 = findViewById(R.id.tv_option_one);
        option2 = findViewById(R.id.tv_option_two);
        option3 = findViewById(R.id.tv_option_three);
        option4 = findViewById(R.id.tv_option_four);
        next_questions = findViewById(R.id.btn_submit);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(quetionData.size());
        tv_progress = findViewById(R.id.tv_progress);

        defaultOptionsMenu();
        setQuestion();

        option4.setOnClickListener(this);
        option3.setOnClickListener(this);
        option2.setOnClickListener(this);
        option1.setOnClickListener(this);
        next_questions.setOnClickListener(this);
    }

    private void setQuestion() {
        mSelectedOption=0;
        defaultOptionsMenu();
        QuetionData question = quetionData.get(position - 1);

        if (question != null) {
            tv_questions.setText(question.getQuestion());
            option1.setText(question.getOption1());
            option2.setText(question.getOption2());
            option3.setText(question.getOption3());
            option4.setText(question.getOption4());
            flag_image.setImageResource(question.getFlag_img());
            progressBar.setProgress(question.getId());
            tv_progress.setText(String.valueOf(position) + "/" + quetionData.size());

          next_questions.setText("Submit");

        }
    }

    private void defaultOptionsMenu(){

        List<TextView>options=new ArrayList<>();
        options.add(0,option1);
        options.add(1,option2);
        options.add(2,option3);
        options.add(3,option4);

        for(TextView option:options){

            option.setBackgroundResource(R.drawable.default_option_border_bg);
            option.setTextColor(Color.parseColor("#7A8089"));
            option.setTypeface(Typeface.DEFAULT);
            option.setClickable(true);
        }

    }

    private void selectedOptionView(TextView tv,int selectedOptionNum){

        defaultOptionsMenu();
        mSelectedOption=selectedOptionNum;
        tv.setBackgroundResource(R.drawable.selected_option_border_bg);
        tv.setTypeface(tv.getTypeface(),Typeface.BOLD);
        tv.setTextColor(Color.parseColor("#363A43"));

    }

    private void setButtonView(int mSelectedOption, int drawable){

        switch (mSelectedOption){
            case 1:
                option1.setBackgroundResource(drawable);
                break;
            case 2:
                option2.setBackgroundResource(drawable);
                break;
            case 3:
                option3.setBackgroundResource(drawable);
                break;
            case 4:
                option4.setBackgroundResource(drawable);
                break;
        }


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tv_option_one:
                selectedOptionView(option1,1);
                break;

            case R.id.tv_option_two:
                selectedOptionView(option2,2);
                break;

            case R.id.tv_option_three:
                selectedOptionView(option3,3);
                break;

            case R.id.tv_option_four:
                selectedOptionView(option4,4);
                break;

            case R.id.btn_submit:
                if(mSelectedOption==0){
                    Toast.makeText(this, "please select atleast one option ", Toast.LENGTH_SHORT).show();
                }else{
                    if(next_questions.getText().toString().equalsIgnoreCase("submit")){
                        QuetionData question=quetionData.get(position-1);
                        if(question.getCorrectAnswer()!=mSelectedOption){
                            setButtonView(mSelectedOption,R.drawable.wrong_option_border_bg);
                        }else{
                            marks++;
                        }
                        setButtonView(question.getCorrectAnswer(),R.drawable.correct_option_border_bg);
                        option1.setClickable(false);
                        option2.setClickable(false);
                        option3.setClickable(false);
                        option4.setClickable(false);

                        if(position==quetionData.size()){
                            next_questions.setText("Finish");
                        }else{
                            next_questions.setText("Next Question");
                        }



                    }else if(next_questions.getText().toString().toString().equalsIgnoreCase("next question")){
                        position++;
                        if(position<=quetionData.size()){
                            setQuestion();
                        }
                    }else if(next_questions.getText().toString().equalsIgnoreCase("finish")){

                        Intent intent=new Intent(QuetionsActivity.this,ResultActivity.class);
                        intent.putExtra("total_questions",String.valueOf(quetionData.size()));
                        intent.putExtra("marks",String.valueOf(marks));
                        intent.putExtra(QuetionsList.USER_NAME,userName);
                        startActivity(intent);
                        finish();


                    }
                }


        }

    }


}
