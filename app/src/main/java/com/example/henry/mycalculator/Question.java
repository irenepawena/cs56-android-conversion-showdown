package com.example.henry.mycalculator;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by UMARU on 7/26/2016.
 */
public class Question implements Parcelable{
    private String from;
    private String to;
    private String questionType;

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Question> CREATOR
            = new Question.Creator<Question>() {
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle b = new Bundle();
        b.putString("from", from);
        b.putString("to", from);
        b.putString("questionType", questionType);
        dest.writeBundle( b );
    }

    public Question( Parcel in ){
        Bundle b = in.readBundle();
        from = b.getString( "from" );
        to = b.getString( "to" );
        questionType = b.getString( "questionType" );
    }
    public Question(String from, String to, String questionType){
        this.from = from;
        this.to = to;
        this.questionType = questionType;
    }

    public String getQuestionType(){
        return questionType;
    }

    public String getFrom(){
        return from;
    }

    public String getTo(){
        return to;
    }

}
