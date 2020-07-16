package com.mc.connection.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 
 * @author sadeka
 * 
 *         service class to check if the cities are connected or not.
 *
 */
@Service
public class CityConnectionService {

	@Autowired
	@Qualifier("citiesConnections")
	public Map<String, String> citiesConnections;

	public String checkIfConnected(String origin, String dest) {
		String result = "no";
		Map<String, String> connectionPairMap = citiesConnections;
		String startPoint = origin;
		while (connectionPairMap.containsKey(startPoint)) {
			startPoint = connectionPairMap.get(startPoint);
			if (startPoint.equals(dest)) {
				result = "yes";
				break;
			}
		}
		return result;
	}
}
