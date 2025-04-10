package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StaffHomePage {
    public void show(Stage primaryStage) {
        VBox layout = new VBox(10);
        layout.setStyle("-fx-alignment: center; -fx-padding: 20;");

        Button viewInteractions = new Button("View All Interactions");
        viewInteractions.setOnAction(e -> new StaffInteractionReviewPage().show(primaryStage));

        layout.getChildren().addAll(viewInteractions);

        Scene scene = new Scene(layout, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Staff Home Page");
    }
}
