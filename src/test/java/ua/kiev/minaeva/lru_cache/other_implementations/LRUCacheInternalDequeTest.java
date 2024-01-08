package ua.kiev.minaeva.lru_cache.other_implementations;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LRUCacheInternalDequeTest {

    @Test
    void scenario1() {
        LRUCacheInternalDeque lruCache = new LRUCacheInternalDeque(3);
        lruCache.put(1, 5);
        lruCache.put(2, 5);
        lruCache.put(1, 3);
        lruCache.print();

        int result = lruCache.get(1);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void scenario2() {
        LRUCacheInternalDeque lruCache = new LRUCacheInternalDeque(3);
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

    @Test
    public void getShouldReturnValueForExistingKey() {
        LRUCacheInternalDeque lruCache = new LRUCacheInternalDeque(10);
        lruCache.put(1, 11);
        assertEquals(11, lruCache.get(1));
    }

    @Test
    public void getShouldReturnNullForNonExistentKey() {
        LRUCacheInternalDeque lruCache = new LRUCacheInternalDeque(10);
        lruCache.put(1, 11);
        assertThat(lruCache.get(2)).isEqualTo(-1);
    }

    @Test
    public void getShouldReturnValueForManyExistingKeys() {
        LRUCacheInternalDeque lruCache = new LRUCacheInternalDeque(10);
        lruCache.put(1, 11);
        lruCache.put(2, 22);
        assertEquals(11, lruCache.get(1));
        assertEquals(22, lruCache.get(2));
    }

    @Test
    public void getShouldReturnNullForKeyNotFittingMaxItemsCount() {
        LRUCacheInternalDeque lruCache = new LRUCacheInternalDeque(1);
        lruCache.put(1, 11);
        lruCache.put(2, 22);
        assertThat(lruCache.get(1)).isEqualTo(-1);
        assertEquals(22, lruCache.get(2));
    }

    @Test
    public void getShouldReturnValueForRecreatedKeyAfterItWasPreviouslyRemoved() {
        LRUCacheInternalDeque lruCache = new LRUCacheInternalDeque(1);
        lruCache.put(1, 11);
        lruCache.put(2, 22);
        lruCache.put(1, 33);
        assertEquals(33, lruCache.get(1));
        assertThat(lruCache.get(2)).isEqualTo(-1);
    }

    @Test
    public void setShouldRemoveOldestKeyOnReachingMaxItemsCountIfNoGetOrHasBeenUsed() {
        LRUCacheInternalDeque lruCache = new LRUCacheInternalDeque(1);
        lruCache.put(1, 11);
        lruCache.put(2, 22);
        assertThat(lruCache.get(1)).isEqualTo(-1);
        assertEquals(22, lruCache.get(2));
    }

    @Test
    public void setShouldRemoveLeastRecentlyUsedKeyOnReachingMaxItemsCount() {
        LRUCacheInternalDeque lruCache = new LRUCacheInternalDeque(2);
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
        LRUCacheInternalDeque lruCache = new LRUCacheInternalDeque(2);
        lruCache.put(1, 11);
        lruCache.put(2, 22);

        lruCache.get(1);
        lruCache.put(3, 33);

        assertEquals(11, lruCache.get(1));
    }

}
