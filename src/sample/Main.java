package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader root = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent p= root.load();
        primaryStage.setTitle("Calcul en pipe-filter avec java");
        Controller controller = root.getController();
        primaryStage.setScene(new Scene(p, 450, 340));
        primaryStage.setMinWidth(450);


        primaryStage.setMaxWidth(450);
        primaryStage.setMinHeight(340);
        primaryStage.setMaxHeight(340);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
