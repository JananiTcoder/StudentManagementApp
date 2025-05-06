import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class StudentManagementApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Management");

        // Menu
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> primaryStage.close());
        fileMenu.getItems().add(exitItem);
        menuBar.getMenus().add(fileMenu);

        // Controls
        Label nameLabel = new Label("Student Name:");
        TextField nameField = new TextField();
        Button addButton = new Button("Add Student");
        ListView<String> studentListView = new ListView<>();

        addButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                studentListView.getItems().add(name);
                nameField.clear();
            }
        });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(menuBar, nameLabel, nameField, addButton, studentListView);
        layout.setPadding(new javafx.geometry.Insets(10));

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
