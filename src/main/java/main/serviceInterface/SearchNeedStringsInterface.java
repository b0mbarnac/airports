package main.serviceInterface;

import main.service.FileParseService;
import main.service.FileReaderService;

import java.io.IOException;
import java.util.List;

public interface SearchNeedStringsInterface {
    String[] searchNeedStringsService(List<String> ListStringOfRow, String userString) throws IOException;
}
