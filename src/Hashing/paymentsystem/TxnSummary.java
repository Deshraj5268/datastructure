package Hashing.paymentsystem;

public class TxnSummary {
    String txnId;
    boolean eligible;

    public TxnSummary(String txnId, boolean eligible) {
        this.txnId = txnId;
        this.eligible = eligible;
    }

    @Override
    public String toString() {
        return "TxnSummary{txnId='" + txnId + "', eligible=" + eligible + "}";
    }
}
