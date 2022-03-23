package lt.viko.eif.bstonkute.praktinis;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class TransformerTest {

    private static Transformer transformer;

    @BeforeAll
    static void setUp() {
        transformer = new Transformer();
    }

    @Test
    void transformToObject() {
        Project project = transformer.transformToObjectFromFile("C:\\Users\\Bri\\Documents\\Code\\Java\\saitynoPraktinis\\src\\test\\resources\\testData.xml");

        // test project data
        assertNotNull(project);
        assertEquals("char", project.getCharacter());
        assertEquals("source", project.getSource());
        assertEquals("due", project.getDueDate());
        assertEquals("start", project.getStartDate());
        assertEquals("finish", project.getFinishDate());
        assertEquals(1234, project.getBudget());
        assertNotNull(project.getComponentList());
        assertEquals(3, project.getComponentList().size());
        assertNotNull(project.getConventionList());
        assertEquals(2, project.getConventionList().size());

        // test component data (1)
        assertNotNull(project.getComponentList().get(0));
        Component component1 = project.getComponentList().get(0);
        assertEquals("comp1", component1.getName());
        assertEquals(10, component1.getCost());
        assertNotNull(component1.getTaskList());
        assertEquals(2, component1.getTaskList().size());
        // test task data (1.1)
        assertNotNull(component1.getTaskList().get(0));
        Task task1 = component1.getTaskList().get(0);
        assertEquals("task1", task1.getName());
        assertEquals(11, task1.getProgress());
        assertEquals(12, task1.getTimeElapsedHours());
        assertEquals(13, task1.getTimeElapsedMinutes());
        // test task data (1.2)
        assertNotNull(component1.getTaskList().get(1));
        Task task2 = component1.getTaskList().get(1);
        assertEquals("task2", task2.getName());
        assertEquals(21, task2.getProgress());
        assertEquals(22, task2.getTimeElapsedHours());
        assertEquals(23, task2.getTimeElapsedMinutes());

        // test component data (2)
        assertNotNull(project.getComponentList().get(1));
        Component component2 = project.getComponentList().get(1);
        assertEquals("comp2", component2.getName());
        assertEquals(20, component2.getCost());
        assertNotNull(component2.getTaskList());
        assertEquals(1, component2.getTaskList().size());
        // test task data (2.1)
        assertNotNull(component2.getTaskList().get(0));
        Task task3 = component2.getTaskList().get(0);
        assertEquals("task3", task3.getName());
        assertEquals(31, task3.getProgress());
        assertEquals(32, task3.getTimeElapsedHours());
        assertEquals(33, task3.getTimeElapsedMinutes());

        // test component data (3)
        assertNotNull(project.getComponentList().get(2));
        Component component3 = project.getComponentList().get(2);
        assertEquals("comp3", component3.getName());
        assertEquals(30, component3.getCost());
        assertNull(component3.getTaskList());

        // test convention data (1)
        assertNotNull(project.getConventionList().get(0));
        Convention convention1 = project.getConventionList().get(0);
        assertEquals("con1", convention1.getName());
        assertEquals("conDate1", convention1.getDate());
        assertNotNull(convention1.getCompetitionList());
        assertEquals(2, convention1.getCompetitionList().size());
        // test competition data (1.1)
        assertNotNull(convention1.getCompetitionList().get(0));
        Competition competition1 = convention1.getCompetitionList().get(0);
        assertEquals("category1", competition1.getCategory());
        assertEquals("award1", competition1.getAward());
        assertEquals("prize1", competition1.getPrize());
        // test competition data (1.2)
        assertNotNull(convention1.getCompetitionList().get(1));
        Competition competition2 = convention1.getCompetitionList().get(1);
        assertEquals("category2", competition2.getCategory());
        assertEquals("award2", competition2.getAward());
        assertEquals("prize2", competition2.getPrize());

        // test convention data (2)
        assertNotNull(project.getConventionList().get(1));
        Convention convention2 = project.getConventionList().get(1);
        assertEquals("con2", convention2.getName());
        assertEquals("conDate2", convention2.getDate());
        assertNull(convention2.getCompetitionList());
    }

    @Test
    void transformToXmlFile() throws IOException {
        String filePathIn = "C:\\Users\\Bri\\Documents\\Code\\Java\\saitynoPraktinis\\src\\test\\resources\\testData.xml";
        String filePathOut = "C:\\Users\\Bri\\Documents\\Code\\Java\\saitynoPraktinis\\src\\test\\resources\\fileTest.xml";
        Project project = transformer.transformToObjectFromFile(filePathIn);
        transformer.transformToXmlFile(project, filePathOut);
        Path path = Path.of(filePathOut);
        String xmlString = Files.readString(path);
        assertNotNull(xmlString);
        assertTrue(xmlString.contains("char"));
        assertTrue(xmlString.contains("source"));
        assertTrue(xmlString.contains("due"));
        assertTrue(xmlString.contains("start"));
        assertTrue(xmlString.contains("finish"));
        assertTrue(xmlString.contains("1234"));
        assertTrue(xmlString.contains("comp1"));
        assertTrue(xmlString.contains("10"));
        assertTrue(xmlString.contains("task1"));
        assertTrue(xmlString.contains("11"));
        assertTrue(xmlString.contains("12"));
        assertTrue(xmlString.contains("13"));
        assertTrue(xmlString.contains("task2"));
        assertTrue(xmlString.contains("21"));
        assertTrue(xmlString.contains("22"));
        assertTrue(xmlString.contains("23"));
        assertTrue(xmlString.contains("comp2"));
        assertTrue(xmlString.contains("20"));
        assertTrue(xmlString.contains("task3"));
        assertTrue(xmlString.contains("31"));
        assertTrue(xmlString.contains("32"));
        assertTrue(xmlString.contains("33"));
        assertTrue(xmlString.contains("comp3"));
        assertTrue(xmlString.contains("30"));
        assertTrue(xmlString.contains("con1"));
        assertTrue(xmlString.contains("conDate1"));
        assertTrue(xmlString.contains("category1"));
        assertTrue(xmlString.contains("award1"));
        assertTrue(xmlString.contains("prize1"));
        assertTrue(xmlString.contains("category2"));
        assertTrue(xmlString.contains("award2"));
        assertTrue(xmlString.contains("prize2"));
        assertTrue(xmlString.contains("con2"));
        assertTrue(xmlString.contains("conDate2"));
    }

    @Test
    void transformToXmlString() {
        String filePath = "C:\\Users\\Bri\\Documents\\Code\\Java\\saitynoPraktinis\\src\\test\\resources\\testData.xml";
        Project project = transformer.transformToObjectFromFile(filePath);
        String xmlString = transformer.transformToXmlString(project);
        assertNotNull(xmlString);
        assertTrue(xmlString.contains("char"));
        assertTrue(xmlString.contains("source"));
        assertTrue(xmlString.contains("due"));
        assertTrue(xmlString.contains("start"));
        assertTrue(xmlString.contains("finish"));
        assertTrue(xmlString.contains("1234"));
        assertTrue(xmlString.contains("comp1"));
        assertTrue(xmlString.contains("10"));
        assertTrue(xmlString.contains("task1"));
        assertTrue(xmlString.contains("11"));
        assertTrue(xmlString.contains("12"));
        assertTrue(xmlString.contains("13"));
        assertTrue(xmlString.contains("task2"));
        assertTrue(xmlString.contains("21"));
        assertTrue(xmlString.contains("22"));
        assertTrue(xmlString.contains("23"));
        assertTrue(xmlString.contains("comp2"));
        assertTrue(xmlString.contains("20"));
        assertTrue(xmlString.contains("task3"));
        assertTrue(xmlString.contains("31"));
        assertTrue(xmlString.contains("32"));
        assertTrue(xmlString.contains("33"));
        assertTrue(xmlString.contains("comp3"));
        assertTrue(xmlString.contains("30"));
        assertTrue(xmlString.contains("con1"));
        assertTrue(xmlString.contains("conDate1"));
        assertTrue(xmlString.contains("category1"));
        assertTrue(xmlString.contains("award1"));
        assertTrue(xmlString.contains("prize1"));
        assertTrue(xmlString.contains("category2"));
        assertTrue(xmlString.contains("award2"));
        assertTrue(xmlString.contains("prize2"));
        assertTrue(xmlString.contains("con2"));
        assertTrue(xmlString.contains("conDate2"));
    }
    //dont compare whole string, use contains
    //galima versti i DOM
}