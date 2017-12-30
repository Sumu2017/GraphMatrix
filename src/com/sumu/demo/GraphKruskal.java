package com.sumu.demo;

/**
 * ��³˹�����㷨
 * 
 * @author sumu
 *
 */
public class GraphKruskal {
	public class Edge {
		private int begin;// ��ʼ����
		private int end;// ��������
		private int weight;// ������֮���Ȩֵ

		public Edge(int begin, int end, int weight) {
			super();
			this.begin = begin;
			this.end = end;
			this.weight = weight;
		}

		public int getBegin() {
			return begin;
		}

		public void setBegin(int begin) {
			this.begin = begin;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

	}

	private int vertexSize;// ��������
	private Edge[] edges;//	Ȩֵ����

	public GraphKruskal(int vertexSize) {
		// TODO Auto-generated constructor stub
		this.vertexSize = vertexSize;
		edges = new Edge[vertexSize];
	}

	public void createGraphKrusKalArray() {
		//��³˹�����㷨��ǰ����Ҫ��Ȩֵ��С��������
		Edge edge0 = new Edge(4, 7, 7);
		Edge edge1 = new Edge(2, 8, 8);
		Edge edge2 = new Edge(0, 1, 10);
		Edge edge3 = new Edge(0, 5, 11);
		Edge edge4 = new Edge(1, 8, 12);
		Edge edge5 = new Edge(3, 7, 16);
		Edge edge6 = new Edge(1, 6, 16);
		Edge edge7 = new Edge(5, 6, 17);
		Edge edge8 = new Edge(1, 2, 18);
		Edge edge9 = new Edge(6, 7, 19);
		Edge edge10 = new Edge(3, 4, 20);
		Edge edge11 = new Edge(3, 8, 21);
		Edge edge12 = new Edge(2, 3, 22);
		Edge edge13 = new Edge(3, 6, 24);
		Edge edge14 = new Edge(4, 5, 26);
		edges[0]=edge0;
		edges[1]=edge1;
		edges[2]=edge2;
		edges[3]=edge3;
		edges[4]=edge4;
		edges[5]=edge5;
		edges[6]=edge6;
		edges[7]=edge7;
		edges[8]=edge8;
		edges[9]=edge9;
		edges[10]=edge10;
		edges[11]=edge11;
		edges[12]=edge12;
		edges[13]=edge13;
		edges[14]=edge14;
	}
	
	/**
	 * ��³˹�����㷨 ��С������(���Ա�ΪĿ��ȥ����,����ʱҪ�����Ƿ���γɻ�·)
	 */
	public void miniSpanTreeKruskal() {
		int[] parent=new int[vertexSize];//�������飬�±�Ϊ��㣬ֵΪ�յ�
		int m,n,sum=0;
		for (int i = 0; i < vertexSize; i++) {
			//��ʼ����������
			parent[i]=0;
		}
		for (int i = 0; i < vertexSize; i++) {
			Edge edge = edges[i];
			m=find(parent,edge.begin);
			n=find(parent, edge.end);
			if (m!=n) {//m,n���ȣ���˵�������γɻ�·
				parent[m]=n;
				System.out.println("��³˹���� ����:"+edge.begin+" �յ�:"+edge.end+" Ȩֵ:"+edge.weight);
				sum+=edge.weight;
			}
		}
		System.out.println("��³˹����  ��С������:"+sum);
	}
    /**
     * �������߶����β���±�,��ȡ�ǻػ���ֵ
     * @param parent
     * @param vertex
     * @return
     */
	private int find(int[] parent, int vertex) {
		// TODO Auto-generated method stub
		while (parent[vertex]>0) {
			vertex=parent[vertex];
		}
		return vertex;
	}

	public static void main(String[] args) {
		GraphKruskal graphKruskal=new GraphKruskal(15);
		graphKruskal.createGraphKrusKalArray();
		graphKruskal.miniSpanTreeKruskal();
	}
}
