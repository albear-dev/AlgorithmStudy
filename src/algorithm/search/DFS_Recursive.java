package algorithm.search;

/**
 * 깊이 우선 탐색 (DFS, Depth-First Search)
 */
public class DFS_Recursive {
  private static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
  static boolean[] visited = new boolean[graph.length];

  public static void main(String[] args) throws Exception{
    new DFS_Recursive().search(1);
  }

  private void search(int nodeIndex){
    visited[nodeIndex] = true;
    System.out.printf("현재 방문 노드 -> {%d} \n", nodeIndex);

    for (int node : graph[nodeIndex]) {
      if(!visited[node]){
        search(node);
      }
    }
  }
}
