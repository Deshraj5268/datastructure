package Hashing.paymentsystem;

public class Transaction {
    String txnId;
    double amount;
    TransactionType type;
    String senderId;

    public Transaction(String txnId, double amount, TransactionType type, String senderId) {
        this.txnId = txnId;
        this.amount = amount;
        this.type = type;
        this.senderId = senderId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "txnId='" + txnId + '\'' +
                ", amount=" + amount +
                ", type=" + type +
                ", senderId='" + senderId + '\'' +
                '}';
    }
}