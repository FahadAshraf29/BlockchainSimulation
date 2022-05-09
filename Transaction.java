import java.math.BigInteger;

public class Transaction {

    String senderAddress;
    String receiverAddress;
    BigInteger amount;

    public Transaction(String fromAddress, String toAddress, BigInteger transactionAmount) {
        senderAddress = fromAddress;
        receiverAddress = toAddress;
        amount=transactionAmount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "senderAddress='" + senderAddress + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", amount=" + amount +
                '}';
    }

    public void setAmount(String a) {
        this.amount=new BigInteger(a);
    }
}
