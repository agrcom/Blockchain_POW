import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    @DisplayName("Do transaction between two wallets")
    public void oneTransaction() {
        Wallet walletFirst = new Wallet();
        Wallet walletSecond = new Wallet();

        Transaction first = new Transaction(walletFirst.publicKey, walletSecond.publicKey, 10, null);
        first.generateSignature(walletFirst.privateKey);
        System.out.println("Value: " + first.value);
        System.out.println("TransactionId: " + first.transactionId);

        assertTrue(first.verifiySignature());

    }
}
