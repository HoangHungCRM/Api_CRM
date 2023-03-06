package com.resdii.crm.user.repository.impl;

import com.resdii.noodev.maria.repository.CommonMariaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class  BaseCustomRepositoryImpl {

    protected EntityManager em;
    protected CommonMariaRepository commonRepository;

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Autowired
    public void setCommonRepository(CommonMariaRepository commonRepository) {
        this.commonRepository = commonRepository;
    }
}
