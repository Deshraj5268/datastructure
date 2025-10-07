package Hashing.paymentsystem;

import javafx.util.Pair;

import java.util.*;

public class PaymentService {

    private Map<String, List<Transaction>> p2pTxnListMap; // SenderId , totalAmount for history Query
    private Map<String, Double> p2mTxnMap; // SenderId , totalAmount for history Query

    private TreeMap<UserKey, List<Transaction>> topP2M;
    private static int topUserCount;

    public PaymentService(int topUserCount) {
        this.topUserCount = topUserCount;
        this.p2pTxnListMap = new HashMap<>();
        this.p2mTxnMap = new HashMap<>();
        this.topP2M = new TreeMap<>((u1,u2)->{
            int amount = Double.compare(u2.totalAmount , u1.totalAmount);
            if(amount == 0){
                return u1.senderId.compareTo(u2.senderId);
            }
            return amount;
        });
    }


    public List<UserKey> topKUser(){
        return new ArrayList<>(topP2M.keySet());
    }
    public TxnSummary makePayment(double amount, String txnId, TransactionType txnType, String senderId) {
        Transaction transaction = new Transaction(txnId, amount, txnType, senderId);
        boolean eligible = false;

        if (txnType == TransactionType.P2M) {
            updateP2M(senderId, transaction);
            eligible = isEligible(senderId);
        }else {
            p2pTxnListMap.computeIfAbsent(senderId, k-> new LinkedList<Transaction>()).add(transaction);
        }
        return new TxnSummary(txnId, eligible);
    }

    public Pair<String, Integer> getTxnHistory(String senderId, TransactionType txnType) {
        Pair<String, Integer> userIdCountPair;
        if(txnType == TransactionType.P2M){
            int listSize = 0;
            for(Map.Entry<UserKey, List<Transaction>> entry : topP2M.entrySet()){
                if(entry.getKey().senderId.equals(senderId)){
                    listSize = entry.getValue().size();
                    break;
                }
            }
            userIdCountPair = new Pair<>(senderId, listSize);
        }else {
            userIdCountPair = new Pair<>(senderId,p2pTxnListMap.get(senderId).size());
        }
        return userIdCountPair;
    }

    private boolean isEligible(String senderId) {
        boolean isEligible =  topP2M.keySet().stream().anyMatch(userKey -> userKey.senderId.equals(senderId));
        return isEligible;
    }

    private void updateP2M(String senderId, Transaction newTransaction) {
        double oldTotalAmount = p2mTxnMap.getOrDefault(senderId, 0.0);
        double newTotalAmount = oldTotalAmount + newTransaction.amount;
        List<Transaction> senderTransactions = topP2M.getOrDefault(new UserKey(senderId, oldTotalAmount),
                new LinkedList<Transaction>());
        senderTransactions.add(newTransaction);

        if(oldTotalAmount > 0){
            topP2M.remove(new UserKey(senderId, oldTotalAmount));
        }
        p2mTxnMap.put(senderId, newTotalAmount);

        UserKey newKey = new UserKey(senderId, newTotalAmount);
        topP2M.put(newKey, senderTransactions);
        trimTopP2MTxn();
    }

    private void trimTopP2MTxn() {
        while (topP2M.size() > topUserCount){
            Map.Entry<UserKey, List<Transaction>> entry =  topP2M.pollLastEntry();
            System.out.println("removed: "+entry.getKey().toString());
        }
    }
}
