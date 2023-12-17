package ua.kiev.minaeva;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxSubarraySumTest {

    MaxSubarraySum maxSubarraySum = new MaxSubarraySum();

    @Test
    void findMaxSubarraySum_shouldReturn6() {
        assertThat(maxSubarraySum.findMaxSubarraySum(new int[]{-2,1,-3,4,-1,2,1,-5,4})).isEqualTo(6);
    }

}
