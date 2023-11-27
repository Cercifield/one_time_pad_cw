import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Pad_View extends Application {
    private TextField messageInput;
    private TextArea output;
    private Label errorLabel;
    private Pad_Controller controller;
    private boolean isPadLoadedFromFile = false;
    private boolean isMessageLoadedFromFile = false;
    private String pad;
    private Button loadPadButton;
    private Button loadMessageButton;


    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(80));
        grid.setHgap(20);
        grid.setVgap(20);

        Label messageInputLabel = new Label("Nachricht eingeben:");
        messageInput = new TextField();
        grid.add(messageInputLabel, 0, 0);
        grid.add(messageInput, 1, 0);

        Label messageLoadLabel = new Label("Lade eine Nachricht hoch:");
        loadMessageButton = new Button(".txt Datei laden");
        loadMessageButton.setOnAction(e -> loadMessageFile(primaryStage));
        grid.add(messageLoadLabel, 0, 1);
        grid.add(loadMessageButton, 1, 1);
        Button resetMessageButton = new Button("Nachricht zurücksetzen");
        resetMessageButton.setOnAction(e -> resetMessage());
        grid.add(resetMessageButton, 2, 1);

        Label padLoadLabel = new Label("Lade einen OneTimePad hoch:");
        loadPadButton = new Button(".txt Datei laden");
        loadPadButton.setOnAction(e -> loadPadFile(primaryStage));
        grid.add(padLoadLabel, 0, 2);
        grid.add(loadPadButton, 1, 2);
        Button resetPadButton = new Button("OneTimePad zurücksetzen");
        resetPadButton.setOnAction(e -> resetPad());
        grid.add(resetPadButton, 2, 2);

        Button encryptButton = new Button("Verschlüsseln");
        encryptButton.setOnAction(e -> {
            clearError();
            controller.encryptMessage();
        });
        Button decryptButton = new Button("Entschlüsseln");
        decryptButton.setOnAction(e -> {
            clearError();
            controller.decryptMessage();
        });
        grid.add(encryptButton, 0, 3);
        grid.add(decryptButton, 1, 3);

        output = new TextArea();
        output.setPrefHeight(100);
        grid.add(output, 0, 4, 2, 1);

        Button resetButton = new Button("Alles zurücksetzen");
        resetButton.setOnAction(e -> resetAll());
        grid.add(resetButton, 0, 5, 2, 1);

        errorLabel = new Label();
        grid.add(errorLabel, 0, 6, 2, 1);

        controller = new Pad_Controller(new Pad_Model(), this);

        Scene scene = new Scene(grid, 500, 420);
        scene.getStylesheets().add("style.css");
        primaryStage.setTitle("Perfekte Kryptografie");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(750);
        primaryStage.setMinHeight(500);
        primaryStage.show();
    }

    private void loadPadFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                pad = new String(Files.readAllBytes(Paths.get(file.toURI())))
                        .replaceAll("[^\\x20-\\x7E]", "");
                isPadLoadedFromFile = true;
                loadPadButton.setStyle("-fx-text-fill: green;");
            } catch (Exception e) {
                showError("Fehler beim Lesen der Pad-Datei: " + e.getMessage());
            }
        }
    }

    private void loadMessageFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                String message = new String(Files.readAllBytes(Paths.get(file.toURI())))
                        .replaceAll("[^\\x20-\\x7E]", "");
                messageInput.setText(message);
                messageInput.setDisable(true);
                isMessageLoadedFromFile = true;
                loadMessageButton.setStyle("-fx-text-fill: green;");
            } catch (Exception e) {
                showError("Fehler beim Lesen der Nachrichten-Datei: " + e.getMessage());
            }
        }
    }

    private void resetAll() {
        messageInput.clear();
        messageInput.setDisable(false);
        output.clear();
        pad = null;
        isPadLoadedFromFile = false;
        isMessageLoadedFromFile = false;
        loadPadButton.setStyle("");
        loadMessageButton.setStyle("");
    }

    public boolean isPadLoadedFromFile() {
        return isPadLoadedFromFile;
    }

    public String getPad() {
        return pad;
    }

    public String getMessageInput() {
        return messageInput.getText();
    }
    private void resetMessage() {
        messageInput.clear();
        messageInput.setDisable(false);
        isMessageLoadedFromFile = false;
        loadMessageButton.setStyle("");
    }
    private void resetPad() {
        pad = null;
        isPadLoadedFromFile = false;
        loadPadButton.setStyle("");
    }

    public void setOutput(String message) {
        output.setText(message);
    }

    public void showError(String errorMessage) {
        errorLabel.setText("Fehler: " + errorMessage);
    }

    private void clearError() {
        errorLabel.setText("");
    }
}