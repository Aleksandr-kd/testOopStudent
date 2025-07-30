package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String name;
    private int age;
    private String studentId;
    private List<String> courses;

    public Student(String name, int age, String studentId) {
        super();
        if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;
            courses = new ArrayList<>(); //инициализируем courses
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void enrollCourse(String course) {
        if (validateCourseName(course)) {
            if (!courses.contains(course)) {
                courses.add(course);
                System.out.println("Студен записан на курс: " + course + "!");
            } else {
                System.err.println("Студент уже добавлен на курс " + course);
            }
        }
    }

    public void printStudentInfo() {
        System.out.println("===================== Student Information =====================");
        System.out.println("Student name: " + name);
        System.out.println("Student age: " + age);
        System.out.println("Enrolled For: " + courses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId='" + studentId + '\'' +
                ", courses=" + courses +
                '}';
    }

    public boolean validateAge(int age) {
        if (age >= 19 && age <= 35) {
            return true;
        } else {
            System.err.println("Недопустимый возраст! Возраст должен быть от 19 до 35 лет.");
            return false;
        }
    }

    public boolean validateName(String name) {
        //имя будет в нижним регистри: a-z, начинается с буквы: ^, если надо разный регистр то: a-zA-Z
        //если пробелы нужны то: \\s, комбинации имени и фамилии или несколько имени: +, заканчиваем тем чем начали: $
        String nameRegex = "^[a-zA-Z\\s]+$";
        Pattern namePattern = Pattern.compile(nameRegex);
        Matcher nameMatcher = namePattern.matcher(name);
        if (nameMatcher.matches()) {
            return true;
        } else {
            System.err.println("Неверное имя. Введите только буквы.");
            return false;
        }
    }


    private boolean validateStudentId(String studentId) {
        String studentIdRegex = "S-\\d+$";  //шаблон: S - 123, \\d-это цифры
        Pattern studentIdPattern = Pattern.compile(studentIdRegex);
        Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
        if (studentIdMatcher.matches()) {
            return true;
        } else {
            System.err.println("Не верный. Верный формат S - 123... ");
            return false;
        }
    }

    public boolean validateCourseName(String course) {
        if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA")
                || course.equalsIgnoreCase("Python")) {
            return true;
        } else {
            System.err.println("Не верный курс. Выберите из списка: Java, DSA, Python");
            return false;
        }
    }
}
