package com.inguarus;

import java.io.*;
import java.util.Scanner;

public class Main {

    static final String file = "List.txt";
    private static int result;
    static int characters = 0;

    public static void main(String[] args) {

        getFromFileLine();
        getFromFileWords();
        getFromFileCharacter();

    }

    public static void getFromFileLine() {

        try (FileReader input = new FileReader((file));
             LineNumberReader count = new LineNumberReader(input)) {
            while (count.skip(Long.MAX_VALUE) > 0) {

            }
            result = count.getLineNumber() + 1;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR! File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Number of lines: " + result);
    }

    public static void getFromFileWords() {

        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            int count = 0;
            while (scanner.hasNext()) {
                scanner.next();
                count++;
            }
            System.out.println("Number of words: " + count);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR! File not found!");
        }
    }

    public static void getFromFileCharacter() {

        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                characters += line.length();
                String[] tmpArray = line.split(" ");
                for (int i = 0; i < tmpArray.length; i++) {
                    if (tmpArray[i].matches("[a-zA-Zа-яА-Я.,;]+")) {
                    }
                }
            }
            System.out.println("Number of characters: " + characters);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR! File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



