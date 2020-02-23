package com.xie.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xie.domain.bean.Customer2;
import com.xie.domain.bean.LinkMan;
import com.xie.domain.dao.ICustomerDao2;
import com.xie.domain.dao.ILinkManDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OneToManyTest {

    @Autowired
    private ICustomerDao2 icustomerDao;

    @Autowired
    private ILinkManDao ilinkManDao;
    
    /**
     * 保存一个客户，保存一个联系人
     *  效果：客户和联系人作为独立的数据保存到数据库中
     *      联系人的外键为空
     *  原因？
     *      实体类中没有配置关系
     */
    @Test
    @Transactional //配置事务
    @Rollback(false) //不自动回滚
    public void testAdd() {
        //创建一个客户，创建一个联系人
        Customer2 customer = new Customer2();
        customer.setCustName("百度");
        
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小杨");

        linkMan.setCustomer(customer);
//      customer.getLinkMans().add(linkMan);

        icustomerDao.save(customer);
        ilinkManDao.save(linkMan);
   }
    
    /**
     * 会有一条多余的update语句
     *      * 由于一的一方可以维护外键：会发送update语句
     *      * 解决此问题：只需要在一的一方放弃维护权即可
     *
     */
    @Test
    @Transactional //配置事务
    @Rollback(false) //不自动回滚
    public void testAdd2() {
        //创建一个客户，创建一个联系人
        Customer2 customer = new Customer2();
        customer.setCustName("百度");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小李");


//        linkMan.setCustomer(customer);
        customer.getLinkMans().add(linkMan);

        icustomerDao.save(customer);
        ilinkManDao.save(linkMan);
    }
    
    /**
     * 级联添加：保存一个客户的同时，保存客户的所有联系人
     *      需要在操作主体的实体类上，配置casacde属性
     */
    @Test
    @Transactional //配置事务
    @Rollback(false) //不自动回滚
    public void testCascadeAdd() {
        Customer2 customer = new Customer2();
        customer.setCustName("百度1");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小李1");

        customer.getLinkMans().add(linkMan);
        
        icustomerDao.save(customer);
    }


    /**
     * 级联删除：
     *      删除1号客户的同时，删除1号客户的所有联系人
     */
    @Test
    @Transactional //配置事务
    @Rollback(false) //不自动回滚
    public void testCascadeRemove() {
        //1.查询1号客户
        Customer2 customer = icustomerDao.findOne(1l);
        //2.删除1号客户
        icustomerDao.delete(customer);
    }

}
