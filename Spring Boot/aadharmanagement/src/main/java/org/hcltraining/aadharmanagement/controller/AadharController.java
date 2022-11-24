package org.hcltraining.aadharmanagement.controller;

import java.util.List;

import org.hcltraining.aadharmanagement.dto.UserResponse;
import org.hcltraining.aadharmanagement.entity.Aadhar;
import org.hcltraining.aadharmanagement.service.AadharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aadhar")
public class AadharController {

    @Autowired
    AadharService aadharService;

    @PostMapping("/addAadhar")
    public Aadhar addAadhar(@RequestBody Aadhar aadhar){
        return aadharService.addAadhar(aadhar);
    }
    
    @GetMapping("/getAadharUsers")
    public List<Aadhar> getAllAadharUsers(){
    	return aadharService.getAllAadharUsers();
    }
    
    @GetMapping("/getAadharByUserName")
    public List<Aadhar> getAadharByUserName(@RequestParam String firstName){
    	return aadharService.getAadharByUserName(firstName);
    }
    
    @PutMapping("/updateAadhar")
    public List<Aadhar> updateAadhar(@RequestParam String firstName,@RequestBody Aadhar aadhar) {
    	return aadharService.updateAadharByUserName(firstName,aadhar);
    }
    
    @DeleteMapping("/deleteAadharByAadharNumber")
    public String deleteAadharByUserName(@RequestParam String aadharNumber) {
    	aadharService.deleteAadharByUserName(aadharNumber);
    	return "Data Deleted Successfully";
    }
    
    @GetMapping("/getNumberOfAadharUsers")
    public UserResponse getNumberOfAadharUsers(String aadharNumber) {
    	return aadharService.getNumberOfAadharUsers(aadharNumber);
    }
}
