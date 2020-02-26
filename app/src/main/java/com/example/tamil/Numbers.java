package com.example.tamil;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;








public class Numbers extends AppCompatActivity {
    MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        final ArrayList<Word> words=new ArrayList<>();
        words.add(new Word("One","Ondru",R.drawable.number_one,R.raw.one));
        words.add(new Word("Two","Erendu",R.drawable.number_two,R.raw.two));
        words.add(new Word("Three","Moondru",R.drawable.number_three,R.raw.three));
        words.add(new Word("Four","Naanghu",R.drawable.number_four,R.raw.four));
        words.add(new Word("Five","Aindhu",R.drawable.number_five,R.raw.five));
        words.add(new Word("Six","Aaru",R.drawable.number_six,R.raw.six));
        words.add(new Word("Seven","Yezhu",R.drawable.number_seven,R.raw.seven));
        words.add(new Word("Eight","Yettu",R.drawable.number_eight,R.raw.eight));
        words.add(new Word("Nine","Onbadhu",R.drawable.number_nine,R.raw.nine));
        words.add(new Word("Ten","Patthu",R.drawable.number_ten,R.raw.ten));

        WordAdapter adapter =new WordAdapter(this,words,R.color.orange);
        ListView listView =  findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

             Word w =words.get(position);
             releaseMedia();
             m=MediaPlayer.create(Numbers.this,w.getMedia());
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
    @Override
    protected void onStop() {
        super.onStop();
        releaseMedia();
    }
    public void releaseMedia()
    {
        if(m!=null)
        {
            m.release();
            m=null;
        }
    }
}
