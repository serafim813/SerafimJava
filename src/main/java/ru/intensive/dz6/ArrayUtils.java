package ru.intensive.dz6;

public class ArrayUtils {
    public static int findSum(String[][] matrix) throws MyArraySizeException, NumberFormatException, MyArrayDataException {
        if (matrix.length != 4) {
            throw new MyArraySizeException("Array should have 4 rows");
        }
        int sum = 0;
        for (String[] row : matrix) {
            if (row.length != 4) {
                throw new MyArraySizeException("Array should have 4 columns");
            }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Invalid data in cell [" + i + "][" + j + "]: " + matrix[i][j], i, j);
                }
            }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        //String[][] matrix = {{"1", "2", "3"}, {"5", "6", "7"}, {"9", "10", "11"}, {"13", "14", "15"}};
        String[][] matrix = {{"1", "2", "3", "4"}, {"5", "6", "7", "o"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        //String[][] matrix = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

        try {
            int sum = ArrayUtils.findSum(matrix);
            System.out.println(sum);
        } catch (MyArraySizeException | NumberFormatException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}

