package com.ohgiraffers.section02.stream;

import java.io.FileWriter;
import java.io.IOException;

public class Application4 {
    public static void main(String[] args) {
        /** FileWriter
         * 프로그램의 데이터를 파일로 내보내기 위한 용도의 스트림이다.
         * 1글자 단위로 데이터를 처리한다.
         */

        FileWriter fw = null;

        try {
            fw = new FileWriter("src/com/ohgiraffers/section02/stream/testWriter.txt");

            fw.write(97);

            fw.write('A');
            /** char 배열도 가능 */
            fw.write(new char[] {'a', 'p', 'p', 'l', 'e'});

            /** 문자열도 가능 */
            fw.write("우리나라 대한민국");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
