package edu.jenshin831.lab.songr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    Controller controller;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testControllerIsAutowired() {
        assertNotNull(controller);
    }

    @Test
    public void testDefaultRoute() throws Exception {
        mockMvc.perform(get("/")).andExpect(content().string(containsString("Welcome to Jen's Songrz app.")));
    }

    @Test
    public void testHelloRoute() throws Exception {
        mockMvc.perform(get("/hello")).andExpect(content().string(containsString("Hello, world")));
    }

    @Test
    public void testCapitalizeRoute() throws Exception {
        mockMvc.perform(get("/hello/world")).andExpect(content().string(containsString("WORLD")));
    }

    @Test
    public void testReverseRoute() throws Exception {
        mockMvc.perform(get("/reverse?sentence=Hello World Yay")).andExpect(content().string(containsString("Yay World Hello")));
    }
}

