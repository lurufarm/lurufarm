package com.ohgiraffers.section03.abstraction;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        /**
         * [추상화]
         * 추상화는 공통된 부분을 추출하고, 공통되지 않은 부분을 제거하는 것으로, 추상화의 목적은 유연성 확보이다.
         * 유연성을 확보한다는 것은 여러 곳에 적용될 수 있는 유연한 객체를 의미하므로 재사용성을 높일 수 있다.
         * 객체의 재사용성이 증가하면 중복 작성되는 코드를 줄일 수 있고, 오류 발생을 가능성을 감소시키며 유지보수성을 향상시킨다.
         *
         * [시스템 요구사항]
         * 1. 카레이서는 시동걸기, 엑셀레이터 밟기, 브레이크 밟기, 시동 끄기를 할 수 있다.
         * 2. 자동차는 시동걸기, 앞으로가기, 멈추기 , 시동끄기를 할 수 있다.
         * 3. 자동차는 처음에 멈춘 상태로 대기하고 있는다.
         * 4. 카레이서는 먼저 자동차에 시동을 건다. 이미 걸려있는 경우 다시 시동을 걸 수 없다.
         * 5. 카레이서가 엑셀레이터를 밟으면 시동이 걸린 상태일 경우 자동차는 시속이 10km/h 증가하며 앞으로 나간다.
         * 6. 자동차가 달리는 중인 경우 브레이크를 밟으면 자동차의 시속은 0으로 떨어지며 멈춘다.
         * 7. 브레이크를 밟을 때 자동차가 달리는 중이 아니라면 이미 멈춰있는 상태라고 안내한다.
         * 8. 카레이서가 시동을 끄면 더 이상 자동차는 움직이지 않는다.
         * 9. 자동차가 달리는 중이라면 시동을 끌 수 없다.
         *
         * [필요한 객체 도출]
         * - 플레이어, 카레이서, 자동차
         *
         * - 카레이서가 수신할 수 있는 메세지 (카레이서가 해야 하는 일)
         * 1. 시동을 걸어라
         * 2. 엑셀레이터를 밟아라
         * 3. 브레이크를 밟아라
         * 4. 시동을 꺼라
         * - 자동차가 수신할 수 있는 메세지 (자동차가 해야 하는 일)
         * 1. 시동을 걸어라
         * 2. 앞으로 가라
         * 3. 멈춰라
         * 4. 시동을 꺼라
         */

        CarRacer carRacer = new CarRacer();
        Scanner sc = new Scanner(System.in);

        label: while (true)
        {
            System.out.println(" ==== 카레이싱 프로그램 ==== ");
            System.out.println(" 1. 시동 걸기 ");
            System.out.println(" 2. 액셀 밟기 ");
            System.out.println(" 3. 브레이크 밟기 ");
            System.out.println(" 4. 시동 끄기 ");
            System.out.println(" 9. 프로그램 종료 ");
            System.out.print(" 메뉴 선택: ");
            int no = sc.nextInt();

            switch (no)
            {
                case 1:
                    carRacer.startCar();
                    break;
                case 2:
                    carRacer.stepAccelator();
                    break;
                case 3:
                    carRacer.stepBreak();
                    break;
                case 4:
                    carRacer.turnOff();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    break label;
                default:
                    System.out.println("잘못된 번호를 선택하셨습니다.");
                    break;
            }
        }


    }
}
