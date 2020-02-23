package com.xie.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xie.domain.bean.User;

public interface IUserDao extends JpaRepository<User, Long> , JpaSpecificationExecutor<User>{

}
