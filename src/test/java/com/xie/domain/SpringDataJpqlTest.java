package com.xie.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xie.domain.bean.Customer;
import com.xie.domain.dao.ICustomerDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringDataJpqlTest {
	@Autowired
    private ICustomerDao icustomerDao;
	
	@Test
    public void  testFindJPQL() {
		Customer customer =icustomerDao.findJpql("张飞");
		System.out.println(customer.toString());
	}
	
	@Test
    public void testFindCustNameAndId1() {
        Customer customer =  icustomerDao.findCustNameAndId1("黑马程序员",1l);
        System.out.println(customer);
    }
	
	@Test
    public void testFindCustNameAndId2() {
        Customer customer =  icustomerDao.findCustNameAndId2(1l,"黑马程序员");
        System.out.println(customer);
    }
	
	/**
     * 测试jpql的更新操作
     *  * springDataJpa中使用jpql完成 更新/删除操作
     *         * 需要手动添加事务的支持
     *         * 默认会执行结束之后，回滚事务
     *   @Rollback : 设置是否自动回滚
     *          false | true
     */
    @Test
    @Transactional //添加事务的支持
    @Rollback(value = false)
    public void testUpdateCustomer() {
        icustomerDao.updateCustomer(1l,"马超程序员");
    }
}
