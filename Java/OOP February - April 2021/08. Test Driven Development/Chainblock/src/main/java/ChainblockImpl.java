import java.util.*;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactions;


    public ChainblockImpl() {
        this.transactions = new LinkedHashMap<>();
    }

    public int getCount() {
        return this.transactions.size();
    }

    public void add(Transaction transaction) {
        if (!this.contains(transaction)) {
            this.transactions.put(transaction.getId(),transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return this.contains(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (this.transactions.containsKey(id)) {
            Transaction transaction = this.transactions.get(id);
            transaction.setStatus(newStatus);
        } else {
            throw new IllegalArgumentException();
        }

    }

    public void removeTransactionById(int id) {

    }

    public Transaction getById(int id) {
        return this.transactions.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return null;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
