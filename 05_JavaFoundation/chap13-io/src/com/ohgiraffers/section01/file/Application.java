package com.ohgiraffers.section01.file;

import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        /** File 클래스의 사용 용법을 이해할 수 있다. */
        File file = new File("src/com/ohgiraffers/section01/file/test.txt");

        try {
            boolean createSuccess = file.createNewFile();
            System.out.println(createSuccess);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("파일의 크기: " + file.length() + "byte");
        System.out.println("파일의 경로: " + file.getPath());
        System.out.println("현재 파일의 상위 경로: " + file.getParent());
        System.out.println("파일의 절대 경로: " + file.getAbsolutePath());

        boolean deleteSuccess = file.delete();
        System.out.println(deleteSuccess);
    }
}
