package com.example.testappa;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

    public static String lastMessage = "";

  private CountDownLatch latch = new CountDownLatch(1);

  public void receiveMessage(String message) {
    System.out.println("Received <" + message + ">");
    lastMessage = message;
    latch.countDown();
  }

  public CountDownLatch getLatch() {
    return latch;
  }

}
