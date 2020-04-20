import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	//Number of vertices
	private int V;
	
	private LinkedList<LinkedList<Integer>> graph=new LinkedList<>();
	
	
	public Graph(int v) {
		V=v;
		for(int i=0;i<V;i++) {
			graph.add(i,new LinkedList<>());
		}
	}
	
	public void addEdge(int v,int u) {
		
		graph.get(v).add(u);
	}
	
	
	public void DFS(int s,boolean[] visited){
		
		visited[s]=true;
		System.out.print(s+" ");
		Iterator<Integer> i=graph.get(s).iterator();
		
		while(i.hasNext()) {
			int c=i.next();
			if(!visited[c]) {
				visited[c]=true;
				DFS(c,visited);
			}
		}
		
	}
	public  void BFS(int s) {
		boolean visited[]=new boolean[V];
		
		Queue<Integer> queue=new LinkedList<>();
		
		queue.add(s);
		visited[s]=true;
		while(!queue.isEmpty()) {
			
			int c=queue.poll();
			
			System.out.println(c);
			
			Iterator<Integer> i=graph.get(c).iterator();
			
			while(i.hasNext()) {
				int temp=i.next();
				if(!visited[temp]) {
					queue.add(temp);
					visited[temp]=true;
				}
			}
			
		}
	}
	public static void main(String[] args) {
		
		Graph g = new Graph(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.BFS(2); 
        
        g.DFS(2,new boolean[g.graph.size()]);
		
	}
	
	
	

}
