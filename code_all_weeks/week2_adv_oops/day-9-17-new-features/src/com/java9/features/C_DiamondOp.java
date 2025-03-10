package com.java9.features;
import com.pojo.Book;

import java.sql.Array;
import  java.util.*;
class A{
        void foo(){
            System.out.println("foo of class A");
        }
}
class B extends  A{
    void foo(){
        System.out.println("foo of class B override");
    }
}
public class C_DiamondOp {
    public static void main(String[] args) {

        //java 1.6
        List<String> list=new LinkedList<String>();

        //java 1.7
        List<String> list2=new LinkedList<>();

        //java 1.8
        List<String> list3=new LinkedList<String>(){

        };
        //java 1.9
        List<String> list4=new LinkedList<>(){

        };
    }
}
