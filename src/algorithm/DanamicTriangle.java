package algorithm;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */
public class DanamicTriangle {
  public static void main(String[] args){
    int[][] triangle = new int[][]{
      new int[]       {7},        //          7
      new int[]      {3, 8},      //       10, 15
      new int[]     {8, 1, 0},    //     18, 11, 15
      new int[]   {2, 7, 4, 4},   //   20, 25, 15, 19
      new int[]  {4, 5, 2, 6, 5}  // 24, 25, 27, 21, 24
    };
    int result = new DanamicTriangle().solution(triangle);
    System.out.println(result);
  }

  public int solution(int[][] triangle) {

        int[][] memo = new int[triangle.length][triangle[triangle.length-1].length];
        for(int i=0; i<triangle.length; i++){
          for(int j=0; j<triangle[i].length; j++){
            if(i == 0){
              memo[0][0] = triangle[0][0];
            }else{
              if(j == 0){
                memo[i][j] = memo[i-1][j] + triangle[i][j];
              }else if(j == triangle[i].length-1){
                memo[i][j] = memo[i-1][triangle[i-1].length-1] + triangle[i][j];
              }else{
                memo[i][j] = max(memo[i-1][j-1], memo[i-1][j]) + triangle[i][j];
              }
            }
          }
        }

        return Arrays.stream(memo[memo.length-1]).max().getAsInt();
    }

    private int max(int a, int b){
      if(a > b) return a;
      else if(a < b) return b;
      else return a;
    }
}
