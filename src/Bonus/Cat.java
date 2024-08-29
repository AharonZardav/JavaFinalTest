package Bonus;

public class Cat extends Animal implements Pet{
    private String name;

    public Cat(int legs, String name) {
        super(legs);
        this.name = name;
    }

    public Cat(){
        super(4);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play(){
        System.out.println("The cat is playing!");
    }

    @Override
    public void eat(){
        System.out.println("The cat eat!");
    }
}
