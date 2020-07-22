package com.example.quizappjava;

public class QuetionData {
    int id;
    String question;
    int flag_img;
    String option1;
    String option2;
    String option3;
    String option4;
    int correctAnswer;

    public QuetionData(int id, String question, int flag_img, String option1, String option2, String option3, String option4, int correctAnswer) {
        this.id = id;
        this.question = question;
        this.flag_img = flag_img;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public int getFlag_img() {
        return flag_img;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
