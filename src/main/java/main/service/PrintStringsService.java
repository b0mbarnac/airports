package main.service;

import main.serviceInterface.PrintStringsInterface;

public class PrintStringsService implements PrintStringsInterface {
    public void printStrings(String[] strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
