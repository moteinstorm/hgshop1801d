package com.bawei.hgshop.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration({"classpath:applicationContext-dubbo-provider.xml",
"classpath:applicationContext-dao.xml"})
@RunWith(SpringRunner.class)
public class TestBase {

}
