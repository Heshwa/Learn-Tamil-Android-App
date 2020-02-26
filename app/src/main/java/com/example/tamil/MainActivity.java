package com.example.tamil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void numbers(View v)
    {
        Intent i=new Intent(this, Numbers.class);
        startActivity(i);
    }
    public void family(View v)
    {
        Intent i=new Intent(this, Family.class);
        startActivity(i);
    }
    public void colours(View v)
    {
        Intent i=new Intent(this, colours.class);
        startActivity(i);
    }
    public void phrases(View v)
    {
        Intent i=new Intent(this, phrases.class);
        startActivity(i);
    }
}
