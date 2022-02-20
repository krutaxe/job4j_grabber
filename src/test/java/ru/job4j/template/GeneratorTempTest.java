package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GeneratorTempTest {

    @Ignore
    @Test
    public void whenGeneratorTestOne() {
        Generator generator = new GeneratorTemp();
        Map<String, String> tempMap = Map.of("name", "Dima", "subject", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        String rsl = generator.produce(template, tempMap);
        assertThat(rsl, is("I am a Dima, Who are you?"));
    }

    @Ignore
    @Test
    public void whenGeneratorTestTwo() {
        Generator generator = new GeneratorTemp();
        Map<String, String> tempMap = Map.of("?", "Hello", "!", "name");
        String template = "${?}, my name is Misha, what is your ${!}? ";
        String rsl = generator.produce(template, tempMap);
        assertThat(rsl, is("Hello, my name is Misha, what is your name? "));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void wrongKeys() {
        Generator generator = new GeneratorTemp();
        Map<String, String> tempMap = Map.of("user", "Hello", "login", "name");
        String template = "${?}, my name is Misha, what is your ${!}? ";
        String rsl = generator.produce(template, tempMap);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void extraKeys() {
        Generator generator = new GeneratorTemp();
        Map<String, String> tempMap = Map.of("?", "Hello", "!", "name", "@", "are");
        String template = "${?}, my name is Misha, what is your ${!}? ";
        String rsl = generator.produce(template, tempMap);
    }
}