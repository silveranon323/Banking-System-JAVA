public interface AccountInterface {
  /**
   * Deposits the specified amount into the account.
   *
   * @param amount the amount to be deposited
   */
  void deposit(int amount);

  /**
   * Withdraws the specified amount from the account balance.
   * 
   * @param amount the amount to withdraw
   * @return 0 if the withdrawal is successful, -1 if the account balance is
   *         insufficient
   */
  int withdraw(int amount);
}