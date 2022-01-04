package algo;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JEditorPane;


/**
 * 
 * @author mouri
 *
 */

public class main {

	public static void main(String[] args) {
		
		asking();
		play();
		pcHand();

	}


	public static void asking() {
		
		System.out.println("bonjour bienvenue dans ce jeu de Pierre-Papier-Ciseaux.");
		System.out.println("choissez 1 pour Pierre");
		System.out.println("choissez 2 pour Papier");
		System.out.println("choissez 3 pour Ciseaux");
		
	}
	public static void newAsking() {
		
		System.out.println("vous rejouez à nouveau, merci de choissir parms les possibilités suivante:");
		System.out.println("Tapez 1 pour Pierre");
		System.out.println("Tapez 2 pour Papier");
		System.out.println("Tapez 3 pour Ciseaux");
		
	}
	
	
	public static void play() {
		
		int number = Clavier.lireInt();
		
		
		if (number == 1|| number==2||number==3) {
			if (number==1) {
				
				System.out.println("vous avez choisi Pierre");
				
			}else if (number==2) {
				
				System.out.println("vous avez choisi Papier");
					
			}else {
				
				System.out.println("vous avez choisi Ciseaux");
				
			}
		}	else {
			System.err.println("vous n'avez pas saissi un choix valide, veuillez recommencer");
			play();
		}
		
		comparaison(number);	// me permet de faire passer le parametre number à ma méthode comparaisons plus bas
	}
	
	public static String pcHand() {	// main de l'ordi, au hazars
			String game[][] =  {
					{
					 "Pierre", "1"
					},
					{
					 "Papier", "2"
					},
					{
					 "Ciseaux", "3"
					}		
			};	
				Random random =new Random();
				int randomValue= random.nextInt(game.length); // je déclare une variable un i qui sera mon ref dans le tableau,
//				cette valeur déclarer 1 fois permet d'etre identitique partout.
			
			return game[randomValue][0] +"-"+ game[randomValue][1]; // je retourne papier - 2 ou Ciseau 3 pour traitement ensuite
			
		}


	public static void comparaison(int number) {// attention ne pas oublier le parametre
	
	
		String pcChoice = pcHand();	// je déclare ma variable qui reprend le tableau de choix du pc plus haut depuis le retourne
//		 je recupere papier-2 ou Cideaux-3...
		String[] nameValues = pcChoice.split ("-") ;// je sépare dans un nouveau tableau mes valeurs papier-2 pour n'avoir que papier d'un coté et 2 de l'autre.
		
		int  iPcChoice = Integer.parseInt(nameValues[1]); // je converti mon resultat en Int 
	
		
		
		if (number == iPcChoice) { // je lance ma logique 
			System.out.println("le Pc a choisi "+nameValues[0]);
			System.out.println("Vous avez fait égalité, veuillez rejouer");
			System.out.println("Tapez 1 pour Pierre");
			System.out.println("Tapez 2 pour Papier");
			System.out.println("Tapez 3 pour Ciseaux");
			play();
		} else {
			if(number==1 && iPcChoice==2){
				System.out.println("le Pc a choisi "+nameValues[0]);
				System.err.println("le Pc gagne, LOOSER! ");
				replay();
			} else if(number==1 && iPcChoice==3) {
				System.out.println("le Pc a choisi "+nameValues[0]);
				System.out.println("Vous gagnez, felicitation!");
				replay();
			} else if(number==2 && iPcChoice==3) {
				System.out.println("le Pc a choisi "+nameValues[0]);
				System.err.println("le Pc gagne, LOOSER!");
				replay();
			} else if(number==2 && iPcChoice==1) {
				System.out.println("le Pc a choisi "+nameValues[0]);
				System.out.println("Vous gagnez, felicitation!");
				replay();
			} else if(number==3 && iPcChoice==1) {
				System.out.println("le Pc a choisi "+nameValues[0]);
				System.err.println("le Pc gagne, LOOSER!");	
				replay();
			} else if(number==3 && iPcChoice==2) {
				System.out.println("le Pc a choisi "+nameValues[0]);
				System.out.println("Vous gagnez, felicitation!");
				replay();
			}
		}
		
	}

	public static void replay() {// je crée une method pour rejouer

		Scanner sc = new Scanner(System.in); // j'appelle le scanner 
		System.out.println("Souhaitez-vous rejouer? 1- oui / 0- non");
		 int yAndN = sc.nextInt(); //je lui passe la variable
	
		if (yAndN ==1) { //je fais ma logique
			newAsking();
			play();
		
		} else if (yAndN ==0) {
				System.out.println("ce fut un plaisir de jouer avec vous! ");
		} else {
			System.out.println("Veuillez saisis un choix valide");
			replay();
		}
		
		
		
		
	}

	
}
