package com.javaproject.javacore;

import java.util.Scanner;
public class LoopingStatement {
    public static void main(String[] args) {
        System.out.println("While Loop");
        int i = 1;
        while(i <= 10){
            System.out.println("Hello World");
            i++;
        }    
        System.out.println("--------------------------------------");
        System.out.println("Natural number using while loop");
        i = 1;
        while(i<=10){
            System.out.println(i++);
        }
        System.out.println("--------------------------------------");
        System.out.println("Even number using while loop");
        i = 1;
        while(i<=20){
            if(i%2==0)
                System.out.println(i++);
            else 
                i++;
        }
        System.out.println("--------------------------------------");
        System.out.println("Sum of 10 number using while");
        i = 1;
        int sum = 0;
        while(i<=10){
            sum += i++;
        }
        System.out.println(sum);
        System.out.println("--------------------------------------");
        System.out.println("Factorial of number using while loop");
        sum = 1;
        try (Scanner sc = new Scanner(System.in)) {
            //System.out.println("Enter the number: ");
            int n = 8;
            i = 2;
            while(i<=n){
                sum *= i++;
            }
            System.out.println(sum);
            System.out.println("--------------------------------------");
            System.out.println("Number of digits in a number");
            System.out.println("Enter the number");
            int num = 8451254;
            sum = 0;
            while(num > 0){
                num /= 10;
                sum++;
            }
            System.out.println(sum);
            System.out.println("--------------------------------------");
            System.out.println("Printing numbers form n to 1");
            System.out.println("Enter the number n:");
            n = 8;
            i = n;
            do{
                System.out.println(i--);
            }while(i>0);
            System.out.println("--------------------------------------");
            System.out.println("Numbers using for loop");
            for(i = 10;i > 0;i--)
                System.out.println(i);
            System.out.println("--------------------------------------");
            System.out.println("Reverse a number");
            System.out.println("Enter the number:");
            n = 8454;
            int result = 0;
            while(n > 0){
                int t = n%10;
                result = result * 10 + t;
                n /= 10;
            }
            System.out.println("Reversed number: "+result);
            System.out.println("--------------------------------------");
            System.out.println("Palindrome");
            System.out.println("Enter the number:");
            int temp = n = 845745;
            result = 0;
            while(n > 0){
                int t = n%10;
                result = result * 10 + t;
                n /= 10;
            }
            System.out.println((temp == result) ? (result+" is a palindrome") : (result+"is not palindrome")); 
            System.out.println("--------------------------------------");
            System.out.println("Print even digit in a given number");
            System.out.println("Enter the number:");
            n = 74584;
            while(n > 0){
                int t = n%10;
                if(t%2==0)
                    System.out.print(t+" ");
                n /= 10;
            }
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("Sum of even digits in a number");
            System.out.println("Enter the number:");
            n = 4685924;
            result = 0;
            while(n > 0){
                int t = n%10;
                if(t%2==0)
                    result += t;
                n /= 10;
            }
            System.out.println("Sum of even digits in: "+result);
            System.out.println("--------------------------------------");
            System.out.println("Factors of number");
            System.out.println("Enter the number:");
            n = 45;
            for(i = 1;i<=n/2;i++){
                if(n % i == 0)
                    System.out.println(i);
            }
            System.out.println("--------------------------------------");
            System.out.println("Prime numbers in given range");
            System.out.println("Enter the range:");
            boolean flag = true;
            n = 1;
            int m = 63;
            for(i = n;i<=m;i++){
                for(int j = 2;j*j<=i;j++){
                    if(i%j==0){
                        flag = false;
                    }
                }
                if(flag)
                    System.out.println(i);
                flag = true;
            }
            System.out.println("--------------------------------------");
            System.out.println("Tables");
            System.out.println("Enter the number:");
            n = 22;
            for(i = 1;i <= 10;i++){
                System.out.println(n+" x "+i+" = "+n*i);
            }
            System.out.println("--------------------------------------");
            System.out.println("Armstrong Number");
            System.out.println("Enter the number:");
            sum = temp = n = 1634;
            result = 0;
            if(n < 10){
                System.out.println(n+" is an Armstrong number");
            }
            else{
                int multiple = 1;
                while(n > 0){
                    int t = n%10;
                    while(temp > 0){
                        multiple *= t;
                        temp /= 10;
                    }
                    temp = sum;
                    result += multiple;
                    multiple = 1;
                    n /= 10;
                }
            System.out.println((sum == result) ? (sum+" is a Armstrong Number") : (sum+" is not Armstrong Number")); 
            }
            System.out.println("--------------------------------------");
            System.out.println("Fibonacci Series");
            System.out.println("Enter the number:");
            n = sc.nextInt();
            int f1 = 0,f2 = 1,f3 = 0;
            System.out.print(f1+" "+f2+" ");
            for(i = 2;i <= n;i++){
                f3 = f1 + f2;
                System.out.print(f3+" ");
                f1 = f2;
                f2 = f3;
            }
            System.out.println();
            System.out.println("--------------------------------------");
        }
    }    
}





