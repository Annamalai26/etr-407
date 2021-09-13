package com.toll.etr.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.google.gson.Gson;
import com.toll.etr.models.Key;
import com.toll.etrservice.models.Location;
import com.toll.etrservice.models.Route;
import com.toll.etrservice.models.TollCalculatorResponse;

@Component
public class TollCalculatorService {

	static Map<Key, Route> distMap = new HashMap<Key, Route>();
	static List<Location> locationList = new ArrayList<Location>();
	JSONParser parser = new JSONParser();
	
	@Value("${etr.407.config-value.toll-rate}") 	
	private String tollRate;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		try {

			//Object obj = parser.parse(new FileReader("D:\\Workspace\\Code_Base\\A1_407ETR\\interchanges.json"));
			//JSONObject locations = (JSONObject) ((JSONObject) obj).get("locations");

			InputStream in = new FileInputStream(ResourceUtils.getFile("classpath:json/interchanges.json"));
			JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(in, "UTF-8"));
			JSONObject locations = (JSONObject) jsonObject.get("locations");

			locations.keySet().forEach(
					(Object loc) -> {
						String locationId = (String) loc;
						Gson gson = new Gson();

						Location locationDetails = gson.fromJson(gson.toJson(locations.get(locationId)),Location.class);
						locationDetails.setId(Integer.parseInt(locationId));
						locationList.add(locationDetails);
						locationDetails.getRoutes().forEach(route->distMap.put(new Key(locationDetails.getId(), route.getToId()), route));
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TollCalculatorResponse calculateTollDetailsByRoute( Integer sourceId, Integer destinationId) {

		TollCalculatorResponse tollCalculatorResponse= new TollCalculatorResponse();

		BigDecimal tripDistance = calculateDistance(sourceId, destinationId);
		System.out.println("Total Trip distance :: " + tripDistance );
		tollCalculatorResponse.setDistance(tripDistance);
		tollCalculatorResponse.setCharge(tripDistance.multiply(new BigDecimal(tollRate)));

		return tollCalculatorResponse;
	}

	public static BigDecimal calculateDistance(Integer startId, Integer destinationId) {

		BigDecimal tripDistance = BigDecimal.ZERO;
		int sourcePoint;

		if (startId < destinationId) {
			for (sourcePoint = startId; sourcePoint<destinationId; sourcePoint++) {

				if (null != distMap.get(new Key(sourcePoint, sourcePoint+1)))
					tripDistance = tripDistance.add( distMap.get(new Key(sourcePoint, sourcePoint+1)).getDistance());
			}
		}else {
			for (sourcePoint = startId; sourcePoint>destinationId; sourcePoint--) {

				if (null != distMap.get(new Key(sourcePoint, sourcePoint-1)))
					tripDistance = tripDistance.add( distMap.get(new Key(sourcePoint, sourcePoint-1)).getDistance());
			}
		}

		return tripDistance;

	}

	public Location getLocationByName(String locName) {

		List<Location> location = new ArrayList<Location>();
		if(null != locName) {

			location = locationList
					.stream()
					.filter(loc -> loc.getName().equalsIgnoreCase(locName))
					.collect(Collectors.toList());
		}

		return (location.size() == 1) ? location.get(0) : null;
	}
	
	public Boolean isExistEntryAndExit(Integer startId, Integer destinationId) {
		
		Boolean entryFlag, exitFlag = false;
		int startIndex = 0, destIndex = 0;
		
		locationList.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
		for (Location loc : locationList) {
			if(startId == loc.getId()) 
				startIndex = locationList.indexOf(loc);
			
			if(destinationId == loc.getId()) 
				destIndex = locationList.indexOf(loc);
		}
		
		if(startId < destinationId) {
			
			entryFlag = distMap.get(new Key(locationList.get(startIndex + 1).getId(), startId)).getEnter();
			exitFlag = distMap.get(new Key(locationList.get(destIndex - 1).getId(), destinationId)).getExit();
		} else {
			
			entryFlag = distMap.get(new Key(locationList.get(startIndex - 1).getId(), startId)).getEnter();
			exitFlag = distMap.get(new Key(locationList.get(destIndex + 1).getId(), destinationId)).getExit();
			
		}
		
		return ((entryFlag && exitFlag) ? true : false );
	}
}
