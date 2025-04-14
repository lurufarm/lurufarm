public class RandomCar extends Car{
    public RandomCar(){
        super("RandomCar", (int)(Math.random()*20) + 5, (int)(Math.random()*20) + 5);
    }
}
