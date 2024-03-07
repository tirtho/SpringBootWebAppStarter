package com.tr.webapp.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tr.webapp.demo.model.UserProfile;

@RestController
public class AdminController {
	@RequestMapping(value = "/api/Admin/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
//	@PreAuthorize("hasAuthority('APPROLE_Admin')")
	public ResponseEntity<?> getAdminUserProfile(
//			OAuth2AuthenticationToken authToken,
			@PathVariable String id
		) {
//		OAuth2User auth2User = authToken.getPrincipal();
		String userName = "HELLO"; //auth2User.getName();
		String preferredUserName = "HELLO@HELLO"; //auth2User.getAttribute("preferred_username");
		return new ResponseEntity<>(new UserProfile(userName, preferredUserName, true), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/Admin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
//	@PreAuthorize("hasAuthority('APPROLE_Admin')")
	public ResponseEntity<?> verifyAdminUserProfile(
//			OAuth2AuthenticationToken authToken,
			@RequestBody UserProfile userProfile 
		) {
//		OAuth2User auth2User = authToken.getPrincipal();
		String userName = "HELLO"; //auth2User.getName();
		String preferredUserName = "HELLO@HELLO"; //auth2User.getAttribute("preferred_username");
		if (userName.compareTo(userProfile.getUserName()) == 0
				&& preferredUserName.compareTo(userProfile.getPreferredUserName()) == 0
				&& userProfile.getIsAdmin() == true) {
			return new ResponseEntity<>("Name matched with logged in Admin user name", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Name didn't match with logged in Admin user name", HttpStatus.NOT_ACCEPTABLE);
		}
	}
}