package practice.ood;

public abstract class Account {

  private String userName;
  private String password;
  private Person person;
  private AccountStatus accountStatus;

  public abstract boolean resetPassword();
}
