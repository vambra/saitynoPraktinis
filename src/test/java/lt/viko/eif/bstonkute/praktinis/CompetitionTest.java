package lt.viko.eif.bstonkute.praktinis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionTest {

    private Competition competition;

    @BeforeEach
    void setUp() {
        competition = new Competition();
    }

    @Test
    void getCategory() {
        competition.setCategory("testCategory");
        assertNotNull(competition);
        assertEquals("testCategory", competition.getCategory());
    }

    @Test
    void setCategory() {
        competition.setCategory("testCategory");
        assertNotNull(competition);
        assertEquals("testCategory", competition.getCategory());
        assertTrue(competition.toString().contains("testCategory"));
    }

    @Test
    void getAward() {
        competition.setAward("testAward");
        assertNotNull(competition);
        assertEquals("testAward", competition.getAward());
    }

    @Test
    void setAward() {
        competition.setAward("testAward");
        assertNotNull(competition);
        assertEquals("testAward", competition.getAward());
        assertTrue(competition.toString().contains("testAward"));
    }

    @Test
    void getPrize() {
        competition.setPrize("testPrize");
        assertNotNull(competition);
        assertEquals("testPrize", competition.getPrize());
    }

    @Test
    void setPrize() {
        competition.setPrize("testPrize");
        assertNotNull(competition);
        assertEquals("testPrize", competition.getPrize());
        assertTrue(competition.toString().contains("testPrize"));
    }
}