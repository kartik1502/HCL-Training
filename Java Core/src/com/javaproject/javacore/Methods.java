package com.javaproject.javacore;
public class Methods {
    public static void main(String[] args) {
        oneData(5);
        System.out.println("------------------------------------------------");
        threeData(8, 5.4f, "kartik");
        System.out.println("------------------------------------------------");
        addition(5, 7);
        subtraction(8, 9);
        multiply(5, 4);
        divide(248, 9);
        modular(589, 7);
        System.out.println("------------------------------------------------");
        System.out.println("The String: "+intData(7));
        System.out.println("The number: "+floatData(5.7f, 8.7d));
        System.out.println("The boolean: "+stringData("Arya"));
        System.out.println("------------------------------------------------");
    }   
    public static void oneData(int a){
        System.out.println("The number: "+a);
    }  
    public static void threeData(int a,float b,String str){
        System.out.println("The number: "+a+"\nThe float number: "+b+"\nThe String is: "+str);
    }
    public static void addition(int a,int b){
        System.out.println(a+b);
    } 
    public static void subtraction(int a,int b){
        System.out.println(a-b);
    } 
    public static void multiply(int a,int b){
        System.out.println(a*b);
    } 
    public static void divide(int a,int b){
        System.out.println(a/b);
    } 
    public static void modular(int a,int b){
        System.out.println(a%b);  
    }
    public static String intData(int a){
        System.out.println("The number: "+a);
        return "Kartik";
    }
    public static int floatData(float a,double b){
        System.out.println("The float: "+a+"\nThe double: "+b);
        return 10;
    }
    public static boolean stringData(String str){
        System.out.println("The string data: "+str);
        return true;
    }
}