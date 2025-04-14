package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application2 {
    public static void main(String[] args) {
        /** InputStreamReader, OutputStreamWriter에 대해 이해하고 사용할 수 있다.
         * 형변환 보조 스트림
         * 기본 스트림이 byte기반이고, 보조 스트림이 char 기반 스트림인 경우 사용한다. */

        /** 표준 스트림
         * 자바에서는 콘솔이나 키보드같은 표준 입출력장치로부터 데이터를 입출력하기 위한 스트림을
         * 표준 스트림의 형태로 제공하고 있다.System 클래스의 필드 in, out이 대상 데이터의 스트림을 의미한다.
         * System.in(InputStream): 콘솔로부터 데이터를 입력받는다.
         * System.out(PrintStream): 콘솔로 데이터를 출력한다.
         * 즉, 자주 사용되는 자원에 대해 미리 스트림을 생성해두었기 때문에 개발자가 별도로 스트림을 생성하지 않아도 됨.
         */

        /** System.in을 InputStreamReader로 변환하여 바이트기반 스트림을 문자 기반 스트림으로 변환 시
         * 버퍼를 이용한 보조스트림과 연결함
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("문자열 입력: ");
            String value = br.readLine();

            System.out.println("입력받은 문자열: " + value);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /** try-with-resources: try 블록이 끝나면 자동으로 닫힘(close()를 직접 호출할 필요 없음) */
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            bw.write("java mysql jdbc");
        } catch (IOException e) {
            e.printStackTrace();
        } /* finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } */

    }
}
