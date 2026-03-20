package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Daily242Test {

    Daily242 daily242;

    @BeforeEach
    void setUp() {
        daily242 = new Daily242();
    }

    @Test
    void isAnagram() {
        //given
        var s = "Coal";
        var t = "Cola";

        //when &  then
        assertTrue(daily242.isAnagram(s,t));
    }

    @Test
    void isNotAnagram(){
        //given
        var s = "rat";
        var t = "car";

        //when &  then
        assertFalse(daily242.isAnagram(s,t));
    }
}