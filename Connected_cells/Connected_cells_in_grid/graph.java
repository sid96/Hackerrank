package Connected_cells_in_grid;

public class graph {
	int numVertices=0;
	Vertex[][] vertexMatrix;
	Vertex[] mapVertexobj;
	public graph(int n,int m){
		vertexMatrix=new Vertex[n][m];
		mapVertexobj=new Vertex[n*m+1];
	}
	
	public void addVertex(int i,int j){
		numVertices++;
		vertexMatrix[i][j]=new Vertex(numVertices);
		mapVertexobj[numVertices]=vertexMatrix[i][j];
		
	}
	
	public void addEdges(){
		int n=vertexMatrix.length;
		int m=vertexMatrix[0].length;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(vertexMatrix[i][j]!=null)
				{	
					
					if(((i-1)>=0&&(j-1)>=0)&&vertexMatrix[i-1][j-1]!=null)
					{
						vertexMatrix[i][j].connections.add(vertexMatrix[i-1][j-1].value);
					}
					if(((i-1)>=0)&&vertexMatrix[i-1][j]!=null)
					{
						vertexMatrix[i][j].connections.add(vertexMatrix[i-1][j].value);
					}
					if(((i-1)>=0&&((j+1)>=0&&(j+1)<n))&&vertexMatrix[i-1][j+1]!=null)
					{
						vertexMatrix[i][j].connections.add(vertexMatrix[i-1][j+1].value);
					}
					if((((j+1)<m))&&vertexMatrix[i][j+1]!=null)
					{
						vertexMatrix[i][j].connections.add(vertexMatrix[i][j+1].value);
					}
					if((((i+1)<n)&&((j+1)<m))&&vertexMatrix[i+1][j+1]!=null)
					{
						vertexMatrix[i][j].connections.add(vertexMatrix[i+1][j+1].value);
					}
					if((((i+1)<n))&&vertexMatrix[i+1][j]!=null)
					{
						vertexMatrix[i][j].connections.add(vertexMatrix[i+1][j].value);
					}
					if((((i+1)<n)&&(j-1)>=0)&&vertexMatrix[i+1][j-1]!=null)
					{
						vertexMatrix[i][j].connections.add(vertexMatrix[i+1][j-1].value);
					}
					if(((j-1)>=0)&&vertexMatrix[i][j-1]!=null)
					{
						vertexMatrix[i][j].connections.add(vertexMatrix[i][j-1].value);
					}
				}
			}
			
		}
	}
	
	
	

}
