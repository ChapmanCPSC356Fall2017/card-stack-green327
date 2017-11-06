package com.example.matt.carstack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.Stack;


public class MainActivity extends AppCompatActivity
{
    private final String LOGTAG = "Main Test";


    private TextView topLeft;
    private TextView bottomRight;
    private ImageView topLeftImage;
    private ImageView centerImage;
    private ImageView bottomRightImage;

    private RelativeLayout layout;

    private Stack<cardList> stack;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.topLeft = (TextView) findViewById(R.id.topLeft);
        this.bottomRight = (TextView) findViewById(R.id.bottomRight);
        this.topLeftImage = (ImageView) findViewById(R.id.topLeftImage);
        this.centerImage = (ImageView) findViewById(R.id.centerImage);
        this.bottomRightImage = (ImageView) findViewById(R.id.bottomRightImage);

        this.stack = new Stack<>();

        //generates the stack of cards and their suits
        for(int i = 0; i < 4; ++i)//suit
        {
            for(int k = 1; k <= 14; ++k)//value
            {
                this.stack.push(new cardList(i, k));
                Log.d(LOGTAG, i + " " + k);
            }
        }
        Collections.shuffle(this.stack);//shuffles the stack

        //onClick listener for the layout as a whole
        this.layout = (RelativeLayout) findViewById(R.id.onClick);
        layout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if(!stack.isEmpty())
                {
                    nextCard(stack.pop());
                }
                else
                {
                    finish();
                }
            }
        });
    }

    public void nextCard(cardList c)
    {
        //access values from class c and assigns them for easier accessibility and manipulation
        int suit = c.getSuit();
        int value = c.getValue();
        Log.d(LOGTAG, suit + " " + value);//tracks each card that pops
        if(suit == 0)
        {
            topLeftImage.setImageResource(R.drawable.heart);
            centerImage.setImageResource(R.drawable.heart);
            bottomRightImage.setImageResource(R.drawable.heart);

            if (value <= 10)
            {
                topLeft.setText(String.valueOf(value));
                bottomRight.setText(String.valueOf(value));
            }
            else
            {
                face(value);
            }
        }
        if(suit == 1)
        {
            topLeftImage.setImageResource(R.drawable.spade);
            centerImage.setImageResource(R.drawable.spade);
            bottomRightImage.setImageResource(R.drawable.spade);

            if (value <= 10)
            {
                topLeft.setText(String.valueOf(value));
                bottomRight.setText(String.valueOf(value));
            }
            else
            {
                face(value);
            }
        }
        if(suit == 2)
        {
            topLeftImage.setImageResource(R.drawable.club);
            centerImage.setImageResource(R.drawable.club);
            bottomRightImage.setImageResource(R.drawable.club);

            if (value <= 10)
            {
                topLeft.setText(String.valueOf(value));
                bottomRight.setText(String.valueOf(value));
            }
            else
            {
                face(value);
            }
        }
        if(suit == 3)
        {
            topLeftImage.setImageResource(R.drawable.diamond);
            centerImage.setImageResource(R.drawable.diamond);
            bottomRightImage.setImageResource(R.drawable.diamond);

            if (value <= 10)
            {
                topLeft.setText(String.valueOf(value));
                bottomRight.setText(String.valueOf(value));
            }
            else
            {
                face(value);
            }
        }
    }

    //handles all cards that are not strictly integers
    public void face(int value)
    {
        if (value == 11)
        {
            topLeft.setText("J");
            bottomRight.setText("J");
        }
        else if(value == 12)
        {
            topLeft.setText("Q");
            bottomRight.setText("Q");
        }
        else if(value == 13)
        {
            topLeft.setText("K");
            bottomRight.setText("K");
        }
        else if(value == 14)
        {
            topLeft.setText("A");
            bottomRight.setText("A");
        }
    }
}
