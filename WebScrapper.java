import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
public class WebScrapper extends Application {

    @SuppressWarnings("unused")
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        WebView webView = new WebView();
        webView.setMinWidth(680);
        webView.setLayoutY(30);
        TextField urlAddress = new TextField();
        urlAddress.setLayoutX(10);
        urlAddress.setMinWidth(500);
        Button searchButton = new Button("Search");
        Button save = new Button("Save");
        save.setLayoutX(620);
        save.setMinWidth(100);
        searchButton.setLayoutX(515);
        searchButton.setMinWidth(100);
        EventHandler <javafx.event.ActionEvent> eventHandler = e -> {
            try {
                WebData wd = new WebData(urlAddress.getText());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
           webView.getEngine().load("https://"+urlAddress.getText());
           primaryStage.setTitle(urlAddress.getText());
        };
        searchButton.setOnAction(eventHandler);
        root.getChildren().addAll(urlAddress,searchButton,webView,save);
        
        primaryStage.setTitle("Web Scrapper");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        }
}
