package com.Invester_Share.investor.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Invester_Share.investor.entity.Investor;


public interface InvestorRepository extends JpaRepository<Investor, Long>{
    List<Investor> findAllByinvestorId(Long investorId);
}