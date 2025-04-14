package com.ohgiraffers.section02.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application1 {
    public static void main(String[] args) {
        /** 입출력 스트림
         * 데이터는 프로그램 내부에 있을 수도 있지만, 프로그램 외부의 데이터를 가져와서 사용해야 할 수도 있다.
         * 또한 프로그램에서 생성한 데이터를 외부로 출력할 수도 있다.
         *
         * 외부 데이터란, 프로그램 외부에 존재하는 모든 데이터를 의미한다.
         * 외부 데이터를 대상으로 작업할 때 가장 먼저 해야할 일은 자바 프로그램과 외부 데이터를 연결하는 것이다.
         * 프로그램과 외부 데이터가 연결된 길을 스트림(stream)이라고 한다.
         * 스트림은 단방향이기 때문에 데이터를 읽어오기 위한 길은 입력 스트림,
         * 데이터를 출력하기 위한 길은 출력 스트림이라고 부른다.
         *
         * 그 중 InputStream과 Reader는 데이터를 읽어오는 입력 스트림,
         * OutputStream과 Writer는 데이터를 내보내는 출력 스트림이다.
         *
         * 또한 InputStream과 OutputStream은 데이터를 1바이트 단위로 입/출력을 하고
         * Reader와 Writer 계열은 글자(2바이트 혹은 3바이트) 단위로 작업한다.
         */

        FileInputStream fin = null;
        try {
            fin = new FileInputStream("src/com/ohgiraffers/section02/stream/testInputStream.txt");

//            int value;
//            /** read(): 파일에 기록된 값을 순차적으로 읽어오고 더이상 읽어올 데이터가 없는 경우 -1을 반환 */
//            while((value = fin.read()) != -1)
//            {
//                System.out.println(value);
//                System.out.println((char)value);
//            }

            int fileSize = (int) new File("src/com/ohgiraffers/section02/stream/testInputStream.txt").length();
            byte[] bar = new byte[fileSize];
            /** read() 메소드의 인자로 생성한 byte 배열을 넣어주면
             * 파일의 내용을 읽어서 byte 배열에 기록해준다. */
            fin.read(bar);

            for (int i = 0; i < bar.length; i++)
            {
                System.out.println((char) bar[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fin != null){
                try {
                    /** 스트림을 닫지 않는 경우 다양한 리소스에서 누수(leak)가 발생한다.
                     * 만약 잔류 데이터가 남은 상황에서 추가로 스트림을 사용한다면, 데드락(deadlock) 상태가 된다.
                     * 때문에 마지막에는 데이터를 강제로 전송하는 flush()를 무조건 실행해주는 것이 좋다.
                     * close() 메소드는 자원을 반납하며 flush()를 내부적으로 실행하기 때문에 close()만 제대로 해줘도 된다.
                     * close() 메소드는 외부 자원을 사용하는 경우 반드시 마지막에 호출해주어야 한다. */
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
