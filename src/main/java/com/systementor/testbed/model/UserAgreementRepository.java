package com.systementor.testbed.model;

import org.springframework.data.repository.CrudRepository;

public interface UserAgreementRepository extends CrudRepository<UserAgreement, Integer> { 
    public Iterable<UserAgreement> findByEmail(String email);
}
