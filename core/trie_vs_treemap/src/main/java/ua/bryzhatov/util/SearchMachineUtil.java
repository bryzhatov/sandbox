package ua.bryzhatov.util;

import ua.bryzhatov.entity.Meta;
import ua.bryzhatov.realization.Tree;
import ua.bryzhatov.realization.Trie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitry Bryzhatov
 * @since 07.12.2018
 */
public class SearchMachineUtil {

    private static final List<String> STOP_WORDS = new ArrayList<>();

    static {
        STOP_WORDS.add("the");
        STOP_WORDS.add("th");
        STOP_WORDS.add("a");
        STOP_WORDS.add("at");
        STOP_WORDS.add("in");
        STOP_WORDS.add("is");
        STOP_WORDS.add("am");
        STOP_WORDS.add("are");
    }

    public static Trie indexing(String path) {
        Trie trie = null;
        StringBuilder wordBuilder = new StringBuilder();

        try (BufferedReader stream = new BufferedReader(new FileReader(new File(path)))) {

            int cursorIndex = -1;
            int startIndex = 0;
            int character = 0;
            int column = 1;
            int row = 1;
            int startRow = 1;
            trie = new Trie();

            while ((character = stream.read()) != -1) {
                cursorIndex++;

                if (character == 32 || character == '\n' || character == ',' || character == '.'
                        || character == '-' || character == '!' || character == '?') {

                    String word = wordBuilder.toString();

                    if (!STOP_WORDS.contains(word.toLowerCase()) && word.length() > 0) {
                        trie.add(word.toLowerCase(), column, startRow, startIndex);
                    }
                    wordBuilder.delete(0, wordBuilder.length());
                }

                if ((character >= 65 && character <= 90) || (character >= 97 && character <= 122)) {

                    if (wordBuilder.length() == 0) {
                        startIndex = cursorIndex;
                        startRow = row;
                    }

                    wordBuilder.append((char) character);
                }

                if (character == '\n') {
                    column++;
                    row = 0;
                }
                row++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Problems with file.");
        }
        return trie;
    }

    public static Tree indexingTreeMap(String path) {
        Tree tree = new Tree();

        StringBuilder wordBuilder = new StringBuilder();

        try (BufferedReader stream = new BufferedReader(new FileReader(new File(path)))) {

            int cursorIndex = -1;
            int startIndex = 0;
            int character = 0;
            int column = 1;
            int row = 1;
            int startRow = 1;

            while ((character = stream.read()) != -1) {
                cursorIndex++;


                if (character == 32 || character == '\n' || character == ',' || character == '.'
                        || character == '-' || character == '!' || character == '?') {

                    String word = wordBuilder.toString();

                    if (!STOP_WORDS.contains(word.toLowerCase()) && word.length() > 0) {
                        tree.add(word.toLowerCase(), new Meta(column, startRow, startIndex));
                    }
                    wordBuilder.delete(0, wordBuilder.length());
                }

                if ((character >= 65 && character <= 90) || (character >= 97 && character <= 122)) {

                    if (wordBuilder.length() == 0) {
                        startIndex = cursorIndex;
                        startRow = row;
                    }

                    wordBuilder.append((char) character);
                }

                if (character == '\n') {
                    column++;
                    row = 0;
                }
                row++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Problems with file.");
        }
        return tree;
    }
}
