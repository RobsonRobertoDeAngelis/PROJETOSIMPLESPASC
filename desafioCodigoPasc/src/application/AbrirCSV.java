package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ListaDeProdutos.Produtos;


public class AbrirCSV {

	public static void main(String[] args) {

       String path = "C:\\Rba\\teste.csv";
		
		List<Produtos> list = new ArrayList<Produtos>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				
				String[] vect = line.split(",");
				String nam = vect[0];
				Double vlr = Double.parseDouble(vect[1]);
				Integer qte = Integer.parseInt(vect[2]);
				
				Produtos prod = new Produtos(nam, vlr, qte);
				list.add(prod);
				
				line = br.readLine();
			}	
			
			System.out.println("PROXIMA COMPRA:");
			for (Produtos p : list) {
				System.out.println(p);
			}
		}
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
