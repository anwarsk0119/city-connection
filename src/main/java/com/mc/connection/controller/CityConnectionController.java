/**
 * 
 */
package com.mc.connection.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mc.connection.service.CityConnectionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author sadeka
 *
 *         controller class to deal with checking if the given cities has a
 *         connection between them.
 */
@RestController
public class CityConnectionController {
	
	@Autowired
	private CityConnectionService cityConnectionService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "API will redirect to swagger ui page, we can access end points available in this micro service")
	public void redirectToSwaggerUi(HttpServletResponse response) throws IOException {
		response.sendRedirect("swagger-ui.html");
	}

	@RequestMapping(value = "connected", method = RequestMethod.GET)
	@ApiOperation(value = "API used to check if there is connection between given cities(derives from city.txt combinations)")
	public String checkIfConnected(
			@ApiParam(value = "Please enter Departure city", required = true) @RequestParam("origin") String origin,
			@ApiParam(value = "Please enter Arrival city", required = true) @RequestParam("destination") String destination) {
		return cityConnectionService.checkIfConnected(origin, destination);
	}
}
