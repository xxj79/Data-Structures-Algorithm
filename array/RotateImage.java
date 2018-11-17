package array;

/*
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 */


/*
 * The idea is to first draw a example to see what tricks we
 * can do to get the result.
 * 
 * For example, for this problem all we need is two opertations:
 * a transpose operation and a flip operation
 */

public class RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        //swap up side down
        for(int first=0, last=rows-1; first<last; first++,last--) {
            int[] tmp = matrix[first];
            matrix[first] = matrix[last];
            matrix[last] = tmp;
        }
        
        //Then swap symmetry
        for(int i = 0; i < rows; i++){
            for(int j = i+1; j < cols; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    
    //Or we can transpose first, then flip horizontally
}
