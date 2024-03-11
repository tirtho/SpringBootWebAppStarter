package com.tr.webapp.demo.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tr.webapp.demo.model.HelloItem;

@RestController
public class AdminController {
	@RequestMapping(value = "/api/admin/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@PreAuthorize("hasAuthority('APPROLE_DocAIDemo-Admin')")
	public ResponseEntity<?> getAdminUserProfile(
			OAuth2AuthenticationToken authToken,
			@PathVariable String id
		) {
		OAuth2User auth2User = authToken.getPrincipal();
		String userName = auth2User.getName();
		String preferredUserName = auth2User.getAttribute("preferred_username");
		return new ResponseEntity<>(new HelloItem(userName, preferredUserName, true), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/admin/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@PreAuthorize("hasAuthority('APPROLE_DocAIDemo-Admin')")
	public ResponseEntity<?> verifyAdminUserProfile(
			OAuth2AuthenticationToken authToken,
			@RequestBody HelloItem userProfile 
		) {
		OAuth2User auth2User = authToken.getPrincipal();
		String userName = auth2User.getName();
		String preferredUserName = auth2User.getAttribute("preferred_username");
		if (StringUtils.compare(userName, userProfile.getUserName()) == 0
				&& StringUtils.compare(preferredUserName, userProfile.getPreferredUserName()) == 0
				&& userProfile.getIsAdmin() == true) {
			return new ResponseEntity<>("Entered profile matched with logged in ADMIN user", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Entered profile DID NOT match with logged in ADMIN user", HttpStatus.NOT_ACCEPTABLE);
		}
	}
}