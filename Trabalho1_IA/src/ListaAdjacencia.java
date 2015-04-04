import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**Esta classe implementa a estrutura de um grafo como uma lista de
 * adjacências. */
public class ListaAdjacencia {
	
	private Map<Character, Set<Character>> grafo;
	
	
	public ListaAdjacencia(Hashtable<Character, Set<Character>> grafo) {
		
		this.grafo = new Hashtable<Character, Set<Character>>(26);
		this.grafo.putAll(grafo);
		
	}
	
	
	
	
	
}
