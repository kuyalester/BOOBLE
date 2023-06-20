import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * A game variant of the are you smarter than a fifth grader game.
 * The main class of the game.
 * @authors Lester Lascano, Roy Donoz, EG Renz Go
 * @version 5.0
 */
public class Main extends Application{

	Stage window;
	
	Components components = new Components();
	Questions questions = new Questions();
	Music music = new Music();
	
	Group group = new Group();
	
	boolean musicIsOn = true;
	boolean isGame = false;
	boolean answerIsCorrect = true;
	int score = 0;
	int stageNumber = 1;
	int questionNumber = 0;
	int optionCounter = 1;
	int characterPageCounter = 1;
	int counter = 0;
	
	/**
	 * The menu window of the game.
	 * @return the menu group.
	 */
	public Group menu() {

		ImageView viewImage = new ImageView(components.getBackgroundImages().get(0));
		Button playButton = components.getButtons().get(0);
		Button optionsButton = components.getButtons().get(1);
		Button quitButton = components.getButtons().get(2);
		
		//Actions ------------------------------------------------------------------------------------
		playButton.setOnAction(e-> {
			music.playButtonClick();
			isGame = true;
			group.getChildren().setAll(characterPage());
		});
		optionsButton.setOnAction(e-> {
			music.playButtonClick();
			optionCounter = 1;
			group.getChildren().setAll(options());
		});
		quitButton.setOnAction(e-> {
			music.playButtonClick();;
			quit();
		});
		
		//Layout ------------------------------------------------------------------------------------
		VBox vbox = new VBox(0);
		vbox.setAlignment(Pos.TOP_CENTER);
		vbox.setPadding(new Insets(200, 0, 0, 325));
		vbox.getChildren().addAll(playButton, optionsButton, quitButton);
		
		Group menu = new Group();
		menu.getChildren().setAll(viewImage, vbox);
		
		return menu;
	}
	
