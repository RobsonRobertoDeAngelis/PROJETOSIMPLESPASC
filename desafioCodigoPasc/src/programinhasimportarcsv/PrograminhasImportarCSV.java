package programinhasimportarcsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrograminhasImportarCSV {

	public static void main(String[] args) {
            
     
       File arquivoCSV = new File("C:\\Rba\\clientes.csv");
        
        try{
        	  Scanner leitor = new Scanner(arquivoCSV);
              
              String linhasDoArquivo = new String();
              
              leitor.nextLine();
              
              while(leitor.hasNext()){
                  
                  linhasDoArquivo = leitor.nextLine();
                  
                  String[] valoresEntreVirgulas = linhasDoArquivo.split(",");
                  
                  System.out.println(valoresEntreVirgulas[2]);
              }
                  
        }catch(FileNotFoundException e){
            
        }
        
	}
}	
	
