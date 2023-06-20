import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * This class handles almost all the components of the game.
 * @see Main
 *
 */
public class Components {	//need to rename to components

	private ArrayList<Image> backgroundImages;
	private ArrayList<Label> numbers;
	private Label stageNumber;
	private Label characterIcon;
	private ArrayList<Button> dialogBox;
	private ArrayList<Background> background;
	private ArrayList<Button> buttons;
	
	/**
	 * This constructor initializes the components of the game
	 */
	public Components() {
		Color color_LIGHT_BLUE = new Color(.18, .3, .52, .4);				//light blue
		Color color_LIGHT_GREEN = new Color(.31, .49, .2, .5);				//light green
		Color color_GREEN = new Color(.31, .49, .2, 1);						//green
		Color color_DARK_GREEN = new Color(0, .81, .19, 1);					//dark green
		Color color_RED = new Color(.87, .13, 0, 1);						//red
		Color color_LIGHT_RED = new Color(.6, .3, .1, .5);					//light red
		
		// ------------------------------------------------------------------------------------------------------------------Background Images ---------------------------------------------------------------
		backgroundImages = new ArrayList<Image>();
		backgroundImages.add(new Image("file:images/BackgroundImage.jpg"));				//main background		0
		backgroundImages.add(new Image("file:images/HowToPlay1.jpg"));					//options background 1	1	
		backgroundImages.add(new Image("file:images/HowToPlay2.jpg"));					//options background 2	2	
		backgroundImages.add(new Image("file:images/HowToPlay3.jpg"));					//options background 3	3	
		backgroundImages.add(new Image("file:images/questionBackgroundImage.jpg"));		//gameplay background	4
		backgroundImages.add(new Image("file:images/settings.png"));					//settings icon			5
		backgroundImages.add(new Image("file:images/music.png"));						//music icon			6
		backgroundImages.add(new Image("file:images/character1.png"));					//character icon 1		7
		backgroundImages.add(new Image("file:images/character2.png"));					//character icon 2		8
		backgroundImages.add(new Image("file:images/character3.png"));					//character icon 3		9
		backgroundImages.add(new Image("file:images/character4.png"));					//character icon 4		10
		backgroundImages.add(new Image("file:images/character5.png"));					//character icon 5		11
		backgroundImages.add(new Image("file:images/character6.png"));					//character icon 6		12
		backgroundImages.add(new Image("file:images/character7.png"));					//character icon 7		13
		backgroundImages.add(new Image("file:images/dialogBox1.png"));					//dialog box 1			14
		backgroundImages.add(new Image("file:images/interviewBackground.jpg"));			//background 			15
		backgroundImages.add(new Image("file:images/winner.jpg"));						//win result image		16
		backgroundImages.add(new Image("file:images/loser.jpg"));						//loss result image		17
		backgroundImages.add(new Image("file:images/musicOff.png"));					//music off icon		18
		backgroundImages.add(new Image("file:images/fiftyfifty.png"));					//fiftyfifty icon		19
		backgroundImages.add(new Image("file:images/switch.png"));						//switch icon			20
		
		backgroundImages.add(new Image("file:images/interviewBackground1.jpg"));		//background1			21
		backgroundImages.add(new Image("file:images/interviewBackground2.jpg"));		//background2			22
		backgroundImages.add(new Image("file:images/interviewBackground3.jpg"));		//background3			23
		backgroundImages.add(new Image("file:images/interviewBackground4.jpg"));		//background4			24
		backgroundImages.add(new Image("file:images/interviewBackground5.jpg"));		//background5			25
		backgroundImages.add(new Image("file:images/interviewBackground6.jpg"));		//background6			26
		backgroundImages.add(new Image("file:images/interviewBackground7.jpg"));		//background7			27
		backgroundImages.add(new Image("file:images/interviewBackground8.jpg"));		//background8			28
		backgroundImages.add(new Image("file:images/interviewBackground9.jpg"));		//background9			29
		backgroundImages.add(new Image("file:images/interviewBackground10.jpg"));		//background10			30
		backgroundImages.add(new Image("file:images/interviewBackground11.jpg"));		//background11			31
		backgroundImages.add(new Image("file:images/interviewBackground12.jpg"));		//background12			32
		backgroundImages.add(new Image("file:images/interviewBackground13.jpg"));		//background13			33
		backgroundImages.add(new Image("file:images/interviewBackground14.jpg"));		//background14			34
		backgroundImages.add(new Image("file:images/interviewBackground15.jpg"));		//background15			35
		

		// ------------------------------------------------------------------------------------------------------------------Stage Number Label ---------------------------------------------------------------
		stageNumber = new Label("Stage 1: Graph Theory");
		stageNumber.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		stageNumber.setPrefSize(450, 75);
		stageNumber.setLayoutX(150);
		stageNumber.setTextFill(Color.WHITE);
			
		// ------------------------------------------------------------------------------------------------------------------Character Icon Label ---------------------------------------------------------------
		characterIcon = new Label();
		characterIcon.setPrefSize(150, 170);
		characterIcon.setLayoutX(10);
		characterIcon.setLayoutY(275);
		characterIcon.setBackground(new Background(new BackgroundImage(backgroundImages.get(8), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		
		// --------------------------------------------------------------------------------------------------------------------Dialog Box Label ---------------------------------------------------------------
		dialogBox = new ArrayList<Button>();
		
		Button dialogBox1 = new Button();
		
		dialogBox.add(dialogBox1);
		
		for(Button dialog : dialogBox) {
			dialog.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 10));
			dialog.setTextFill(Color.WHITE);
			dialog.setPrefSize(166, 100);
			dialog.setLayoutX(125);
			dialog.setLayoutY(225);
			dialog.setBackground(new Background(new BackgroundImage(backgroundImages.get(14), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		}
				
		// -------------------------------------------------------------------------------------------------------------------Number's Label ---------------------------------------------------------------
		numbers = new ArrayList<Label>();
		
		Label number1 = new Label("1");
		Label number2 = new Label("2");
		Label number3 = new Label("3");
		Label number4 = new Label("4");
		Label number5 = new Label("5");
		Label number6 = new Label("6");
		Label number7 = new Label("7");
		Label number8 = new Label("8");
		Label number9 = new Label("9");
		Label number10 = new Label("10");
		
		numbers.add(number1);
		numbers.add(number2);
		numbers.add(number3);
		numbers.add(number4);
		numbers.add(number5);
		numbers.add(number6);
		numbers.add(number7);
		numbers.add(number8);
		numbers.add(number9);
		numbers.add(number10);
		
		for(Label number : numbers) {
			number.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 10));
			number.setPrefSize(125, 20);
			number.setAlignment(Pos.BASELINE_CENTER);
			number.setTextFill(Color.WHITE);
			number.setBackground(new Background(new BackgroundFill(color_LIGHT_BLUE, new CornerRadii(4), Insets.EMPTY)));
		}
		
		// ------------------------------------------------------------------------------------------------------------------- Background ---------------------------------------------------------------
		background = new ArrayList<Background>();
			
		Background character1 = new Background(new BackgroundImage(backgroundImages.get(7), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
		Background character2 = new Background(new BackgroundImage(backgroundImages.get(8), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
		Background character3 = new Background(new BackgroundImage(backgroundImages.get(9), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
		Background character4 = new Background(new BackgroundImage(backgroundImages.get(10), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
		Background character5 = new Background(new BackgroundImage(backgroundImages.get(11), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
		Background character6 = new Background(new BackgroundImage(backgroundImages.get(12), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
		Background character7 = new Background(new BackgroundImage(backgroundImages.get(13), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
		
		background.add(character1);			//0
		background.add(character2);			//1
		background.add(character3);			//2
		background.add(character4);			//3
		background.add(character5);			//4
		background.add(character6);			//5
		background.add(character7);			//6
		
		Background color1 = new Background(new BackgroundFill(color_LIGHT_BLUE, new CornerRadii(4), Insets.EMPTY));
		Background color2 = new Background(new BackgroundFill(color_LIGHT_GREEN, new CornerRadii(4), Insets.EMPTY));
		Background color3 = new Background(new BackgroundFill(color_GREEN, new CornerRadii(4), Insets.EMPTY));
		Background color4 = new Background(new BackgroundFill(color_DARK_GREEN, new CornerRadii(4), Insets.EMPTY));
		Background color5 = new Background(new BackgroundFill(color_RED, new CornerRadii(4), Insets.EMPTY));
		Background color6 = new Background(new BackgroundFill(color_LIGHT_RED, new CornerRadii(4), Insets.EMPTY));
		
		background.add(color1);				//7
		background.add(color2);				//8
		background.add(color3);				//9
		background.add(color4);				//10
		background.add(color5);				//11
		background.add(color6);				//12
		
		// -------------------------------------------------------------------------------------------------------------------Buttons ----------------------------------------------------------------------------
		buttons = new ArrayList<Button>();
		
		Button playButton = new Button("Play");
		playButton.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 30));
		playButton.setBackground(null);
		playButton.setTextFill(Color.WHITE);
		
		Button optionsButton = new Button("Options");
		optionsButton.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 30));
		optionsButton.setBackground(null);
		optionsButton.setTextFill(Color.WHITE);
		
		Button quitButton = new Button("Quit");
		quitButton.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 30));
		quitButton.setBackground(null);
		quitButton.setTextFill(Color.WHITE);
		
		Button proceedButton = new Button("Proceed >");
		proceedButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		proceedButton.setBackground(null);
		proceedButton.setTextFill(Color.BLACK);
		proceedButton.setLayoutX(625);
		proceedButton.setLayoutY(375);
		
		Button nextButton = new Button("Next >");
		nextButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		nextButton.setBackground(null);
		nextButton.setTextFill(Color.WHITE);
		nextButton.setLayoutX(625);
		nextButton.setLayoutY(375);
		
		Button backButton = new Button("< Back");
		backButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		backButton.setBackground(null);
		backButton.setTextFill(Color.WHITE);
		backButton.setLayoutX(75);
		backButton.setLayoutY(375);
		
		Button backToGame = new Button("< Back to Game");
		backToGame.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		backToGame.setBackground(null);
		backToGame.setTextFill(Color.WHITE);
		backToGame.setLayoutY(375);
		
		Button musicButton = new Button("");
		musicButton.setPrefSize(44, 44);
		musicButton.setBackground(new Background(new BackgroundImage(backgroundImages.get(6), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));		
		musicButton.setLayoutX(725);
		musicButton.setLayoutY(20);
		
		Button backToMenu = new Button("< Back to Menu");
		backToMenu.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		backToMenu.setBackground(null);
		backToMenu.setTextFill(Color.WHITE);
		backToMenu.setLayoutY(375);
		
		Button settings = new Button();
		settings.setPrefSize(36, 36);
		settings.setBackground(new Background(new BackgroundImage(backgroundImages.get(5), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));		
		settings.setLayoutX(725);
		settings.setLayoutY(20);
		
		Button fiftyfifty;
		fiftyfifty = new Button("");
		fiftyfifty.setPrefSize(53, 36);
		fiftyfifty.setBackground(new Background(new BackgroundImage(backgroundImages.get(19), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		fiftyfifty.setLayoutX(615);
		fiftyfifty.setLayoutY(20);
		
		Button switchQuestion;
		switchQuestion = new Button("");
		switchQuestion.setPrefSize(36, 36);
		switchQuestion.setBackground(new Background(new BackgroundImage(backgroundImages.get(20), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		switchQuestion.setLayoutX(675);
		switchQuestion.setLayoutY(20);
		
		buttons.add(playButton);			//0
		buttons.add(optionsButton);			//1
		buttons.add(quitButton);			//2
		buttons.add(proceedButton);			//3
		buttons.add(nextButton);			//4
		buttons.add(backButton);			//5
		buttons.add(backToGame);			//6
		buttons.add(musicButton);			//7
		buttons.add(backToMenu);			//8
		buttons.add(settings);				//9
		buttons.add(fiftyfifty);			//10
		buttons.add(switchQuestion);		//11
		
	}

	/**
	 * Returns the background Images of the game.
	 * @return backgroundImagesList.
	 */
	public List<Image> getBackgroundImages(){
		return backgroundImages;
	}
	
	/**
	 * Returns the number labels of the game.
	 * @return number Label List.
	 */
	public List<Label> getNumbers(){
		return numbers;
	}
	
	/**
	 * Returns the stageNumber label used in the game.
	 * @return stageNumber Label.
	 */
	public Label getStage() {
		return stageNumber;
	}
	
	/**
	 * Returns the character Icon Label.
	 * @return character icon label.
	 */
	public Label getCharacterIcon() {
		return characterIcon;
	}
	
	/**
	 * Returns the backgrounds used in the game.
	 * @return backgrounds List.
	 */
	public List<Background> getBackground(){
		return background;
	}
	
	/**
	 * Returns the dialogs Button.
	 * @return dialogBox List.
	 */
	public List<Button> getDialogBox(){
		return dialogBox;
	}
	
	/**
	 * Returns the button used in the game.
	 * @return buttons List.
	 */
	public List<Button> getButtons(){
		return buttons;
	}
	
}
