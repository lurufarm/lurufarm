package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application1 {
    public static void main(String[] args) {
        /** BufferedWriter와 BufferedReader에 대해 이해하고 사용할 수 있다. */
        /** 버퍼 공간을 이용하여 데이터를 쌓아두었다가 입출력함으로써 입출력 횟수를 줄이고 성능을 향상시킨다. */

        BufferedWriter bw = null;
        try {
            /** 보조스트림 객체를 생성할 때, 생성자의 인자로 기반 스트림 전달 */
            bw = new BufferedWriter(new FileWriter("src/com/ohgiraffers/section03/filterstream/testBuffered.txt"));
            
            bw.write("안녕하세요\n");
            bw.write("반갑습니다\n");

            /**
             * 버퍼를 이용하는 경우 버퍼가 가득 차면 자동으로 내보내기를 하지만
             * 버퍼가 가득 차지 않은 상태에서는 강제로 내보내기를 해야한다.
             */
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/com/ohgiraffers/section03/filterstream/testBuffered.txt"));

            String temp;
            /** readLine(): 버퍼의 한 줄을 읽어와서 문자열로 반환, 읽어올 값이 없는 경우 null을 반환 */
            while ((temp = br.readLine()) != null)
            {
                System.out.println(temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
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

    }
}
