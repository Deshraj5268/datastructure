package Hashing.paymentsystem;

public class UserKey {

    String senderId;
    double totalAmount;

    public UserKey(String senderId, double totalAmount) {
        this.senderId = senderId;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return senderId + " (" + totalAmount + ")";
    }
}
