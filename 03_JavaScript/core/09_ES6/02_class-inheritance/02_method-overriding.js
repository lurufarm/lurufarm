class Animal
{
    constructor(name, weight)
    {
        this.name = name;
        this.weight = weight;
    }

    eat(foodWeight)
    {
        this.weight += foodWeight;
        console.log(`${this.name}은/는 ${foodWeight}kg의 식사를 하고 ${this.weight}kg이 되었습니다.`);
    }

    move(lostWeight)
    {
        if(this.weight > lostWeight)
            this.weight -= lostWeight;
        console.log(`${this.name}은/는 움직임으로 인해 ${lostWeight}kg 감량되어 ${this.weight}kg이 되었습니다.`);
    }
}

class Tiger extends Animal
{
    attack(target)
    {
        console.log(`${this.name}은/는 ${target}을 공격합니다.`);
    }

    // 메서드 오버라이딩
    // Animal의 move를 확장한 Tiger의 move
    move(target)
    {
        // super.을 통해 부모 클래스의 메서드를 참조한다.
        super.move(0.1);
        this.attack(target);
    }
}

let tiger = new Tiger("호랑이", 90);
tiger.move("사슴");

class Deer extends Animal
{
    // 생성자 오버라이딩
    constructor(name, weight, legLength)
    {
        // 상속 클래스의 생성자에선 반드시 super(...)를 호출해야 한다.
        super(name, weight); // 이 코드 순서를 바꾸면 에러가 나는데, super가 항상 먼저 위에가야함. this를 사용하기 전에 super를 호출한다.
        this.legLength = legLength;
    }

    hide(place)
    {
        console.log(`${this.name}은 ${place}에 숨습니다.`);
    }
}

let deer = new Deer("사슴", 40, 30);
deer.hide("동굴 안");