import java.math.BigInteger;
import java.util.Random;

public class PeerToPeerNetwork {

    final int MAXNUMOFTRANSACTIONS = 100;
    static Random randomAdd = new Random();
    final int BOUND = 20;
    /**
    This function will create fake transactions for us to include in a block.
     */
    public Transaction[] collectNewTransactions() {

        Random randomAmount = new Random();

        int numOfTx = randomAdd.nextInt(MAXNUMOFTRANSACTIONS);
        Transaction[] txList = new Transaction[numOfTx+1];//we reserve 0 index for the coinbase transaction
        for(int i=1;i<numOfTx+1;i++){
            String fromAddress = generateRandomAddress();
            String toAddress = generateRandomAddress();
            BigInteger amount = BigInteger.valueOf(randomAmount.nextInt(BOUND)* A5AshrafFahad.SATOSHI);
            Transaction tx = new Transaction(fromAddress,toAddress,amount);
            txList[i]=tx;
        }
        return txList;
    }

    /**
     * Generate a fake bitcoin address.
     * @return the generated address.
     */
    private String generateRandomAddress() {
        //bitcoin addresses can contain alphanumeric values, but here we will use numeric addresses only for ease.
        StringBuilder address = new StringBuilder();
        address.append("1");//bitcoin addresses can start with 1, 3 or bc. We will use the most standard 1 addresses.
        for(int i=0;i<30;i++){
            address.append(randomAdd.nextInt(10));
        }
        return address.toString();
    }
}
