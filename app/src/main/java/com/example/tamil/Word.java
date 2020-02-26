package com.example.tamil;



public class Word
{
    private String eng;
    private String tam;
    private  int img;
    private int media;
    Word(String s1,String s2,int s3)
    {
        eng=s1;
        tam=s2;
        img=-1;
        media=s3;
    }
    Word(String s1,String s2,int s3,int s4)
    {
        eng=s1;
        tam=s2;
        img=s3;
        media=s4;
    }
//    Word(String s1,String s2,int s3)
//    {
//        eng=s1;
//        tam=s2;
//        img=s3;
//    }


    public String getEng()
    {
        return eng;
    }
    public String getTam()
    {
        return tam;
    }
    public int getImg() { return img;}
    public int getMedia(){return media;}
}

