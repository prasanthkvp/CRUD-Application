package com.jpa.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jpa.example.project.model.SignUpModel;
import com.jpa.example.project.model.response.Response;
import com.jpa.example.project.service.SignUpService;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class SignUpController {
	@Autowired(required = true)
	private SignUpService service;

	@PostMapping("/create")
	public ResponseEntity<Response> createUser(@RequestBody SignUpModel datas) {
		return ResponseEntity.ok(service.createUser(datas));
	}

	@GetMapping("/findall")
	public ResponseEntity<Response> findall() {
		return ResponseEntity.ok(service.findall());
	}

	@GetMapping("/findone")
	public ResponseEntity<Response> getone(@RequestParam String sNo) {
		return ResponseEntity.ok(service.getone(sNo));
	}

	@PutMapping("/update")
	public ResponseEntity<Response> updateUser(@RequestBody SignUpModel datas) {
		return ResponseEntity.ok(service.updateUser(datas));
	}

	@PostMapping("/login")
	public ResponseEntity<Response> loginUser(@RequestParam String mail, @RequestParam String password) {
		return ResponseEntity.ok(service.loginUser(mail, password));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Response> todelete(@RequestParam String sNo) {
		return ResponseEntity.ok(service.todelete(sNo));

	}
}
