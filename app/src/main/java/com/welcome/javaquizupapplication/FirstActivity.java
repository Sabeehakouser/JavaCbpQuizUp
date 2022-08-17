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

public class FirstActivity  extends AppCompatActivity {

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
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(FirstActivity.this);
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

                currentPos = 0;
                setDataToViews(currentPos);
                questionAttempted=0;
                currentScore=0;
                bottomSheetDialog.dismiss();
                Intent i = new Intent(FirstActivity.this, FirstActivity.class);
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
                Intent i = new Intent(FirstActivity.this, MainActivity.class);
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
        quizModalArrayList.add(new QuizModal("Who invented Java Programm?","Guido van Rossum"
                ,"James Gosling","Dennis Ritchie","Bjarne Stroustrup","James Gosling"));
       //2
        quizModalArrayList.add(new QuizModal("What is correct syntax for main method of java class"
                ," public static int main(String[] args)","  public int main(String[] args)","public static void main(String[] args)","None of the above.","public static void main(String[] args)"));
        //3
        quizModalArrayList.add(new QuizModal("Which of these cannot be used for variable name in Java"
                ,"identifier & keyword","identifier","Keyword","none of the mentioned","keyword"));
        //4
        quizModalArrayList.add(new QuizModal("What is the extension of java code files?"
                ,".js",".java",".txt",".class",".java"));
        //5
        quizModalArrayList.add(new QuizModal("Which of the following is not an OOPS concept in Java"
                ,"Polymorphism","Inheritance","Compilation","Encapsulation","Compilation"));
        //6
        quizModalArrayList.add(new QuizModal(" What is the default value of char variable?"
                ,"'\\u0000'","0","null","not defined","'\\u0000'"));
        //7
        quizModalArrayList.add(new QuizModal(" What is static block?\n"
                ,"It is used to create syncronized code."," There is no such block.","It is used to initialize the static data member","None of the above","It is used to initialize the static data member"));
        //8
        quizModalArrayList.add(new QuizModal("What happens when thread's sleep() method is called?"
                ,"Thread starts running.","Thread returns to the ready state.","Thread returns to the waiting state.","none","Thread returns to the waiting state."));
        //9
        quizModalArrayList.add(new QuizModal("This is the parent of Error and Exception classes."
                ," Throwable", " MainException\n","Catchable","MainError"," Throwable"));
        //10
        quizModalArrayList.add(new QuizModal("The final element of the array ?int [ ] grades = new int[35];"
                ,"Grades[35]","Grades[34]","Grades[0]","none","Grades[34]"));

    }

}

