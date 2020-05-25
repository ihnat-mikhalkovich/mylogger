package com.epam.ekids.mylogger;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double firstNumber = scanner.nextDouble();
        log("Первое полученное число: " + firstNumber);


        System.out.print("Введите второе число: ");
        double secondNumber = scanner.nextDouble();
        log("Первое полученное число: " + secondNumber);

        System.out.print("Введите арифметическую операцию: ");
        scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        log("Полученный оператор: " + operation);

        double result = 0.0;
        switch (operation) {
            case "+" :
                result = firstNumber + secondNumber;
                break;
            case "-" :
                result = firstNumber - secondNumber;
                break;
            case "*" :
                result = firstNumber * secondNumber;
                break;
            case "/" :
                result = firstNumber / secondNumber;
                break;
            default :
                System.out.println("Default case");
        }

        System.out.println("Result: " + result);
    }

    public static void log(String message) {
        System.out.println(LocalDateTime.now() + " " + message);
    }

}