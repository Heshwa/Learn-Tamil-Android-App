package com.example.tamil;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class colours extends AppCompatActivity {
    MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);


        final ArrayList<Word> words=new ArrayList<>();
        words.add(new Word("White","Vellai",R.drawable.color_white,R.raw.white));
        words.add(new Word("Yellow","Manjal",R.drawable.color_mustard_yellow,R.raw.yellow));
        words.add(new Word("Red","Sivapu",R.drawable.color_red,R.raw.red));
        words.add(new Word("Green","Pachai",R.drawable.color_green,R.raw.green));
        words.add(new Word("Black","Karuppu",R.drawable.color_black,R.raw.black));
        words.add(new Word("Brown","Pazhupu",R.drawable.color_brown,R.raw.brown));
        words.add(new Word("Silver","Velli",R.drawable.color_gray,R.raw.silver1));
        words.add(new Word("Gold","Thangam",R.drawable.color_dusty_yellow,R.raw.gold));


        WordAdapter adapter =new WordAdapter(this,words,R.color.purple);
        ListView listView =  findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word w =words.get(position);
                releaseMedia();
                m=MediaPlayer.create(colours.this,w.getMedia());
                m.start();
                m.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMedia();
                    }
                });
            }
        });

    }
    public void releaseMedia()
    {
        if(m!=null)
        {
            m.release();
            m=null;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMedia();
    }
}
