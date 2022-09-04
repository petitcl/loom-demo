package com.glovoapp.demo.perf;

import com.glovoapp.demo.common.WorkLoads;
import java.util.ArrayList;

public class VirtualThreadsPerf {

  public static final int NUM_THREADS = 10_000;

  public static void main(String[] args) {
    System.err.printf("Starting %s virtual threads !%n", NUM_THREADS);

    final var threads = new ArrayList<Thread>();
    for (int i = 0; i < NUM_THREADS; i++) {
      final var thread = Thread.ofVirtual().start(WorkLoads::silentSleep);
      threads.add(thread);
    }
    System.err.println("All virtual threads started !");
    System.err.println("Waiting on all virtual threads!");

    threads.forEach(thread -> {
      try {
        thread.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
    System.err.println("Done waiting on all virtual threads!");
  }

}
