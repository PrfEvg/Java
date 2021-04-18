package Lesson3;

import java.util.HashMap;

public class ArrayWords {
    public void findUniqueWords(){
        String [] words = {
                "watermelon", "banana", "pear", "peach", "pineapple", "apple",
                "watermelon", "pear", "kiwi", "apple", "melon", "pear", "melon",
                "apple", "pineapple",};

        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (hm.containsKey(words[i]))
                hm.put(words[i], hm.get(words[i]) + 1);
            else
                hm.put(words[i], 1);
        }
        System.out.println(hm);
    }
}
