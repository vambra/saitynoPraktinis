package lt.viko.eif.bstonkute.praktinis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComponentTest {

    private Component component;

    @BeforeEach
    void setUp() {
        component = new Component();
    }

    @Test
    void getName() {
        component.setName("testName");
        assertNotNull(component);
        assertEquals("testName", component.getName());
    }

    @Test
    void setName() {
        component.setName("testName");
        assertNotNull(component);
        assertEquals("testName", component.getName());
        assertTrue(component.toString().contains("testName"));
    }

    @Test
    void getCost() {
        component.setCost(10f);
        assertNotNull(component);
        assertEquals(10f, component.getCost());
    }

    @Test
    void setCost() {
        component.setCost(10f);
        assertNotNull(component);
        assertEquals(10f, component.getCost());
        assertTrue(component.toString().contains("10"));
    }

    @Test
    void getTaskList() {
        List<Task> taskList = new ArrayList<>();
        Task task = new Task("taskName", 10, 2, 30);
        taskList.add(task);
        component.setTaskList(taskList);
        assertNotNull(component);
        assertEquals(taskList, component.getTaskList());
    }

    @Test
    void setTaskList() {
        List<Task> taskList = new ArrayList<>();
        Task task = new Task("taskName", 10, 2, 30);
        taskList.add(task);
        component.setTaskList(taskList);
        assertNotNull(component);
        assertEquals(taskList, component.getTaskList());
        System.out.println();
        assertTrue(component.toString().contains("taskName"));
        assertTrue(component.toString().contains("10"));
        assertTrue(component.toString().contains("2"));
        assertTrue(component.toString().contains("30"));
    }
}