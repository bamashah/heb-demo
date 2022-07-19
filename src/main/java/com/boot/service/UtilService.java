package com.boot.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class UtilService {

    public Date getDateFromString(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date parsedDate;
		try {
			parsedDate = formatter.parse(str);
		} catch (ParseException e) {
			parsedDate = new Date();
		}
		
		return parsedDate;
    }

}