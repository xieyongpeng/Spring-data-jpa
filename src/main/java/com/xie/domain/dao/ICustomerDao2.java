package com.xie.domain.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xie.domain.bean.Customer2;

public interface ICustomerDao2 extends JpaRepository<Customer2, Long>, JpaSpecificationExecutor<Customer2>{

}
