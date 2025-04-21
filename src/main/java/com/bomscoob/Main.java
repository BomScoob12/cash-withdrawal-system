package com.bomscoob;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number you need to withdraw : ");
        int amount = scanner.nextInt();
        scanner.nextLine();

        Map<Integer, Integer> banknotes = setupBanknotes();
        System.out.println("Available banknotes : " + banknotes);

        Map<Integer, Integer> results = new LinkedHashMap<>();
        for (var banknote : banknotes.entrySet()) {
            if (amount >= banknote.getKey()) {
                int numberOfBanknote = calNumberOfCash(amount, banknote.getKey());

                // validate banknotes
                if (isNotValidNumberBanknoteAvailable(numberOfBanknote, banknote.getValue())) {
                    int validBanknote = banknote.getValue();
                    amount -= validBanknote * banknote.getKey();

                    // update bank available
                    banknotes.replace(banknote.getKey(), 0);
                    results.put(banknote.getKey(), validBanknote);
                    continue;
                }
                // update amount
                amount %= banknote.getKey();

                // update bank available
                banknotes.replace(banknote.getKey(), banknote.getValue() - numberOfBanknote);
                results.put(banknote.getKey(), numberOfBanknote);
            } else {
                results.put(banknote.getKey(), 0);
            }
        }
        System.out.printf("Total remaining : %d\n", amount);
        results.entrySet().forEach(System.out::println);
    }

    private static int calNumberOfCash(int amount, int divider) {
        return amount / divider;
    }

    private static boolean isNotValidNumberBanknoteAvailable(int numberOfBanknote, int availableBanknote) {
        return numberOfBanknote > availableBanknote;
    }

    private static Map<Integer, Integer> setupBanknotes() {
        Map<Integer, Integer> banknotes = new LinkedHashMap<>();
        banknotes.put(1000, 10);
        banknotes.put(500, 10);
        banknotes.put(100, 2);
        banknotes.put(50, 10);
        banknotes.put(20, 10);
        return banknotes;
    }

}