package com.welcome.javaquizupapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class SecondActivity  extends AppCompatActivity {

    private TextView questionTV,questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    //Random random;
    int[] random = {1,2,3,4,5,6,7,8,9,10};
    int currentScore=0,questionAttempted=0,currentPos=0;
    int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        questionTV=findViewById(R.id.idTVQuestion);
        questionNumberTV=findViewById(R.id.idTVQuestionAttempted);
        option1Btn=findViewById(R.id.idBtnOption1);
        option2Btn=findViewById(R.id.idBtnOption2);
        option3Btn=findViewById(R.id.idBtnOption3);
        option4Btn=findViewById(R.id.idBtnOption4);
        quizModalArrayList=new ArrayList<>();
        //random=new Random();

        getQuizQuestion(quizModalArrayList);
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                //currentPos=random.nextInt(quizModalArrayList.size());
                currentPos++;
                setDataToViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                //currentPos=random.nextInt(quizModalArrayList.size());
                currentPos++;
                setDataToViews(currentPos);
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                //currentPos=random.nextInt(quizModalArrayList.size());
                currentPos++;
                setDataToViews(currentPos);
            }
        });
        option4Btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                //currentPos=random.nextInt(quizModalArrayList.size());
                currentPos++;
                setDataToViews(currentPos);
            }
        }));
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(SecondActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_layout,(LinearLayout)findViewById(R.id.idLlScore));
        TextView scoreTV=bottomSheetView.findViewById(R.id.idTVScore);

        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
        Button restartQuizBtn =bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is \n"+currentScore+"\10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
                currentPos = 0;
                setDataToViews(currentPos);
                questionAttempted=0;
                currentScore=0;
                Intent i = new Intent(SecondActivity.this, SecondActivity.class);
                startActivity(i);

            }
        });
        Button EndQuizBtn =bottomSheetView.findViewById(R.id.idBtnEnd);
        EndQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = 0;
                setDataToViews(currentPos);
                questionAttempted=0;
                currentScore=0;
                bottomSheetDialog.dismiss();
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }


    private void setDataToViews(int currentPos) {
        questionNumberTV.setText("Questions attempted : "+questionAttempted + "/10");
        if (questionAttempted==10){
            showBottomSheet();
        }
        else {
            questionNumberTV.setText("Questions attempted : " + questionAttempted + "/10");
            questionTV.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModalArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModalArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModalArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModalArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuizQuestion(ArrayList<QuizModal> quizModalArrayList) {
        //1
        quizModalArrayList.add(new QuizModal("Which type of Programming does Python support?"
                ,"object-oriented programming","structured programming","functional programming","all of the mentioned","all of the mentioned"));
        //2
        quizModalArrayList.add(new QuizModal("Is Python case sensitive when dealing with identifiers"
                ," no","yes","Can't tell","None of the above."," no"));
        //3
        quizModalArrayList.add(new QuizModal(" Is Python code compiled or interpreted?"
                ,"Python code is both compiled and interpreted"," Python code is neither compiled nor interpreted"," Python code is compiled "," Python code is interpreted"," Python code is neither compiled nor interpreted"));
        //4
        quizModalArrayList.add(new QuizModal(" Is used to define a block of code in Python language?"
                ," Indentation","Key","Brackets","All of the mentioned"," Indentation"));
        //5
        quizModalArrayList.add(new QuizModal("Creation of anonymous functions at runtime by"
                ," pi"," anonymous"," lambda","none of the mentioned","lambda"));
        //6
        quizModalArrayList.add(new QuizModal("What does pip stand for python?"
                ,"unlimited length","all private members must have leading and trailing _","Preferred Installer Program","none of the mentioned","Preferred Installer Program"));
        //7
        quizModalArrayList.add(new QuizModal(" Is the use of id() function in python?"
                ,"Every object doesn’t have a unique id","Id returns the identity of the object","All of the mentioned","None of the mentioned","Id returns the identity of the object"));
        //8
        quizModalArrayList.add(new QuizModal("Is not a core data type in Python programming?"
                ,"Tuples","Lists"," Class","Dictionary"," Class"));
        //9
        quizModalArrayList.add(new QuizModal("Is not a keyword in Python language?"
                ,"pass", " eval","nonlocal","assert"," eval"));
        //10
        quizModalArrayList.add(new QuizModal("Is the use of function in python?"
                ,"Functions don’t provide better modularity for your application","you can’t also create your own functions","Functions are reusable pieces of programs","All of the above","Functions are reusable pieces of programs"));

    }

}

