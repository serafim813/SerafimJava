package ru.intensive.dz6;

public class ArrayUtils {
    public static int findSum(String[][] matrix) throws MyArraySizeException, NumberFormatException {
        if (matrix.length != 4) {
            throw new MyArraySizeException("Array should have 4 rows");
        }
        for (String[] row : matrix) {
            if (row.length != 4) {
                throw new MyArraySizeException("Array should have 4 columns");
            }
        }
        int totalSum = 0;
        for (String[] row : matrix) {
            for (String element : row) {
                try {
                    totalSum += Integer.parseInt(element);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Array should contain only integers");
                }
            }
        }
        return totalSum;
    }
    public static void main(String[] args) {
        String[][] matrix = {{"1", "2", "3"}, {"5", "6", "7"}, {"9", "10", "11"}, {"13", "14", "15"}};
        try {
            int sum = ArrayUtils.findSum(matrix);
            System.out.println(sum);
        } catch (MyArraySizeException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

