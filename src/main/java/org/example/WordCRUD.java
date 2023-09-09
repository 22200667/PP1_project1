package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> wordlist;
    WordCRUD(){
        wordlist = new ArrayList<>();
    }
    @Override
    public Object add() {
        Word word = new Word();
        Scanner scanner = new Scanner(System.in);
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        String str = scanner.nextLine();
        word.setHardness(Integer.parseInt(str.substring(0, 1)));
        word.setWord(str.substring(2));
        System.out.print("뜻 입력 : ");
        word.setMean(scanner.nextLine());

        System.out.println("새 단어가 단어장에 추가되었습니다.");

        wordlist.add(word);
        return word;
    }

    @Override
    public int update(Object o) {
        return 0;
    }

    @Override
    public int delete(Object o) {
        return 0;
    }

    @Override
    public void select(Object o) {

    }
    public void listAll(){
        System.out.println("--------------------------");
        for(int i=0; i< wordlist.size(); i++){
            System.out.print((i+1)+" ");
            System.out.println(wordlist.get(i).toString());
        }
        System.out.println("--------------------------");
    }


}
