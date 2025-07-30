package com.studentapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    private static List<Student> studentList;
    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("*************** Student Management System ***************");
        studentList = new ArrayList<Student>();

        while (true) {
            System.out.println("*********************** Welcome *************************");

            scanner = new Scanner(System.in);
            System.out.println("Выберите вариант");
            System.out.println("1. Регистрация студента");
            System.out.println("2. Поиск студента по ID");
            System.out.println("3. Показать информацию о студентах");
            System.out.println("4. Показать информацию о студентах в отсортированном порядке");
            System.out.println("5. Выход");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    enrollStudent(scanner);
                    break;
                case 2:
                    findStudentById(scanner);
                    break;
                case 3:
                    printAllStudentData();
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    exit();
                    break;

                default:
                    System.out.println("Не верный вариант...");

            }
        }

    }

    private static void exit() {
        System.exit(0);
    }

    private static void printAllStudentData() {
        if (!studentList.isEmpty()) {
            System.out.println("-------------------Список всех студентов--------------------------");
            for (Student student : studentList) {
                student.printStudentInfo();
            }
            System.out.println("-------------------*********************--------------------------");
        } else {
            System.out.println("Список студентов пуст");
        }
    }

    private static void findStudentById(Scanner scanner) {
        Student studentFound = null;
        System.out.println("Введите ID студента");
        String studentId = scanner.next();
        if (!studentList.isEmpty()) {
            try {
                studentFound = studentList.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId)).findFirst()
                        .orElseThrow(() -> new RuntimeException("Не найдено"));
            } catch (RuntimeException e) {
                System.err.println("Студент с ID '" + studentId + "' не найден");
            }
            studentFound.printStudentInfo();

        }
        if (studentList.isEmpty()) {
            System.out.println("Введите верный ID");
        }
    }

    private static void enrollStudent(Scanner scanner) {
        System.out.println("Введите имя студента");
        String studentName = scanner.next();

        System.out.println("Введите возраст студента");
        int studentAge = scanner.nextInt();

        System.out.println("Введите идентификатор студента");
        String studentId = scanner.next();

        Student newStudent = new Student(studentName, studentAge, studentId);
        studentList.add(newStudent);

        while (true) {
            System.out.println("Введите курс  на который хотите записаться... Или введите Done чтобы выйти");
            String courseName = scanner.next();
            if (courseName.equalsIgnoreCase("done")) {
                break;
            }
            newStudent.enrollCourse(courseName);
        }
        newStudent.printStudentInfo();
    }

    private static void sortByName() {
        Comparator<Student> studentNameComparator = Comparator.comparing(Student::getName);
        studentList.sort(studentNameComparator);
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

