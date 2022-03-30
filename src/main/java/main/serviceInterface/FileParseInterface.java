package main.serviceInterface;

import main.service.FileReaderService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileParseInterface {
    List<String> parse(FileReaderInterface fileReaderService) throws IOException;
    String[] parseNeedStr(FileReaderService fileReaderService, int firstIndex, int countStr, List<String> ListStringOfRow) throws IOException;
}
