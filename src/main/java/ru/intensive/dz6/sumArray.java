package ru.intensive.dz6;

public class sumArray {
    public static int sumArray(String[][] arr) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    int num = Integer.parseInt(arr[i][j]);
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Invalid data in cell [" + i + "][" + j + "]: " + arr[i][j], i, j);
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        String[][] array = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "j"}};
        try {
            int sum = sumArray(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArrayDataException e) {
            System.out.println("Неверный формат данных в ячейке [" + e.getRow() + "][" + e.getColumn() + "]");
        }
        String[][] matrix = {{"1", "2", "3"}, {"5", "6", "7"}, {"9", "10", "11"}, {"13", "14", "15"}};
        try {
            int sum = ArrayUtils.findSum(matrix);
            System.out.println(sum);
        } catch (MyArraySizeException | NumberFormatException e) {
            e.printStackTrace();
        }

    }
}