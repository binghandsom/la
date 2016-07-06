package com.maq.base;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@TransactionConfiguration(defaultRollback=false)
@ContextConfiguration(locations = {"classpath:config/spring/applicationContext.xml","classpath:config/mongodb/mongodb.xml"})
public class SpringBaseTest extends AbstractTransactionalJUnit4SpringContextTests{

}
