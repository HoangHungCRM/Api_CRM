package com.resdii.crm.user.repository;

import com.resdii.crm.user.domain.Test;
import com.resdii.noodev.maria.repository.MariaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface TestRepository extends MariaRepository<Test, BigInteger> {
//    Test findById(String id);
}
