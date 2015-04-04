import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class BuscaLargura {

	private Map<Character, Set<Character>> listaAdjacencia;
	private List<Character> resultado;
	private List<Character> fila;
	private List<Character> listaAtual;
	private Character raiz;
	private Character estadoFinal;
	private boolean achouResultado;
	
	
	public BuscaLargura(ListaAdjacencia grafo, Character raiz, Character estadoFinal){
		
		listaAdjacencia = grafo.getListaAdjacencia();
		resultado = new LinkedList<Character>();
		fila = new LinkedList<Character>();
		listaAtual = new LinkedList<Character>();
		this.raiz =raiz;
		this.estadoFinal = estadoFinal;
		
		buscar();
		
	}
	
	
	private void buscar(){
		
		resultado.add(raiz);
		
		if(raiz == estadoFinal){
			
			achouResultado = true;
			listaAtual.clear();
			
		}else
			listaAtual.addAll(listaAdjacencia.get(raiz));
			
		while(!listaAtual.isEmpty()){
			
			for(Character c: listaAtual){
				
				if(!resultado.contains(c)){
					
					resultado.add(c);
					fila.add(c);
					mostrarResultadoParcial();

					if(c == estadoFinal){
						
						listaAtual.clear();
						fila.clear();
						achouResultado = true;
						break;
						
					}
					
				}
				
			}
			
			listaAtual.clear();

			if(!fila.isEmpty()){
				
				listaAtual.addAll(listaAdjacencia.get(fila.get(0)));
				fila.remove(0);
				mostrarResultadoParcial();
				
			}
			
		}
		
		if(achouResultado){
		
			System.out.print("Resultado Final: ");
			for(Character c: resultado)
				System.out.print(c+" ");
			
			System.out.println();
		
		}else
			System.out.println("Resultado não encontrado.");
		
	}
	
	
	private void mostrarResultadoParcial(){
		
		System.out.print("Fila: ");
		
		for(Character c: fila)
			System.out.print(c+" ");
		
		System.out.println();
		System.out.print("Resultado Parcial: ");

		for(Character c: resultado)
			System.out.print(c+" ");
		
		System.out.println("\n");
		
	}
	
	
}