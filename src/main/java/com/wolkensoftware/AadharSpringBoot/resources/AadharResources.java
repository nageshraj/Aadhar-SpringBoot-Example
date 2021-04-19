package com.wolkensoftware.AadharSpringBoot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.wolkensoftware.AadharSpringBoot.service.AadharService;

@RestController
@RequestMapping("/")
public class AadharResources {

//	Logger logger = (Logger) LoggerFactory.logger(AadharResources.class);

	@Autowired
	AadharService aadharService;

	@PostMapping("/add")
	public AadharEntity addPerson(@RequestBody SaveDTO saveDTO) {
		return aadharService.validateAndAddPerson(saveDTO);

	}

	@GetMapping("/get")
	public List<AadharEntity> getAll() {
		return aadharService.validateAndGetAll();

	}

	@DeleteMapping("/delete/{name}")
	public String deleteByName(@PathVariable String name) {
		return aadharService.validateAndDeleteByName(name);

	}

	@PutMapping("/update")
	public AadharEntity updatePincodeByName(@RequestBody AadharEntity aadharEntity) {
		return aadharService.validateAndUpdatePincodeByName(aadharEntity.getPincode(), aadharEntity.getName());
	}

}
