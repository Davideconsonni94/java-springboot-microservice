package io.swagger;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import io.swagger.api.HelloWorldApiController;
import io.swagger.database.dao.HelloWorldDao;
import io.swagger.model.HelloWorldRequest;
import io.swagger.service.HelloWorldService;

public class HelloWorldTest {
	
	@Spy
	HelloWorldApiController helloApiController = new HelloWorldApiController();
	
	@Spy
	HelloWorldService helloWorldService = new HelloWorldService();
	
	@Mock
	HelloWorldDao helloWorldDao = new HelloWorldDao();
	
	public static final String NAME = "test";
	
	public static final List<String> FRIENDS = Arrays.asList("test1","test2","test3");
	
	@Before
	public void init(){
		helloWorldService.setHelloWorldDao(helloWorldDao);
		helloApiController.setHelloWorldService(helloWorldService);
	}
	
	@Test
	public void testHelloWorld(){
		helloApiController.getHelloWorld();
	}
	
	@Test
	public void testHelloWorldForMyFriends(){
		HelloWorldRequest helloWorldRequest = new HelloWorldRequest();
		helloWorldRequest.setMyName(NAME);
		helloWorldRequest.setFriends(FRIENDS);
		helloApiController.getHelloWorldForMyFriends(helloWorldRequest);
	}
	
	@Test
	public void testHelloWorldWithName(){
		helloApiController.getHelloWorldWithName(NAME);
	}

}
