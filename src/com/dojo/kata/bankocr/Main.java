package com.dojo.kata.bankocr;

import com.dojo.kata.bankocr.checksum.ChecksumUtil;
import com.dojo.kata.bankocr.ioutils.FileReader;
import com.dojo.kata.bankocr.ioutils.Pair;
import com.dojo.kata.bankocr.ioutils.Parser;

import java.io.File;
import java.util.List;

public class Main {
    private static String FILENAME = "inputFile1-9.txt";

    public static void main(String[] args) {
        FileReader fileReader = new FileReader((new File("").getAbsolutePath() + "\\resources\\" + FILENAME));
        List<String> fileLines = fileReader.getLines();

        getCode(fileLines);
    }

    /* Story 1 - Decode file */
    public static void getCode(List<String> fileLines) {
        Parser parser = new Parser(fileLines);
        List<String> codeList = parser.getCodeList();
        codeList.forEach(code -> System.out.println(code));
        verifyChecksum(codeList);
    }

    /* Story 2 - Verify checksum */
    public static void verifyChecksum(List<String> codeList) {
        ChecksumUtil checksumUtil = new ChecksumUtil(codeList);
        List<Pair<String, Boolean>> codeChecksumList = checksumUtil.areCodesValid();
        codeChecksumList.forEach(codeChecksum -> System.out.println(codeChecksum.a() + " has a " + codeChecksum.b() + " checksum"));
    }
}
