package ua.kiev.minaeva;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class CountStringsTest {

    @Test
    public void count_shouldReturnMap() {
        CountStrings countStrings = new CountStrings();
        String input = "This this is is done by Roman Roman";

        Map<String, Integer> result = countStrings.count(input);
        assertThat(result).isEqualTo(Map.of("by", 1, "this", 1,
                "This", 1, "Roman", 2, "is", 2, "done", 1));
    }

    @Test
    public void countInParallel_shouldReturnMap() {
        CountStrings countStrings = new CountStrings();
        String input = "This this is is done by Roman Roman";

        Map<String, Integer> result = countStrings.countInParallel(input);
        assertThat(result).isEqualTo(Map.of("by", 1, "this", 1,
                "This", 1, "Roman", 2, "is", 2, "done", 1));
    }

    @Test
    public void compareTimeToExecute() {
        CountStrings countStrings = new CountStrings();
        String input = """
                        To be, or not to be, that is the question:
                        Whether 'tis nobler in the mind to suffer
                        The slings and arrows of outrageous fortune,
                        Or to take arms against a sea of troubles
                        And by opposing end them. To die: to sleep;
                        No more; and by a sleep to say we end
                        The heart-ache and the thousand natural shocks
                        That flesh is heir to, 'tis a consummation
                        Devoutly to be wish'd. To die, to sleep;
                        To sleep: perchance to dream: ay, there's the rub;
                        For in that sleep of death what dreams may come
                        When we have shuffled off this mortal coil,
                        Must give us pause: there's the respect
                        That makes calamity of so long life;
                        """;

        long startTime = System.nanoTime();
        countStrings.count(input);
        long endTime = System.nanoTime();
        long durationInNano = endTime - startTime;
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(durationInNano);
        System.out.println("Time without threads " + durationInMillis);

        startTime = System.nanoTime();
        countStrings.countInParallel(input);
        endTime = System.nanoTime();
        durationInNano = endTime - startTime;
        durationInMillis = TimeUnit.NANOSECONDS.toMillis(durationInNano);
        System.out.println("Time with threads " + durationInMillis);

    }
}
