package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application3 {
    public static void main(String[] args) {
        /** DataInputStream / DataOutputStream
         * 데이터 입출력 보조 스트림을 이해하고 사용할 수 있다. */

        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("score.txt")))
        {
            dout.writeUTF("홍길동");
            dout.writeInt(95);
            dout.writeChar('A');

            dout.writeUTF("김철수");
            dout.writeInt(73);
            dout.writeChar('C');

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream din = new DataInputStream(new FileInputStream("score.txt")))
        {
            /** 파일에 기록한 순서대로 읽어오지 않는 경우 에러가 발생하거나 의미 없는 데이터를 읽어온다. */
            while(true)
            {
                System.out.println(din.readUTF() + ", " + din.readInt() + ", " + din.readChar());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) { // IOException의 후손이므로 IOException보다 위에 작성해야함.
            System.out.println("파일 읽기 완료!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
