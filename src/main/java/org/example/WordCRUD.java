package org.example;

import java.util.Scanner;

public class WordCRUD implements ICRUD{
    @Override
    public int add() {
        Word word = new Word();
        Scanner scanner = new Scanner(System.in);
        System.out.println("=> 난이도(1,2,3) & 새 단어 입력 : ");
        String str = scanner.next();
        word.setHardness(Integer.parseInt(str.substring(0, 1)));
        word.setWord(str.substring(2));
        System.out.println("뜻 입력 : ");
        word.setMean(scanner.next());

        System.out.println("새 단어가 단어장에 추가되었습니다.");

        return 0;
    }

    @Override
    public int update() {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }

    @Override
    public void select(Object o) {

    }

    public void listAll(){

    }
}
