package com.ohgiraffers.section03.stringbuilder;

public class Application {
    public static void main(String[] args) {
        /** String과 StringBuilder의 차이점에 대해 이해하고 사용할 수 있다. */

        /** String: 불변이라는 특성을 가지고 있음.
         *          문자열에 + 연산으로 합치기 하는 경우, 기존 인스턴스를 수정하는 것이 아닌
         *          새로운 인스턴스를 반환한다.
         *          따라서 문자열 변경이 자주 일어나는 경우 성능 면에서 좋지 않다.
         *          하지만 변하지 않는 문자열을 자주 읽어들이는 경우에는 오히려 좋은 성능을 기대할 수 있다.
         ** StringBuilder: 가변이라는 특성을 가지고 있다.
         *                 문자열에 append() 메소드를 이용하여 합치기 하는 경우,
         *                 기존 인스턴스를 수정하기 때문에 새로운 인스턴스를 생성하지 않는다.
         *                 따라서 잦은 문자열 변경이 일어나는 경우 String보다 성능이 좋다.
         */

        /** StringBuilder 인스턴스 생성 */
        StringBuilder sb = new StringBuilder("java");
        /** toString이 오버라이딩 되어있다. */
        System.out.println("sb: " + sb);

        /** hashCode는 오버라이딩 되어있지 않다.
         * 즉, 동일한 값을 가지는 경우 같은 해시코드를 반환하는 것이 아닌
         * 인스턴스가 동일해야 같은 해시코드를 반환한다.
         */
        System.out.println("sb의 hashCode: " + sb.hashCode());
        /** 문자열 수정 */
        sb.append("oracle");
        System.out.println("sb: " + sb);
        /** hashCode가 기존과 동일한 것을 확인할 수 있다.
         * 즉, 문자열을 변경했다고 새로운 인스턴스가 생성된 것은 아니다.
          */
        System.out.println("sb의 hashCode: " + sb.hashCode());

    }
}
