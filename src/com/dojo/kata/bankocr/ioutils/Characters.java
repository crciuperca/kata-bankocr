package com.dojo.kata.bankocr.ioutils;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Characters {
    ZERO(new Pair<>(0, new char[][]{
            {' ', '_', ' '},
            {'|', ' ', '|'},
            {'|', '_', '|'},})),
    ONE(new Pair<>(1, new char[][]{
            {' ', ' ', ' '},
            {' ', ' ', '|'},
            {' ', ' ', '|'},})),
    TWO(new Pair<>(2, new char[][]{
            {' ', '_', ' '},
            {' ', '_', '|'},
            {'|', '_', ' '},})),
    THREE(new Pair<>(3, new char[][]{
            {' ', '_', ' '},
            {' ', '_', '|'},
            {' ', '_', '|'},})),
    FOUR(new Pair<>(4, new char[][]{
            {' ', ' ', ' '},
            {'|', '_', '|'},
            {' ', ' ', '|'},})),
    FIVE(new Pair<>(5, new char[][]{
            {' ', '_', ' '},
            {'|', '_', ' '},
            {' ', '_', '|'},})),
    SIX(new Pair<>(6, new char[][]{
            {' ', '_', ' '},
            {'|', '_', ' '},
            {'|', '_', '|'},})),
    SEVEN(new Pair<>(7, new char[][]{
            {' ', '_', ' '},
            {' ', ' ', '|'},
            {' ', ' ', '|'},})),
    EIGHT(new Pair<>(8, new char[][]{
            {' ', '_', ' '},
            {'|', '_', '|'},
            {'|', '_', '|'},})),
    NINE(new Pair<>(9, new char[][]{
            {' ', '_', ' '},
            {'|', '_', '|'},
            {' ', '_', '|'},}));

    private Pair<Integer, char[][]> value;

    public Pair<Integer, char[][]> getValue() {
        return value;
    }

    public static Integer getNumber(char[][] matrix) {
        Integer found = null;
        try {
            found = Arrays.stream(values()).filter(x -> {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (x.value.b[i][j] != matrix[i][j]) {
                            return false;
                        }
                    }
                }
                return true;
            }).map(x -> x.value.a).collect(Collectors.toList()).get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid input");
            System.exit(1);
        }
        return found;
    }

    Characters(Pair<Integer, char[][]> value) {
        this.value = value;
    }
}
