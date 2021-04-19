package com.endava.utils;

import com.endava.entity.annotations.SortPageField;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

public class PageUtils {
    public static <T> Sort getSortField(Class<T> myClass){

        Optional<Field> sortField = Arrays.stream(myClass.getDeclaredFields())
                                          .filter(field -> field.getAnnotation(SortPageField.class) != null)
                                          .findFirst();

        return sortField.map(field -> Sort.by(field.getName())).orElse(Sort.by("id"));
    }
}
