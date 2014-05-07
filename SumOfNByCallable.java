import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class SumOfNByCallable {
   private static long N = 1000000L;
   private static long calculatedSum = 0;
   private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();


   static class SumCalc implements Callable<Long> {
      long from, to, localSum = 0;

      public SumCalc(long from, long to) {
         this.from = from;
         this.to = to;
      }

      public Long call() {
         for (long i = from; i <= to; i++) {
            localSum += i;
         }
         return localSum;
      }

   }

   public static void main(String[] args) {

      // Get Thread Pool
      ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

      // callable work unit for each thread. Added to a List<Future<Long>>.
      List<Future<Long>> summationTasks = new ArrayList<>();

      long nUnit = N/NUM_THREADS;
      for(int i = 0; i < NUM_THREADS; i++) {
         long fromInInnerRange = (nUnit * i) + 1;
         long toInInnerRange = nUnit * (i+1);
         System.out.printf("Spawning thread for summing in range %d to %d %n", fromInInnerRange, toInInnerRange);

         Callable<Long> summationTask = new SumCalc(fromInInnerRange, toInInnerRange);
         // It will take some time for the task to complete.
         Future<Long> futureSum = executorService.submit(summationTask);
         summationTasks.add(futureSum);

   }

      // sum the future result of threads
      for(Future<Long> partialSum : summationTasks) {
         try {
            calculatedSum += partialSum.get();
         } catch (CancellationException | ExecutionException | InterruptedException exception) {
             exception.printStackTrace();
             System.exit(-1);
         }
      }

      //validation the summation by another math formula to make sure the threads did the right thing.
      long formulaSum = (N * (N + 1)) /2;

      if (calculatedSum != formulaSum) {
         System.out.printf("Sum by threads = %d, sum using formula = %d", calculatedSum, formulaSum);
      } else {
         System.out.printf("Correct summation by threads using callable per validation of the formula. ");
      }
}

}