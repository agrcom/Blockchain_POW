import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleChainTest {

    @Test
    @DisplayName("Build chain with three blocks, check if size is fine")
    public void buildSimpleChain(){

        SimplyChain simpleChain = new SimplyChain();
        simpleChain.add("First element of chain");
        simpleChain.add("Second element of chain");
        simpleChain.add("Third element of chain");

        assertEquals(simpleChain.size(), 3);
    }

    @Test
    @DisplayName("Build chain with five blocks, list all objects")
    public void listAllElementsInChain(){

        SimplyChain chain = new SimplyChain();
        chain.add("First element of chain");
        chain.add("Second element of chain");
        chain.add("Third element of chain");
        chain.add("Fourth element of chain");
        chain.add("Fifth element of chain");

        assertEquals(chain.size(), 5);
        assertNotNull(chain.listAllInChain());

    }

    @Test
    @DisplayName("Build chain with five blocks, check integrity")
    public void checkIntegrityOfChain() {

        SimplyChain chain = new SimplyChain();
        chain.add("First element of chain");
        chain.add("Second element of chain");
        chain.add("Third element of chain");
        chain.add("Fourth element of chain");
        chain.add("Fifth element of chain");

        assertTrue(chain.isChainValid());
    }

    @Test
    @DisplayName("Mining Blocks")
    public void miningBlocks(){
        SimplyChain chain = new SimplyChain();
        chain.add("First element of chain");
        chain.get(0).mineBlock(0);

        chain.add("Second element of chain");
        chain.get(1).mineBlock(1);

        chain.add("Third element of chain");
        chain.get(2).mineBlock(1);

        chain.add("Fourth element of chain");
        chain.get(3).mineBlock(1);

        chain.add("Fifth element of chain");
        chain.get(4).mineBlock(1);

        assertTrue(chain.isChainValid());

    }


}
