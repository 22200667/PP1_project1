package org.example;

public class Word {
    private int hardness;
    private String word, mean;

    public void setHardness(int hardness){
        this.hardness=hardness;
    }
    public int getHardness() {
        return hardness;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
    @Override
    public String toString(){
        String str = hardness+"|"+word+"|"+mean;
        return str;
    }
}
