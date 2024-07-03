import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

enum TransactionType {
  DEPOSIT,
  WITHDRAW
}

public class Database {
  ArrayList<Account> accounts;

  Database() {
    accounts = new ArrayList<>();
  }

  void createAccount(String name) {
    Account account = new Account(name);
    accounts.add(account);
  }

  void deposit(int amount, String name) throws InterruptedException {
    for (Account account : accounts) {
      if (account.name.equals(name)) {
        // Create a new thread to deposit
        displayTime(account, TransactionType.DEPOSIT, amount);
        ThreadDeposit transaction = new ThreadDeposit(account, amount);
        transaction.start();
      }
    }
  }

  void withdraw(int amount, String name) throws InterruptedException {
    for (Account account : accounts) {
      if (account.name.equals(name)) {
        // Create a new thread to withdraw
        displayTime(account, TransactionType.WITHDRAW, amount);
        ThreadWithdraw transaction = new ThreadWithdraw(account, amount);
        transaction.start();
      }
    }
  }

  private void displayTime(Account account, TransactionType type, int amount) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String timestamp = dtf.format(LocalDateTime.now());
    System.out.println(timestamp); // Print current timestamp in DD/MM/YYYY HH:MM:SS
    System.out.printf("User: %s, Transaction type: %s, amount: %d\n", account.name, type, amount);
  }
}
