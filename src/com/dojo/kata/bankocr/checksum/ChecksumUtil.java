package com.dojo.kata.bankocr.checksum;

import com.dojo.kata.bankocr.ioutils.Pair;

import java.util.List;
import java.util.stream.Collectors;

public class ChecksumUtil {
    List<String> codeList;

    public ChecksumUtil(List<String> codeList) {
        this.codeList = codeList;
    }

    public List areCodesValid() {
        return codeList.stream().map(code -> {
            int sum = 0;
            for (int i = 0; i < code.length(); i++) {
                sum += Integer.parseInt(String.valueOf(code.charAt(i))) * (code.length() - i);
            }
            return new Pair(code, sum % 11 == 0);
        }).collect(Collectors.toList());
    }
}
