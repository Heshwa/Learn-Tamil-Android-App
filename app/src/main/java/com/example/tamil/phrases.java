package com.example.tamil;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class phrases extends AppCompatActivity {
    MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);


        final ArrayList<Word> words=new ArrayList<>();
        words.add(new Word("How are you?","Epadi iruka",R.raw.p1));
        words.add(new Word("Come here","Inga vaa",R.raw.p2));
        words.add(new Word("Go there","Anga poo",R.raw.p3));
        words.add(new Word("Did you eat?","Saptiya",R.raw.p4));
        words.add(new Word("Get some water","Thaneer Kondu vaa",R.raw.p5));
        words.add(new Word("Where are you going?","Enga poigirai",R.raw.p6));
        words.add(new Word("Where are you?","Enga iruka",R.raw.p7));
        words.add(new Word("What are you doing?","Enna panra",R.raw.p8));
        words.add(new Word("I am fine","Na nallairuken",R.raw.p9));
        words.add(new Word("Did u sleep?","Thooginiya",R.raw.p10));
        words.add(new Word("What you are seeing?","Enna pakura",R.raw.p11));
        words.add(new Word("Sit down","Ukaru",R.raw.p12));
        words.add(new Word("Stand up","EZhundru",R.raw.p13));
        words.add(new Word("Open the door","kathavai thuraa",R.raw.p113));
        words.add(new Word("Bell rang","Mani adichuruchu",R.raw.p15));
        words.add(new Word("Turn off the light","Vilakai anai",R.raw.p16));




        WordAdapter adapter =new WordAdapter(this,words,R.color.blue);
        ListView listView =  findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word w =words.get(position);
                releaseMedia();
                m=MediaPlayer.create(phrases.this,w.getMedia());
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
