import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumOfNUsingForkJoin {

   private static long N = 1000000;
   private static final int NUM_THREADS = 10;


   static class RecursiveSumOfN extends RecursiveTask<Long> {
      long from, to;

      public RecursiveSumOfN(long from, long to) {
         this.from = from;
         this.to = to;
      }

      public Long compute() {
         if( (to-from) <= N/NUM_THREADS) {
            // the range is something that can be handled by a thread
            long localSum = 0;
            // add with 'to' inclusive
            for(long i = from; i <= to; i++) {
               localSum += i;
            }

            System.out.printf("\t Summing of value range %d to %d is %d %n",
                  from, to, localSum);
            return localSum;
         } else {
            long mid = (from + to) /2;
            System.out.printf("Forking computation into 2 ranges: " +
            "%d to %d,  and %d to %d %n", from, mid, mid+1, to);

            RecursiveSumOfN firstHalf = new RecursiveSumOfN(from, mid);
            // fork off the task
            firstHalf.fork();


            RecursiveSumOfN secondHalf = new RecursiveSumOfN(mid+1, to);
            long resultSecond = secondHalf.compute();

            // wait until done
            return firstHalf.join() + resultSecond;
         }
      }

   }


   public static void main(String[] args) {
      // create a fork-join pool that consists of NUM_THREADS
      ForkJoinPool pool = new ForkJoinPool(NUM_THREADS);

      // submit the computation task to the fork-join pool
      long computedSum = pool.invoke(new RecursiveSumOfN(0, N));

      long formulaSum = (N * (N+1)) /2;

      if (computedSum != formulaSum) {
         System.out.println("fork-join produces a different result");
      } else {
         System.out.println("Tata for fork-join, as good as the formula result");
      }


   }


}
