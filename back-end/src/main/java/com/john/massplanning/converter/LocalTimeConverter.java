package com.john.massplanning.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.sql.Time;
import java.time.LocalTime;

@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {

    @Override
    public Time convertToDatabaseColumn(LocalTime attribute) {
        return attribute == null ? null : Time.valueOf(attribute);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time dbData) {
        return dbData == null ? null : dbData.toLocalTime();
    }
}