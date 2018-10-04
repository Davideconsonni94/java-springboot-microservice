package io.swagger.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.api.HelloWorldApiController;
import io.swagger.constant.Constant;
import io.swagger.database.dao.HelloWorldDao;
import io.swagger.model.HelloWorld;
import io.swagger.model.HelloWorldRequest;

@Service
public class HelloWorldService {
	
	private static final Logger log = LoggerFactory.getLogger(HelloWorldApiController.class);
	
	HelloWorldDao helloWorldDao;
	
	@Autowired
	public void setHelloWorldDao(HelloWorldDao helloWorlDao) {
		this.helloWorldDao = helloWorldDao;
	}

	public Object getHelloWorld (Object request){
		Object response = null;
		try {
			if (request==null)
				response =  getHelloWorld();
			if (request instanceof HelloWorldRequest)
				response =  getHelloWorld((HelloWorldRequest) request);
			if (request instanceof String)
				response = getHelloWorld((String)request);
		} catch (Exception e) {
			log.error("Error during execute service method getHelloWorld - Details: " + e);
			throw e;
		}
		return response;
	}

	public String getHelloWorld() {
		return Constant.HELLO_WORLD;
	}

	public List<HelloWorld> getHelloWorld(HelloWorldRequest body) {
		List<HelloWorld> helloWorldList = new ArrayList<HelloWorld>();
		for(String name: body.getFriends()){
			HelloWorld helloWorld = new HelloWorld();
			helloWorld.setMessage("Hello " + name + " from " + body.getMyName() + "!");
			helloWorldList.add(helloWorld);
		}
		return helloWorldList;
	}

	public String getHelloWorld(String name) {
		return "Hello " + name + "!";
	}


}
