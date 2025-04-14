package com.ohgiraffers.section03.abstraction;

public class CarRacer
{
    private Car car = new Car();

    public void startCar()
    {
        car.startCar();
    }

    public void stepAccelator()
    {
        car.go();
    }

    public void stepBreak()
    {
        car.stop();
    }

    public void turnOff()
    {
        car.turnOff();
    }
}
