package com.example.insurance.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.insurance.company.model.InsurancePolicy;
import com.example.insurance.company.repository.InsurancePolicyRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InsurancePolicyService {

    private final InsurancePolicyRepository repository;

    public InsurancePolicyService(InsurancePolicyRepository repository) {
        this.repository = repository;
    }

    public List<InsurancePolicy> getAllPolicies() {
        return repository.findAll();
    }

    public Optional<InsurancePolicy> getPolicyById(Long id) {
        return repository.findById(id);
    }

    public InsurancePolicy createPolicy(InsurancePolicy policy) {
        return repository.save(policy);
    }

    public InsurancePolicy updatePolicy(Long id, InsurancePolicy policyDetails) {
        InsurancePolicy existingPolicy = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Policy not found: " + id));
        
        existingPolicy.setPolicyNumber(policyDetails.getPolicyNumber());
        existingPolicy.setCusomerName(policyDetails.getCusomerName());
        existingPolicy.setStartDate(policyDetails.getStartDate());
        existingPolicy.setEndDate(policyDetails.getEndDate());
        existingPolicy.setPremiumAmount(policyDetails.getPremiumAmount());

        return repository.save(existingPolicy);
    }

    public ResponseEntity<Void> deletePolicy(Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    public Page<InsurancePolicy> searchPoliciesByCustomerName(String customerName, int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }
    
}
