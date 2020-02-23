package com.xie.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xie.domain.bean.Role;

public interface IRoleDao extends JpaRepository<Role, Long> , JpaSpecificationExecutor<Role>{

}
