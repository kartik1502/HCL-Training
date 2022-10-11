package com.javaproject.javacore;
public class IncrementOperator {
	public static void main(String[] args) {
        int a = 10;
        // a = a++ + ++a + 10 + ++a + 11;
        // System.out.println(++a);
        // System.out.println(a++);
        // System.out.println(a);    
        int b = 20;
        int c = 30;
        //c = a + b++ + c-- + --c + ++b + --a + a;
      	//128 10  20    30      28    22    9   9
      	c = a + --b + ++c + --c + --b + ++a + a--;
      	a = a-- + a++ + --b + c;
      	b = b-- + --c;
        System.out.println(++c);
        System.out.println(a++);
        System.out.println(--b);
        System.out.println(c--);
        System.out.println(--a);
        System.out.println(a);
        System.out.println(b);    
        System.out.println(c);
    }
}
