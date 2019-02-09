package ua.bryzhatov.realization;

import ua.bryzhatov.entity.Meta;

import java.util.*;

/**
 * @author Dmitry Bryzhatov
 * @since 07.12.2018
 */
public class Trie {
    private TreeMap<Character, Trie> tries;
    private List<Meta> indexes;

    public Trie() {
        tries = new TreeMap<>();
    }

    public Trie(boolean end) {
        this();
        if (end) {
            indexes = new ArrayList<>();
        }
    }

    public Map<String, List<Meta>> get(String word) {
        HashMap<Integer, Trie> nearestTrie = nearestEqualTrie(word.toLowerCase());

        if (nearestTrie == null) {
            return null;
        } else {
            Map<String, List<Meta>> words = new TreeMap<>();

            Trie root = getTrie(nearestTrie);
            recursion(root, getCommonPart(word, getIndex(nearestTrie)), words);

            return words;
        }
    }

    public void add(String word, int column, int row, int startIndex) {
        Map<Integer, Trie> nearestTrie = nearestEqualTrie(word);
        Trie trie;
        int index;

        if (nearestTrie == null) {
            trie = new Trie(false);
            this.tries.put(word.charAt(0), trie);
            index = 1;
        } else {
            trie = getTrie(nearestTrie);

            if (getIndex(nearestTrie) == word.length()) {
                if (trie.indexes == null) {
                    trie.indexes = new ArrayList<>();
                }
                trie.indexes.add(new Meta(column, row, startIndex));
                return;
            }
            index = getIndex(nearestTrie);
        }

        for (int i = index; i < word.length(); i++) {
            Trie intermediateTrie = new Trie(i == word.length() - 1);
            if (i == word.length() - 1) {
                intermediateTrie.indexes.add(new Meta(column, row, startIndex));
            }
            trie.tries.put(word.charAt(i), intermediateTrie);
            trie = intermediateTrie;
        }
    }

    /**
     * Find nearest part of word that contain in trie and put it in HashMap. Key - is index word.
     * Value - is last equal symbol in find word. This index need for method add().
     * It will start add word with point index from HashMap.
     */
    private HashMap<Integer, Trie> nearestEqualTrie(String word) {
        HashMap<Integer, Trie> nearestTrie = new HashMap<>();
        Trie cursor = this;
        int i = 0;

        while (i < word.length() && cursor.tries.get(word.charAt(i)) != null) {
            cursor = cursor.tries.get(word.charAt(i));
            i++;
        }

        if (cursor == this) {
            return null;
        }

        nearestTrie.put(i, cursor);
        return nearestTrie;
    }

    private int getIndex(Map<Integer, Trie> trieMap) {
        return trieMap.keySet().iterator().next();
    }

    private Trie getTrie(Map<Integer, Trie> trieMap) {
        return trieMap.get(getIndex(trieMap));
    }

    private void recursion(Trie trie, StringBuilder wordBuilder, Map<String, List<Meta>> words) {
        // indexes hold only in end ua.bryzhatov.realization.Trie of word.
        if (trie.indexes != null) {
            words.put(wordBuilder.toString(), trie.indexes);
        }

        for (Character c : trie.tries.keySet()) {
            wordBuilder.append(c);
            recursion(trie.tries.get(c), wordBuilder, words);
            wordBuilder.delete(wordBuilder.length() - 1, wordBuilder.length());
        }
    }

    private StringBuilder getCommonPart(String word, int endIndex) {
        StringBuilder builder = new StringBuilder();
        char[] words = word.toCharArray();

        for (int i = 0; i < endIndex; i++) {
            builder.append(words[i]);
        }
        return builder;
    }
}
