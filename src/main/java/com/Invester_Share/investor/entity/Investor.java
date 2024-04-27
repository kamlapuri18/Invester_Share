package com.Invester_Share.investor.entity;
import java.util.HashSet;
import java.util.Set;

import com.Invester_Share.share.entity.Share;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Investor")
public class Investor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long investorId;
	private String investerName;
	private String investerPanCard;
	private double investorAccount;
	
	public Investor(Long investorId, String investerName, String investerPanCard, double investorAccount,
			Set<Share> assignedShare) {
		super();
		this.investorId = investorId;
		this.investerName = investerName;
		this.investerPanCard = investerPanCard;
		this.investorAccount = investorAccount;
		this.assignedShare = assignedShare;
	}
	public Investor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany
	@JoinTable(name = "investor_share",
		joinColumns = @JoinColumn(name = "investor_id"),
		inverseJoinColumns = @JoinColumn(name = "share_id")
	)
	private Set<Share> assignedShare =  new HashSet<>();

	public Set<Share> getAssignedShare() {
		return assignedShare;
	}

	public void setAssignedShare(Set<Share> assignedShare) {
		this.assignedShare = assignedShare;
	}

	public Long getInvestorId() {
		return investorId;
	}

	public void setInvestorId(Long investorId) {
		this.investorId = investorId;
	}

	public String getInvesterName() {
		return investerName;
	}

	public void setInvesterName(String investerName) {
		this.investerName = investerName;
	}

	public String getInvesterPanCard() {
		return investerPanCard;
	}

	public void setInvesterPanCard(String investerPanCard) {
		this.investerPanCard = investerPanCard;
	}

	public double getInvestorAccount() {
		return investorAccount;
	}

	public void setInvestorAccount(double investorAccount) {
		this.investorAccount = investorAccount;
	}
}
