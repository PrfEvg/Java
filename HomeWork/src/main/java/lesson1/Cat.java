package lesson1;

public class Cat implements JumpAndRun{
    private int maxHeight;
    private int maxLength;
    private String name;
    public Cat(int maxHeight, int maxLength, String name){
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
        this.name = name;
    }

    @Override
    public int goMaxHeight() {
        return maxHeight;
    }

    @Override
    public void jump() {
        System.out.println("Кот прыгает.");
    }

    @Override
    public int goMaxLength() {
        return maxLength;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Кот бежит");


    }
}
