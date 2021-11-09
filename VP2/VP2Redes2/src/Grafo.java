import java.util.*;

public class Grafo {
	public static final int INFINITY = Integer.MAX_VALUE / 2;
	protected int[][] adjacents;
	protected int qtdArestas;
	protected int qtdVertices;
	
	public Grafo(int qtdVertices) {
		
		this.qtdVertices = qtdVertices;
		this.adjacents = new int[qtdVertices][qtdVertices];
		
		for (int i = 0; i < adjacents.length; i++) {
			for (int j = 0; j < adjacents.length; j++) {
				if (i == j) {
					adjacents[i][j] = 0; 
				} else {
					adjacents[i][j] = INFINITY; 
					adjacents[j][i] = INFINITY; 
				}
			}
		}
		
	}
	
	public void addAresta(int v, int w, int custo) {
		
		adjacents[v][w] = custo;
		adjacents[w][v] = custo;
		
		qtdArestas++;
		
	}
	
	public List<Integer> getPredecessors(int v) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = 0; i < adjacents.length; i++) {
			if (adjacents[v][i] != INFINITY) {
				result.add(i);
			}
		}
	
		return result;
	}
	
	public List<Integer> getAdjacentes(int v) {
	
		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = 0; i < adjacents.length; i++) {
			if (adjacents[v][i] != INFINITY) {
				result.add(i);
			}
		}
	
		return result;
		
	}
	
	public int getCusto(int v, int w) {
		return adjacents[v][w];
	}

	public int getQtdArestas() {
		return qtdArestas;
	}

	public int getQtdVertices() {
		return qtdVertices;
	}
	
	public List<Integer> getVertices() {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < getQtdVertices(); i++) {
			result.add(i);
		}

		return result;
	}

	
	
}