package edu.jenshin831.lab.songr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongrApplicationTests {
	Controller classToTest;

	@Test
	public void init() {
		classToTest = new Controller();
	}

	@Test
	public void notNullApp() {
		SongrApplication app = new SongrApplication();
		assertNotNull("Instantiated SongrApp should not be null", app);
	}

	@Test
	public void capitalize() {
		init();

		assertEquals("Should return 'HI THERE'",
				"HI THERE",
				classToTest.capitalize("hi there"));
		//number should be converted to String and returned as String number
		assertTrue("Should return number back as String",
				classToTest.capitalize("22") instanceof String);
	}

	@Test
	public void reverseString() {
		init();

		assertEquals("Should reverse phrase to 'palindrome. a not am I",
				"palindrome. a not am I",
				classToTest.reverseStringParam("I am not a palindrome."));	}
}
