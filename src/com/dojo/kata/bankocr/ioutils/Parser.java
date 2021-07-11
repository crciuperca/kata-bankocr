package com.dojo.kata.bankocr.ioutils;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    List<String> lines;

    public Parser(List<String> lines) {
        this.lines = lines;
    }

    public List<String> getCodeList() {
        List<String> codeList = new ArrayList<>();
        for (int j = 0; j < lines.size(); j += 4) {
            String code = "";
            for (int i = 0; i < lines.get(0).length(); i += 3) {
                char[][] characterMatrix = new char[][]{
                        {getChar(  j,     i), getChar(   j,     i + 1), getChar(  j,     i + 2)},
                        {getChar(j + 1, i), getChar(j + 1, i + 1), getChar(j + 1, i + 2)},
                        {getChar(j + 2, i), getChar(j + 2, i + 1), getChar(j + 2, i + 2)}};
                code += Characters.getNumber(characterMatrix);
            }
            codeList.add(code);
        }
        return codeList;
    }

    /*Fix for missing trailing spaces*/
    private char getChar(int i, int j) {
        try {
            return lines.get(i).charAt(j);
        } catch (StringIndexOutOfBoundsException e) {
            return ' ';
        }
    }
}
