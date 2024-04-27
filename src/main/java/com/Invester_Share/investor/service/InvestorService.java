package com.Invester_Share.investor.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Invester_Share.investor.entity.Investor;
import com.Invester_Share.investor.repository.InvestorRepository;
import com.Invester_Share.share.entity.Share;
import com.Invester_Share.share.repository.ShareRepository;


@Service
public class InvestorService {

	@Autowired
	private InvestorRepository investorRepository;
	
	@Autowired
	private ShareRepository shareRepository;

	private Share[] shareList;
	
	public void saveInvestor(Investor investorObj ) {
		investorRepository.save(investorObj);
	}
	
	public List<Investor> getInvestorDetails(Long investorId){
		if(null != investorId) { 
	return investorRepository.findAllByinvestorId(investorId);		
		}else {
			return investorRepository.findAll();
	}}
	public void deleteInvestor(Long investorId) {
		investorRepository.deleteById(investorId);
	}
	
	public Investor assignShareToInvestor(Long investorId, Long shareId) {
		Set<Share> shareSet = null;
		Investor investor = investorRepository.findById(investorId).get();
		Share share = shareRepository.findById(shareId).get();
		shareSet = investor.getAssignedShare();
		shareSet.add(share);
		investor.setAssignedShare(shareSet);	
		return investorRepository.save(investor);
		
	}
	
	public Investor assignShareAllotedToInvestor(Long investorId, Long shareId, int shareAlloted) {
		Set<Share> shareSet = null;
		Investor investor = investorRepository.findById(investorId).get();
		Share share = shareRepository.findById(shareId).get();
		shareSet = investor.getAssignedShare();
		shareSet.add(share);
		investor.setAssignedShare(shareSet);
		return investorRepository.save(investor);
	}
}
