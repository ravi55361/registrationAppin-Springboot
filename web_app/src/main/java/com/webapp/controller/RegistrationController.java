package com.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.dto.RegistrationDto;
import com.webapp.entity.Registration;
import com.webapp.service.RegistrationService;
import com.webapp.util.EmailService;

@Controller
public class RegistrationController {
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private EmailService emailService;

	//Handler Method  http://localhost:9005/view-registration-page
	@RequestMapping("/view-registration-page")
	public String viewsRegistrationPage() {
		return "new_registration";
	}

	@RequestMapping("/saveReg")
	public String saveRegistration(Registration registration) {
		registrationService.saveRegistration(registration);
		emailService.sendEmail(registration.getEmail(), "welcome", "text");
		return "new_registration";
	}
	//	@RequestMapping("/saveReg")
	//	public String saveRegistration(@ModelAttribute Registration registration) {
	//		registrationService.saveRegistration(registration);
	//		return "new_registration";
	//	}

	//		@RequestMapping("/saveReg")
	//	    public String saveRegistration(
	//	    		@RequestParam("firstName") String fname,
	//	    		@RequestParam("LastName") String lname,
	//	    		@RequestParam("email") String email,
	//	    		@RequestParam("mobile") long mobile
	//	    		) {
	//			Registration registration = new Registration();
	//			registration .setFirstName(fname);
	//			registration.setLastName(lname);
	//			registration.setEmail(email);
	//			registration.setMobile(mobile);
	//			registrationService.saveRegistration(registration);
	//	    	return "new_registration";
	//	    }

	@RequestMapping("/getAllReg")
	public String getAllRegistrations(Model model) {
		List<Registration> reg=registrationService.getAllRegistrations();
		model.addAttribute("registrations", reg);
		return "list_registrations";
	}

	@RequestMapping("/delete")
	public String deleteRegById(@RequestParam("id") int id,Model model) {
		registrationService.deleteRegById(id);
		List<Registration> reg=registrationService.getAllRegistrations();
		model.addAttribute("registrations", reg);
		return "list_registrations";	
	}

	@RequestMapping("/getRegistrationById")
	public String getRegistrationById(@RequestParam("id") int id,Model model) {
		Registration registration = registrationService.getRegistrationById(id);
		model.addAttribute("reg", registration);
		return "update_registration";
	}

	@RequestMapping("/updateReg")
	public String updateRegistration(
			RegistrationDto dto,
			ModelMap model
			) {
		Registration registration = new Registration();
		//registration.setId(dto.getId());
		registration.setFirstName(dto.getFirstName());
		registration.setLastName(dto.getLastName());
		registration.setEmail(dto.getEmail());
		registration.setMobile(dto.getMobile());
		registrationService.saveRegistration(registration);
		List<Registration> reg=registrationService.getAllRegistrations();
		model.addAttribute("registrations", reg);
		return "list_registrations";	
	}
}
