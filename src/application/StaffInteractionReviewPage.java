package application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StaffInteractionReviewPage {

    public void show(Stage primaryStage) {
        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        TextField searchField = new TextField();
        searchField.setPromptText("Search questions or answers...");

        ListView<String> interactionList = new ListView<>();
        interactionList.getItems().addAll(
            
        );

        Button flagButton = new Button("Flag Selected");
        Button noteButton = new Button("Add Note to Flag");
        Button discussionButton = new Button("Open Discussion");

        flagButton.setOnAction(e -> {
            String selected = interactionList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                FlagStore.addFlag("staff1", selected);
                System.out.println("Flagged: " + selected);
            }
        });

        noteButton.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Enter your note for instructors:");
            dialog.showAndWait().ifPresent(note -> {
                String selected = interactionList.getSelectionModel().getSelectedItem();
                if (selected != null) {
                    FlagStore.addNoteToFlag(selected, note);
                    System.out.println("Note added to: " + selected);
                }
            });
        });

        discussionButton.setOnAction(e -> {
            String selected = interactionList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                new DiscussionThreadPage(selected).show(primaryStage);
            }
        });

        layout.getChildren().addAll(
            new Label("Search & Review"),
            searchField,
            interactionList,
            flagButton,
            noteButton,
            discussionButton
        );

        Scene scene = new Scene(layout, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Staff Interaction Review");
    }
}
