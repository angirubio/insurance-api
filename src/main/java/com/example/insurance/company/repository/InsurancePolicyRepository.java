package com.example.insurance.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.insurance.company.model.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long>{
    InsurancePolicy findByPolicyNumber(String policyNumber);
}
