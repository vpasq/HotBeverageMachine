package vendingmachine.condiments;

import vendingmachine.beverages.Beverage;

public abstract class CondimentDecorator extends Beverage {
  Beverage beverage;

  /**
   * Accessor method for the name of the beverage.
   *
   * @return the name of the beverage
   */
  public abstract String getName();

  /**
   * Accessor method for the type of the beverage.
   *
   * @return the type of the beverage
   */
  public abstract String getType();


}