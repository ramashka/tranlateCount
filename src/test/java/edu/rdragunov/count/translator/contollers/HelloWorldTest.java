package edu.rdragunov.count.translator.contollers;

import edu.rdragunov.count.translator.controllers.StubController;
import edu.rdragunov.count.translator.starter.Config;
import edu.rdragunov.count.translator.starter.Main;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by roman.dragunov on 03-06-02016.
 */
@Test
@WebIntegrationTest(value = "server.port=8080")
@SpringApplicationConfiguration(Main.class)
public class HelloWorldTest extends AbstractTestNGSpringContextTests{
  @Autowired
  Config config;

  private static Integer PORT;
  private static String LOCALHOST="http://localhost";
  private static String HELLOWORLD_RESOURCE="/stub/helloworld";

  @Test
  public void stubControllerTest() {

    PORT=config.getPort();
    System.out.println(PORT);
    String url=LOCALHOST + ":" + PORT + HELLOWORLD_RESOURCE;
    System.out.println(url);
    try {
      String get=doGet(url);
      String aGet=doApacheGet(url);
      System.out.println("GET: " + get);
      System.out.println("A_GET: " + aGet);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String doGet(String urlPath) throws IOException {
    URL url=new URL(urlPath);
    HttpURLConnection con= (HttpURLConnection) url.openConnection();
    BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
    String s;
    StringBuilder sb=new StringBuilder();
    while ((s=br.readLine())!=null){
      sb.append(s);
    }
    return sb.toString();
  }
  private String doApacheGet(String urlPath) throws IOException {
    HttpClient client=new DefaultHttpClient();
    HttpGet getRequest=new HttpGet(urlPath);
      HttpResponse response=client.execute(getRequest);
      client.getConnectionManager().shutdown();
      BufferedReader br=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
      String s;
      StringBuilder sb=new StringBuilder();
      while ((s=br.readLine())!=null){
        sb.append(s);
      }
    return sb.toString();
  }

}
