package vendingmachine.machine;

import vendingmachine.beverages.Beverage;


public interface MachineState {

  /**
   * Process the beverage.
   *
   * @param beverage the beverage to process.
   * @return a description of the beverage that was processed.
   */
  public String process(Beverage beverage);

}
