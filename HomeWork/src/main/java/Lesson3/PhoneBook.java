package Lesson3;

import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> hm = new HashMap<>();

    public void add(String surname, String phone_number) {
        List<String> phone_number_list;
        if (hm.containsKey(surname)) {
            phone_number_list = hm.get(surname);
        } else {
            phone_number_list = new ArrayList<>();
        }
        phone_number_list.add(phone_number);
        hm.put(surname, phone_number_list);
    }

    public List<String> get(String surname) {
        return hm.get(surname);
    }
}
