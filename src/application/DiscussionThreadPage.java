package application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DiscussionThreadPage {
    private final String flaggedItem;

    public DiscussionThreadPage(String flaggedItem) {
        this.flaggedItem = flaggedItem;
    }

    public void show(Stage primaryStage) {
        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        ListView<String> discussionList = new ListView<>();
        discussionList.getItems().addAll(FlagStore.getDiscussion(flaggedItem));

        TextField messageField = new TextField();
        Button postButton = new Button("Post Message");

        postButton.setOnAction(e -> {
            String msg = messageField.getText();
            if (!msg.trim().isEmpty()) {
                FlagStore.addDiscussionMessage(flaggedItem, "Staff: " + msg);
                discussionList.getItems().add("Staff: " + msg);
                messageField.clear();
            }
        });

        layout.getChildren().addAll(
            new Label("Discussion on: " + flaggedItem),
            discussionList,
            messageField,
            postButton
        );

        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Discussion Thread");
    }
}
