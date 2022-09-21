package lab1;

public class Variant3 {

    public enum SEASON {
        WINTER, SPRING, SUMMER, AUTUMN
    }

    /**
     *
     * @param b-number in bytes
     * @return number in kilobytes
     */
    public int integerNumbersTask(int b) {
        assert (b > 0) : "Argument should be more than zero";
        return b / 1024;
    }

    /**
     *
     * @param a-number
     * @return whether the number is even
     */
    public boolean booleanTask(int a) {
        return a % 2 == 0;
    }

    /**
     *
     * @param a - number
     * @return if a>0: a+1; if a<0: a-1;if a=0: 10;
     */
    public int ifTask(int a) {
        if (a > 0)
            return ++a;
        if (a < 0)
            return a -= 2;
        return 10;
    }

    /**
     *
     * @param a month number
     * @return season
     */
    public SEASON switchTask(int a) {
        assert (a >= 1 && a <= 12) : "Argument should be between 1 and 12";
        switch (a) {
            case 1:
            case 2:
            case 12:
                return SEASON.WINTER;
            case 3:
            case 4:
            case 5:
                return SEASON.SPRING;
            case 6:
            case 7:
            case 8:
                return SEASON.SUMMER;
            case 9:
            case 10:
            case 11:
                return SEASON.AUTUMN;
            default:
                throw new IllegalArgumentException("Argument should be between 1 and 12");
        }
    }

    /**
     *
     * @param a number
     * @param b number
     * @return numbers between a and b and their amount
     */
    public int[] forTask(int a, int b) {
        assert (a < b) : "Argument a should be less than b";
        int[] mas = new int[b - a];
        for (int i = 0, n = a + 1; n < b; n++) {
            mas[i++] = n;
        }
        mas[b - a - 1] = mas.length - 1;
        return mas;
    }

    /**
     *
     * @param n number
     * @param k number
     * @return division of whole n by k and remainder from division
     */
    public int[] whileTask(int n, int k) {
        assert (n >0 && k > 0): "Argument should be more than zero";
        int[] result= new int[2];
        result[0]=0;
        while(k<=n){
            n-=k;
            ++result[0];
        }
        result[1]=n;
        return result;
    }


    /**
     *
     * @param n number
     * @param a1 first element of arithmetic progression
     * @param d difference of arithmetic progression
     * @return array of arithmetic progression elements
     */
    public int[] arrayTask(int n, int a1, int d) {
        assert (n >1): "Argument should be more than one";
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i]=a1+i*d;
        }
        return array;
    }

    /**
     *
     * @param array array of numbers
     * @param m number
     * @param n number
     * @return matrix in which each column contains all the numbers from the array
     */
    public int[][]  twoDimensionArrayTask(int[] array, int m, int n) {
        assert (n >0 && m > 0): "Argument should be more than zero";
        int[][] result = new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result[i][j]=array[i];
            }
        }

        return result;
    }

}