package org.hcltraining.mvcrud.controller;

import java.util.List;

import org.hcltraining.mvcrud.dto.Customer;
import org.hcltraining.mvcrud.service.CustomerService;
import org.hcltraining.mvcrud.service.CustomerServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CustomerController {
	
		@Autowired
		CustomerServiceImplementation implementation;
		
		@RequestMapping("/loadCustomer")
		public ModelAndView loadCustomer() {
			ModelAndView view = new ModelAndView("AddCustomer.jsp");
			view.addObject("customer", new Customer());
			return view;	
		}
		
		@RequestMapping("/messagePage")
		public ModelAndView message() {
			ModelAndView view = new ModelAndView("Message.jsp");
			return view;
		}
		
		@RequestMapping("/saveCustomer")
		public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
			ModelAndView view = new ModelAndView("messagePage");
			implementation.saveCustomer(customer);
			return view.addObject("msg","Data inserted successfully");
		}
		
		@RequestMapping("/displayCustomer")
		public ModelAndView getCustomers() {
			ModelAndView view = new ModelAndView("display.jsp");
			List<Customer> customer = implementation.getCustomers();
			return view.addObject("getCustomer", customer);
		}
		
		@RequestMapping("/update")
		public ModelAndView update(@RequestParam int id) {
			ModelAndView view = new ModelAndView("updateCustomer.jsp");
			view.addObject("update", implementation.getCustomerById(id));
			return view;
		}
		
		@RequestMapping("/updateCustomer")
		public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
			ModelAndView view = new ModelAndView("messagePage");
			implementation.updateCustomer(customer);
			return view.addObject("msg","Data updated successfully");
		}
		
		@RequestMapping("/delete")
		public ModelAndView delete(@RequestParam int id) {
			ModelAndView view = new ModelAndView("messagePage");
			implementation.deleteCustomer(id);
			return view.addObject("msg","Data deleted successfully");
		}

}
