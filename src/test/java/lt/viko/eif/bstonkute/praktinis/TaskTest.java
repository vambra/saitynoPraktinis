package lt.viko.eif.bstonkute.praktinis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
    }

    @Test
    void getName() {
        task.setName("testName");
        assertNotNull(task);
        assertEquals("testName", task.getName());
    }

    @Test
    void setName() {
        task.setName("testName");
        assertNotNull(task);
        assertEquals("testName", task.getName());
        assertTrue(task.toString().contains("testName"));
    }

    @Test
    void getProgress() {
        task.setProgress(50);
        assertNotNull(task);
        assertEquals(50, task.getProgress());
    }

    @Test
    void setProgress() {
        task.setProgress(50);
        assertNotNull(task);
        assertEquals(50, task.getProgress());
        assertTrue(task.toString().contains("50"));
    }

    @Test
    void getTimeElapsedHours() {
        task.setTimeElapsedHours(20);
        assertNotNull(task);
        assertEquals(20, task.getTimeElapsedHours());
    }

    @Test
    void setTimeElapsedHours() {
        task.setTimeElapsedHours(20);
        assertNotNull(task);
        assertEquals(20, task.getTimeElapsedHours());
        assertTrue(task.toString().contains("20"));
    }

    @Test
    void getTimeElapsedMinutes() {
        task.setTimeElapsedMinutes(15);
        assertNotNull(task);
        assertEquals(15, task.getTimeElapsedMinutes());
    }

    @Test
    void setTimeElapsedMinutes() {
        task.setTimeElapsedMinutes(15);
        assertNotNull(task);
        assertEquals(15, task.getTimeElapsedMinutes());
        assertTrue(task.toString().contains("15"));
    }
}