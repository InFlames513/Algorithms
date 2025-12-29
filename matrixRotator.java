  public class matrixRotator {

      public static void main(String[] args) {

          // 3x3 Test Matrix
          int[][] input = {
                  { 1, 2, 3 },
                  { 4, 5, 6 },
                  { 7, 8, 9 }
          };

          // int[][] input5x5 = {
          //         { 1, 2, 3, 4, 5 },
          //         { 6, 7, 8, 9, 10 },
          //         { 11, 12, 13, 14, 15 },
          //         { 16, 17, 18, 19, 20 },
          //         { 21, 22, 23, 24, 25 }
          // };

          // int[][] input7x7 = {
          //   {  1,  2,  3,  4,  5,  6,  7 },
          //   {  8,  9, 10, 11, 12, 13, 14 },
          //   { 15, 16, 17, 18, 19, 20, 21 },
          //   { 22, 23, 24, 25, 26, 27, 28 },
          //   { 29, 30, 31, 32, 33, 34, 35 },
          //   { 36, 37, 38, 39, 40, 41, 42 },
          //   { 43, 44, 45, 46, 47, 48, 49 }
          // };
          

          System.out.println("=== SMART MATRIX ROTATOR TESTS ===\n");
          System.out.println("Original Matrix:");
          printMatrix(input);

          System.out.println("--- Rotating 90 Degrees Right ---");
          int[][] res90 = rotate(input, 90);
          printMatrix(res90);

          System.out.println("--- Rotating 180 Degrees Right ---");
          int[][] res180 = rotate(input, 180);
          printMatrix(res180);

          System.out.println("--- Rotating 270 Degrees Right ---");
          int[][] res270 = rotate(input, 270);
          printMatrix(res270);

          System.out.println("--- Rotating 360 Degrees Right ---");
          int[][] res360 = rotate(input, 360);
          printMatrix(res360);

          System.out.println("--- Rotating 450 Degrees Right ---");
          int[][] res450 = rotate(input, 450);
          printMatrix(res450);
      }

      public static void printMatrix(int[][] matrix) {
          for (int[] matrix1 : matrix) {
              System.out.print("[ ");
              for (int j = 0; j < matrix1.length; j++) System.out.print(matrix1[j] + "\t");
              System.out.println("]");
          }
      }
      
      public static int[][] rotate(int[][] matrix, int degrees) {
          if(degrees<0) degrees+=360;
          if(degrees>360) degrees %= 360;
          int N = matrix.length;
          double step = degrees*((N-1.0)*4)/360;
          int[][] temp = new int[N][N];
          for (int i = 0; i < N; i++) temp[i] = matrix[i].clone();
          int[][] res = new int[N][N];
          for (int i = 0; i < N; i++) res[i] = matrix[i].clone();
          for(int x=0; x<step; x++) {
            for(int y=0; y<temp.length; y++) {
              for(int z=0; z<temp[y].length; z++) {
                if(y == N/2 && y == z) res[y][z] = temp[y][z];
                else if(y<N/2 && y<=z && N-y-z-1 > 0 && degrees*((N-y*2-1.0)*4)/360 > x) res[y][z+1] = temp[y][z]; // For top
                else if(y>=N/2 && y>=z && N-y-z-1 < 0 && degrees*((N-(N-y-1)*2-1.0)*4)/360 > x) res[y][z-1] = temp[y][z]; // For bottom
                else if(z<N/2 && z<=y && degrees*((N-z*2-1.0)*4)/360 > x) res[y-1][z] = temp[y][z]; // For left
                else if(z>=N/2 && z>=y && degrees*((N-(N-z-1)*2-1.0)*4)/360 > x) res[y+1][z] = temp[y][z]; // For right
              }
            }
            for (int i = 0; i < N; i++) temp[i] = res[i].clone();
          }
          return res;
      }
  }
