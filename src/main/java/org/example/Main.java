package org.example;

import CsvFileReader.CsvFileReader;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<String> ignoreList = new ArrayList<>();

        ignoreList.add("EventDate");
        ignoreList.add("Amount");
        ignoreList.add("TransactionDate");
        ignoreList.add("TransactionNumber");

        System.out.println("First file data\n====================================\n");
        List<String> firstFile = CsvFileReader.readFile("TRANSACTION_002.csv", ignoreList);
        System.out.println("\nSecond file data\n====================================\n");
        List<String> secondFile = CsvFileReader.readFile("TRANSACTION_003.csv", ignoreList);

        System.out.println("\nReport\n====================================\n");
        CsvFileReader.compareFiles(firstFile, secondFile);
    }
}