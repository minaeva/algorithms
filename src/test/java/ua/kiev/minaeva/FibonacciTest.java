package ua.kiev.minaeva;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FibonacciTest {

    Fibonacci fibonacci = new Fibonacci();

    @Test
    public void getFibonacci_when1_shouldReturn0() {
        assertThat(fibonacci.getFibonacci(1)).isEqualTo(0);
    }

    @Test
    public void getFibonacciFromBottom_when1_shouldReturn0() {
        assertThat(fibonacci.getFibonacciFromBottom(1)).isEqualTo(0);
    }

    //0 1 1 2 3 5 8 13 21 34

    @Test
    public void getFibonacci_when2_shouldReturn1() {
        assertThat(fibonacci.getFibonacci(2)).isEqualTo(1);
    }

    @Test
    public void getFibonacciFromBottom_when2_shouldReturn1() {
        assertThat(fibonacci.getFibonacciFromBottom(2)).isEqualTo(1);
    }

    //0 1 1 2 3 5 8 13 21 34

    @Test
    public void getFibonacci_when3_shouldReturn1() {
        assertThat(fibonacci.getFibonacci(3)).isEqualTo(1);
    }

    @Test
    public void getFibonacciFromBottom_when3_shouldReturn1() {
        assertThat(fibonacci.getFibonacciFromBottom(3)).isEqualTo(1);
    }

    //0 1 1 2 3 5 8 13 21 34

    @Test
    public void getFibonacci_when4_shouldReturn2() {
        assertThat(fibonacci.getFibonacci(4)).isEqualTo(2);
    }

    @Test
    public void getFibonacciFromBottom_when4_shouldReturn2() {
        assertThat(fibonacci.getFibonacciFromBottom(4)).isEqualTo(2);
    }

    //0 1 1 2 3 5 8 13 21 34

    @Test
    public void getFibonacci_when5_shouldReturn3() {
        assertThat(fibonacci.getFibonacci(5)).isEqualTo(3);
    }

    @Test
    public void getFibonacciFromBottom_when5_shouldReturn3() {
        assertThat(fibonacci.getFibonacciFromBottom(5)).isEqualTo(3);
    }

    //0 1 1 2 3 5 8 13 21 34

    @Test
    public void getFibonacci_when6_shouldReturn5() {
        assertThat(fibonacci.getFibonacci(6)).isEqualTo(5);
    }

    @Test
    public void getFibonacciFromBottom_when6_shouldReturn5() {
        assertThat(fibonacci.getFibonacciFromBottom(6)).isEqualTo(5);
    }

    //0 1 1 2 3 5 8 13 21 34

    @Test
    public void getFibonacci_when7_shouldReturn8() {
        assertThat(fibonacci.getFibonacci(7)).isEqualTo(8);
    }

    @Test
    public void getFibonacciFromBottom_when7_shouldReturn8() {
        assertThat(fibonacci.getFibonacciFromBottom(7)).isEqualTo(8);
    }

    //0 1 1 2 3 5 8 13 21 34

    @Test
    public void getFibonacci_when8_shouldReturn13() {
        assertThat(fibonacci.getFibonacci(8)).isEqualTo(13);
    }

    @Test
    public void getFibonacciFromBottom_when8_shouldReturn13() {
        assertThat(fibonacci.getFibonacciFromBottom(8)).isEqualTo(13);
    }


}
