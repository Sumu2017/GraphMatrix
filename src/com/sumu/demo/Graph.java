package com.sumu.demo;

public class Graph {
	private int vertexSize;//顶点的数量
	private int[] vertexs;//顶点数组
	private int[][] matrix;
	private static final int MAX_WEIGHT=1000;
	
	public Graph(int vertexSize) {
		// TODO Auto-generated constructor stub
		this.vertexSize=vertexSize;
		matrix=new int[vertexSize][vertexSize];
	}
	
	/**
	 * 获取某个顶点的出度(横向看矩阵)
	 * @return
	 */
	public int getOutDegree(int vertex) {
		int degree=0;
		for (int i = 0; i < matrix[vertex].length; i++) {
			int j = matrix[vertex][i];
			if (j!=0&&j!=MAX_WEIGHT) {
				degree++;
			}
		}
		return degree;
	}
	
	/**
	 * 获取某个顶点的入度(纵向看矩阵)
	 * @return
	 */
	public int getInDegree(int vertex) {
		int degree=0;
		for (int i = 0; i < matrix[vertex].length; i++) {
			int j = matrix[i][vertex];
			if (j!=0&&j!=MAX_WEIGHT) {
				degree++;
			}
		}
		return degree;
	}
	
	/**
	 * 获取两个顶点之间的权值
	 * @param v1
	 * @param v2
	 * @return
	 */
	public int getWeight(int v1,int v2) {
		int weight = matrix[v1][v2];
		if (weight==MAX_WEIGHT) {
			weight=-1;
		}
		return weight;
	}
	
	/**
	 * 添加新的顶点
	 * @param vertex
	 */
	public void addVertex(int vertex) {
		if (vertexs==null) {
			return;
		}
		vertexSize++;
		int[] oldVertexs=vertexs;
		vertexs=new int[vertexSize];
		for (int i = 0; i < oldVertexs.length; i++) {
			vertexs[i]=oldVertexs[i];		
		}
		vertexs[vertexSize-1]=vertex;
		
		int[][]	oldMatrix=matrix;
		matrix=new int[vertexSize][vertexSize];
		for (int i = 0; i < oldMatrix.length; i++) {
			for (int j = 0; j < oldMatrix[i].length; j++) {
				matrix[i][j]=oldMatrix[i][j];	
			}
		}
		for (int i = 0; i < matrix.length-1; i++) {
			matrix[matrix.length-1][i]=MAX_WEIGHT;
			matrix[i][matrix.length-1]=MAX_WEIGHT;
		}
		
	}
	/**
	 * 打印出带权邻接矩阵
	 */
	public void print() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	
	public int[] getVertexs() {
		return vertexs;
	}



	public void setVertexs(int[] vertexs) {
		this.vertexs = vertexs;
	}



	public static void main(String[] args) {
		Graph graph=new Graph(5);
		int[] a0=new int[] {0,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,6};
		int[] a1=new int[] {9,0,3,MAX_WEIGHT,MAX_WEIGHT};
		int[] a2=new int[] {2,MAX_WEIGHT,0,5,MAX_WEIGHT};
		int[] a3=new int[] {MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0,1};
		int[] a4=new int[] {MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0};
		int[] vertexs=new int[] {0,1,2,3,4};
		graph.setVertexs(vertexs);
		graph.matrix[vertexs[0]]=a0;
		graph.matrix[vertexs[1]]=a1;
		graph.matrix[vertexs[2]]=a2;
		graph.matrix[vertexs[3]]=a3;
		graph.matrix[vertexs[4]]=a4;
		for (int i = 0; i < graph.vertexs.length; i++) {
			int v = graph.vertexs[i];
			System.out.println("v"+graph.vertexs[v]+"的出度为："+graph.getOutDegree(graph.vertexs[v]));
		}
		System.out.println("");
		for (int i = 0; i < graph.vertexs.length; i++) {
			int v = graph.vertexs[i];
			System.out.println("v"+graph.vertexs[v]+"的入度为："+graph.getInDegree(graph.vertexs[v]));
		}
		
		System.out.println("  "+graph.getWeight(graph.vertexs[1], graph.vertexs[2]));
		
		graph.addVertex(5);
		for (int i = 0; i < graph.vertexs.length; i++) {
			int v = graph.vertexs[i];
			System.out.println(graph.vertexs[v]);
		}
		
		graph.print();
		
	}
}
