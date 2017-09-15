package Connected_cells_in_grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Connectedcells {
	static int count;
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();	//number of rows
		int m=in.nextInt();	//number of columns
		int[][] matrix=new int[n][m];
		graph g=new graph(n,m);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				matrix[i][j]=in.nextInt();
				if(matrix[i][j]==1){
					g.addVertex(i, j);
				}	
			}
		}
		g.addEdges();
		//printGraph(g);
		Vertex[] a=g.mapVertexobj;
		for(int i=1;i<a.length;i++)
		{
			if(a[i]==null)
				break;
			dfs(a[i].value,g);
		}
		System.out.println(count);
		in.close();
	}
	
	/*public static void printGraph(graph g){
		
		Vertex[][] matrix=g.vertexMatrix;
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				if(matrix[i][j]!=null){
					System.out.print(matrix[i][j].connections);
					System.out.println();
				}
			}
		}
	}*/
	
	public static void dfs(int s,graph g){
		//long startTime = System.nanoTime();
		Stack<Integer> st=new Stack<Integer>();
		boolean[] flag=new boolean[g.numVertices+1];
		int tempcount=0;
		//System.out.println("dfs:");
		/*for(int i=0;i<g1.getNumVertices();i++){
			flag[i]=false;
		}*/
		st.push(s);
		while(!st.empty()){
			int i=st.pop();
			if(flag[i]==true)
				continue;
			
				flag[i]=true;
				tempcount++;
				//System.out.print(i+" ");
				List<Integer> l=new ArrayList<Integer>(g.mapVertexobj[i].connections);
				if(l!=null){
				for(int j=0;j<l.size();j++){
					//if(flag[l.get(j)]!=true)
					st.push(l.get(j));
					}
				}
		}
		if(tempcount>count)
			count=tempcount;
		//System.out.println();
		//System.out.println((double)(System.nanoTime() - startTime)/1000000000);
}
}
