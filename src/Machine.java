import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Machine {
	
	
	public static void main(String[] args) {
		
		int counter = 0;
		String word;
		String initialState = "";
		String finalState = "";
		String currentState = "";
		Transitions currentTransition = null;
		
		List<Transitions> transitionList = new ArrayList<Transitions>();
		List<String> banda = new ArrayList<String>();
		
		System.out.print("Se verifica cuvantul: ");
		
		Scanner read = null;
		try {
			read = new Scanner (new File("file.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		read.useDelimiter(" ");
		System.out.println(word=read.nextLine());
		
		String cuv[]=word.split("");
		for(int i =0;i<cuv.length;i++){
			banda.add(cuv[i]);
		}
		System.out.print("Avem starea initiala: ");
		System.out.println(initialState=read.nextLine());
		System.out.print("Avem starea finala: ");
		System.out.println(finalState=read.nextLine());
		System.out.println("Avem lista de tranzitii:");
		while(read.hasNext()){
			String linie =read.nextLine();
			String[] detalii = linie.split(" ");
			System.out.println(detalii[0]+" "+detalii[1]+" "+detalii[2]+" "+detalii[3]+" "+detalii[4]);
			transitionList.add(new Transitions(detalii[0],detalii[1],detalii[2],detalii[3],detalii[4]));
		}
		read.close();
		
		System.out.println("");

		boolean state = true;
		currentState=initialState;
		while(counter>=0 && !(currentState.equals(finalState)) && state) {
			state = false;
			System.out.print("             ");
			for(int i =0;i<counter;i++) {
				System.out.print(" ");
			}
			System.out.println("▼");
			for(Transitions x:transitionList) {
				if(x.getFromState().equals(currentState) && x.getReadValue().equals(banda.get(counter))) {
					currentTransition=x;
					state = true;
					break;
				}
				else {
					state = false;
				}
			}
			
			if(state) {
				banda.set(counter, currentTransition.getWriteValue());
				
				if(currentTransition.getMove().equals("R"))
					counter++;
				else if(currentTransition.getMove().equals("L"))
					counter--;
				
				currentState=currentTransition.getTo();
				
				System.out.print(currentTransition.getFromState() + " " + currentTransition.getReadValue() + currentTransition.getWriteValue() +currentTransition.getMove() +" "+ currentTransition.getTo() + " = ");
				System.out.print(" ");
				for(String z:banda) {
					System.out.print(z);
				}
				System.out.println("");
			}
		}
		
		if(currentState.equals(finalState)) {
			System.out.println("Cuvantul este valid");
		}
		else {
			System.out.println("Cuvantul nu este valid");
		}
	}
}