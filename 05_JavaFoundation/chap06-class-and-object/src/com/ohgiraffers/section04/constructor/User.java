package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class User {

    // 필드 선언부
    private String pwd;
    private String id;
    private String name;
    private Date enrollDate;

    /** 생성자의 사용 목적
     * 1. 인스턴스 생성 시점에 수행할 명령이 있는 경우
     * 2. 매개변수 있는 생성자의 경우 매개변수로 전달 받은 값으로 필드를 초기화하여 인스턴스를 생성할 목적으로 주로 사용
     * 3. 작성한 생성자 외에는 인스턴스를 생성하는 방법을 제공하지 않겠다는 의미
     *    따라서, 인스턴스를 생성하는 방법을 제한하기 위한 용도로 사용 가능(초기값 전달 강제화)
     */

    /** [생성자 작성 방법]
     * 접근제한자 클래스명(매개변수)
     * {
     *     인스턴스 생성 시점에 수행할 명령 기술(주로 필드 초기화)
     *     this.필드명 = 매개변수;
     * }
     *
     * 생성자 작성 시 주의할 점
     * 1. 생성자 메소드는 반드시 클래스의 이름과 동일해야 한다.(대/소문자까지 같아야 함)
     * 2. 생성자 메소드는 반환형을 작성하지 않는다.(작성하는 경우 생성자가 아닌 메소드로 인식한다.)
     */

    /** 1. 기본 생성자 (default constructor) */
    /** 클래스 내에 작성된 생성자가 0개일 경우 컴파일러가 자동으로 기본 생성자를 생성한다. */
    public User()
    {
        System.out.println("User 클래스의 기본 생성자 호출...");
    }

    /** 2. 매개변수 생성자 */
    public User(String id, String pwd, String name)
    {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        System.out.println("User 클래스의 id, pwd, name을 초기화하는 생성자 호출...");
    }

    public User(String id, String pwd, String name, Date date)
    {
//        this.id = id;
//        this.pwd = pwd;
//        this.name = name;
        /** this()는 동일한 클래스 내에 작성한 다른 생성자 메소드를 호출하는 구문이다.
         * 괄호 안의 매개변수의 타입, 갯수, 순서에 맞는 생성자를 호출하고 복귀한다.
         * 리턴이 되어 돌아오지만 리턴 값은 존재하지 않으며 가장 첫 줄에 선언해야 한다.(그렇지 않으면 컴파일 에러) */
        this(id, pwd, name);
        this.enrollDate = date;
        System.out.println("User 클래스의 id, pwd, name, enrollDate를 초기화하는 생성자 호출...");

    }


    // 메소드 선언부
    public String getPwd() {
        return pwd;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getInformation()
    {
        return "User[id = " + this.id + ", pwd = " + this.pwd + ", name = " + this.name + ", enrollDate = " + this.enrollDate + "]";
    }

}
