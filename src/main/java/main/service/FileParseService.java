package main.service;

import main.serviceInterface.FileParseInterface;
import main.serviceInterface.FileReaderInterface;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileParseService implements FileParseInterface {

    private int rowNumber;

    public FileParseService(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public List<String> parse(FileReaderInterface fileReaderService) throws IOException {
        BufferedReader bufferedReader = fileReaderService.reader();

        String tempRow;
        List<String> list = new ArrayList<>();

        while ((tempRow = bufferedReader.readLine()) != null) {
            String splitRow = tempRow.split(",")[this.rowNumber];
            list.add(splitRow);
        }
        bufferedReader.close();
        return list;
    }

    public String[] parseNeedStr(FileReaderService fileReaderService, int firstIndex, int countStr, List<String> ListStringOfRow) throws IOException {
        String[] needStr = new String[countStr];
        BufferedReader bufferedReader = fileReaderService.reader();
        String tempRow;
        int counter = 0;
        int tmpIndex;
        while ((tempRow = bufferedReader.readLine()) != null && counter < countStr) {
            tmpIndex = ListStringOfRow.indexOf(tempRow.split(",")[rowNumber]);//+ countOfRepeat;
            if ((firstIndex + countStr - 1) >= tmpIndex && firstIndex <= tmpIndex) {
                needStr[tmpIndex - firstIndex] = tempRow;
                if (tmpIndex != ListStringOfRow.lastIndexOf(tempRow.split(",")[rowNumber])) {
                    ListStringOfRow.set(tmpIndex,null);
                }
                counter++;
            }
        }
        return needStr;
    }
}
