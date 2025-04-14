public abstract class Car {

    protected String name;
    protected int speed;
    protected int luck;
    protected int changeSpeed;
    protected int finalSpeed;

    public Car(String name, int speed, int luck){
        this.name = name;
        this.speed = speed;
        this.luck = luck;
        this.finalSpeed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setChangeSpeed(int changeSpeed) {
        this.changeSpeed = changeSpeed;
    }

    public void setFinalSpeed(int speed) {
        this.finalSpeed = speed;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getFinalSpeed(){
        return this.finalSpeed = speed + changeSpeed;

    }

    public void resetSpeed(){
        Thread t1 =new Thread(()-> {
            try {
                Thread.sleep(3000);
                this.changeSpeed = 0;
//                System.out.println("아이템의 효과가 사라졌습니다!!");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });t1.start();
    }
}