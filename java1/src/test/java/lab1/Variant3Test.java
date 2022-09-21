package lab1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Variant3Test {


   @Test(dataProvider = "integerNumbersTaskTestProvaider")
    public void integerNumbersTaskTest(int input, int output){
        assertEquals(new Variant3().integerNumbersTask(input), output);
    }
    @DataProvider
    public Object[][] integerNumbersTaskTestProvaider() {
        return new Object[][] { { 2048, 2 }, { 678, 0 } };
    }

    @Test(expectedExceptions = AssertionError.class,dataProvider = "integerNumbersTaskTestNegativeProvaider")
    public void integerNumbersTaskTestNegative(int a){
        new Variant3().integerNumbersTask(a);
    }
    @DataProvider
    public Object[][] integerNumbersTaskTestNegativeProvaider() {
        return new Object[][] { { -1024 }, { -1} };
    }

   @Test(dataProvider = "booleanTaskTestProvaider")
   public void booleanTaskTest(int input, boolean output){
       assertEquals(new Variant3().booleanTask(input), output);
   }
    @DataProvider
    public Object[][] booleanTaskTestProvaider() {
        return new Object[][] { { 10 ,true},{ 5 ,false}};
    }

    @Test(dataProvider = "ifTaskTestProvaider")
    public void ifTaskTest(int input, int output){
        assertEquals(new Variant3().ifTask(input), output);
    }
    @DataProvider
    public Object[][] ifTaskTestProvaider() {
        return new Object[][] { { 10 ,11},{ -5 ,-7},{ 0 ,10}};
    }

    @Test(dataProvider = "switchTaskTestProvaider")
    public void switchTaskTest(int input, Variant3.SEASON output){
        assertEquals(new Variant3().switchTask(input), output);
    }
    @DataProvider
    public Object[][] switchTaskTestProvaider() {
        return new Object[][] {
                { 1,Variant3.SEASON.WINTER },
                { 9, Variant3.SEASON.AUTUMN },
                { 5, Variant3.SEASON.SPRING } };
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider="switchTaskTestNegativeProvaider")
    public void switchTaskTestNegative(int a){
        new Variant3().switchTask(a);
    }
    @DataProvider
    public Object[][] switchTaskTestNegativeProvaider() {
        return new Object[][] { {-1}, {13}};
    }

    @Test(dataProvider = "forTaskTestProvaider")
    public void forTaskTest(int input, int output, int[] result){
        assertEquals(new Variant3().forTask(input, output),result);
    }
    @DataProvider
    public Object[][] forTaskTestProvaider() {
        return new Object[][]{
                {1, 5, new int[]{2, 3,4, 3}},
                {5, 11, new int[]{6, 7, 8,9,10,5}}
        };
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider="forTaskTestNegativeProvaider")
    public void forTaskTestNegative(int a, int b){
        new Variant3().forTask(a,b);
    }
    @DataProvider
    public Object[][] forTaskTestNegativeProvaider() {
        return new Object[][] { {10 ,6}};
    }


    @Test(dataProvider = "whileProvider")
    public void whileTest(int a, int b, int[] result) {
        assertEquals(new Variant3().whileTask(a, b), result);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] {
                { 10, 2, 5,0},
                { 12, 10, 1,2},
                { 12, 1, 12,0},
                { 25, 7, 3, 4 } };
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider = "negativeWhileProvider")
    public void negativeWhileTest(int a, int b) {
        new Variant3().whileTask(a, b);
    }

    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][] { { -25, 2 }, { -2, 1 }, { 2, -1 } };
    }

    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int n, int a1, int d,int[] result) {
        assertEquals(new Variant3().arrayTask(n,a1,d), result);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][]{
                {5, 3, 2, new int[]{3, 5, 7, 9, 11}},
                {4, 1, 3, new int[]{1, 4, 7, 10}}};
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider = "negativeArrayProvider")
    public void negativeArrayTest(int n, int a1, int d) {
        new Variant3().arrayTask(n, a1, d);
    }

    @DataProvider
    public Object[][] negativeArrayProvider() {
        return new Object[][] { { 0, 4, 1 }, { -2, 1, 3} };
    }



    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[] array, int m, int n, int[][] output) {
        assertEquals(new Variant3().twoDimensionArrayTask(array, m, n), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[] input_1 = {1,4,6};

        int[][] input1 = {{1,1,1,1},
                {4,4,4,4},
                {6,6,6,6}};

        int[] input_2 = {6,4,3,5};

        int[][] input2 = {{6,6},
                {4,4},
                {3,3},
                {5,5}};

        return new Object[][] { {input_1, 3, 4, input1} ,{input_2, 4, 2, input2} };

    }

    @Test(expectedExceptions = AssertionError.class, dataProvider = "negativeMatrixProvider")
    public void negativeMatrixTest(int[] array, int m, int n) {
        new Variant3().twoDimensionArrayTask(array, m, n);
    }

    @DataProvider
    public Object[][] negativeMatrixProvider() {
        return new Object[][] {{new int[]{1,4,6,0}, 4,-2 }};
    }


}
