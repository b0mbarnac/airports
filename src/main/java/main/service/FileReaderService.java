package main.service;

import main.Main;
import main.serviceInterface.FileReaderInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

public class FileReaderService implements FileReaderInterface {

    String fileName;

    public FileReaderService(String fileName) {
        this.fileName = fileName;
    }

    public BufferedReader reader() throws FileNotFoundException {
        try {
            return new BufferedReader(new FileReader(fileName));
        }
        catch (FileNotFoundException e){
            throw new FileNotFoundException("файл не найден");
        }

    }
}
