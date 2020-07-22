package com.example.quizappjava;

import java.util.ArrayList;
import java.util.List;

public class QuetionsList {

     public static String MARKS;
     public static String USER_NAME;
     public static String TOTAL_QUESTIONS;

    public static List<QuetionData> getQuetionsList(){

        List<QuetionData>getQuetionsData=new ArrayList<>();

        QuetionData q1=new QuetionData(1,"What country does this flag belong to?",
                                            R.drawable.ic_flag_of_india,"Argentina", "Australia",
                "India", "Austria", 3);

        QuetionData q2=new QuetionData( 2, "What country does this flag belong to?",
                R.drawable.ic_flag_of_argentina,
                "Argentina", "Australia",
                "Armenia", "Austria", 1);

        QuetionData q3=new QuetionData(3, "What country does this flag belong to?",
                R.drawable.ic_flag_of_australia,
                "Angola", "Austria",
                "Australia", "Armenia", 3
        );

        QuetionData q4=new QuetionData(4, "What country does this flag belong to?",
                R.drawable.ic_flag_of_belgium,
                "Bahamas", "Belgium",
                "Barbados", "Belize", 2);

        QuetionData q5=new QuetionData( 5, "What country does this flag belong to?",
                R.drawable.ic_flag_of_fiji,
                "Gabon", "France",
                "Fiji", "Finland", 3);

        QuetionData q6=new QuetionData(  6, "What country does this flag belong to?",
                R.drawable.ic_flag_of_germany,
                "Germany", "Georgia",
                "Greece", "none of these", 1);

        QuetionData q7=new QuetionData(  7, "What country does this flag belong to?",
                R.drawable.ic_flag_of_denmark,
                "Dominica", "Egypt",
                "Denmark", "Ethiopia", 3);

        QuetionData q8=new QuetionData(  8, "What country does this flag belong to?",
                R.drawable.ic_flag_of_brazil,
                "Belarus", "Belize",
                "Brunei", "Brazil", 4);

        QuetionData q9=new QuetionData( 9, "What country does this flag belong to?",
                R.drawable.ic_flag_of_new_zealand,
                "Australia", "New Zealand",
                "Tuvalu", "United States of America", 2);

        QuetionData q10=new QuetionData( 10, "What country does this flag belong to?",
                R.drawable.ic_flag_of_kuwait,
                "Kuwait", "Jordan",
                "Sudan", "Palestine", 1);

        getQuetionsData.add(q1);
        getQuetionsData.add(q2);
        getQuetionsData.add(q3);
        getQuetionsData.add(q4);
        getQuetionsData.add(q5);
        getQuetionsData.add(q6);
        getQuetionsData.add(q7);
        getQuetionsData.add(q8);
        getQuetionsData.add(q9);
        getQuetionsData.add(q10);


        return getQuetionsData;
    }
}
