package com.webapp.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.dto.ReadRegistrationDto;
import com.webapp.dto.RegistrationDto;
import com.webapp.entity.Registration;
import com.webapp.exception.ResourceNotFoundExecption;
import com.webapp.repository.RegistrationRepository;

@RestController
@RequestMapping("/api/registrations")
public class RestRegistrationController {
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	//Read
	@GetMapping
	public ResponseEntity<ReadRegistrationDto> getAllRegistration(){
		List<Registration> registration = registrationRepository.findAll();
		ReadRegistrationDto readdto = new ReadRegistrationDto();
		readdto.setRegistration(registration);
		readdto.setMessage("Reading Records Successfulluy....");
		return new ResponseEntity<>(readdto,HttpStatus.OK);
	}
	
	//Delete 
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRegistration(@PathVariable int id) {
		Optional<Registration> optional = registrationRepository.findById(id);
		if(optional.isPresent()) {
			registrationRepository.deleteById(id);
		}else {
			throw new ResourceNotFoundExecption("Record not found with id:"+id);
		}		
		return new ResponseEntity<>("Record deleted....",HttpStatus.OK);
	}
	
	//Save
	@PostMapping
	public ResponseEntity<RegistrationDto> saveRegistration(@RequestBody Registration reg) {
		Registration registration = registrationRepository.save(reg);
		RegistrationDto dto = new RegistrationDto();
		dto.setFirstName(reg.getFirstName());
		dto.setLastName(registration.getLastName());
		dto.setEmail(registration.getEmail());
		dto.setMobile(registration.getMobile());
		return new ResponseEntity<>(dto,HttpStatus.CREATED);
	}
	
	//Update
	@PutMapping
	public ResponseEntity<Registration> updateRegistration(@RequestParam int id,@RequestBody RegistrationDto registrationDto) {
		Registration registration = registrationRepository.findById(id).get();
		registration.setFirstName(registrationDto.getFirstName());
		registration.setLastName(registrationDto.getLastName());
		registration.setEmail(registrationDto.getEmail());
		registration.setMobile(registrationDto.getMobile());
		Registration updateRegistration = registrationRepository.save(registration);
		return new ResponseEntity<>(updateRegistration,HttpStatus.OK);
	}

}