package ua.bryzhatov;

import ua.bryzhatov.formatter.ConsoleFormatter;
import ua.bryzhatov.realization.Tree;
import ua.bryzhatov.realization.Trie;
import ua.bryzhatov.util.SearchMachineUtil;

/**
 * @author Dmitry Bryzhatov
 * @since 07.12.2018
 */
public class Application {
    private final static String PATH = "./src/main/resources/book.txt";
    private final static int COUNT = -1;
    private static final String QUERY = "the";

    public static void main(String[] args) {
        System.out.println("================ trie ================\n");
        long trie = trie();
        System.out.println("\n================ tree ================");
        long tree = tree();

        System.out.println("Trie: " + trie);
        System.out.println("Tree: " + tree);
    }

    public static long trie() {
        long start = System.nanoTime();
        Trie tree = SearchMachineUtil.indexing(PATH);
        System.out.println(new ConsoleFormatter<>().format(tree.get(QUERY), COUNT));
        return System.nanoTime() - start;
    }

    public static long tree() {
        long start = System.nanoTime();
        Tree tree = SearchMachineUtil.indexingTreeMap(PATH);
        System.out.println(new ConsoleFormatter<>().format(tree.get(QUERY), COUNT));
        return System.nanoTime() - start;
    }
}
