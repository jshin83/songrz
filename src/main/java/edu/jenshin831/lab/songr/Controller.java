package edu.jenshin831.lab.songr;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;

@RestController
public class Controller {

    /**
     * Default route
     * @return String welcome message
     */
    @GetMapping("/")
    public String defaultRoute() {
        return "Welcome to Jen's Songrz app.";
    }

    /**
     * Hello route
     * that shows message Hello, World
     * @return String Hello World
     */
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, world";
    }

    /**
     * Hello route that passes in a String
     * and will return that string capitalized
     * @param string String, word to capitalize
     * @return String, capitalized word
     */
    @GetMapping("/hello/{string}")
    public String capitalize(@PathVariable String string) {
        return string.toUpperCase();
    }

    /**
     * Reverse route that grabs a param
     * with key sentence
     * and returns
     * @param stringToReverse String, string to reverse
     * @return
     */
    @GetMapping("/reverse")
    @ResponseBody
    public String reverseStringParam(@RequestParam(name = "sentence") String stringToReverse) {
        return reverse(stringToReverse);
    }

    //helper route to split and return reversed phrase
    private String reverse(String word) {
        String[] split = word.split(" ");
        Collections.reverse(Arrays.asList(split));
        return arrayToString(split);
    }

    //helper route to loop through reversed array and return String
    private String arrayToString(String[] arr) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            result.append(arr[i]);
            if(i != arr.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
