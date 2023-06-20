import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class handles the questions of the game
 * @see Main
 *
 */
public class Questions {

	private ArrayList<String> question = new ArrayList<String>(); 
	private ArrayList<String> choiceA = new ArrayList<String>(); 
	private ArrayList<String> choiceB = new ArrayList<String>(); 
	private ArrayList<String> choiceC = new ArrayList<String>(); 
	private ArrayList<String> choiceD = new ArrayList<String>(); 
	private ArrayList<Integer> takenNumbers = new ArrayList<Integer>(); 
	
	private int random = 0;		//current question number in excel
	
	/**
	 * This constructor takes the questions and choices from the excel sheet and
	 * Stores the question and choices to ArrayLists.
	 */
	public Questions() {
		
		try {
			FileInputStream file = new FileInputStream(new File("Questions/CS123_Questions.xlsx"));
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			for(int i = 1; i < 186; i++) {
				Row row = sheet.getRow(i);
				question.add(row.getCell(2).getStringCellValue());
				choiceA.add(row.getCell(3).getStringCellValue());
				choiceB.add(row.getCell(4).getStringCellValue());
				choiceC.add(row.getCell(5).getStringCellValue());
				choiceD.add(row.getCell(6).getStringCellValue());
			} 
		}catch (Exception e) {
			System.out.println("error in excel reading");
		}
		
		takenNumbers.add(200); // just add trash number above 185 so takenNumbers is not null when used.
	}
	
	//gives a random question depending of the stage number
	/**
	 * Takes a random question from the question ArrayList.
	 * @param stageNumber The current stage number of the game.
	 * @return the random question taken from the question ArrayList.
	 */
	public String getQuestion(int stageNumber) {
		
		boolean isTaken = true;
		
		while(isTaken) {
			if(stageNumber == 1) {
				random = (int)Math.floor(Math.random() * 30);			//Graphs Theory: A Review
			}else if(stageNumber == 2) {
				random = (int)Math.floor(Math.random() * (30) + 30);	//Algorithmic Design Paradigms
			}else if(stageNumber == 3) {
				random = (int)Math.floor(Math.random() * (35) + 60);	//Metaheuristic Algorithms 
			}else if(stageNumber == 4) {
				random = (int)Math.floor(Math.random() * (30) + 95);	//Intractability
			}else if(stageNumber == 5) {
				random = (int)Math.floor(Math.random() * (30) + 125);	//Sorting Algorithms
			}else if(stageNumber == 6) {
				random = (int)Math.floor(Math.random() * (30) + 155);	//Searching Algorithms
			}
			
			for(int num : takenNumbers) {
				if(num == random) {
					isTaken = true;
					break;
				}
				isTaken = false;
			}
		}
		
		takenNumbers.add(random);
		
		return question.get(random);	
	}
	
	//gives the choices of the current question
	/**
	 * Takes the choices of the current question and stores it into an ArrayList.
	 * @return The ArrayList of choices.
	 */
	public ArrayList<String> getChoices() {
		
		ArrayList<String> choices = new ArrayList<String>(); 
		
		choices.add(choiceA.get(random));
		choices.add(choiceB.get(random));
		choices.add(choiceC.get(random));
		choices.add(choiceD.get(random));
		
		return choices;
	}

}
