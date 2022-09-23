package algorithm.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 너비 우선 탐색 (BFS, Breadth-First Search)
 */
public class BFS {
  private static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
  static boolean[] visited = new boolean[graph.length];

  public static void main(String[] args) throws Exception{
    String result = new BFS().search(1, graph, visited);
    System.out.println(result);
  }

  private String search(int start, int[][] graph, boolean[] visited){
    StringBuilder sb = new StringBuilder();
    Queue<Integer> q = new LinkedList<>();

    q.offer(start);
    visited[start] = true;

    while(!q.isEmpty()){
      int nodeIndex = q.poll();
      sb.append(nodeIndex + " -> ");

      for(int i=0; i<graph[nodeIndex].length; i++){
        int temp = graph[nodeIndex][i];
        if(!visited[temp]){
          visited[temp] = true;
          q.offer(temp);
        }
      }
    }

    return sb.toString();
  }
}