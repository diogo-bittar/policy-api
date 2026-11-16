package br.com.diogo.policyapi.controller;

import br.com.diogo.policyapi.dto.PolicyRequest;
import br.com.diogo.policyapi.dto.PolicyResponse;
import br.com.diogo.policyapi.entity.Policy;
import br.com.diogo.policyapi.repository.PolicyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {
    private final PolicyRepository repository;

    public PolicyController(PolicyRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PolicyResponse create(@RequestBody PolicyRequest request){
        Policy newPolicy = new Policy(request.insuredName(), request.premiumValue(), request.category());
        Policy saved = repository.save(newPolicy);
        return toResponse(saved);
    }

    @GetMapping
    public List<PolicyResponse> list() {
        return repository.findAll().stream().map(p -> toResponse(p)).toList();
    }

    private PolicyResponse toResponse(Policy p){
        return new PolicyResponse(p.getId(), p.getInsuredName(), p.getPremiumValue(), p.getCategory());
    }
}


