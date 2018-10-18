package myPackage;

import java.util.Scanner;

public class MoyenneNotes {

	public static Double lireNote(String saisie)
	{
		double note = 0.00;
		
		try
		{
			// transforme la chaine de caractere en (int)eger
			note = Double.parseDouble(saisie);
			
			if (note >= 0 && note <= 20)
			{
				return note;
			}
			else
			{
				System.out.println("Saisir une note entre 0 et 20");
				return -1.00;
			}// end if
			
		}// end try
		
		catch (NumberFormatException e)
		{
			System.out.println("Veuillez saisir un nombre");
			return -1.00;
		}// end catch
	}// end method lireNote
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrer une note entre 0 et 20 ou le mot fini : ");

		String saisie = null;
		Double statusNumber = 0.00;
		int nbNote = 0;
		double somme = 0;
		double moyenne = 0;
		boolean end = false;
		
		while (!end)
		{
			// tant que la saisie n'est pas egale a "fini"
			// et bien boucler sur le bloc d'instructions
			//
			// ordres des instructions de la condition de sortie
			//     [4] [  2 ]   [     1     ]  [      3     ]
			while ( ! (saisie = sc.nextLine()).equals("fini"))
			{
				System.out.print("Entrer une note entre 0 et 20 ou le mot fini : ");
			
				statusNumber = lireNote(saisie);
				if (statusNumber != -1.00)
				{
					// equivalent a somme += statusNumber
					somme = somme + statusNumber;
					nbNote++;
				}// end if
			}// end while
		
			// gerer la division par 0
			if (nbNote != 0)
			{
				moyenne = (somme / nbNote);
				System.out.println("La moyenne des notes est de : " + moyenne);
				end = true;
			}
			else
			{
				System.out.println("Entrez au moins une note !!");
			}// end if
		}// end while
	}// end method main

}