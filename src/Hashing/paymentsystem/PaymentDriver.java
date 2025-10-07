package Hashing.paymentsystem;

//Question description
/*
* ✅ Requirements

Transaction Processing
Implement a method:

void makePayment(double amount, String txnId, TransactionType type, String senderId)


Records a transaction with amount, txnId, type, and senderId.

Transactions can be of type:

P2M: Payment to a merchant

P2P: Payment to another user

Leaderboard for P2M

Maintain a top spender leaderboard for P2M transactions.

The leaderboard should rank users by total transaction amount.

You should be able to efficiently retrieve the top users based on amount.

Hint: Use a TreeMap (or similar sorted data structure) with a custom key (amount + senderId) to store and sort data.

Transaction History Query
Implement a method:

String getTxnHistory(String senderId, TransactionType type)


Returns the total number of transactions performed by a user for the given transaction type.

Example:

getTxnHistory("U1", P2M) → "Sender: U1, Total P2M transactions: 5"

Data Structures

Use efficient in-memory data structures for:

Storing P2M transactions (e.g., TreeMap<UserKey, List<Transaction>>)

Storing P2P transactions (e.g., Map<String, List<Transaction>>)

Bonus (Optional)

Add a method isEligible(senderId) that checks if a user is eligible for cashback or rewards based on P2M spend (e.g., total > ₹10,000).

Print eligibility when processing a transaction.*/
public class PaymentDriver {

    public static void main(String[] args) {
        PaymentService service = new PaymentService(2);
        TestCase2(service);
    }

    private static void normalTestCase(PaymentService service) {
        System.out.println(service.makePayment(5000, "TXN1", TransactionType.P2M, "U1"));
        System.out.println(service.makePayment(6000, "TXN3", TransactionType.P2M, "U1"));
        System.out.println(service.makePayment(8000, "TXN6", TransactionType.P2M, "U1"));
        System.out.println(service.makePayment(12000, "TXN4", TransactionType.P2M, "U3"));

        System.out.println(service.makePayment(8000, "TXN5", TransactionType.P2M, "U2"));


        System.out.println(service.makePayment(2000, "TXN2", TransactionType.P2P, "U1"));

        System.out.println(service.getTxnHistory("U1", TransactionType.P2M));
        System.out.println(service.getTxnHistory("U1", TransactionType.P2P));

        System.out.println(service.topKUser());
    }

    private static void TestCase2(PaymentService service) {
        System.out.println(service.makePayment(5000, "TXN1", TransactionType.P2M, "U1"));
        System.out.println(service.makePayment(6000, "TXN3", TransactionType.P2M, "U1"));
        System.out.println(service.makePayment(8000, "TXN6", TransactionType.P2M, "U1"));
        System.out.println(service.makePayment(19000, "TXN4", TransactionType.P2M, "U3"));

        System.out.println(service.makePayment(19000, "TXN5", TransactionType.P2M, "U2"));


        System.out.println(service.makePayment(2000, "TXN2", TransactionType.P2P, "U1"));

        System.out.println("txnType :"+TransactionType.P2M+"-:{userId, count}: "+service.getTxnHistory("U1", TransactionType.P2M));
        System.out.println("txnType :"+TransactionType.P2P+"-:{userId, count}: "+service.getTxnHistory("U1", TransactionType.P2P));

        System.out.println(service.topKUser());
    }
}
