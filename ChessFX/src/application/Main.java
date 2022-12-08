package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	@Override
	  public void start(Stage primaryStage) {
	    GridPane pane = new GridPane();

	    int count = 0;
	    for (int i = 0; i < 8; i++) {
	      count++;
	      for (int j = 0; j < 8; j++) {
	        Rectangle r = new Rectangle(80, 80, 80, 80);
	        if (count % 2 == 0)
	          r.setFill(Color.WHITE);
	        pane.add(r, j, i);
	        count++;
	      }
	    }

	    Scene scene = new Scene(pane);
	    primaryStage.setTitle("Chess");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	  }
	
	public static void main(String[] args) {
		launch(args);
	}
}
