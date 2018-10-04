package io.swagger.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;
import io.swagger.model.HelloWorld;
import io.swagger.model.HelloWorldRequest;
import io.swagger.service.HelloWorldService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-09-07T07:48:13.195Z")

@Controller
public class HelloWorldApiController implements HelloWorldApi {

	private static final Logger log = LoggerFactory.getLogger(HelloWorldApiController.class);

	private HelloWorldService helloWorldService;
	
	@Autowired
	public void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	public ResponseEntity<HelloWorld> getHelloWorld() {
		log.info("Start method getHelloWorld..");
		HelloWorld helloworld = new HelloWorld();
		try {
			helloworld.setMessage((String)helloWorldService.getHelloWorld());
			log.info("Exit message: " + helloworld.getMessage());
			return new ResponseEntity<HelloWorld>(helloworld, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error during method getHelloWorld - Detail: " + e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<HelloWorld>> getHelloWorldForMyFriends(
			@ApiParam(value = "HelloWorld request", required = true) @Valid @RequestBody HelloWorldRequest body) {
		log.info("Start method getHelloWorldForMyFriends..");
		List<HelloWorld> helloWorldList = new ArrayList<HelloWorld>();
		try {
			helloWorldList = (List<HelloWorld>)helloWorldService.getHelloWorld(body);
			log.info("Exit messages: " + helloWorldList);
			return new ResponseEntity<List<HelloWorld>>(helloWorldList, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error during method getHelloWorldForMyFriends - Detail: " + e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<HelloWorld> getHelloWorldWithName(
			@ApiParam(value = "Enter your name", required = true) @PathVariable("name") String name) {
		log.info("Start method getHelloWorldWithName..");
		HelloWorld helloworld = new HelloWorld();
		try {
			helloworld.setMessage((String)helloWorldService.getHelloWorld(name));
			log.info("Exit message: " + helloworld.getMessage());
			return new ResponseEntity<HelloWorld>(helloworld, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error during method getHelloWorldWithName - Detail: " + e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
