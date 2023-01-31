package ua.kiev.minaeva;


public class UnionFind {

    private final int[] array;

    public UnionFind(int n) {
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    public int[] getArray() {
        return array;
    }
    public boolean isConnected(int p, int q) {
        return array[p] == array[q];
    }

    public void union(int first, int second) {
        int oldValue = array[first];
        array[first] = array[second];

        for (int i = 0; i < array.length; i++) {
            if (array[i] == oldValue) {
                array[i] = array[second];
            }
        }
    }
}
