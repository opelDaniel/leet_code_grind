package medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Daily1415Test {

    Daily1415 daily1415;

    @BeforeEach
    void setUp() {
        daily1415 = new Daily1415();
    }


    @Test
    void shouldReturnValidStringC() {
        //given
        var n = 1;
        var k = 3;

        //when & then
        assertEquals("c", daily1415.getHappyString(n, k));
    }

    @Test
    void shouldReturnEmptyString() {
        //given
        var n = 1;
        var k = 4;

        //when & then
        assertEquals("", daily1415.getHappyString(n, k));
    }

    @Test
    void shouldReturnValidStringCAB() {
        //given
        var n = 3;
        var k = 9;

        //when & then
        assertEquals("cab", daily1415.getHappyString(n, k));
    }
}