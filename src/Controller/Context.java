package Controller;

import View.Circus;

public class Context {
 
   private Strategy strategy;

   public Context(Strategy strategy){
      this.strategy = strategy;
   }

   public Circus executeStrategy(Circus c){
      return strategy.changeDifficulty(c);
   }

   public Strategy getStrategy()
   {
      return this.strategy;
   }
}

