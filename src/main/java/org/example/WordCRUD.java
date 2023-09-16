package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> wordlist;
    Scanner scanner;
    final String fname = "Dictionary.txt";
    WordCRUD(){
        wordlist = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    @Override
    public Object add() {
        Word word = new Word();

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
        System.out.print("=> 수정할 단어 검색 : ");
        String str = scanner.nextLine();
        System.out.println("---------------------------------");
        int i=1;
        ArrayList<Word> tw = new ArrayList<>();
        for(Word t: wordlist){
            if(t.getWord().contains(str)){
                tw.add(t);
                System.out.print((i++)+" ");
                System.out.println(t.toString());
            }
        }
        System.out.println("---------------------------------");
        System.out.print("=> 수정할 번호 선택 : ");
        i = scanner.nextInt();
        System.out.print("=> 뜻 입력 : ");
        try {
            tw.get(i - 1).setWord(scanner.nextLine());
        }catch (Exception ignored){}

        System.out.println("단어 수정이 성공적으로 되었습니다!!");
        return 0;
    }

    @Override
    public int delete(Object o) {
        System.out.print("=> 삭제할 단어 검색 : ");

        System.out.print("=> 삭제할 단어 검색 : ");
        return 0;
    }

    @Override
    public void select(Object o) {

    }
    public ArrayList<Integer> listAll(String keyword){
        ArrayList<Integer> idlist = new ArrayList<>();
        int j=0;
        System.out.println("--------------------------");
        for(int i=0; i< wordlist.size(); i++){
            String word = wordlist.get(i).getWord();
            if(!word.contains(keyword)) continue;
            System.out.print((j+1)+" ");
            System.out.println(wordlist.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("--------------------------");
        return idlist;
    }
    public void listAll(int level){
        int j=0;
        System.out.println("--------------------------");
        for(int i=0; i< wordlist.size(); i++){
            int ilevel = wordlist.get(i).getHardness();
            if(ilevel!=level) continue;
            System.out.print((j+1)+" ");
            System.out.println(wordlist.get(i).toString());

            j++;
        }
        System.out.println("--------------------------");

    }
//    public ArrayList<Integer> listAll(String keyword){
//        ArrayList<Integer> idlist = new ArrayList<>();
//        System.out.println("--------------------------");
//        for(int i=0; i< wordlist.size(); i++){
//            System.out.print((i+1)+" ");
//            System.out.println(wordlist.get(i).toString());
//        }
//        System.out.println("--------------------------");
//        return idlist;
//    }

    public void updateItem(){
        System.out.print("=>수정할 단어 검색 : ");
        String keyword = scanner.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 수정할 번호 선택 : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("=> 뜻 입력 : ");
        String meaning = scanner.nextLine();
        Word word = wordlist.get(idlist.get(id-1));
        word.setMean(meaning);
        System.out.println("단어가 수정되었습니다. ");
    }

    public void deleteItem(){
        System.out.print("=> 삭제할 단어 검색 : ");
        String keyword = scanner.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 삭제할 번호 선택 : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("=> 정말로 삭제하실래요? (Y/n) ");
        String ans = scanner.next();
        if(ans.equalsIgnoreCase("y")){
            wordlist.remove((int)idlist.get(id-1));
            System.out.println("단어가 삭제되었습니다. ");

        }else
            System.out.println("취소되었습니다. ");


    }

    public void loadFile(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int count = 0;

            while(true){
                line = br.readLine();
                if(line==null) break;

                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                wordlist.add(new Word(0, level, word, meaning));
                count++;
            }
            br.close();
            System.out.println("===> "+count+"개 데이터 로딩 완료!!!");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void saveFile() {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(fname));
            for (Word one : list) {
                pr.write(one.toFileString() + "\n");

            }
            pr.close();
            ;
            System.out.println("==> 데이터 저장 완료 !!!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void searchLevel() {
        System.out.print("=> 원하는 레벨은? (1~3) ");
        int level = scanner.nextInt();
        listAll(level);
    }

    public void searchWord() {
        System.out.print("=> 원하는 단어는? ");
        String key = scanner.next();
        listAll(key);
    }
}
