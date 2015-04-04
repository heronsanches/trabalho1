import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;


public class Main {
	
	private static ListaAdjacencia grafo;
	private final static String caminho = "/home/fedora/workspaces/workspace_graduation/trabalho1";
	private final static String nomeArquivo = caminho+"/Trabalho1_IA/src/espacoEstados.txt";
	private static Scanner entrada;

	
	public static void main(String[] args) {

		geraListaAdjacencia();
		new BuscaLargura(grafo, 'C', 'I');
		
	}
	

	private static void geraListaAdjacencia(){
		
		Hashtable<Character, Set<Character>> htGrafo = new Hashtable<Character, Set<Character>>(26);
		
		try {
			
			entrada = new Scanner(new File(nomeArquivo));
			String linha[];
			Set<Character> filhos;
			
			while(entrada.hasNextLine()){
				
				linha = entrada.nextLine().split("\t");
				filhos = new HashSet<Character>();
				
				//System.out.print("key: "+linha[0].toCharArray()[0]+"\n");
				
				for(int i=1; i < linha.length; i++){
					
					filhos.add(linha[i].toCharArray()[0]);
					//System.out.print(linha[i]);

				}
				
				//System.out.println();
				htGrafo.put(linha[0].toCharArray()[0], filhos);
				
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			entrada.close();
			System.exit(1);
			
		}	
		
		entrada.close();
		grafo = new ListaAdjacencia(htGrafo);
		
	}
	

}