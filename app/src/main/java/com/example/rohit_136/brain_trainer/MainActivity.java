package com.example.rohit_136.brain_trainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    Button button1,button2,button3;
    Button button4;
    Button playagainbutton;
    TextView resluttextview;
    TextView pointtextView;
    TextView sumtextview;
    TextView timertextview;
    RelativeLayout mainrelativelayout;
    ArrayList<Integer> arr = new ArrayList<>();
    int pos_of_correct;
    int correct = 0;
    int noOfQues = 0;


    public void playagain(View view)
    {
        correct = 0;
        noOfQues = 0;

        timertextview.setText("30s");
        pointtextView.setText("0/0");
        resluttextview.setText("");
        playagainbutton.setVisibility(View.INVISIBLE);
        generateQuestion();

        new CountDownTimer(30100,1000)
        {
            @Override
            public void onTick(long l) {

                timertextview.setText(String.valueOf(l/1000) + "s");

            }

            @Override
            public void onFinish() {

                timertextview.setText("0s");
                playagainbutton.setVisibility(View.VISIBLE);
                resluttextview.setText("Your Score: " + Integer.toString(correct)+"/"+Integer.toString(noOfQues));
            }
        }.start();

    }

    public void generateQuestion()
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
                Log.i("I is", Integer.toString(i));
                Log.i("pos is ", Integer.toString(pos_of_correct));
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



    public void  chooseAnswer(View view)
    {
        Log.i("Tag",(String) view.getTag());
        Log.i("Location", Integer.toString(pos_of_correct));

        if(view.getTag().toString().equals(Integer.toString(pos_of_correct)))
        {
            //Log.i("Result","Correct Answer");
            correct++;
            noOfQues++;
            resluttextview.setText("Correct!");
        }
        else
        {
            resluttextview.setText("Incorrect");
            noOfQues++;
        }
        pointtextView.setText(Integer.toString(correct)+"/"+Integer.toString(noOfQues));
        generateQuestion();
    }


    public void start(View view)
    {
        startbutton.setVisibility(View.INVISIBLE);
        mainrelativelayout.setVisibility(RelativeLayout.VISIBLE);
        playagain(findViewById(R.id.playAgainbutton));
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
        resluttextview = (TextView) findViewById(R.id.resultTextView);
        pointtextView = (TextView) findViewById(R.id.pointsTextView);
        timertextview = (TextView) findViewById(R.id.timer);
        playagainbutton = (Button) findViewById(R.id.playAgainbutton);
        mainrelativelayout = (RelativeLayout) findViewById(R.id.mainrelativeLayout);

    }
}
