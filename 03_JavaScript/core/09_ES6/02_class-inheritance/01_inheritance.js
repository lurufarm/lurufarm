/**
 * 클래스 상속
 * 클래스 상속을 사용하면 클래스를 다른 클래스로 확장할 수 있다.
 */

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

let animal = new Animal("고양이", 6);
animal.eat(2);
animal.move(1.5);

class Human extends Animal
{
    develop(language)
    {
        console.log(`${this.name}은/는 ${language}로 개발을 합니다. 정말 즐겁습니다~~~`);
    }
}

let human = new Human("수강생", 70);

human.eat(1);
human.move(0.2);

human.develop(`JavaScript`);

