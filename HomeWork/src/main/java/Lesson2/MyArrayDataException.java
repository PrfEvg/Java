package Lesson2;

public class MyArrayDataException extends Exception{
    public MyArrayDataException(int i1, int i2, String value){
        super("ошибка в ячейке: " + i1 + " " + i2 + ". " + value + " - не является числом.");
    }
}
