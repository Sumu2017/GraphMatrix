package com.sumu.demo;

import java.util.LinkedList;

public class Graph {
	private int vertexSize;// ���������
	private int[] vertexs;// ��������
	private int[][] matrix;
	private static final int MAX_WEIGHT = 1000;
	private static final String Integer = null;
	private boolean[] isVisited;

	public Graph(int vertexSize) {
		// TODO Auto-generated constructor stub
		this.vertexSize = vertexSize;
		matrix = new int[vertexSize][vertexSize];
		isVisited = new boolean[vertexSize];
	}

	/**
	 * ��ȱ�������
	 */
	public void broadFirstSearch() {
		isVisited = new boolean[vertexSize];
		for (int i = 0; i < vertexs.length; i++) {
			if (!isVisited[i]) {
				broadFirstSearch(i);
			}
		}
	}

	/**
	 * ��ȱ�������
	 * @param i
	 */
	private void broadFirstSearch(int index) {
		// TODO Auto-generated method stub
		int queueIndex,neighborIndex;
		System.out.println("broadFirstSearch �������ˣ�" + vertexs[index]);
		isVisited[index]=true;
		LinkedList<Integer> queue=new LinkedList<>();
		queue.add(index);
		while (!queue.isEmpty()) {
			queueIndex = queue.removeFirst().intValue();
			neighborIndex = getFirstNeighbor(queueIndex);
			while (neighborIndex!=-1) {
				if (!isVisited[neighborIndex]) {
					System.out.println("broadFirstSearch �������ˣ�" + vertexs[neighborIndex]);
					isVisited[neighborIndex]=true;
					queue.add(neighborIndex);
				}
				neighborIndex = getNextNeighbor(queueIndex, neighborIndex);
			}
		}
	}

	/**
	 * ��ȱ�������
	 */
	public void depthFirstSearch() {
		isVisited = new boolean[vertexSize];
		for (int i = 0; i < vertexs.length; i++) {
			if (!isVisited[i]) {
				System.out.println("depthFirstSearch �������ˣ�" + vertexs[i]);
				depthFirstSearch(i);
			}
		}
	}

	/**
	 * ͼ��������ȱ���
	 * 
	 * @param index
	 *            ����һ�����㿪ʼ
	 */
	private void depthFirstSearch(int index) {
		// TODO Auto-generated method stub
		isVisited[index] = true;
		int neighborIndex = getFirstNeighbor(index);
		while (neighborIndex != -1) {
			if (!isVisited[neighborIndex]) {
				System.out.println("depthFirstSearch �������ˣ�" + neighborIndex);
				depthFirstSearch(neighborIndex);
			}
			neighborIndex = getNextNeighbor(index, neighborIndex);
		}
	}

	/**
	 * ����ǰһ���ڽӵ���±���ȡ����һ���ڽӵ�
	 * 
	 * @param index  
	 *            ����
	 * @param neighborIndex
	 *            �ڽӵ��±� ����ڸ��ڽӵ�ȥ��ȡ��һ���ڽӵ�
	 * @return
	 */
	private int getNextNeighbor(int index, int neighborIndex) {
		// TODO Auto-generated method stub
		for (int i = neighborIndex + 1; i < vertexSize; i++) {
			int weight = matrix[index][i];
			if (weight > 0 && weight < MAX_WEIGHT) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * ��ȡĳ������ĵ�һ���ڽӵ�
	 * 
	 * @param vertex
	 */
	private int getFirstNeighbor(int index) {
		// TODO Auto-generated method stub
		for (int i = 0; i < vertexSize; i++) {
			int weight = matrix[index][i];
			if (weight > 0 && weight < MAX_WEIGHT) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * ��ȡĳ������ĳ���(���򿴾���)
	 * 
	 * @return
	 */
	public int getOutDegree(int vertex) {
		int degree = 0;
		for (int i = 0; i < matrix[vertex].length; i++) {
			int j = matrix[vertex][i];
			if (j != 0 && j != MAX_WEIGHT) {
				degree++;
			}
		}
		return degree;
	}

	/**
	 * ��ȡĳ����������(���򿴾���)
	 * 
	 * @return
	 */
	public int getInDegree(int vertex) {
		int degree = 0;
		for (int i = 0; i < matrix[vertex].length; i++) {
			int j = matrix[i][vertex];
			if (j != 0 && j != MAX_WEIGHT) {
				degree++;
			}
		}
		return degree;
	}

	/**
	 * ��ȡ��������֮���Ȩֵ
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public int getWeight(int v1, int v2) {
		int weight = matrix[v1][v2];
		if (weight == MAX_WEIGHT) {
			weight = -1;
		}
		return weight;
	}

	/**
	 * ����µĶ���
	 * 
	 * @param vertex
	 */
	public void addVertex(int vertex) {
		if (vertexs == null) {
			return;
		}
		vertexSize++;
		int[] oldVertexs = vertexs;
		vertexs = new int[vertexSize];
		for (int i = 0; i < oldVertexs.length; i++) {
			vertexs[i] = oldVertexs[i];
		}
		vertexs[vertexSize - 1] = vertex;

		int[][] oldMatrix = matrix;
		matrix = new int[vertexSize][vertexSize];
		for (int i = 0; i < oldMatrix.length; i++) {
			for (int j = 0; j < oldMatrix[i].length; j++) {
				matrix[i][j] = oldMatrix[i][j];
			}
		}
		for (int i = 0; i < matrix.length - 1; i++) {
			matrix[matrix.length - 1][i] = MAX_WEIGHT;
			matrix[i][matrix.length - 1] = MAX_WEIGHT;
		}

	}

	/**
	 * ��ӡ����Ȩ�ڽӾ���
	 */
	public void print() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
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
		int[] vertexs = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		Graph graph = new Graph(vertexs.length);
		int[] a0 = new int[] { 0, 10, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT };
		int[] a1 = new int[] { 10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12 };
		int[] a2 = new int[] { MAX_WEIGHT, 18, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 8 };
		int[] a3 = new int[] { MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, 24, 16, 21 };
		int[] a4 = new int[] { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT };
		int[] a5 = new int[] { 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT };
		int[] a6 = new int[] { MAX_WEIGHT, 16, MAX_WEIGHT, 24, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT };
		int[] a7 = new int[] { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT };
		int[] a8 = new int[] { MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0 };

		graph.setVertexs(vertexs);
		graph.matrix[vertexs[0]] = a0;
		graph.matrix[vertexs[1]] = a1;
		graph.matrix[vertexs[2]] = a2;
		graph.matrix[vertexs[3]] = a3;
		graph.matrix[vertexs[4]] = a4;
		graph.matrix[vertexs[5]] = a5;
		graph.matrix[vertexs[6]] = a6;
		graph.matrix[vertexs[7]] = a7;
		graph.matrix[vertexs[8]] = a8;

		for (int i = 0; i < graph.vertexs.length; i++) {
			int v = graph.vertexs[i];
			System.out.println("v" + graph.vertexs[v] + "�ĳ���Ϊ��" + graph.getOutDegree(graph.vertexs[v]));
		}
		System.out.println("");
		for (int i = 0; i < graph.vertexs.length; i++) {
			int v = graph.vertexs[i];
			System.out.println("v" + graph.vertexs[v] + "�����Ϊ��" + graph.getInDegree(graph.vertexs[v]));
		}

		// System.out.println(" "+graph.getWeight(graph.vertexs[1], graph.vertexs[2]));

		// graph.print();
		//graph.depthFirstSearch();
		graph.broadFirstSearch();

	}
}
