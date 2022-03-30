package main.serviceInterface;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

public interface FileReaderInterface {
    BufferedReader reader() throws FileNotFoundException;
}
