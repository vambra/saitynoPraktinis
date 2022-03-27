package lt.viko.eif.bstonkute.praktinis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    private Project project;

    @BeforeEach
    void setUp() {
        project = new Project();
    }

    @Test
    void getCharacter() {
        project.setCharacter("testChar");
        assertNotNull(project);
        assertEquals("testChar", project.getCharacter());
    }

    @Test
    void setCharacter() {
        project.setCharacter("testChar");
        assertNotNull(project);
        assertEquals("testChar", project.getCharacter());
        assertTrue(project.toString().contains("testChar"));
    }

    @Test
    void getSource() {
        project.setSource("testSource");
        assertNotNull(project);
        assertEquals("testSource", project.getSource());
    }

    @Test
    void setSource() {
        project.setSource("testSource");
        assertNotNull(project);
        assertEquals("testSource", project.getSource());
        assertTrue(project.toString().contains("testSource"));
    }

    @Test
    void getDueDate() {
        project.setDueDate("testDueDate");
        assertNotNull(project);
        assertEquals("testDueDate", project.getDueDate());
    }

    @Test
    void setDueDate() {
        project.setDueDate("testDueDate");
        assertNotNull(project);
        assertEquals("testDueDate", project.getDueDate());
        assertTrue(project.toString().contains("testDueDate"));
    }

    @Test
    void getStartDate() {
        project.setStartDate("testStartDate");
        assertNotNull(project);
        assertEquals("testStartDate", project.getStartDate());
    }

    @Test
    void setStartDate() {
        project.setStartDate("testStartDate");
        assertNotNull(project);
        assertEquals("testStartDate", project.getStartDate());
        assertTrue(project.toString().contains("testStartDate"));
    }

    @Test
    void getFinishDate() {
        project.setFinishDate("testFinishDate");
        assertNotNull(project);
        assertEquals("testFinishDate", project.getFinishDate());
    }

    @Test
    void setFinishDate() {
        project.setFinishDate("testFinishDate");
        assertNotNull(project);
        assertEquals("testFinishDate", project.getFinishDate());
        assertTrue(project.toString().contains("testFinishDate"));
    }

    @Test
    void getBudget() {
        project.setBudget(100.00f);
        assertNotNull(project);
        assertEquals(100.00f, project.getBudget());
    }

    @Test
    void setBudget() {
        project.setBudget(100.00f);
        assertNotNull(project);
        assertEquals(100.00f, project.getBudget());
        assertTrue(project.toString().contains("100,00"));
    }

    @Test
    void getComponentList() {
        List<Task> taskList = new ArrayList<>();
        Task task = new Task("taskName", 10, 2, 30);
        taskList.add(task);
        List<Component> componentList = new ArrayList<>();
        Component component = new Component("compName", 40f, taskList);
        componentList.add(component);
        project.setComponentList(componentList);
        assertNotNull(project);
        assertEquals(componentList, project.getComponentList());
    }

    @Test
    void setComponentList() {
        List<Task> taskList = new ArrayList<>();
        Task task = new Task("taskName", 10, 2, 30);
        taskList.add(task);
        List<Component> componentList = new ArrayList<>();
        Component component = new Component("compName", 40f, taskList);
        componentList.add(component);
        project.setComponentList(componentList);
        assertNotNull(project);
        assertEquals(componentList, project.getComponentList());
        assertTrue(project.toString().contains("taskName"));
        assertTrue(project.toString().contains("10"));
        assertTrue(project.toString().contains("2"));
        assertTrue(project.toString().contains("30"));
        assertTrue(project.toString().contains("compName"));
        assertTrue(project.toString().contains("40"));
    }

    @Test
    void getConventionList() {
        List<Competition> competitionList = new ArrayList<>();
        Competition competition = new Competition("testCategory", "testAward", "testPrize");
        competitionList.add(competition);
        List<Convention> conventionList = new ArrayList<>();
        Convention convention = new Convention("testName", "testDate", competitionList);
        conventionList.add(convention);
        project.setConventionList(conventionList);
        assertNotNull(project);
        assertEquals(conventionList, project.getConventionList());
    }

    @Test
    void setConventionList() {
        List<Competition> competitionList = new ArrayList<>();
        Competition competition = new Competition("testCategory", "testAward", "testPrize");
        competitionList.add(competition);
        List<Convention> conventionList = new ArrayList<>();
        Convention convention = new Convention("testName", "testDate", competitionList);
        conventionList.add(convention);
        project.setConventionList(conventionList);
        assertNotNull(project);
        assertEquals(conventionList, project.getConventionList());
        assertTrue(project.toString().contains("testCategory"));
        assertTrue(project.toString().contains("testAward"));
        assertTrue(project.toString().contains("testPrize"));
        assertTrue(project.toString().contains("testName"));
        assertTrue(project.toString().contains("testDate"));
    }

    @Test
    void testToString() {
        project.setCharacter("testChar");
        project.setSource("testSource");
        project.setDueDate("testDueDate");
        project.setStartDate("testStartDate");
        project.setFinishDate("testFinishDate");
        project.setBudget(100.00f);
        List<Task> taskList = new ArrayList<>();
        Task task = new Task("taskName", 10, 2, 30);
        taskList.add(task);
        List<Component> componentList = new ArrayList<>();
        Component component = new Component("compName", 40f, taskList);
        componentList.add(component);
        project.setComponentList(componentList);
        List<Competition> competitionList = new ArrayList<>();
        Competition competition = new Competition("testCategory", "testAward", "testPrize");
        competitionList.add(competition);
        List<Convention> conventionList = new ArrayList<>();
        Convention convention = new Convention("testName", "testDate", competitionList);
        conventionList.add(convention);
        project.setConventionList(conventionList);
        assertNotNull(project);
        assertTrue(project.toString().contains("testChar"));
        assertTrue(project.toString().contains("testSource"));
        assertTrue(project.toString().contains("testDueDate"));
        assertTrue(project.toString().contains("testStartDate"));
        assertTrue(project.toString().contains("testFinishDate"));
        assertTrue(project.toString().contains("100,00"));
        assertTrue(project.toString().contains("taskName"));
        assertTrue(project.toString().contains("10"));
        assertTrue(project.toString().contains("2"));
        assertTrue(project.toString().contains("30"));
        assertTrue(project.toString().contains("compName"));
        assertTrue(project.toString().contains("40"));
        assertTrue(project.toString().contains("testCategory"));
        assertTrue(project.toString().contains("testAward"));
        assertTrue(project.toString().contains("testPrize"));
        assertTrue(project.toString().contains("testName"));
        assertTrue(project.toString().contains("testDate"));
    }
}