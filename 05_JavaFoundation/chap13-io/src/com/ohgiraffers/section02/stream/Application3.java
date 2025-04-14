package com.ohgiraffers.section02.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application3 {
    public static void main(String[] args) {
        /** FileoutputStream
         * 프로그램의 데이터를 파일로 내보내기 위한 용도의 스트림
         * 1바이트 단위로 데이터를 처리한다. */

        FileOutputStream fout = null;

        try {
            /** Outputstream의 경우 대상 파일이 존재하지 않으면 파일을 자동으로 생성한다. */
            fout = new FileOutputStream("src/com/ohgiraffers/section02/stream/testOutputStream.txt");

            fout.write(97);

            /** 10: 개행문자 (엔터) */
            byte[] bar = new byte[] {98, 99, 100, 101, 10};
            fout.write(bar);
            fout.write(bar, 1, 3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
