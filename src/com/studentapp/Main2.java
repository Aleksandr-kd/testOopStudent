package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        Student s3 = new Student("rday", 24, "S-788");
        s3.enrollCourse("Java");


        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
//        System.out.println(studentList);


//        Student student = findStudentById("S-441");
//        System.out.println("Найден: " + student.getName());

        sortByName();

    }

    private static void sortByName() {
        Comparator<Student> studentNameComparator = new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Collections.sort(studentList, studentNameComparator);
        System.out.println(studentList);
    }

    public static Student findStudentById(String studentId) {
        return studentList
                .stream()
                .filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                .findFirst()
                .orElseThrow(() -> {
                    System.err.println("Студент с ID '" + studentId + "' не найден");
                    return new RuntimeException("Студент с ID '" + studentId + "' не найден");
                });
    }
}

