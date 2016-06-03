package edu.rdragunov.count.translator.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by roman.dragunov on 03-06-02016.
 */
@RestController
@RequestMapping("stub")
public class StubController {

  public final static String HELLO_WORLD="<h1>Hello world<h1>";
  public final static Logger LOGGER= LoggerFactory.getLogger(StubController.class);

  @RequestMapping(value = "/helloworld")
  public String getIndex(){
    LOGGER.info("Enter to the getIndex");
    return HELLO_WORLD;
  }
}
