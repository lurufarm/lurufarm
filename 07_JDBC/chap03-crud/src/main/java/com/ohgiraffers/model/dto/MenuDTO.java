package com.ohgiraffers.model.dto;

import java.sql.Date;

/**
 * DTO(Data Transfer Object)
 * 여러 계층간 데이터 전송을 위해 다양한 타입의 데이터를 하나로 묶어 전송하닌 용도의 클래스
 *
 * DTO 클래스의 조건
 * 1. 모든 필드는 private
 * 2. 기본 생성자와 모든 필드를 초기화하는 생성자
 * 3. 모든 필드에 대한 setter/getter
 * 4. toString Overriding을 이용한 필드값 반환용 메소드
 * 5. 직렬화 처리
 */

public class MenuDTO implements java.io.Serializable {

    private int code;
    private String name;
    private int price;
    private int categoryCode;
    private String orderableStatus;

    public MenuDTO() {}

    public MenuDTO(int code, String name, int price, int categoryCode, String orderableStatus) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoryCode='" + categoryCode + '\'' +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
