package com.example.insurance.company.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.insurance.company.model.InsurancePolicy;
import com.example.insurance.company.service.InsurancePolicyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {
    private final InsurancePolicyService service;

    public InsurancePolicyController (InsurancePolicyService service) {
        this.service = service;
    }

    @GetMapping
    public List<InsurancePolicy> getAllPolicies() {
        return service.getAllPolicies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsurancePolicy> getPolicyById(@PathVariable Long id) {
        Optional<InsurancePolicy> policy = service.getPolicyById(id);
        return policy.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InsurancePolicy> createPolicy(@Valid @RequestBody InsurancePolicy policy) {
       InsurancePolicy newPolicy = service.createPolicy(policy);
       return ResponseEntity.status(201).body(newPolicy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsurancePolicy> updatePolicy(@PathVariable Long id, @Valid @RequestBody InsurancePolicy policy) {
        InsurancePolicy updatedPolicy = service.updatePolicy(id, policy);
        return ResponseEntity.ok(updatedPolicy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
        service.deletePolicy(id);
        return ResponseEntity.noContent().build();
    }

}
