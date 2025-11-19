package Hashing.paymentsystem;

import javafx.util.Pair;

import java.util.*;

public class PaymentServiceOptimize {

    private Map<String, Integer> p2pTxnListMap; // SenderId , totalTxnCount
    private Map<String, AmountAndTxnPair> p2mTxnMap; // SenderId , totalAmount and totalTxnCount

    private TreeMap<UserKey, AmountAndTxnPair> topP2M;
    private static int topUserCount;

    public PaymentServiceOptimize(int topUserCount) {
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
        boolean eligible = false;

        if (txnType == TransactionType.P2M) {
            eligible = checkEligibleP2MTxn(senderId, amount);
        }else {
            p2pTxnListMap.put(senderId, p2pTxnListMap.getOrDefault(senderId, 0)+1);
        }
        return new TxnSummary(txnId, eligible);
    }

    public Pair<String, Integer> getTxnHistory(String senderId, TransactionType txnType) {
        Pair<String, Integer> userIdCountPair;
        if(txnType == TransactionType.P2M){
            AmountAndTxnPair amountAndTxnPair = p2mTxnMap.get(senderId);
            userIdCountPair = new Pair<>(senderId, amountAndTxnPair.totalTxn);
        }else {
            userIdCountPair = new Pair<>(senderId,p2pTxnListMap.get(senderId));
        }
        return userIdCountPair;
    }

    private boolean checkEligibleP2MTxn(String senderId, double amount) {
        AmountAndTxnPair oldAmountAndTxnPair = p2mTxnMap.getOrDefault(senderId, new AmountAndTxnPair(0.0,0));
        double newTotalAmount = oldAmountAndTxnPair.amount + amount;
        UserKey oldUserKey = new UserKey(senderId, oldAmountAndTxnPair.amount);


        if(oldAmountAndTxnPair.amount > 0){
            topP2M.remove(oldUserKey);
        }
        UserKey newKey = new UserKey(senderId, newTotalAmount);
        AmountAndTxnPair NewAmountAndTxnPair =  new AmountAndTxnPair(newTotalAmount, oldAmountAndTxnPair.totalTxn+1);
        p2mTxnMap.put(senderId, new AmountAndTxnPair(newTotalAmount, oldAmountAndTxnPair.totalTxn+1));

        topP2M.put(newKey, NewAmountAndTxnPair);
        trimTopP2MTxn();

        // check isEligible
        return topP2M.get(newKey) != null;
    }

    private void trimTopP2MTxn() {
        while (topP2M.size() > topUserCount){
            Map.Entry<UserKey, AmountAndTxnPair> entry =  topP2M.pollLastEntry();
            System.out.println("removed: "+entry.getKey().toString());
        }
    }
}
