package br.com.diogo.policyapi.controller;

import br.com.diogo.policyapi.dto.PolicyRequest;
import br.com.diogo.policyapi.dto.PolicyResponse;
import br.com.diogo.policyapi.entity.Policy;
import br.com.diogo.policyapi.repository.PolicyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return new PolicyResponse(saved.getId(), saved.getInsuredName(), saved.getPremiumValue(), saved.getCategory());
    }
}
