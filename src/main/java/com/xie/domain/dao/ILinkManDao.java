package com.xie.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xie.domain.bean.LinkMan;

/**
 * 联系人的dao接口
 */
public interface ILinkManDao extends JpaRepository<LinkMan, Long>,JpaSpecificationExecutor<LinkMan>{

}
