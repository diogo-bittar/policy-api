package br.com.diogo.policyapi.service;

import br.com.diogo.policyapi.dto.PolicyRequest;
import br.com.diogo.policyapi.dto.PolicyResponse;
import br.com.diogo.policyapi.entity.Policy;
import br.com.diogo.policyapi.repository.PolicyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PolicyService {
    private final PolicyRepository repository;

    public PolicyService(PolicyRepository repository) {
        this.repository = repository;
    }

    public PolicyResponse create( PolicyRequest request){
        Policy newPolicy = new Policy(request.insuredName(), request.premiumValue(), request.category());
        Policy saved = repository.save(newPolicy);
        return toResponse(saved);
    }

    public List<PolicyResponse> list() {
        return repository.findAll().stream().map(p -> toResponse(p)).toList();
    }

    private PolicyResponse toResponse(Policy p){
        return new PolicyResponse(p.getId(), p.getInsuredName(), p.getPremiumValue(), p.getCategory());
    }


}
