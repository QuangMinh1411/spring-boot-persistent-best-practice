package com.quangminh.enumattributeconverter.converter;

import com.quangminh.enumattributeconverter.enums.GenreType;
import jakarta.persistence.AttributeConverter;

import static com.quangminh.enumattributeconverter.enums.GenreType.*;

public class GenreTypeConverter implements AttributeConverter<GenreType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(GenreType attr) {

        if (attr == null) {
            return null;
        }

        switch (attr) {
            case HORROR:
                return 10;
            case ANTHOLOGY:
                return 20;
            case HISTORY:
                return 30;
            default:
                throw new IllegalArgumentException("The " + attr + " not supported.");
        }
    }

    @Override
    public GenreType convertToEntityAttribute(Integer dbData) {

        if (dbData == null) {
            return null;
        }

        switch (dbData) {
            case 10:
                return HORROR;
            case 20:
                return ANTHOLOGY;
            case 30:
                return HISTORY;
            default:
                throw new IllegalArgumentException("The " + dbData + " not supported.");
        }
    }
}
