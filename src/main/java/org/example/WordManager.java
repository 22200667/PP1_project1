package org.example;

import java.util.Scanner;

public class WordManager {
    private WordCRUD crud;
    WordManager(){
        crud = new WordCRUD();
    }
    void selectMenu(){
        System.out.print("***영단어 마스터***\n\n");
        Scanner scanner = new Scanner(System.in);
        crud.loadFile();
        while(true) {
            System.out.print(
                    "**********************\n" +
                    "1. 모든 단어 보기\n" +
                    "2. 수준별 단어 보기\n" +
                    "3. 단어 검색\n" +
                    "4. 단어 추가\n" +
                    "5. 단어 수정\n" +
                    "6. 단어 삭제\n" +
                    "7. 파일 저장\n" +
                    "0. 나가기\n" +
                    "*************************\n" +
                    "=> 원하는 메뉴는? ");
            int nm = scanner.nextInt();

            if (nm == 1) {
                crud.listAll();
            }
            else if (nm == 2){
                crud.searchLevel();
            }
            else if (nm == 3){
                crud.searchWord();
            }
            else if (nm == 4) {

                crud.add();
            }
            else if (nm == 5){
                crud.update(null);
            }
            else if (nm == 6){
                crud.delete(null);
            }
            else if (nm == 7){

            }
            else if(nm==0){
                break;
            }
        }
    }
}