	/**
	 * The playing window of the game.
	 * @return the play group.
	 */
	public Group play() {
		
		questionNumber++;
		
		ImageView background = new ImageView(components.getBackgroundImages().get(4));
		
		Label characterIcon = components.getCharacterIcon();
		Label stageNum = components.getStage();	
		List<Label> numbers = components.getNumbers();		
		
		Button dialogBox = components.getDialogBox().get(0);
		Button fiftyfifty = components.getButtons().get(10);
		Button switchQuestion = components.getButtons().get(11);
		
		numbers.get(questionNumber-1).setBackground(components.getBackground().get(9));
		
		dialogBox.setOnAction(e->{
			music.playButtonClick();
			nextQuestion(characterIcon, stageNum, numbers);
		});
		
		Button settings = components.getButtons().get(9);
		
		settings.setOnAction(e->{
			music.playButtonClick();
			optionCounter = 1;
			group.getChildren().setAll(options());
		});
		
		//Question
		Text question = new Text(questions.getQuestion(stageNumber));			
		question.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 15)); 
		question.setWrappingWidth(550);
		question.setTextAlignment(TextAlignment.JUSTIFY);
		question.setFill(Color.WHITE);
		question.setTranslateX(15);
		question.setTranslateY(15);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(question);
		scrollPane.setStyle("-fx-background: #132341 ; -fx-border-color: #132341; -fx-opacity: .9"); //132341
		scrollPane.setPrefSize(585, 190);
		
		//Choices
		String[] letterChoices = new String[] {"A", "B", "C", "D"};
		List<String> strChoices = new ArrayList<String>(questions.getChoices());
		List<Text> buttonChoices = new ArrayList<Text>();
		List<HBox> choices = new ArrayList<HBox>();
		List<ScrollPane> choicesScrollPane = new ArrayList<ScrollPane>();
		
		GridPane choiceGrid = new GridPane();
		choiceGrid.setHgap(30);
		choiceGrid.setVgap(15);
		choiceGrid.setLayoutX(175);
		choiceGrid.setLayoutY(285);
		
		//loop for creating the buttons for the choices then storing it on the Grid
		for(int i = 0, j = 0, k = 0; i < 4; i++) {
			Text choiceText = new Text();
			choiceText.setFont(Font.font(12));
			choiceText.setFill(Color.WHITE);
			choiceText.setTextAlignment(TextAlignment.JUSTIFY);
			choiceText.setWrappingWidth(220);
			choiceText.setTranslateX(7);
			choiceText.setTranslateY(7);
			buttonChoices.add(choiceText);
			
			ScrollPane choiceScrollPane = new ScrollPane();
			choiceScrollPane.setContent(choiceText);
			choiceScrollPane.setStyle("-fx-background: #132341 ; -fx-border-color: #132341; -fx-opacity: .9"); //132341
			choiceScrollPane.setPrefSize(240, 65);
			choicesScrollPane.add(choiceScrollPane);
			
			Button letter = new Button(letterChoices[i]);
			letter.setTextFill(Color.WHITE);
			letter.setPrefSize(40, 65);
			letter.setFont(Font.font(18));
			letter.setBackground(null);
			
			HBox choice = new HBox(letter, choiceScrollPane);
			choice.setBackground(components.getBackground().get(7));
			choices.add(choice);

			choiceScrollPane.setOnMouseClicked(e->{
				
				if(choiceText.getText().equals(strChoices.get(0))) {	// got correct answer	
					score ++;
					music.playCorrect();
					answerIsCorrect = true;
					choice.setBackground(components.getBackground().get(10));
					choiceScrollPane.setStyle("-fx-background: #008119 ; -fx-border-color: #008119; -fx-opacity: .8"); //008119
					dialogBox.setText("Great Job! \nClick me to go to next question\n\n.");	
					for(ScrollPane b : choicesScrollPane) {				
						b.setDisable(true);
					}
				}else {												//got wrong answer		
					music.playWrong();
					answerIsCorrect = false;
					choice.setBackground(components.getBackground().get(11));
					choiceScrollPane.setStyle("-fx-background: #871300 ; -fx-border-color: #871300; -fx-opacity: .8"); //871300
					dialogBox.setText("Nice Try \nClick me to go to next question\n\n.");
					
					for(ScrollPane b : choicesScrollPane) {
						if(b.getContent().equals(buttonChoices.get(0))) {
							b.setStyle("-fx-background: #008119 ; -fx-border-color: #008119; -fx-opacity: .8"); //008119
						}
						b.setDisable(true);
					}
				}
				group.getChildren().add(dialogBox);
			});
			
			if(i == 1){
				j = 0;
				k = 1;
			}else if(i == 2){
				j = 1;
				k = 0;
			}else if(i == 3){
				j = 1;
				k = 1;
			}
			choiceGrid.add(choice, j, k);
		}
		
		//shuffles the button for the choices on the Grid so we get a random order everytime
		Collections.shuffle(buttonChoices);			
		
		for(int i = 0; i < 4; i++){
			buttonChoices.get(i).setText(strChoices.get(i));
		}
		
		//Lifeline Actions
		fiftyfifty.setOnAction(e->{
			music.playButtonClick();
			for(ScrollPane btn : choicesScrollPane) {
				if(btn.getContent().equals(buttonChoices.get(2)) || btn.getContent().equals(buttonChoices.get(3))) {
					btn.setStyle("-fx-background: #132341 ; -fx-border-color: #132341; -fx-opacity: .2"); //132341
					btn.setDisable(true);
				}
			}
			fiftyfifty.setDisable(true);
		});
		
		switchQuestion.setOnAction(e->{
			music.playButtonClick();
			questionNumber--;
			nextQuestion(characterIcon, stageNum, numbers);
			switchQuestion.setDisable(true);
		});		
		
		
		//Layout -------------------------------------------------------------------------------------
		VBox numberBox = new VBox(5);
		numberBox.getChildren().addAll(numbers);
		numberBox.setPadding(new Insets(20, 35, 0, 15));
		
		VBox box1 = new VBox();
		box1.getChildren().addAll(numberBox);
		
		VBox box2 = new VBox();
		box2.getChildren().addAll(stageNum, scrollPane);
		
		HBox hbox = new HBox();
		hbox.getChildren().setAll(box1, box2);
		
		Group playScreen = new Group();
		playScreen.getChildren().setAll(background, characterIcon, hbox, settings, choiceGrid, switchQuestion, fiftyfifty);	
		
		return playScreen;
		
	}
	
	/**
	 * The option window of the game. 
	 * The how to play instructions is shown.
	 * @return the option group
	 */
	public Group options() {
		
		ImageView viewImage = new ImageView(components.getBackgroundImages().get(1));
		Button nextButton = components.getButtons().get(4);
		Button backButton = components.getButtons().get(5);
		Button backToGame = components.getButtons().get(6);
		Button musicButton = components.getButtons().get(7);
		Button backToMenu = components.getButtons().get(8);
	
		//Actions ------------------------------------------------------------------------------------
		nextButton.setOnAction(e-> {
			music.playButtonClick();
			optionCounter++;
			group.getChildren().setAll(options());
		});
		
		backButton.setOnAction(e->{
			music.playButtonClick();
			optionCounter--;
			group.getChildren().setAll(options());
		});
		
		backToGame.setOnAction(e->{
			music.playButtonClick();
			questionNumber--;
			group.getChildren().setAll(play());
		});
		
		backToMenu.setOnAction(e->{
			music.playButtonClick();
			group.getChildren().setAll(menu());
		});
		
		musicButton.setOnAction(e-> {
			music.toggleMusic();
			if(musicIsOn) {
				musicIsOn = false;
				musicButton.setBackground(new Background(new BackgroundImage(components.getBackgroundImages().get(18), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
			}else {
				musicIsOn = true;
				musicButton.setBackground(new Background(new BackgroundImage(components.getBackgroundImages().get(6), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
			}
		});
		
		//Layout -------------------------------------------------------------------------------------
		Group optionsScreen = new Group();
		if(optionCounter == 1) {
			backToMenu.setLayoutX(75);
			backToGame.setLayoutX(75);
			viewImage = new ImageView(components.getBackgroundImages().get(1));
			
			if(isGame) {
				optionsScreen.getChildren().setAll(viewImage, backToGame, nextButton, musicButton);
			}else {
				optionsScreen.getChildren().setAll(viewImage, backToMenu, nextButton, musicButton);
			}
		}else if(optionCounter == 3) {
			backToMenu.setLayoutX(550);
			backToGame.setLayoutX(550);
			viewImage = new ImageView(components.getBackgroundImages().get(3));
			
			if(isGame) {
				optionsScreen.getChildren().setAll(viewImage, backButton, backToGame, musicButton);
			}else {
				optionsScreen.getChildren().setAll(viewImage, backButton, backToMenu, musicButton);
			}
		}else {
			viewImage = new ImageView(components.getBackgroundImages().get(2));
			optionsScreen.getChildren().setAll(viewImage, backButton, nextButton, musicButton);
		}
		
		return optionsScreen;
	}
	
	/**
	 * Quits/Exits the game.
	 */
	public void quit() {
		music.playButtonClick();
		window.close();
	}
	
	/**
	 * The dialog window of the game, there are introductory dialogs in every level.
	 * Toggles between dialogs.
	 * @return the characterPage group.
	 */
	public Group characterPage() {
		
		ImageView viewImage = new ImageView(components.getBackgroundImages().get(15));
		Button button = components.getButtons().get(3);	
		Label characterIcon = components.getCharacterIcon();
		
		if(stageNumber == 1) {
			if(counter < 3) {
				characterPageCounter--;
				counter++;
				characterIcon.setBackground(components.getBackground().get(0));
				viewImage.setImage((components.getBackgroundImages().get(counter + 20)));
			}else {
				characterPageCounter++;
				characterIcon.setBackground(components.getBackground().get(1));
				viewImage.setImage((components.getBackgroundImages().get(24)));
			}
		}else if(stageNumber == 2) {
			if(characterPageCounter == 1) {
				characterIcon.setBackground(components.getBackground().get(0));
				viewImage.setImage((components.getBackgroundImages().get(26)));
			}else {
				characterIcon.setBackground(components.getBackground().get(2));
				viewImage.setImage((components.getBackgroundImages().get(27)));
			}
		}else if(stageNumber == 3) {
			if(characterPageCounter == 1) {
				characterIcon.setBackground(components.getBackground().get(0));
				viewImage.setImage((components.getBackgroundImages().get(28)));
			}else {
				characterIcon.setBackground(components.getBackground().get(3));
				viewImage.setImage((components.getBackgroundImages().get(29)));
			}
		}else if(stageNumber == 4) {
			if(characterPageCounter == 1) {
				characterIcon.setBackground(components.getBackground().get(0));
				viewImage.setImage((components.getBackgroundImages().get(30)));
			}else {
				characterIcon.setBackground(components.getBackground().get(4));
				viewImage.setImage((components.getBackgroundImages().get(31)));
			}
		}else if(stageNumber == 5) {
			if(characterPageCounter == 1) {
				characterIcon.setBackground(components.getBackground().get(0));
				viewImage.setImage((components.getBackgroundImages().get(32)));
			}else {
				characterIcon.setBackground(components.getBackground().get(5));
				viewImage.setImage((components.getBackgroundImages().get(33)));
			}
		}else {
			if(characterPageCounter == 1) {
				characterIcon.setBackground(components.getBackground().get(0));
				viewImage.setImage((components.getBackgroundImages().get(34)));
			}else {
				characterIcon.setBackground(components.getBackground().get(6));
				viewImage.setImage((components.getBackgroundImages().get(35)));
			}
		}
		
		button.setOnAction(e->{
			music.playButtonClick();
			if(characterPageCounter < 2) {
				characterPageCounter++;
				group.getChildren().setAll(characterPage());
			}else {
				group.getChildren().setAll(play());
			}
		});
		
		Group characterPage = new Group();
		characterPage.getChildren().setAll(viewImage, characterIcon, button);
		
		return characterPage;
	}
	
	/**
	 * Goes to the nextQuestion.
	 * @param characterIcon The character Icon of the current level.
	 * @param stageNum The current stageNumber.
	 * @param numbers The numbers in the left of the playing window which indicate the current number.
	 */
	public void nextQuestion(Label characterIcon, Label stageNum,  List<Label> numbers) {
		
		if(questionNumber != 0) {
			if(answerIsCorrect) {
				numbers.get(questionNumber-1).setBackground(components.getBackground().get(8));
			}else {
				numbers.get(questionNumber-1).setBackground(components.getBackground().get(12));
			}
		}
		
		if(questionNumber == 10) {
			stageNumber++;
			characterPageCounter = 1;
			
			for(Label nu : numbers) {
				nu.setBackground(components.getBackground().get(7));
			}
			
			if(stageNumber == 7) {
				result();
			}else if(stageNumber == 2) {
				stageNum.setText("Stage 2: Algorithmic Design Paradigm");
				characterIcon.setBackground(components.getBackground().get(2));
				questionNumber = 0;
				group.getChildren().setAll(characterPage());
			}else if(stageNumber == 3) {
				stageNum.setText("Stage 3: Metaheuristic Algorithms");
				characterIcon.setBackground(components.getBackground().get(3));
				questionNumber = 0;
				group.getChildren().setAll(characterPage());
			}else if(stageNumber == 4) {
				stageNum.setText("Stage 4: Intractability");
				characterIcon.setBackground(components.getBackground().get(4));
				questionNumber = 0;
				group.getChildren().setAll(characterPage());
			}else if(stageNumber == 5) {
				stageNum.setText("Stage 5: Sorting Algorithms");
				characterIcon.setBackground(components.getBackground().get(5));
				questionNumber = 0;
				group.getChildren().setAll(characterPage());
			}else {
				stageNum.setText("Stage 6: Searching Algorithms");
				characterIcon.setBackground(components.getBackground().get(6));
				questionNumber = 0;
				group.getChildren().setAll(characterPage());
			}
		}else {
			group.getChildren().setAll(play());
		}
	}
	
	/**
	 * shows the result of the game and
	 * Asks the player if he/she want to play again or quit the game.
	 */
	public void result() {
		
		isGame = false;
		stageNumber = 1;
		questionNumber = 0;
		counter = 0;
		
		components.getButtons().get(10).setDisable(false);
		components.getButtons().get(11).setDisable(false);
		
		ImageView viewImage = new ImageView();
		
		Button quitButton = new Button("Quit");
		quitButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		quitButton.setBackground(null);
		quitButton.setTextFill(Color.WHITE);
		quitButton.setLayoutX(75);
		quitButton.setLayoutY(375);	
		
		Button playAgainButton = new Button("Play Again");
		playAgainButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		playAgainButton.setBackground(null);
		playAgainButton.setTextFill(Color.WHITE);
		playAgainButton.setLayoutX(600);
		playAgainButton.setLayoutY(375);
		
		quitButton.setOnAction(e-> {
			music.playButtonClick();
			quit();
		});
		playAgainButton.setOnAction(e-> {
			music.playButtonClick();
			music.playBackgroundMusic();
			if(score > 35) {
				music.stopWin();
			}else {
				music.stopLose();
			}
			score = 0;
			group.getChildren().setAll(menu());
		});
		
		Label scoreText = new Label();
		scoreText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 50));
		scoreText.setLayoutX(250);
		scoreText.setLayoutY(150);
		scoreText.setTextFill(Color.WHITE);
		scoreText.setTextAlignment(TextAlignment.CENTER);
		
		if(score > 35) {
			music.stopBackgroundMusic();
			music.playWin();
			scoreText.setText("You're Hired\n" + score + "/60");
			viewImage.setImage(components.getBackgroundImages().get(16));
		}else {
			music.stopBackgroundMusic();
			music.playLose();
			scoreText.setText("Get Another Job\n" + score + "/60");
			viewImage.setImage(components.getBackgroundImages().get(17));
		}
		
		group.getChildren().setAll(viewImage, scoreText, quitButton, playAgainButton);
	}

	/**
	 * Creates the window and start the game by going to the menu window.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		window.setTitle("BOOBLE");
	
		music.playBackgroundMusic();

		group.getChildren().setAll(menu());
		
		Scene viewIntroduction = new Scene(group, 800, 450);
		window.setScene(viewIntroduction);

		window.setResizable(false);
		window.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);

	}

}
