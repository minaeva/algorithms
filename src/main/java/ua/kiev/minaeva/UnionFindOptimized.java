package ua.kiev.minaeva;

public class UnionFindOptimized {

    private final int[] array;

    public UnionFindOptimized(int n) {
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    public int[] getArray() {
        return array;
    }

    public void union(int p, int q) {
        int rootOfFirst = findRoot(p);
        int rootOfSecond = findRoot(q);
        array[rootOfFirst] = rootOfSecond;
    }

    public boolean isConnected(int p, int q) {
        return array[p] == array[q];
    }

    private int findRoot(int index) {
        int value = array[index];
        return (value == index ? index : findRoot(value));
    }
}
