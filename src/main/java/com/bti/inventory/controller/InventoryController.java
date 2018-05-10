
package com.bti.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bti.inventory.dto.SiteDto;
import com.bti.inventory.service.InventoryService;

import io.swagger.annotations.ApiOperation;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/sites")
	@ApiOperation(value = "Api to create the sites", response = ResponseEntity.class)
	public ResponseEntity<String> createSite(@Valid @RequestBody SiteDto Site) {
		inventoryService.createSite(Site);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/test/sites")
	public ResponseEntity<String> createSite1() {
		return new ResponseEntity<String>("hellllo", HttpStatus.OK);

	}

	@GetMapping("/sites")
	public List<SiteDto> getAllSite() {
		return inventoryService.getAllSite();

	}

	@GetMapping("/sites/{siteId}")
	public SiteDto getSiteById(@PathVariable("siteId") String siteId) {
		return inventoryService.getSiteById(siteId);

	}

	@PutMapping("/sites/{Id}")
	public ResponseEntity<String> updateSite(@Valid @RequestBody SiteDto Site,@PathVariable("Id") Long id) {
		inventoryService.updateSite(Site,id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@DeleteMapping("/sites/{siteId}")
	public ResponseEntity<String> updateSite(@PathVariable("siteId") String siteId) {
		inventoryService.deleteSite(siteId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
