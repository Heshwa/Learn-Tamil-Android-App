package com.example.tamil;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Family extends AppCompatActivity {
    MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        final ArrayList<Word> words=new ArrayList<>();
        words.add(new Word("Mother","Amma",R.drawable.family_mother,R.raw.mother));
        words.add(new Word("Father","Appa",R.drawable.family_father,R.raw.father));
        words.add(new Word("Elder sister","Akka",R.drawable.family_older_sister,R.raw.elder_sister));
        words.add(new Word("Younger sister","Thangai",R.drawable.family_younger_sister,R.raw.younger_sister));
        words.add(new Word("Elder brother","Anna",R.drawable.family_older_brother,R.raw.elder_brother));
        words.add(new Word("Younger Brother","Thambi",R.drawable.family_younger_brother,R.raw.younger_brother));
        words.add(new Word("Son","Magan",R.drawable.family_son,R.raw.son));
        words.add(new Word("Daughter","Magal",R.drawable.family_daughter,R.raw.daughter));
        words.add(new Word("Grand father","Thatha",R.drawable.family_grandfather,R.raw.grand_father));
        words.add(new Word("Grand Mother","Paati",R.drawable.family_grandmother,R.raw.grand_mother));
        words.add(new Word("Grand son","Peyran",R.drawable.family_son,R.raw.grand_son));
        words.add(new Word("Grand daughter","Peythi",R.drawable.family_daughter,R.raw.grand_daughter));
        words.add(new Word("Uncle","Mama",R.drawable.family_father,R.raw.uncle));
        words.add(new Word("Ant","Athai",R.drawable.family_mother,R.raw.ant));





        WordAdapter adapter =new WordAdapter(this,words,R.color.green);
        ListView listView =  findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word w =words.get(position);
                releaseMedia();
                m=MediaPlayer.create(Family.this,w.getMedia());
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
