package Laboration;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


/*
 * Just did an empty standard test
 */
class StandardTest {

	static class StandardTests {

	    @BeforeAll
	    static void initAll() {
	    }

	    @BeforeEach
	    void init() {
	    }

	    @Test
	    void succeedingTest() {
	    }

	    @Test
	    void failingTest() {
	        fail("a failing test");
	    }

	    @Test
	    @Disabled("for demonstration purposes")
	    void skippedTest() {
	        // not executed
	    }

	    @Test
	    void abortedTest() {
	        assumeTrue("abc".contains("Z"));
	        fail("test should have been aborted");
	    }

	    @AfterEach
	    void tearDown() {
	    }

	    @AfterAll
	    static void tearDownAll() {
	    }

	}

}
