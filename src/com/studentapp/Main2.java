package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Main2 {
    private static List<Student> studentList;

    public static void main(String[] args) {
        System.out.println("*************** Student Management System ***************");
        System.out.println("*********************** Welcome *************************");
        studentList = new ArrayList<Student>();

        Student s1;
        s1 = new Student("Alex ewe", 31, "S-1");
        s1.enrollCourse("Java");
        s1.enrollCourse("Python");
        s1.enrollCourse("DSA");
        System.out.println(s1);

        s1.printStudentInfo();

        Student s2 = new Student("Uday", 24, "S-888");
        s2.enrollCourse("Java");
        Student s3 = new Student("Uday", 24, "S-888");
        s3.enrollCourse("Java");


        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        System.out.println(studentList);

        Student result = findStudentById("S-1");
        System.out.println("Результат поиска: " + result);
    }

    public static Student findStudentById(String studentId) {

        Student result = null;
        try {
            result = studentList
                    .stream()
                    .filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Данный идентификатор студента не найдено."));
        } catch (NoSuchElementException e) {
            System.err.println("Студент с ID " + studentId + " не найден.");
        }
        return result;
    }
}
