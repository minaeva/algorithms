package ua.kiev.minaeva;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnionFindTest {

    @Test
    public void shouldCreateArrayOnStart() {
        UnionFind unionFind = new UnionFind(5);
        assertArrayEquals(unionFind.getArray(), new int[]{0, 1, 2, 3, 4});
    }

    @Test
    public void union1and2() {
        UnionFind unionFind = new UnionFind(5);
        unionFind.union(1, 2);
        assertArrayEquals(unionFind.getArray(), new int[]{0, 2, 2, 3, 4});
    }

    @Test
    public void union1_2and2_3() {
        UnionFind unionFind = new UnionFind(5);
        unionFind.union(1, 2);
        unionFind.union(2, 3);
        assertArrayEquals(unionFind.getArray(), new int[]{0, 3, 3, 3, 4});
    }

    @Test
    public void union_complex() {
        UnionFind unionFind = new UnionFind(10);
        unionFind.union(4, 3);
        unionFind.union(3, 8);
        unionFind.union(6, 5);
        unionFind.union(9, 4);
        unionFind.union(2, 1);
        assertArrayEquals(unionFind.getArray(), new int[]{0, 1, 1, 8, 8, 5, 5, 7, 8, 8});
        assertTrue(unionFind.isConnected(8,9));
    }
}