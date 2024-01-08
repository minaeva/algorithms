package ua.kiev.minaeva.lru_cache;

public class LRUCacheProvider {
    public static <T> LRUCache<T> createLRUCache(CacheLimits options) {
        return new LRUCacheImpl(options.getMaxItemsCount());
    }
}
