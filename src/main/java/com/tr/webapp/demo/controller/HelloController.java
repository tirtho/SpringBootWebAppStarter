package com.tr.webapp.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tr.webapp.demo.model.UserProfile;

@RestController
public class HelloController {
	
	public HelloController() {
	}

	@RequestMapping(value = "/api/hello/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
//	@PreAuthorize("hasAuthority('APPROLE_DemoUser')")
	public ResponseEntity<?> getHelloUserProfile(
//				OAuth2AuthenticationToken authToken,
				@PathVariable String id 
			) {
//		OAuth2User auth2User = authToken.getPrincipal();
		String userName = "TEST"; //auth2User.getName();
		String preferredUserName = "TEST@TEST"; //auth2User.getAttribute("preferred_username");
		return new ResponseEntity<>(new UserProfile(userName, preferredUserName, false), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/hello", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	@PreAuthorize("hasAuthority('APPROLE_DemoUser')")
	public ResponseEntity<?> verifyHelloUserProfile(
//				OAuth2AuthenticationToken authToken,
				@RequestBody UserProfile userProfile
			) {
//		OAuth2User auth2User = authToken.getPrincipal();
		String userName = "TEST"; //auth2User.getName();
		String preferredUserName = "TEST@TEST"; //auth2User.getAttribute("preferred_username");
		if (userName.compareTo(userProfile.getUserName()) == 0
				&& preferredUserName.compareTo(userProfile.getPreferredUserName()) == 0
				&& userProfile.getIsAdmin() == false) {
			return new ResponseEntity<>("Name matched with logged in user name", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Name didn't match with logged in user name", HttpStatus.NOT_ACCEPTABLE);
		}
	}
}