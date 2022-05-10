import java.util.Scanner;

public class Analizzatore {

	private String[] token;
	
	public Analizzatore(String inputUser, int numberOfLetters) throws InputUserNotValid {

		token = inputUser.split(" ");
		
		if(token.length <= 2) {
			if(token[0].equals("/nuova")) {
				
				if(token.length == 2) {
					
					if(numberOfLetters == token[1].length()) {
						token[1] = token[1].toLowerCase();
						
						for (int i = 0; i < token[1].length(); i++) {
							if(!(token[1].charAt(i) >= 'a' && token[1].charAt(i) <= 'z')) {
								throw new InputUserNotValid("La parola inserita contiene caratteri speciali / valori numerici");
							}
						}
						
						//setSecretWord(token[1]);
						System.out.println("Parola segreta inserita: " + token[1]);
					} else {
						  if(token[1].length() > numberOfLetters) {
								throw new InputUserNotValid("Lunghezza della nuova parola troppo lunga. Numero di caratteri consentiti : " + numberOfLetters);

						  } else {
								throw new InputUserNotValid("Lunghezza della nuova parola troppo corta. Numero di caratteri consentiti : " + numberOfLetters);
						  }
					}
					
				} else {
					throw new InputUserNotValid("Inserire la parola da impostare come segreta");
				}
				
			} else if (token[0].equals("/mostra")) {
				
				//getSecretWord();
				System.out.println("Richiesta get parola segreta");
			} else if (token[0].equals("/help") || token[0].equals("--help") || token[0].equals("-h")) {
				//help();
				System.out.println("Richiesta comando help");
			} else if (token[0].equals("/gioca")) {
				//play();
				System.out.println("Richiesta comando play");
			} else if (token[0].equals("/abbandona")) {
				
				Scanner scanner = new Scanner(System.in);
				String disclaimer;
				
				do {			
					System.out.println("Sei sicuro di voler uscire? [Y / n] ");
					disclaimer = scanner.nextLine();
				} while (!(disclaimer.equals("Y") || disclaimer.equals("n")));
				
				scanner.close();
				
				if(disclaimer.equals("Y")) {
					System.out.println("Partita abbandonata...");
				}
				
				//quit();
				System.out.println("Richiesta comando abbandona");
			} else if (token[0].equals("/esci")) {
				
				Scanner scanner = new Scanner(System.in);
				String disclaimer;
				
				do {			
					System.out.println("Sei sicuro di voler uscire? [Y / n] ");
					disclaimer = scanner.nextLine();
				} while (!(disclaimer.equals("Y") || disclaimer.equals("n")));
				
				scanner.close();
				
				if(disclaimer.equals("Y")) {
					System.out.println("Uscita in corso...");
					System.exit(0);
				}
				
				
			} else {
				char checkInvalidCommand = token[0].charAt(0);
				
				if(checkInvalidCommand != '/') {
					
					if(token.length > 1) 
						throw new InputUserNotValid("Input non valido");
					
					if(numberOfLetters == token[0].length()) {
						token[0] = token[0].toLowerCase();
						
						for (int i = 0; i < token[0].length(); i++) {
							if(!(token[0].charAt(i) >= 'a' && token[0].charAt(i) <= 'z')) {
								throw new InputUserNotValid("La parola inserita contiene caratteri speciali / valori numerici");
							}
						}
						
						//setSecretWord(token[1]);
						System.out.println("Parola tentativo inserita: " + token[0]);
					} else {
						  if(token[0].length() > numberOfLetters) {
								throw new InputUserNotValid("Lunghezza della nuova parola troppo lunga. Numero di caratteri consentiti : " + numberOfLetters);

						  } else {
								throw new InputUserNotValid("Lunghezza della nuova parola troppo corta. Numero di caratteri consentiti : " + numberOfLetters);
						  }
					}
					
					//analisi di token[0]
				} else throw new InputUserNotValid("Comando non corretto - digita /help, --help, -h per ottenere informazioni sui comandi");
			}
		} else {
			//generazione eccezione
			throw new InputUserNotValid("Numero di parole non consentito");
		}
		
	}
	
	

	public static void main(String[] args) {

		String inputUser = new String("asdaa asdas");

		try {
			new Analizzatore(inputUser, 5);
		} catch (InputUserNotValid e) {
			System.out.println("Generazione eccezione: " + e.getMessage());
		}
	}

}

class InputUserNotValid extends Exception {
	InputUserNotValid() {}
	
	InputUserNotValid(String msg) {
		super(msg);
	}
}
