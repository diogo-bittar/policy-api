package br.com.diogo.policyapi.repository;

import br.com.diogo.policyapi.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
}

