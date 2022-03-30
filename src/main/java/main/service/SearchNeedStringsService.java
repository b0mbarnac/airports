package main.service;

import main.helpers.CommonHelper;
import main.serviceInterface.SearchNeedStringsInterface;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class SearchNeedStringsService implements SearchNeedStringsInterface {
    private final FileReaderService fileReaderService;
    private final FileParseService fileParseService;

    public SearchNeedStringsService(FileReaderService fileReaderService, FileParseService fileParseService) {
        this.fileReaderService = fileReaderService;
        this.fileParseService = fileParseService;
    }

    public String[] searchNeedStringsService(List<String> ListStringOfRow, String userString) throws IOException {
        String regex = "^\\W?" + userString + ".*(\\s|$)";
        Collections.sort(ListStringOfRow);
        String first = CommonHelper.FindFirst(ListStringOfRow, regex, userString);
        int firstIndex = ListStringOfRow.indexOf(first);
        int countStr = CommonHelper.FindCountOfStr(ListStringOfRow, regex, first);
        assert fileParseService != null;
        return fileParseService.parseNeedStr(fileReaderService, firstIndex,countStr,ListStringOfRow);
    }
}
