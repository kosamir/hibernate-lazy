package com.example.demo.model.converters;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;

public class DateConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		// TODO Auto-generated method stub
		return attribute == null ? null : Date.valueOf(attribute.now());
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		// TODO Auto-generated method stub
		 return dbData == null ? null : dbData.toLocalDate();
	}

	

}
