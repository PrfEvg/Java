package Lesson3;

public class Main {

    public static void main(String[] args) {
        ArrayWords arrayWords = new ArrayWords();
        arrayWords.findUniqueWords();
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Popov", "+79234566767");
        phoneBook.add("Ivanov", "+79233214141");
        phoneBook.add("Popov", "+79234563434");
        phoneBook.add("Sidorov", "+79234569999");
        phoneBook.add("Petrov", "+79234561111");
        phoneBook.add("Sidorov", "+79234562222");
        phoneBook.add("Petrov", "+79234564444");
        System.out.println(phoneBook.get("Popov"));
        System.out.println(phoneBook.get("Ivanov"));
        System.out.println(phoneBook.get("Sidorov"));
        System.out.println(phoneBook.get("Petrov"));

    }

}
