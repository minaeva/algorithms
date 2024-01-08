package ua.kiev.minaeva.lru_cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static ua.kiev.minaeva.lru_cache.LRUCacheProvider.createLRUCache;

public class LruCacheTest {

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
}
