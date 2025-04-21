package com.bomscoob;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number you need to deposit : ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        Map<Integer, Integer> output = new HashMap<>();

        if (amount >= 1000) {
            int n = calNumberOfCash(amount, 1000);
            amount %= 1000;
            output.put(1000, n);
        }
        if (amount >= 500) {
            int n = calNumberOfCash(amount, 500);
            amount %= 500;
            output.put(500, n);
        }
        if (amount >= 100) {
            if (amount > 200) {
                int n = 2;
                amount = amount - 200;
                output.put(100, n);
            } else {
                int n = calNumberOfCash(amount, 100);
                amount %= 100;
                output.put(100, n);
            }
        }
        if (amount >= 50) {
            int n = calNumberOfCash(amount, 50);
            amount %= 50;
            output.put(50, n);
        }
        if (amount >= 20) {
            int n = calNumberOfCash(amount, 20);
            amount %= 20;
            output.put(20, n);
        }
        if (amount >= 10) {
            int n = calNumberOfCash(amount, 10);
            amount %= 10;
            output.put(10, n);
        }

        System.out.printf("Total remaining : %d\n", amount);

        output.entrySet().forEach(System.out::println);
    }

    private static int calNumberOfCash(int amount, int divider) {
        return amount / divider;
    }

}