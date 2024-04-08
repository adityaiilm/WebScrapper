import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class WebScrapper extends Application {

    @Override
    public void start(Stage primaryStage) {
        Image icon = new Image("WS.png");
        primaryStage.getIcons().add(icon);
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        WebView webView = new WebView();
        webView.getEngine().setJavaScriptEnabled(true);
        webView.setMinWidth(680);
        webView.setLayoutY(30);
        TextField urlAddress = new TextField();
        urlAddress.setLayoutX(10);
        urlAddress.setMinWidth(500);
        Button searchButton = new Button("Search");
        Button saveButton = new Button("Save");
        saveButton.setLayoutX(620);
        saveButton.setMinWidth(100);
        saveButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save File");
            fileChooser.setInitialFileName(urlAddress+".html");
            String predefineFilePath = urlAddress.getText()+".html";
            File predefineFile = new File(predefineFilePath);
            if(predefineFile.exists()){
                fileChooser.setInitialDirectory(predefineFile.getParentFile());
            }
            File saveFile = fileChooser.showSaveDialog(primaryStage);
            if(saveFile != null){
                copyFile(predefineFile.toPath(),saveFile.toPath());
            }
        });
        searchButton.setLayoutX(515);
        searchButton.setMinWidth(100);
        EventHandler <javafx.event.ActionEvent> eventHandler = e -> {
           webView.getEngine().load("https://"+urlAddress.getText());
           primaryStage.setTitle(urlAddress.getText());
        try {
            testFunction(urlAddress.getText());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        };
        searchButton.setOnAction(eventHandler);
        root.getChildren().addAll(urlAddress,searchButton,webView,saveButton);
        
        primaryStage.setTitle("Web Scrapper");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    

    private void copyFile(Path source, Path destination) {
    try{
        Files.copy(source,destination);
    }catch (IOException ex){
    }
    }
    private void testFunction(String address) throws IOException{
        @SuppressWarnings("unused")
        WebData wd = new WebData(address);
    }

    public static void main(String[] args) {
        launch(args);
    }
        
}