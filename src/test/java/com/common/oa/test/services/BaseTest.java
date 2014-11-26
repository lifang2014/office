package com.common.oa.test.services;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2014/11/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-db.xml"})
public class BaseTest {

    public static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    private static long startTime = 0L;
    private static long endTime = 0L;

    @BeforeClass
    public static void beforeClass(){
        startTime = System.currentTimeMillis();
    }
    @AfterClass
    public static void afterClass(){
        endTime = System.currentTimeMillis();
        logger.info("=============================================");
        logger.info("The runing time : {}ms",(endTime - startTime));
        logger.info("=============================================");
    }
}
