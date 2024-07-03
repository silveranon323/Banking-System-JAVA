public class Main {

  public static void main(String[] args) throws InterruptedException {
    Database database = new Database();
    database.createAccount("John");
    database.createAccount("Jane");

    database.deposit(100, "John");
    database.deposit(200, "Jane");

    database.withdraw(10, "John");
    database.withdraw(150, "Jane");
  }
}