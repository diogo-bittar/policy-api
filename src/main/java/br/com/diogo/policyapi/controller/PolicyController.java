package br.com.diogo.policyapi.controller;

import br.com.diogo.policyapi.dto.PolicyRequest;
import br.com.diogo.policyapi.dto.PolicyResponse;
import br.com.diogo.policyapi.service.PolicyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {
    private final PolicyService service;

    public PolicyController(PolicyService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PolicyResponse create(@RequestBody PolicyRequest request){
        return service.create(request);
    }

    @GetMapping
    public List<PolicyResponse> list() {
        return service.list();
    }

}


