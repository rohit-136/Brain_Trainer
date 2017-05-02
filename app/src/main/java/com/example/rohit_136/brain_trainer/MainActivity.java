package com.example.rohit_136.brain_trainer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.sax.RootElement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button startbutton;
    Button button1,button2,button3,add,sub,mul;
    Button yesbutton;
    Button nobutton;
    Button button4;
   // Button playagainbutton;
    TextView resluttextview;
    TextView pointtextView;
    TextView sumtextview;
    TextView timertextview;
    TextView playgn;
    RelativeLayout mainrelativelayout,optionRelativeLayout;
    //generalrelativelayout is the layout of the science questions.
    //mainrelativelayout is the layout of the maths questions.
    ArrayList<Integer> arr = new ArrayList<>();
    int pos_of_correct;
    int correct = 0;
    int noOfQues = 0;
    int tag = 0;


    public void playagain(final View view)
    {
        correct = 0;
        noOfQues = 0;
        //playagainbutton.setVisibility(View.INVISIBLE);
        timertextview.setText("30s");
        pointtextView.setText("0/0");
        resluttextview.setText("");
        yesbutton.setVisibility(View.INVISIBLE);
        nobutton.setVisibility(View.INVISIBLE);
        playgn.setVisibility(View.INVISIBLE);
        //Log.i("Tag is:", Integer.toString(tag));
        if(tag==4)
            generateAdditionQuestion();
        if(tag==5)
            generateSubtractionQuestion();
        if(tag==6)
            generateMultiplicationQuestion();


        new CountDownTimer(30100,1000)
        {
            @Override
            public void onTick(long l) {

                timertextview.setText(String.valueOf(l/1000) + "s");
            }

            @Override
            public void onFinish() {
               // Log.i("Timer :" , "Oye khatam ho gya :P");
                timertextview.setText("0s");
                playgn.setVisibility(View.VISIBLE);
                yesbutton.setVisibility(View.VISIBLE);
                nobutton.setVisibility(View.VISIBLE);
                resluttextview.setText("Your Score: " + Integer.toString(correct)+"/"+Integer.toString(noOfQues));
                //mainrelativelayout.setVisibility(View.INVISIBLE);
                //startbutton.setVisibility(Button.VISIBLE);


            }
        }.start();

    }


    public void over(View view)
    {
        new MainActivity().finish();
        System.exit(0);
    }

    public void  chooseAnswer(View view)
    {
        //Log.i("Tag",(String) view.getTag());
        //Log.i("Location", Integer.toString(pos_of_correct));

        if(view.getTag().toString().equals(Integer.toString(pos_of_correct)))
        {
            //Log.i("Result","Correct Answer");
            correct++;
            noOfQues++;
            resluttextview.setText("Correct!");
        }
        else
        {
            //Log.i("Result","Incorrect Answer");
            resluttextview.setText("Incorrect!");
            noOfQues++;
        }
        pointtextView.setText(Integer.toString(correct)+"/"+Integer.toString(noOfQues));
        if(tag==4)
            generateAdditionQuestion();
        if(tag==5)
            generateSubtractionQuestion();
        if(tag==6)
            generateMultiplicationQuestion();

    }

    public void generateAdditionQuestion()
    {
        Random rand = new Random();
        int a = rand.nextInt(31);
        int b = rand.nextInt(31);
        sumtextview.setText(Integer.toString(a)+" + "+Integer.toString(b));

        int sum = a+b;
        pos_of_correct = rand.nextInt(4);
        arr.clear();
        for(int i=0;i<4;i++)
        {
            if(i==pos_of_correct)
            {
                //Log.i("I is", Integer.toString(i));
                //Log.i("pos is ", Integer.toString(pos_of_correct));
                arr.add(sum);
            }
            else
            {
                int incorrect_ans = rand.nextInt(61);
                while(incorrect_ans==sum)
                {
                    incorrect_ans = rand.nextInt(61);
                }
                arr.add(incorrect_ans);
            }
        }
        button1.setText(Integer.toString(arr.get(0)));
        button2.setText(Integer.toString(arr.get(1)));
        button3.setText(Integer.toString(arr.get(2)));
        button4.setText(Integer.toString(arr.get(3)));

    }



    public void generateSubtractionQuestion()
    {
        Random rand = new Random();
        int a = rand.nextInt(31);
        int b = rand.nextInt(31);
        while(a<b)
        {
            a = rand.nextInt(31);
            b = rand.nextInt(31);

        }
        sumtextview.setText(Integer.toString(a)+" - "+Integer.toString(b));

        int difference = a-b;
        pos_of_correct = rand.nextInt(4);
        arr.clear();
        for(int i=0;i<4;i++)
        {
            if(i==pos_of_correct)
            {
                //Log.i("I is", Integer.toString(i));
                //Log.i("pos is ", Integer.toString(pos_of_correct));
                arr.add(difference);
            }
            else
            {
                int incorrect_ans = rand.nextInt(61);
                while(incorrect_ans==difference)
                {
                    incorrect_ans = rand.nextInt(61);
                }
                arr.add(incorrect_ans);
            }
        }
        button1.setText(Integer.toString(arr.get(0)));
        button2.setText(Integer.toString(arr.get(1)));
        button3.setText(Integer.toString(arr.get(2)));
        button4.setText(Integer.toString(arr.get(3)));
    }


    public void generateMultiplicationQuestion()
    {
        Random rand = new Random();
        int a = rand.nextInt(20);
        int b = rand.nextInt(10);
        sumtextview.setText(Integer.toString(a)+" X "+Integer.toString(b));

        int product = a*b;
        pos_of_correct = rand.nextInt(4);
        arr.clear();
        for(int i=0;i<4;i++)
        {
            if(i==pos_of_correct)
            {
                //Log.i("I is", Integer.toString(i));
                //Log.i("pos is ", Integer.toString(pos_of_correct));
                arr.add(product);
            }
            else
            {
                int incorrect_ans = rand.nextInt(200);
                while(incorrect_ans==product)
                {
                    incorrect_ans = rand.nextInt(200);
                }
                arr.add(incorrect_ans);
            }
        }
        button1.setText(Integer.toString(arr.get(0)));
        button2.setText(Integer.toString(arr.get(1)));
        button3.setText(Integer.toString(arr.get(2)));
        button4.setText(Integer.toString(arr.get(3)));
    }




    /*

    TAGS --
    4 -- Addition
    5 -- Subtraction
    6 -- Multiplication

     */

    public void addition(View view)
    {
        //Log.i("Button: " , "Addition Button");
        tag=4;
        add.setVisibility(Button.INVISIBLE);
        sub.setVisibility(Button.INVISIBLE);
        mul.setVisibility(Button.INVISIBLE);
        optionRelativeLayout.setVisibility(RelativeLayout.INVISIBLE);
        mainrelativelayout.setVisibility(RelativeLayout.VISIBLE);
        playagain(findViewById(R.id.mathsrelativeLayout));
    }

    public void subtraction(View view)
    {
        //Log.i("Button: " , "Subtraction Button");
        tag=5;
        add.setVisibility(Button.INVISIBLE);
        sub.setVisibility(Button.INVISIBLE);
        mul.setVisibility(Button.INVISIBLE);
        optionRelativeLayout.setVisibility(RelativeLayout.INVISIBLE);
        mainrelativelayout.setVisibility(RelativeLayout.VISIBLE);
        playagain(findViewById(R.id.mathsrelativeLayout));
    }

    public void multiplication(View view)
    {
        //Log.i("Button: " , "Subtraction Button");
        tag=6;
        add.setVisibility(Button.INVISIBLE);
        sub.setVisibility(Button.INVISIBLE);
        mul.setVisibility(Button.INVISIBLE);
        mainrelativelayout.setVisibility(RelativeLayout.VISIBLE);
        playagain(findViewById(R.id.mathsrelativeLayout));
    }

    public void start(View view)
    {
        startbutton.setVisibility(View.INVISIBLE);
        optionRelativeLayout.setVisibility(RelativeLayout.VISIBLE);
    }


    public void yes(View view)
    {
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        //mainrelativelayout.setVisibility(View.INVISIBLE);
        //startbutton.setVisibility(View.VISIBLE);
        //start(findViewById(R.id.mathsrelativeLayout));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startbutton = (Button) findViewById(R.id.start_button);
        sumtextview = (TextView) findViewById(R.id.sumTextView);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        add = (Button) findViewById(R.id.addition);
        sub = (Button) findViewById(R.id.subtraction);
        mul = (Button) findViewById(R.id.multiplication);
        yesbutton = (Button) findViewById(R.id.yes);
        nobutton = (Button) findViewById(R.id.no);
        resluttextview = (TextView) findViewById(R.id.resultTextView);
        pointtextView = (TextView) findViewById(R.id.pointsTextView);
        timertextview = (TextView) findViewById(R.id.timer);
        playgn = (TextView) findViewById(R.id.playagain);
        mainrelativelayout = (RelativeLayout) findViewById(R.id.mathsrelativeLayout);
        optionRelativeLayout = (RelativeLayout) findViewById(R.id.optionrelativlayout);

    }


}


/*
   We'll just be making it as a maths app. That has questions based on addition,subtraction,multiplication,
   and division.
   Ek credit ka hai yr kitna kaam karwaoge....

 */