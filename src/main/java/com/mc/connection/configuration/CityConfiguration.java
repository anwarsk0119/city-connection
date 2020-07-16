package com.mc.connection.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * 
 * @author sadeka
 * 
 *         Configuration class to read city.txt and
 *
 */
@Configuration
public class CityConfiguration {
	@Value("classpath:city.txt")
	private Resource file;

	@Bean(name = "citiesConnections")
	public Map<String, String> getCitiesConnections() {
		Map<String, String> citiesConnections = new HashMap<>();
		try (Scanner sc = new Scanner(file.getInputStream())) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine().trim();
				String pair[] = line.split(",");
				citiesConnections.put(pair[1].trim(), pair[0].trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return citiesConnections;
	}

}