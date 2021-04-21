package com.wolkensoftware.AadharSpringBoot.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolkensoftware.AadharSpringBoot.dto.SaveDTO;
import com.wolkensoftware.AadharSpringBoot.entity.AadharEntity;
import com.wolkensoftware.AadharSpringBoot.entity.PANEntity;
import com.wolkensoftware.AadharSpringBoot.service.AadharService;

@RestController
@RequestMapping("/")
public class AadharResources {

//	Logger logger = (Logger) LoggerFactory.logger(AadharResources.class);

	Logger logger = LoggerFactory.getLogger(AadharResources.class);

	@Autowired
	AadharService aadharService;

	@PostMapping("/addPerson")
	public ResponseEntity<AadharEntity> addPerson(@RequestBody SaveDTO saveDTO) {

		logger.info("INSIDE /addPerson");

		AadharEntity aadharEntity = aadharService.validateAndAddPerson(saveDTO);
		if (aadharEntity != null)
			return new ResponseEntity<AadharEntity>(aadharEntity, HttpStatus.OK);
		else
			return new ResponseEntity<AadharEntity>(aadharEntity, HttpStatus.FAILED_DEPENDENCY);

	}

	@PostMapping("/addPersons")
	public ResponseEntity<Integer> addPersons(@RequestBody SaveDTO[] saveDTOs) {

		logger.info("INSIDE /addPersons");

		Integer count = aadharService.validateAndAddPersons(saveDTOs);
		if (count > 0)
			return new ResponseEntity<Integer>(count, HttpStatus.OK);
		else
			return new ResponseEntity<Integer>(count, HttpStatus.FAILED_DEPENDENCY);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<AadharEntity>> getAll() {

		logger.info("INSIDE /getAll");

		List<AadharEntity> aadharEntities = aadharService.validateAndGetAll();
		if (aadharEntities == null) {
			return new ResponseEntity<List<AadharEntity>>(aadharEntities, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<List<AadharEntity>>(aadharEntities, HttpStatus.ACCEPTED);

		}
	}

	@GetMapping("/getAllByArea/{area}")
	public ResponseEntity<List<AadharEntity>> getAllByArea(@PathVariable String area) {

		logger.info("INSIDE /getAllByArea");

		List<AadharEntity> aadharEntities = aadharService.validateAndGetAllByArea(area);
		if (aadharEntities == null) {
			return new ResponseEntity<List<AadharEntity>>(aadharEntities, HttpStatus.FAILED_DEPENDENCY);
		} else {
			return new ResponseEntity<List<AadharEntity>>(aadharEntities, HttpStatus.OK);

		}

	}

	@DeleteMapping("/deleteByName/{name}")
	public ResponseEntity<String> deleteByName(@PathVariable String name) {

		logger.info("INSIDE /deleteByName");

		String message = aadharService.validateAndDeleteByName(name);
		if (message != null) {
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);

		}

	}

	@PutMapping("/updatePincodeByName/{name}/{pincode}")
	public boolean updatePincodeByName(@PathVariable String name, @PathVariable int pincode) {

		logger.info("INSIDE /updatePincodeByName");

		return aadharService.validateAndUpdatePincodeByName(pincode, name);
	}

	@PutMapping("/updatePanCityByPanNumber/{panCity}&{panNumber}&{panPinCode}&{panName}")
	public ResponseEntity<PANEntity> updatePanCityByPanNumber(@PathVariable String panCity,
			@PathVariable double panNumber, @PathVariable double panPinCode, @PathVariable String panName) {

		logger.info("INSIDE /updatePanCityByPanNumber");

		PANEntity panEntity = aadharService.validateAndUpdatePanCityByPanNumber(panCity, panNumber, panPinCode,
				panName);
		if (panEntity != null)
			return new ResponseEntity<PANEntity>(panEntity, HttpStatus.OK);
		else
			return new ResponseEntity<PANEntity>(panEntity, HttpStatus.FAILED_DEPENDENCY);

	}

	@GetMapping("/getAllByPincodeOrAreaOrName/{area}&{name}")
	public ResponseEntity<AadharEntity> getAllByPincodeOrAreaOrName(@PathVariable String area,
			@PathVariable String name) {

		logger.info("INSIDE /getAllByPincodeOrAreaOrName");

		AadharEntity aadharEntity = aadharService.validateAndGetAllByAreaOrName(name, area);
		if (aadharEntity != null)
			return new ResponseEntity<AadharEntity>(aadharEntity, HttpStatus.OK);
		else
			return new ResponseEntity<AadharEntity>(aadharEntity, HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/getAllByPanNameOrPanNumberOrPanCityOrpanPincode/{panName}&{panNumber}&{panCity}&{panPincode}")
	public ResponseEntity<List<PANEntity>> getAllByPanNameOrPanNumberOrPanCityOrpanPincode(@PathVariable String panName,
			@PathVariable double panNumber, @PathVariable String panCity, @PathVariable double panPincode) {

		logger.info("INSIDE /getAllByPanNameOrPanNumberOrPanCityOrpanPincode");

		List<PANEntity> panEntities = aadharService.validateAndGetAllByPanNameOrPanNumberOrPanCityOrpanPincode(panName,
				panNumber, panCity, panPincode);
		if (panEntities != null)
			return new ResponseEntity<List<PANEntity>>(panEntities, HttpStatus.OK);
		else
			return new ResponseEntity<List<PANEntity>>(panEntities, HttpStatus.BAD_REQUEST);

	}

}
