package com.bankzecure.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankzecure.webapp.entity.Customer;
import com.bankzecure.webapp.repository.CustomerRepository;

@Controller
public class CustomerController {
  private CustomerRepository repository = new CustomerRepository();
  
  @PostMapping("/customers/update")
  String getAll(Model model, @RequestParam String identifier, @RequestParam String email, @RequestParam String password) {
    Customer customer = repository.update(identifier, email, password);
    model.addAttribute("customer", customer);
    model.addAttribute("updated", true);
    return "profile";
  }

  @PostMapping("/customers/authenticate")
  String login(Model model, @RequestParam String identifier, @RequestParam String password) throws Exception {
    Customer customer = repository.findByIdentifierAndPassword(identifier, password);
    model.addAttribute("customer", customer);
    return "profile";
  }

}