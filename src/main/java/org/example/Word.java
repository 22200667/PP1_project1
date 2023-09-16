package org.example;

public class Word {
    private int hardness;
    private String word, mean;

    public Word(){}
    public Word(int i, int level, String word, String meaning) {
        hardness = level;
        this.word = word;
        mean = meaning;
    }

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
        String str = "";
        for(int i=0; i<hardness; i++) str+="*";
        str = String.format("%-3s", str)+
                String.format("%15s", word)+"   "+mean;
        return str;
    }

    public String toFileString() {
        return this.hardness+"|"+this.word+"|"+this.mean;
    }
}
