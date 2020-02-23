package com.xie.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xie.domain.dao.ICustomerDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringDataSqlTest {
	@Autowired
    private ICustomerDao icustomerDao;
	
	//测试sql查询
    @Test
    public void testFindSql() {
        List<Object[]> list = icustomerDao.findSql("张飞%");
        for(Object [] obj : list) {
            System.out.println(Arrays.toString(obj));
        }
    }
}
