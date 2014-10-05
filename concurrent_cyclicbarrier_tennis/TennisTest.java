package concurrent_cyclicbarrier_tennis;

import java.util.concurrent.CyclicBarrier;

public class TennisTest {
   public static void main(String[] args) {
      CyclicBarrier mbarrier = new CyclicBarrier(2, new MatchTennis());
      new Player(mbarrier, "X");
      new Player(mbarrier, "Y");

      CyclicBarrier barrier = new CyclicBarrier(4, new DoubleTennis());
      new Player(barrier, "A");
      new Player(barrier, "B");
      new Player(barrier, "C");
      new Player(barrier, "D");
   }
}
