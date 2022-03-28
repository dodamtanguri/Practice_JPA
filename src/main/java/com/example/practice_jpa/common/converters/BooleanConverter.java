package com.example.practice_jpa.common.converters;

import javax.persistence.AttributeConverter;
import java.text.AttributedCharacterIterator;

public class BooleanConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute) ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "Y".equals(dbData);
    }


}
