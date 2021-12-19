package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MatUtilsTest {

//    @Test
//    void eleWiseMulti() {
//        double[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        double[][] mat2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        double[][] expect = {{1, 4, 9}, {16, 25, 36}, {49, 64, 81}};
//        double[][] actual = MatUtils.eleWiseMulti(mat1, mat2);
//        assertArrayEquals(expect[0], actual[0]);
//        assertArrayEquals(expect[1], actual[1]);
//        assertArrayEquals(expect[2], actual[2]);
//    }
//
//    @Test
//    void sum() {
//        double[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        double[][] expect = {{1, 4, 9}, {16, 25, 36}, {49, 64, 81}};
//        assertEquals(45, MatUtils.sum(mat1));
//        assertEquals(1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81, MatUtils.sum(expect));
//    }
//
//    @Test
//    void getMatRowIndex() {
//        double[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        double[][] expect = {{1, 4, 9}, {16, 25, 36}, {49, 64, 81}};
//        assertArrayEquals(mat1[1], MatUtils.getMatRowIndex(Shape.input(0, 0), Shape.input(2, 3), mat1)[1]);
//    }
//
//    @Test
//    void conv() {
//        double[][][][] mat1 = {{{{1, 2}, {2, 3}}, {{3, 4}, {4, 5}}}, {{{1, 2}, {2, 3}}, {{3, 4}, {4, 5}}}};
//        double[][][] expect = {{{1, 1}, {2, 1}, {3, 1}}, {{4, 1}, {5, 1}, {6, 1}}, {{7, 1}, {8, 1}, {9, 1}}};
//        double[] bias = {1, 2};
////        double[][][] temp = new double[2][3][];
////        assertEquals(31, MatUtils.sum(MatUtils.conv(mat1, expect, 1)));
//        System.out.println(MatUtils.print(MatUtils.conv(mat1, expect, bias)));
////        System.out.println(temp[0][0].length);
//    }
//
//    @Test
//    void pool() {
//        double[][][] expect = {{{1, 1}, {2, 1}, {3, 1}, {4, 1}}, {{4, 1}, {5, 1}, {6, 1}, {7, 1}}, {{7, 1}, {8, 1}, {9, 1}, {10, 1}}};
//        System.out.println(MatUtils.print(expect));
//        System.out.println(MatUtils.print(MatUtils.pool(Shape.input(2, 2), expect, "max")));
//
//    }
}