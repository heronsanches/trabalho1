import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**Esta classe implementa a estrutura de um grafo como uma lista de
 * adjacências. */
public class ListaAdjacencia {
	
	private Map<Character, Set<Character>> listaAdjacencia;
	
	
	public ListaAdjacencia(Hashtable<Character, Set<Character>> grafo) {
		
		this.listaAdjacencia = new Hashtable<Character, Set<Character>>(26);
		this.listaAdjacencia.putAll(grafo);
		
	}
	
	
	public Map<Character, Set<Character>> getListaAdjacencia(){
		
		return listaAdjacencia;
		
	}
	
	
}
