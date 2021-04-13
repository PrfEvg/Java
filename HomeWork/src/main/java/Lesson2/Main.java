package Lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] Arr ={
                {"5", "5", "5", "5"},
                {"5", "5", "5", "5"},
                {"5", "5", "5", "5"},
                {"5", "5", "5", "5"},
        };
        try { try {
            int result = array(Arr);
            System.out.println(result);
        }
        catch (MyArraySizeException e){
            e.printStackTrace();
        }
        } catch (MyArrayDataException e){
            e.printStackTrace();
        }
    }

    public static int array(String[][] arr) throws MyArraySizeException, MyArrayDataException {
            if(arr.length != 4){
            throw new MyArraySizeException();
            }
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length != 4){
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr.length; j++) {
                try {
                    sum = sum + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }

            }

        }
        return sum;
    }
}

