import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GuessNumber extends Application{
	 //int target = (int)Math.floor(Math.random() * 100+1);
	 int target;
	
	public void start(Stage primaryStage) throws Exception {
		//				title of the stage
		primaryStage.setTitle("Guessing Numbers");
		
		// we create and import the text 
		// final because should never change with final
		final Text text = new Text();
		text.setText("choose a number between 1 to 100");
	
		// we call function to user writhe in the console
		TextField userIn = new TextField();
		Button start = new Button();
		Button makeGuess = new Button();
		start.setText("Start Game");
		makeGuess.setText("Make Guess");
		
		// making the function of the button "start"
		//declarar una funcion en un parametro, Javascrip
		start.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent arg0) {
				// cuando le de lcick al boton start, target valdra esto.
				target = (int)Math.floor(Math.random()*100+1);
				//setear objeto texto
				text.setText("Make your guess.");
			}
		});
		
		// making the function of the button "makeGuess"
		makeGuess.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				// [^0-9] solo aceptar inputs entre  0 a 9
				String userInput = userIn.getText().replaceAll("[^0-9]", "");
				if(userInput.length()<=0) {
					text.setText("Please enter a valid number between 1 to 100.");
				}
				//casting from string to int(convierte el texto en un entero)
				int guess = Integer.parseInt(userInput);
				if(guess>target) {
					text.setText("Choose a Lower number.");
				}
				else if(guess<target) {
					text.setText("Choose a Higher number");
				}
				else if(guess==target) {
					text.setText("Correct! (" + target + "). Click Start Game to play again");
				}
			}
		});
		//layout ordena mis elementos like css
		VBox pane = new VBox();
		// alinear centro
		// es para dibujar lo de arriba en la cpu
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().add(text);
		pane.getChildren().add(userIn);
		pane.getChildren().add(makeGuess);
		pane.getChildren().add(start);
		pane.setPadding(new Insets(5,5,5,5));
		primaryStage.setScene(new Scene(pane,250,130));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	

}
