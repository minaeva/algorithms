package ua.kiev.minaeva.lru;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LRUCacheJavasDequeTest {

    @Test
    void scenario1() {
        LRUCacheJavasDeque lruCache = new LRUCacheJavasDeque(3);
        lruCache.put(1, 5);
        lruCache.put(2, 5);
        lruCache.put(1, 3);
        int result = lruCache.get(1);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void scenario2() {
        LRUCacheJavasDeque lruCache = new LRUCacheJavasDeque(3);
        lruCache.put(1, 11);
        lruCache.put(2, 22);
        lruCache.put(3, 33);
        assertThat(lruCache.get(1)).isEqualTo(11);
        assertThat(lruCache.get(2)).isEqualTo(22);
        assertThat(lruCache.get(3)).isEqualTo(33);

        lruCache.put(5, 55);
        assertThat(lruCache.get(1)).isEqualTo(-1);

        lruCache.get(3);
        lruCache.put(1, 1);
        assertThat(lruCache.get(2)).isEqualTo(-1);
    }

    @Test
    public void getShouldReturnValueForExistingKey() {
        LRUCacheJavasDeque lruCache = new LRUCacheJavasDeque(10);
        lruCache.put(1, 11);
        assertEquals(11, lruCache.get(1));
    }

    @Test
    public void getShouldReturnNullForNonExistentKey() {
        LRUCacheJavasDeque lruCache = new LRUCacheJavasDeque(10);
        lruCache.put(1, 11);
        assertThat(lruCache.get(2)).isEqualTo(-1);
    }

    @Test
    public void getShouldReturnValueForManyExistingKeys() {
        LRUCacheJavasDeque lruCache = new LRUCacheJavasDeque(10);
        lruCache.put(1, 11);
        lruCache.put(2, 22);
        assertEquals(11, lruCache.get(1));
        assertEquals(22, lruCache.get(2));
    }

    @Test
    public void getShouldReturnNullForKeyNotFittingMaxItemsCount() {
        LRUCacheJavasDeque lruCache = new LRUCacheJavasDeque(1);
        lruCache.put(1, 11);
        lruCache.put(2, 22);
        assertThat(lruCache.get(1)).isEqualTo(-1);
        assertEquals(22, lruCache.get(2));
    }

    @Test
    public void getShouldReturnValueForRecreatedKeyAfterItWasPreviouslyRemoved() {
        LRUCacheJavasDeque lruCache = new LRUCacheJavasDeque(1);
        lruCache.put(1, 11);
        lruCache.put(2, 22);
        lruCache.put(1, 33);
        assertEquals(33, lruCache.get(1));
        assertThat(lruCache.get(2)).isEqualTo(-1);
    }

    @Test
    public void setShouldRemoveOldestKeyOnReachingMaxItemsCountIfNoGetOrHasBeenUsed() {
        LRUCacheJavasDeque lruCache = new LRUCacheJavasDeque(1);
        lruCache.put(1, 11);
        lruCache.put(2, 22);
        assertThat(lruCache.get(1)).isEqualTo(-1);
        assertEquals(22, lruCache.get(2));
    }

    @Test
    public void setShouldRemoveLeastRecentlyUsedKeyOnReachingMaxItemsCount() {
        LRUCacheJavasDeque lruCache = new LRUCacheJavasDeque(2);
        lruCache.put(1, 11);
        lruCache.put(2, 22);
        lruCache.get(1);
        lruCache.print();

        lruCache.put(3, 33);
        lruCache.print();

        assertEquals(11, lruCache.get(1));
        assertThat(lruCache.get(2)).isEqualTo(-1);
        assertEquals(33, lruCache.get(3));
    }

    @Test
    public void itemIsConsideredAccessedWhenGetIsCalled() {
        LRUCacheJavasDeque lruCache = new LRUCacheJavasDeque(2);
        lruCache.put(1, 11);
        lruCache.put(2, 22);

        lruCache.get(1);
        lruCache.put(3, 33);

        assertEquals(11, lruCache.get(1));
    }
}
