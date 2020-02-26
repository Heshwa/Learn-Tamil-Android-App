package com.example.tamil;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word>
{

    private int color;

    public WordAdapter(Activity context, ArrayList<Word> words,int y)
    {
        super(context, 0, words);
        color=y;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final Word currentWord = getItem(position);
        TextView nameTextView =listItemView.findViewById(R.id.english_words);
        nameTextView.setText(currentWord.getEng());
        TextView numberTextView =listItemView.findViewById(R.id.tamil_words);
        numberTextView.setText(currentWord.getTam());

        ImageView ImgView =listItemView.findViewById(R.id.image);

        if(currentWord.getImg()==-1)
        {
            ImgView.setVisibility(View.GONE);
        }
        else
        {
            ImgView.setImageResource(currentWord.getImg());
            ImgView.setVisibility(View.VISIBLE);

        }
        LinearLayout layout=listItemView.findViewById(R.id.layout);
        int x= ContextCompat.getColor(getContext(),color);
        layout.setBackgroundColor(x);


        return listItemView;
    }



}
