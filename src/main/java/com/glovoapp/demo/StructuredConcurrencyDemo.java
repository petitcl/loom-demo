package com.glovoapp.demo;

import com.glovoapp.demo.common.WorkLoads;
import java.util.concurrent.Executors;

public class StructuredConcurrencyDemo {

  public static final int NUM_THREADS = 5;

  public static void main(String[] args) throws Exception {
    System.err.printf("Starting %s virtual threads !%n", NUM_THREADS);

      try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {

        final var call1 = executor.submit(WorkLoads::callApi);
        final var call2 = executor.submit(WorkLoads::callApi);

      final var result1 = call1.get();
      final var result2 = call2.get();
      System.err.printf("Results are: %s %s%n", result1, result2);
    }

    System.err.println("Done waiting on all virtual threads!");
  }

}
