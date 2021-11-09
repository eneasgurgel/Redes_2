import java.util.*;

public class Main {
	
	

	public static void main(String[] args) {
		
		Grafo grafo = new Grafo(7);
		
		// [0,1,2,3,4,5,6]
		// [A,B,C,D,E,F,G]

		grafo.addAresta(0, 1, 7);
		grafo.addAresta(0, 3, 5);
		
		grafo.addAresta(1, 2, 8);
		grafo.addAresta(1, 3, 9);
		grafo.addAresta(1, 4, 7);

		grafo.addAresta(2, 4, 5);

		grafo.addAresta(3, 4, 15);
		grafo.addAresta(3, 5, 6);
		
		grafo.addAresta(4, 5, 8);
		grafo.addAresta(4, 6, 9);
		
		grafo.addAresta(5, 6, 11);

		int origem = 0;
		Dijkstra dijkstra = new Dijkstra(grafo, origem);
		
		List<Integer> vertices = grafo.getVertices();
		for (Integer v : vertices) {
			Collection<Integer> path = dijkstra.pathTo(v);
			dijkstra.traduzir(path);
		}
		
		for (int i = 0; i < dijkstra.getCaminho().size(); i++) {
			System.out.println(dijkstra.getCaminho().get(i));
		}
		
		
	}

}
