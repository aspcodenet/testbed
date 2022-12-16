package com.systementor.testbed.model;

import org.springframework.data.repository.CrudRepository;

public interface UserAgreementRowRepository extends CrudRepository<UserAgreementRow, Integer> { 
    public Iterable<UserAgreementRow> findByAgreementId(int agreementId);
}
