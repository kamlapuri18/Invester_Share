package com.Invester_Share.investor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Invester_Share.investor.entity.Investor;
import com.Invester_Share.investor.service.InvestorService;

@RestController
@RequestMapping("/investor")
public class InvestorController {
	
	@Autowired
	private InvestorService investorService;
	
	@PostMapping("/register")
	public ResponseEntity<Investor> saveInvestor(@RequestBody Investor investorObj){
		investorService.saveInvestor(investorObj);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(value = {"/getInvestors", "/{investorId}"})
	public List<Investor> getInvestor(@PathVariable(required = false) Long investorId) { 
		return investorService.getInvestorDetails(investorId);
	}
	
	@DeleteMapping("delete/{investorId}")
    public ResponseEntity removeInvestor(@PathVariable Long investorId){
        investorService.deleteInvestor(investorId);
        return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping("/{investorId}/share/{shareId}")
	public Investor assignShareToInvestor(
			@PathVariable Long investorId,
			@PathVariable Long shareId
			) {
		return investorService.assignShareToInvestor(investorId, shareId);
	}
	
	
	@PutMapping("/{investorId}/share/{shareId}/allottedshare/{shareAlloted}")
	public Investor assignShareAllotedToInvestor(
			@PathVariable Long investorId,
			@PathVariable Long shareId,
			@PathVariable int shareAlloted
			) {
		return investorService.assignShareAllotedToInvestor(investorId, shareId, shareAlloted);
	}
}