package ua.kiev.minaeva.LRUCache;

public class LRUCacheProvider {
    public static <T> LRUCache<T> createLRUCache(CacheLimits options) {
        return new LRUCacheImpl(options.getMaxItemsCount());
    }
}
