package Bonus;

public class Animal {
    protected int legs;

    protected Animal(int legs) {
        this.legs = legs;
    }

    public void walk(){
        System.out.println("The animal walk!");
    }
    public void eat(){
        System.out.println("The animal eat!");
    }
}
