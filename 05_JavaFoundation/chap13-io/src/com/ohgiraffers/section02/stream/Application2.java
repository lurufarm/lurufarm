package com.ohgiraffers.section02.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application2 {
    public static void main(String[] args) {
        /** FileReader
         * byte 단위가 아닌 character 단위로 읽어온다.
         */

        FileReader fr = null;

        try {
            fr = new FileReader("src/com/ohgiraffers/section02/stream/testReader.txt");

//            int value;
//            while ((value = fr.read()) != -1)
//            {
//                System.out.println((char)value);
//            }
            /** 이미 파일 내용을 읽어들인 스트림은 재사용이 불가능하여 위의 코드를 주석해야 함. */
            char[] carr = new char[(int) new File("src/com/ohgiraffers/section02/stream/testReader.txt").length()];
            fr.read(carr);
            for (int i = 0; i < carr.length; i++)
            {
                System.out.println(carr[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
