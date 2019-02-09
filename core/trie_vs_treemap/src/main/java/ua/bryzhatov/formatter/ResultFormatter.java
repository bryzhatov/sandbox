package ua.bryzhatov.formatter;

import ua.bryzhatov.entity.Meta;

import java.util.List;
import java.util.Map;

/**
 * @author Dmitry Bryzhatov
 * @since 07.12.2018
 */
public interface ResultFormatter<T> {
    T format(Map<String, List<Meta>> locations, int count);
}
