package com.glovoapp.demo.common;

import java.net.URI;

public class WorkLoads {
  private WorkLoads() {}

  public static String callApi() {
    try {
      System.err.printf("Starting thread %s !%n", Thread.currentThread());
      final var uri = new URI("http://localhost:9999/delay/3");
      try (final var stream = uri.toURL().openStream()) {
        final var result = new String(stream.readAllBytes());
        System.err.printf("Got result %s on thread %s !%n", result, Thread.currentThread());
        return "success";
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      System.err.printf("Ending thread %s !%n", Thread.currentThread());
    }
  }

  public static void sleep() {
    System.err.printf("Starting thread %s !%n", Thread.currentThread());
    try {
      Thread.sleep(3000);
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      System.err.printf("Ending thread %s !%n", Thread.currentThread());
    }
  }

  public static void silentSleep() {
    try {
      Thread.sleep(3000);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
