package com.back;

import com.back.entity.WiseSaying;

import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    int idCount = 0;
    WiseSaying[] wiseSayings = new WiseSaying[100];
    int lastIndex = -1;
//        ArrayList<WiseSaying> wiseSayingArrayList = new ArrayList<>();
//        Map<Integer,WiseSaying> wiseSayingMap = new HashMap<>();

    void run(){
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.equals("삭제")) {
                actionDelete();
            }
        }

        scanner.close();
    }

    void actionList(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for(int num = lastIndex; num >= 0; num--){

            if(wiseSayings[num] == null){
                continue;
            }

            int id = wiseSayings[num].getId();
            String content = wiseSayings[num].getcontent();
            String author = wiseSayings[num].getauthor();

            System.out.printf("%d / %s / %s%n", id, content, author);
        }
    }

    void actionWrite(){
        System.out.print("명언 : ");
        String wiseSayingContent = scanner.nextLine().trim();
        System.out.print("작가 : ");
        String wiseSayingAuthor = scanner.nextLine().trim();

        WiseSaying wiseSaying = write(wiseSayingContent, wiseSayingAuthor);

        System.out.println(wiseSaying.getId() + "번 명언이 등록되었습니다.");
    }

    WiseSaying write(String content, String author){
        WiseSaying wiseSaying = new WiseSaying(++idCount, content, author);
        wiseSayings[++lastIndex] = wiseSaying;
        return wiseSaying;
    }

    void actionDelete(){

    }
}
