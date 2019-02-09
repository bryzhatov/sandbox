package ua.bryzhatov.formatter;

import ua.bryzhatov.entity.Meta;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dmitry Bryzhatov
 * @since 07.12.2018
 */
public class ConsoleFormatter<T extends String> implements ResultFormatter<T> {

    @Override
    public T format(Map<String, List<Meta>> locations, int count) {
        StringBuilder builder = new StringBuilder();

        Map<String, List<Meta>> sort = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return locations.get(o1).size() > locations.get(o2).size() ? -1 : 1;
            }
        });

        for (String s : locations.keySet()) {
            sort.put(s, locations.get(s));
        }

        int i = 0;
        builder.append("order: word (count) [column, row]\n\n");

        for (String s : sort.keySet()) {
            if (i != -1 && i == count) {
                break;
            }

            i++;

            builder.append(i).append(": ")
                    .append(s)
                    .append(" ");

            List<Meta> list = locations.get(s);
            builder.append("(").append(list.size()).append(")").append(" ");

            for (Meta meta : list) {
                builder.append("[");
                builder.append(meta.getColumn());
                builder.append(", ");
                builder.append(meta.getRow());
                builder.append("]").append(" ");
            }
            builder.append("\n");

        }

        return (T) builder.toString();
    }
}
