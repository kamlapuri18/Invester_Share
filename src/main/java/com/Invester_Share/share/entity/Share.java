package com.Invester_Share.share.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.Invester_Share.investor.entity.Investor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "SHARE")
public class Share{

	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shareId;
    private String shareName;
    private int sharePrice;
    private int shareQuantity;
    private int shareAlloted;
    private LocalDate issueDate;
    
	public Share(Long shareId, String shareName, int sharePrice, int shareQuantity, int shareAlloted) {
		super();
		this.shareId = shareId;
		this.shareName = shareName;
		this.sharePrice = sharePrice;
		this.shareQuantity = shareQuantity;
		this.shareAlloted= shareAlloted;
		this.issueDate = issueDate;
	}

	public Share() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    public Long getShareId() {
		return shareId;
	}


	public void setShareId(Long shareId) {
		this.shareId = shareId;
	}


	public String getShareName() {
		return shareName;
	}


	public void setShareName(String shareName) {
		this.shareName = shareName;
	}


	public int getSharePrice() {
		return sharePrice;
	}


	public void setSharePrice(int sharePrice) {
		this.sharePrice = sharePrice;
	}


	public int getShareQuantity() {
		return shareQuantity;
	}


	public void setShareQuantity(int shareQuantity) {
		this.shareQuantity = shareQuantity;
	}
	
	public int getShareAlloted() {
		return shareAlloted;
	}

	public void setShareAlloted(int shareAlloted) {
		this.shareAlloted = shareAlloted;
	}
	
	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}


	
    @OneToMany(mappedBy = "assignedShare")
    private Set<Investor> investorSet = new HashSet<>();
    
   
}
