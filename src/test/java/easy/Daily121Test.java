package easy;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Daily121Test {
    Daily121 daily121;

    @BeforeEach
    void setup(){
        daily121 = new Daily121();
    }

    @Test
    void shouldReturnBestProfit5(){
        //given
        var prices = new int[]{7,1,5,3,6,4};

        //when & then
        assertEquals(5,daily121.maxProfit(prices));
    }
}