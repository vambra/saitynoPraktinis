package lt.viko.eif.bstonkute.praktinis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConventionTest {

    private Convention convention;

    @BeforeEach
    void setUp() {
        convention = new Convention();
    }

    @Test
    void getName() {
        convention.setName("testName");
        assertNotNull(convention);
        assertEquals("testName", convention.getName());
    }

    @Test
    void setName() {
        convention.setName("testName");
        assertNotNull(convention);
        assertEquals("testName", convention.getName());
        assertTrue(convention.toString().contains("testName"));
    }

    @Test
    void getDate() {
        convention.setDate("testDate");
        assertNotNull(convention);
        assertEquals("testDate", convention.getDate());
    }

    @Test
    void setDate() {
        convention.setDate("testDate");
        assertNotNull(convention);
        assertEquals("testDate", convention.getDate());
        assertTrue(convention.toString().contains("testDate"));
    }

    @Test
    void getCompetitionList() {
        List<Competition> competitionList = new ArrayList<>();
        Competition competition = new Competition("testCategory", "testAward", "testPrize");
        competitionList.add(competition);
        convention.setCompetitionList(competitionList);
        assertNotNull(convention);
        assertEquals(competitionList, convention.getCompetitionList());
    }

    @Test
    void setCompetitionList() {
        List<Competition> competitionList = new ArrayList<>();
        Competition competition = new Competition("testCategory", "testAward", "testPrize");
        competitionList.add(competition);
        convention.setCompetitionList(competitionList);
        assertNotNull(convention);
        assertEquals(competitionList, convention.getCompetitionList());
        assertTrue(convention.toString().contains("testCategory"));
        assertTrue(convention.toString().contains("testAward"));
        assertTrue(convention.toString().contains("testPrize"));
    }

    @Test
    void testToString() {
        convention.setName("testName");
        convention.setDate("testDate");
        List<Competition> competitionList = new ArrayList<>();
        Competition competition = new Competition("testCategory", "testAward", "testPrize");
        competitionList.add(competition);
        convention.setCompetitionList(competitionList);
        assertNotNull(convention);
        assertTrue(convention.toString().contains("testName"));
        assertTrue(convention.toString().contains("testDate"));
        assertTrue(convention.toString().contains("testCategory"));
        assertTrue(convention.toString().contains("testAward"));
        assertTrue(convention.toString().contains("testPrize"));
    }
}