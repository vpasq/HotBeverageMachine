package vendingmachine.condiments;

import vendingmachine.beverages.Beverage;

public class Milk extends CondimentDecorator {

  public Milk(Beverage beverage) {
    this.beverage = beverage;
  }

  /**
   * Accessor method for the name of the beverage plus milk added.
   *
   * @return the name of the beverage plus milk added.
   */
  @Override
  public String getName() {
    return beverage.getName() + ", Milk";
  }

  /**
   * Accessor method for the type of the beverage.
   *
   * @return the type of the beverage
   */
  @Override
  public String getType() {
    return beverage.getType();
  }
}
