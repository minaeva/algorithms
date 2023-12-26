package ua.kiev.minaeva.lru;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    void scenario3() {
        LRUCacheInternalDeque lruCache = new LRUCacheInternalDeque(2);
        lruCache.put(1, 11);
        lruCache.put(2, 22);
        lruCache.get(1);
        lruCache.print();

        lruCache.put(3, 33);
        lruCache.print();

        assertEquals(11, lruCache.get(1));
        assertNull(lruCache.get(2));
        assertEquals(33, lruCache.get(3));
    }

/*

    /*
        @Test
    public void getShouldReturnValueForExistingKey() {
        LRUCache<String> lruCache = createLRUCache(new CacheLimits(10));
        lruCache.set("foo", "bar");
        assertEquals("bar", lruCache.get("foo"));
    }

    @Test
    public void getShouldReturnNullForNonExistentKey() {
        LRUCache<String> lruCache = createLRUCache(new CacheLimits(10));
        lruCache.set("foo", "bar");
        assertNull(lruCache.get("bar"));
        assertNull(lruCache.get(""));
    }

    @Test
    public void getShouldReturnValueForManyExistingKeys() {
        LRUCache<String> lruCache = createLRUCache(new CacheLimits(10));
        lruCache.set("foo", "foo");
        lruCache.set("baz", "baz");
        assertEquals("foo", lruCache.get("foo"));
        assertEquals("baz", lruCache.get("baz"));
    }

    @Test
    public void getShouldReturnNullForKeyNotFittingMaxItemsCount() {
        LRUCache<String> lruCache = createLRUCache(new CacheLimits(1));
        lruCache.set("foo", "bar");
        lruCache.set("baz", "bar");
        assertNull(lruCache.get("foo"));
        assertEquals("bar", lruCache.get("baz"));
    }

    @Test
    public void getShouldReturnValueForRecreatedKeyAfterItWasPreviouslyRemoved() {
        LRUCache<String> lruCache = createLRUCache(new CacheLimits(1));
        lruCache.set("foo", "bar");
        lruCache.set("baz", "bar");
        lruCache.set("foo", "bar");
        assertEquals("bar", lruCache.get("foo"));
        assertNull(lruCache.get("baz"));
    }

    @Test
    public void setShouldRemoveOldestKeyOnReachingMaxItemsCountIfNoGetOrHasBeenUsed() {
        LRUCache<String> lruCache = createLRUCache(new CacheLimits(1));
        lruCache.set("foo", "bar");
        lruCache.set("baz", "bar");
        assertNull(lruCache.get("foo"));
        assertEquals("bar", lruCache.get("baz"));
    }

    @Test
    public void setShouldRemoveLeastRecentlyUsedKeyOnReachingMaxItemsCount() {
        LRUCache<String> lruCache = createLRUCache(new CacheLimits(2));
        lruCache.set("foo", "bar");
        lruCache.set("bar", "bar");
        lruCache.get("foo");
        lruCache.set("baz", "bar");

        assertEquals("bar", lruCache.get("foo"));
        assertNull(lruCache.get("bar"));
        assertEquals("bar", lruCache.get("baz"));
    }

    @Test
    public void itemIsConsideredAccessedWhenGetIsCalled() {
        LRUCache<String> lruCache = createLRUCache(new CacheLimits(2));
        lruCache.set("1key", "1value");
        lruCache.set("2key", "2value");

        lruCache.get("1key");
        lruCache.set("3key", "3value");

        assertEquals("1value", lruCache.get("1key"));
    }
    * */

}
