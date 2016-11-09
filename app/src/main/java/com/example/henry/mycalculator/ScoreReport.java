package com.example.henry.mycalculator;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class ScoreReport extends Activity {

    private ArrayList<Question> wrongQuestions;


    private void set_wrongQuestions(){

        String content = "";
        assert wrongQuestions != null;
        //Log.i("SET WRONG QUESTIONS", "" + wrongQuestions.size());
        for(Question q : wrongQuestions ){
                content += q.getQuestionType() + "  from:" + q.getFrom() + "  to:" + q.getTo() + "\n";
        }
        TextView wrongQuestionTextView = (TextView) findViewById( R.id.wrongQuestions );
        if( wrongQuestionTextView == null){
            Log.i("ERROR", "TextView NULL");
        }
        wrongQuestionTextView.setText( content );
    }

    public ArrayList<Question> rebuildWrongQuestions( Intent intent ){
        String[] from = intent.getStringArrayExtra( "from" );
        String[] to = intent.getStringArrayExtra( "to" );
        String[] questionType = intent.getStringArrayExtra( "questionType" );
        ArrayList<Question> res = new ArrayList<Question>();
        for(int i = 0 ; i < from.length ; ++i){
            res.add( new Question( from[i], to[i], questionType[i] ));
        }
        return res;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_report);
        RelativeLayout lLayout = (RelativeLayout) findViewById(R.id.scorereport);
        TextView resultS = (TextView) findViewById(R.id.scorePercentage);

        //dummyindex's code -- minor fix by JordanAng
        Intent intent = getIntent();
        float result = intent.getFloatExtra("result",0);
        resultS.setText(String.valueOf(result + "%"));
        int[] scoreBoardByKey = intent.getIntArrayExtra( "scoreBoardByKey" );
        ArrayList<Integer> arrayOfKeys = intent.getIntegerArrayListExtra("arrayOfKeys");
        wrongQuestions = intent.getParcelableArrayListExtra("wrongQuestions");

        Log.i("value of result", ""+result);
        set_wrongQuestions();



        //////////////////////////////////////
        lLayout.setBackgroundColor(Color.parseColor("#00FF00"));
        /*
        if (result > 90){
            lLayout.setBackgroundColor(Color.parseColor("#00FF00"));
        }
        if (result < 89 && result > 75){
            lLayout.setBackgroundColor(Color.parseColor("#FFA500"));
        }
        if (result < 74 && result > 55){
            lLayout.setBackgroundColor(Color.parseColor("#DC143C"));
        }
        if (result < 54){
            lLayout.setBackgroundColor(Color.parseColor("#FF0000"));
        }*/
    }

    public void newTestSelection(View view){
        Intent activity = new Intent(this, QuizSelection.class);
        startActivity(activity);
    }

    public void goToCalculator(View view){
        Intent activity = new Intent(this, ExpressionActivity.class);
        MyUtils.startNoHistoryAcitivity(this, activity);
    }


}
