package main.service;

import main.serviceInterface.InputStringInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStringService implements InputStringInterface {
    public String inputStr() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }
}
