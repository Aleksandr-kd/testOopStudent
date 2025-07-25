package com.studentapp;

public class Main {
    public static void main(String[] args) {
        System.out.println("*************** Student Management System ***************");
        System.out.println("*********************** Welcome *************************");

        Student s1;
        s1 = new Student("Alex ewe", 31, "S-1");
        s1.enrollCourse("Java");// курс должен быть уникальный. нельзя записать на один и тот же курс несколько раз
//        s1.enrollCourse("Javaq");
        s1.enrollCourse("Python");
        System.out.println(s1);

        s1.printStudentInfo();

        Student s2 = new Student("Uday", 24, "S-888");
        s2.enrollCourse("Java");
        System.out.println(s2);

        Student s3 = new Student("Atu", 34, "S-838");
        s3.enrollCourse("Python");
        System.out.println(s3);

        Student s4 = new Student("Atuman", 34, "S-83888");
        s4.enrollCourse("Python");
        System.out.println(s4);


    }
}