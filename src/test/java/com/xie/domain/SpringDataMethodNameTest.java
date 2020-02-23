package com.xie.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xie.domain.bean.Customer;
import com.xie.domain.dao.ICustomerDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringDataMethodNameTest {
	@Autowired
    private ICustomerDao icustomerDao;
	
	//测试方法命名规则的查询
    @Test
    public void testNaming() {
        Customer customer = icustomerDao.findByCustName("张飞");
        System.out.println(customer);
    }
    
  //测试方法命名规则的查询
    @Test
    public void testFindByCustNameLike() {
        List<Customer> list = icustomerDao.findByCustNameLike("%程序员");
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }


    //测试方法命名规则的查询
    @Test
    public void testFindByCustNameLikeAndCustIndustry() {
        Customer customer = icustomerDao.findByCustNameLikeAndCustLevel("%程序员", "普通");
        System.out.println(customer);
    }
}
