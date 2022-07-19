package com.boot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.boot.model.Item;
import com.boot.repository.ItemRepository;
import com.boot.service.UtilService;

@Component
public class CsvReader implements CommandLineRunner {
	@Autowired 
	private ItemRepository itemRepository;
	
	@Autowired
    private UtilService utilService;
	
	public void run(String... args) {
        String csvFile = "C:\\heb\\items.txt";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] itemLine = line.split(cvsSplitBy);
                
        		Item item = new Item();
        		item.setId(Long.parseLong(itemLine[0]));

        		item.setDescription(itemLine[1]);
        		
        		item.setLastSold(utilService.getDateFromString(itemLine[2]));
        		
        		String shelfLife = itemLine[3];
        		item.setShelfLife(Integer.parseInt(shelfLife.substring(0, shelfLife.length()-1)));
        		item.setDepartment(itemLine[4] + " ");
        		item.setPrice(Double.parseDouble(itemLine[5].trim().substring(1)));
        		item.setUnit(itemLine[6]);
        		item.setxFor(Integer.parseInt(itemLine[7]));
        		item.setCost(Double.parseDouble(itemLine[8].trim().substring(1)));
        		
        		itemRepository.save(item);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}