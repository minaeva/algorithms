package ua.kiev.minaeva;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LRUCacheTest {

    @Test
    void scenario1() {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 5);
        lruCache.put(2, 5);
        lruCache.put(1, 3);
        lruCache.print();

        int result = lruCache.get(1);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void scenario2() {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 11);
        lruCache.put(2, 22);
        lruCache.put(3, 33);
        lruCache.print();
        assertThat(lruCache.get(1)).isEqualTo(11);
        assertThat(lruCache.get(2)).isEqualTo(22);
        assertThat(lruCache.get(3)).isEqualTo(33);

        lruCache.put(5, 55);
        lruCache.print();
        assertThat(lruCache.get(1)).isEqualTo(-1);

        lruCache.get(3);
        lruCache.print();

        lruCache.put(1, 1);
        lruCache.print();

        assertThat(lruCache.get(2)).isEqualTo(-1);
    }


}
