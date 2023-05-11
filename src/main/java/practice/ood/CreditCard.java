package practice.ood;

public class CreditCard extends Payment {

  @Override
  public boolean initiateTransaction() {
    return false;
  }
}
