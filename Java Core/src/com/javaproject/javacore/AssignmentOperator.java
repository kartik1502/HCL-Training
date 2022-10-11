package com.javaproject.javacore;
public class AssignmentOperator {
    public static void main(String[] args) {
        int a = 10;
        a += 30;
        System.out.println(a);
        int b = 40;
        b += 45;
        System.out.println(b);
        b-=3;
        System.out.println(b);
        b*=10;
        System.out.println(b);
        b/=5;
        System.out.println(b);
        b%=3;
        System.out.println(b);
        a = 2;b = 4;
	a += b -= a *= a %= 10;
        System.out.println(a);
        a = 10;
        b = 20;
        int c = 5;
        //a += b -= c *= a %= b /= 10;
        //30   20   0    0    2
        a -= b += c *= c /= a += 20;
     //-10   20   0    0    30
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
