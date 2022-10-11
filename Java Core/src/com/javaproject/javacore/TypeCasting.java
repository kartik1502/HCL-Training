package com.javaproject.javacore;
public class TypeCasting {
    public static void main(String[] args) {
        //byte < char < short < int < long < float < double 
        double num = 10;
        float num1 = 30;
        int charA = (int)'a';
        int num3 = (int)5.4d;
        int num4 = (int)(short)(int)(float)(long)5.4d;
        char charB = 98;
        byte b = (byte)130;
        int l = (int)154874565978l;
        byte b1 = (short)(int)5.4d; 
        //double -> int -> short -> byte
        int num5 = (int)(long)48.25f;
        //float -> long -> int
        System.out.println(charA);
        System.out.println(num);
        System.out.println(num1);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(charB);
        System.out.println(b);
        System.out.println(l);
        System.out.println(b1);
        System.out.println(num5);
    }    
}
