package com.example.practice_jpa.common.enmuns;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum BoardSort {
    CREATE_DATE("createDate", "등록일 순 "), MODIFY_DATE("modifyDate", "수정일 순");
    private static final Map<String, BoardSort> map = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(BoardSort::getField, Function.identity())));
    private final String field;
    private final String description;

    public static BoardSort find(String field) {
        return Optional.ofNullable(map.get(field)).orElse(CREATE_DATE);
    }
}
