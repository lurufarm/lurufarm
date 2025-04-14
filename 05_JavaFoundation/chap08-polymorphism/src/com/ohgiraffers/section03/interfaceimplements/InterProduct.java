package com.ohgiraffers.section03.interfaceimplements;

public interface InterProduct {
    /** 인터페이스는 상수 필드만 작성 가능
     * public static final 제어자 조합을 상수 필드라고 부른다.
     * 즉 선언과 동시에 초기화 해주어야 한다.
     */

    /** 상수 필드만 가질 수 있기 때문에 모든 필드는 묵시적으로 public static final이다. */
    int MIN_NUM = 10;
    int MAX_NUM = 100;

    /** 인터페이스는 생성자를 가질 수 없다. */
//    public InterProduct(){};

    public abstract void nonStaticMethod();

    /** 인터페이스 내 메소드는 묵시적으로 public abstract의 의미를 가진다. */
    void abstMethod();

    /** static 메소드는 작성이 가능하다. (JDK 1.8 추가) */
    public static void staticMethod()
    {
        System.out.println("InterProduct 인터페이스의 staticMethod 호출..");
    }

    /** default 키워드를 사용하면 non-static 메소드도 작성 가능하다. (JDK 1.8 추가)
     * default 메소드는 완성되어 있으므로 오버라이딩이 강제화 되지 않는다. */

    /** default 키워드는 인터페이스 내에서만 작성 가능하다. */
    public default void defaultMethod()
    {
        System.out.println("InterProduct 인터페이스의 defaultMethod 호출..");
    }



}
