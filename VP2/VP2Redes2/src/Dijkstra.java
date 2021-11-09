import java.util.*;

public class Dijkstra {
	private int edgeTo[];
	private int distTo[];
	private int origem;
	private List<String> caminho;
	
	public Dijkstra(Grafo grafo, int origem) {
		caminho =  new ArrayList<String>();
		this.origem = origem;
		edgeTo = new int[grafo.getQtdVertices()];
		distTo = new int[grafo.getQtdVertices()];
		
		for (int i = 0; i < distTo.length; i++) {
			distTo[i] = Grafo.INFINITY;
			edgeTo[i] = 0;
		}
		distTo[origem] = 0;
		edgeTo[origem] = 0;
		
		execute(grafo, origem);
	}
	
	private void execute(Grafo grafo, int s) {
		List<Integer> open = grafo.getVertices();
		List<Integer> closed = new ArrayList<Integer>();
		
		while (!open.isEmpty()) {
			Collections.sort(open, new Comparator<Integer>() {
				@Override
				public int compare(Integer v1, Integer v2) {
					return distTo[v1] - distTo[v2];
				}
			});
			
			Integer v = open.get(0);
			closed.add(v);
			open.remove(v);
			
			List<Integer> adj = grafo.getAdjacentes(v);
			for(Integer w :  adj) {
				if (!closed.contains(w)) {
					if (distTo[v] + grafo.getCusto(v, w) < distTo[w]) {
						distTo[w] = distTo[v] + grafo.getCusto(v, w);
						edgeTo[w] = v;
					}
				}
			}
		}
		
	}
	
	public Collection<Integer> pathTo(int v) {
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x != origem; x = edgeTo[x]) {
			path.push(x);
		}
		
		path.push(origem);
		
		return path;
	}
	
	public List<Character> traduzir(Collection<Integer> path) {
		List<Character> result =  new ArrayList<Character>();
		char[] alfabeto = {'A','B','C','D','E','F','G'};
		for (int n : path) {
			result.add(alfabeto[n]);
		}
		
		MontaCaminho(result);
		return result;
		
	}
	
	public void MontaCaminho(List<Character> result) {
		String enlace = null;
		if (result.size() > 1) {
			for(int i = 0; i < result.size()-1; i++) {
				enlace = Character.toString(result.get(i+1)) + '-' + Character.toString(result.get(i));
				if (enlace != null && !caminho.contains(enlace)) {
					caminho.add(enlace);
				}
				
			}
		}
		
	}
	

	public List<String> getCaminho() {
		return caminho;
	}

}

