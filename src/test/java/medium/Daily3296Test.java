package medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Daily3296Test {


    Daily3296 daily3296;

    @BeforeEach
    void setup() {
        daily3296= new Daily3296();
    }

    @Test
    void minNumberOfSeconds() {
        //given
        var mountainHeight =4;
        var workerTimes = new int[]{2,1,1};

        //when & then
        assertEquals(3,daily3296.minNumberOfSeconds(mountainHeight,workerTimes));
    }
}