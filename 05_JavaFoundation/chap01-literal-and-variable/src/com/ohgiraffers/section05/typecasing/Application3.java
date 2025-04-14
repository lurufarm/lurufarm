package com.ohgiraffers.section05.typecasing;

public class Application3 {
    public static void main(String[] args) {
        int inum = 10;
        long lnum = 100;
        int isum = inum + (int) lnum;

        long lsum = inum + lnum;

        // 형변환 시 주의할 점: 데이터 손실
        int inum2 = 290;
        byte bnum2 = (byte) inum2;

        System.out.println(bnum2);

        // 의도적 데이터 손실
        double height = 175.5;
        int floorHeight = (int)height;

        System.out.println("floorHeight: " + floorHeight); // 소수점 절삭에 이용 가능
    }
}
