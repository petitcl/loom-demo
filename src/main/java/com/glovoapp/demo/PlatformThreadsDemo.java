package com.glovoapp.demo;

import com.glovoapp.demo.common.WorkLoads;
import java.util.ArrayList;

public class PlatformThreadsDemo {

  public static final int NUM_THREADS = 5;

  public static void main(String[] args) {
    System.err.printf("Starting %s platform threads !%n", NUM_THREADS);

    final var threads = new ArrayList<Thread>();
    for (int i = 0; i < NUM_THREADS; i++) {
      final var thread = new Thread(WorkLoads::callApi);
      threads.add(thread);
      thread.start();
    }
    System.err.println("All platform threads started !");
    System.err.println("Waiting on all platform threads!");

    threads.forEach(thread -> {
      try {
        thread.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
    System.err.println("Done waiting on all platform threads!");
  }

}