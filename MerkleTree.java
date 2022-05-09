import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MerkleTree {

    public String buildFrom(Transaction[] transactions) throws NoSuchAlgorithmException

    {
        ArrayList<String> a = new ArrayList<>();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        int size=0;
        for(int i=0;i<transactions.length;i=i+1)
        {
            Transaction tx1 = transactions[i];
            String h1 =UtilityFunctions.getSHA256(digest, tx1.toString());
            a.add(h1);
            size++;
        }
        int level = 0;
        String topHash = "";
        ArrayList<String> b = new ArrayList<>();

        int i=0;

        while(a.size()>i)
        {
            String left = a.get(i);
            i++;
            String right = "";
            if(i<a.size())
            {
                right = a.get(i);
            }
            i++;
            //Every sting will concatenate in left to right.
            b.add(left+right);
        }

        for(int j=0;j<b.size();j++)
        {
            topHash += b.get(j);
        }
        System.out.println("Merkle Tree, Bottom Up, Level: " + level + ", number of hashes: " + size);
        System.out.println("Merkle top hash is: " + topHash);

      return topHash;
    }

}
