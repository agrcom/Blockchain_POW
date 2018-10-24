import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;

public class SimplyChain {


    private static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static HashMap<String,TransactionOutput> UTXOs = new HashMap<String,TransactionOutput>(); //list of all unspent transactions.
    public static float minimumTransaction = 0.1f;

    public void add(String data){
        if(blockchain.size()==0){
            blockchain.add(new Block(data, "0"));
        }else{
            blockchain.add(new Block(data,
                    blockchain.get(blockchain.size()-1).hash));
        }
       System.out.print(getLastHash()+"\n");
    }

    public String listAllInChain(){
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
        return blockchainJson;
    }

    public Block get(int index){
        return blockchain.get(index);
    }

    public int size(){
        return blockchain.size();
    }

    public Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);

            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }

            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }

    private String getLastHash(){
        return new GsonBuilder().setPrettyPrinting().create().toJson(blockchain.get(blockchain.size()-1).hash);
    }

}
