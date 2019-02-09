package ua.bryzhatov.realization;

import ua.bryzhatov.entity.Meta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Dmitry Bryzhatov
 * @since 07.12.2018
 */
public class Tree {
    private TreeMap<String, List<Meta>> treeMap;

    public Tree() {
        this.treeMap = new TreeMap<>();
    }

    public void add(String word, Meta meta) {
        List<Meta> locations = treeMap.get(word);

        if (locations == null) {
            locations = new ArrayList<>();
            treeMap.put(word, locations);
        }

        locations.add(meta);
    }

    public TreeMap<String, List<Meta>> get(String get) {
        TreeMap<String, List<Meta>> listTreeMap = new TreeMap<>();

        Iterator<String> iterator = treeMap.navigableKeySet().tailSet(get, true).iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();

            if (checkCommonPart(get, next)) {
                listTreeMap.put(next, treeMap.get(next));
            }
        }

        return listTreeMap;
    }

    private boolean checkCommonPart(String find, String key) {
        for (int i = 0; i < find.length(); i++) {
            if (find.charAt(i) != key.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
