package edu.rdragunov.count.translator.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Component;

/**
 * Created by roman.dragunov on 03-06-02016.
 */
@Component
public class Config {
  @Autowired
  ServerProperties serverProperties;

  public Integer getPort(){
    return serverProperties.getPort();
  }


}
