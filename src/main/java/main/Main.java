package main;


import main.service.*;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputStringService inputStringService = new InputStringService();
        String userString = null;
        try {
            userString = inputStringService.inputStr();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long time = System.currentTimeMillis();

        int rowNumber = Integer.parseInt(args[0]);

        FileReaderService fileReaderService = new FileReaderService("airports.dat");
        FileParseService fileParseService = new FileParseService(rowNumber);
        PrintStringsService printStringsService = new PrintStringsService();
        SearchNeedStringsService searchNeedStringsService = new SearchNeedStringsService(fileReaderService,fileParseService);

        List<String> ListStringOfRow = null;
        try {
            ListStringOfRow = fileParseService.parse(fileReaderService);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] needString = new String[0];
        try {
            needString = searchNeedStringsService.searchNeedStringsService(ListStringOfRow, userString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        printStringsService.printStrings(needString);

        String total = "Количество найденных строк: " +
                needString.length +
                " Время, затраченное на поиск: " +
                (System.currentTimeMillis() - time) +
                " мс.";


        System.out.println(total);
    }
}

