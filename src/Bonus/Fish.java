package Bonus;

public class Fish extends Animal implements Pet{

    private String name;

    protected Fish(int legs) {
        super(legs);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("The fish playing!");
    }

    @Override
    public void walk(){
        System.out.println("The fish swimming!");

    }

    @Override
    public void eat(){
        System.out.println("The fish eat!");
    }
}
