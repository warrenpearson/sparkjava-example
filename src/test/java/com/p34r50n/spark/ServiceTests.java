package com.p34r50n.spark;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	TestUserExists.class,
	TestUserList.class
	})
public class ServiceTests {

}
