package com.toll.etr.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toll.etr.service.TollCalculatorService;
import com.toll.etrservice.api.TollCalculatorServiceApi;
import com.toll.etrservice.models.ETRErrorResponse;
import com.toll.etrservice.models.InlineObject;
import com.toll.etrservice.models.Location;
import com.toll.etrservice.models.TollCalculatorResponse;

@RestController
public class TollController implements TollCalculatorServiceApi {

	@Autowired
	private TollCalculatorService tollCalculatorService;
	
	@Override
	public ResponseEntity<TollCalculatorResponse> calculateTollDetailsByRoute(@RequestBody InlineObject inlineObject) {
		
		TollCalculatorResponse tollCalculatorResponse = new TollCalculatorResponse();
		
		if(null != inlineObject.getSource() && null != inlineObject.getDestination() && 
				! inlineObject.getSource().equalsIgnoreCase(inlineObject.getDestination())) {
			
			Location source = tollCalculatorService.getLocationByName(inlineObject.getSource());
			Location destination = tollCalculatorService.getLocationByName(inlineObject.getDestination());
			
			if (null != source && null != destination) {
				if(tollCalculatorService.isExistEntryAndExit(source.getId(), destination.getId())) {
					tollCalculatorResponse = tollCalculatorService.calculateTollDetailsByRoute(source.getId(), destination.getId());
					if(null != tollCalculatorResponse) {
						tollCalculatorResponse.setEntry(source.getName());
						tollCalculatorResponse.setExit(destination.getName());
					} else {
						ETRErrorResponse err = new ETRErrorResponse();
						err.setErrcode(1004);
						err.setErrMessage("Error in processing...");
						
						tollCalculatorResponse = new TollCalculatorResponse();
						tollCalculatorResponse.setError(err);
						return new ResponseEntity<>(tollCalculatorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
					}
				} else {
					ETRErrorResponse err = new ETRErrorResponse();
					err.setErrcode(1003);
					err.setErrMessage("Entry/Exit not allowed in specifed Source/Destination");
					
					tollCalculatorResponse = new TollCalculatorResponse();
					tollCalculatorResponse.setError(err);
					return new ResponseEntity<>(tollCalculatorResponse, HttpStatus.OK);
				}
				
			} else {
				ETRErrorResponse err = new ETRErrorResponse();
				err.setErrcode(1002);
				err.setErrMessage("Invalid Input - Source/Destination not found");

				tollCalculatorResponse.setError(err);
				return new ResponseEntity<>(tollCalculatorResponse, HttpStatus.BAD_REQUEST);
			}
		} else {
			ETRErrorResponse err = new ETRErrorResponse();
			err.setErrcode(1001);
			err.setErrMessage("Invalid Input - Source/Destination can't be null and can't be same");

			tollCalculatorResponse.setError(err);
			return new ResponseEntity<>(tollCalculatorResponse, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(tollCalculatorResponse,HttpStatus.OK);
	}
}
