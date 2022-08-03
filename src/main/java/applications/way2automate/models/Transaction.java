package applications.way2automate.models;

public class Transaction {

    public int amount;
    public String account;
    public String type;

    public Transaction(int amount, String account) {
        this.amount = amount;
        this.account = account;
    }
}
