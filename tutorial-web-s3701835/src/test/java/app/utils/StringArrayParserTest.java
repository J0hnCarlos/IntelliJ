package app.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringArrayParserTest {

    @Test
    void parse_ValidFormat_OK() {
        assertArrayEquals(new Integer[] {1,21,13}, StringArrayParser.parse("1,21,13"));
    }

    @Test
    void parse_ValidFormatNegative_OK() {
        assertArrayEquals(new Integer[] {1,-21,13}, StringArrayParser.parse("1,-21,13"));
    }

    @Test
    void parse_InValidFormatSemicolon_Fail() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            assertArrayEquals(new Integer[] {1,-21,13}, StringArrayParser.parse("1;-21,13"));
        });
    }


    @Test
    void parse_InValidFormatSpace_Fail() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            assertArrayEquals(new Integer[] {1,-21,13}, StringArrayParser.parse("1 -21 13"));
        });
    }

}