import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BlockTest {

    @Test
    @DisplayName("Build Two blocks check if hash is diffrent for each")
    public void buildTwoBlocks(){
        Block firstBlock = new Block("First Block", "0");
        System.out.print("Hash for block 1: "+firstBlock.hash+"\n");
        assert firstBlock != null;

        Block secondBlock = new Block("Second Block", firstBlock.hash);
        System.out.print("Hash for block 2: "+secondBlock.hash);

        assertNotEquals(firstBlock.hash, secondBlock.hash);
    }
}
