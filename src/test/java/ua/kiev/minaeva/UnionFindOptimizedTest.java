package ua.kiev.minaeva;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnionFindOptimizedTest {

    @Test
    public void shouldCreateArrayOnStart() {
        UnionFindOptimized unionFind = new UnionFindOptimized(5);
        assertArrayEquals(unionFind.getArray(), new int[]{0, 1, 2, 3, 4});
    }

    @Test
    public void union1and2() {
        UnionFindOptimized unionFind = new UnionFindOptimized(5);
        unionFind.union(1, 2);
        assertArrayEquals(unionFind.getArray(), new int[]{0, 2, 2, 3, 4});
    }

    @Test
    public void union1_2and2_3() {
        UnionFindOptimized unionFind = new UnionFindOptimized(5);
        unionFind.union(1, 2);
        unionFind.union(2, 3);
        assertArrayEquals(unionFind.getArray(), new int[]{0, 2, 3, 3, 4});
    }

    @Test
    public void union_complex() {
        UnionFindOptimized unionFind = new UnionFindOptimized(10);
        //0,1,2,3,4,5,6,7,8,9
        unionFind.union(4, 3);
        //0,1,2,3,3,5,6,7,8,9
        unionFind.union(3, 8);
        //0,1,2,8,3,5,6,7,8,9
        unionFind.union(6, 5);
        //0,1,2,8,3,5,5,7,8,9
        unionFind.union(9, 4);
        //0,1,2,8,3,5,5,7,8,8
        unionFind.union(2, 1);
        //0,1,1,8,3,5,5,7,8,8
        assertArrayEquals(unionFind.getArray(), new int[]{0, 1, 1, 8, 3, 5, 5, 7, 8, 8});
        assertTrue(unionFind.isConnected(8, 9));
    }
}