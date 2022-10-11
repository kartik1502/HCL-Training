package customhashmap;

import customhashmap.CustomHashMap;

public class CustomHashMapDriver {
    public static void main(String[] args){
        CustomHashMap<Integer, String> map = new CustomHashMap<>();
        map.put(1,"Kartik");
        map.put(2, "Arya");
        map.put(1, "Artrimis");
        System.out.println(map.size());
        System.out.println(map.get(1));
    }
}
