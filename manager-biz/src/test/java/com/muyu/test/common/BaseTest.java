package com.muyu.test.common;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created by maowei on 2015/11/5.
 */
@ContextConfiguration(locations={"classpath*:spring/spring-*.xml"})
public class BaseTest extends AbstractJUnit4SpringContextTests {

}
