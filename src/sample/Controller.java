package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Controller {
    @FXML
    private JFXTextField oper1;
    @FXML
    private JFXTextField oper2;

    @FXML
    private TextArea result;

    private boolean trans = false;
    private String operation = "";

    private Pipe pipe1 = new Pipe();
    private Pipe pipe2 = new Pipe();

    @FXML
    void fact(ActionEvent event) {
        if (oper1.getText().matches("[-]?[0-9]+")) {
            int a = Integer.parseInt(oper1.getText());
            pipe1.ajouter("!" + ";" + a );
            lancer();
            result.setText(pipe1.envoyer());
        }
    }

    @FXML
    void prod(ActionEvent event) throws IOException {
        if (oper1.getText().matches("[-]?[0-9]+"))
            if (oper2.getText().matches("[-]?[0-9]+")) {
                int a = Integer.parseInt(oper1.getText());
                int b = Integer.parseInt(oper2.getText());
                pipe1.ajouter("*" + ";" + a + ";"+ b);
                lancer();
                result.setText(pipe1.envoyer());
            }
    }

    @FXML
    void quitter(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void somme(ActionEvent event) {
        if (oper1.getText().matches("[-]?[0-9]+"))
            if (oper2.getText().matches("[-]?[0-9]+")) {
                int a = Integer.parseInt(oper1.getText());
                int b = Integer.parseInt(oper2.getText());
                pipe1.ajouter("+" + ";" + a + ";"+ b);
                lancer();
                result.setText(pipe1.envoyer());
            }
    }

    @FXML
    void trace(ActionEvent event) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("trace.txt")));
        if(content.isEmpty())result.setText("No data");
        else result.setText(content);
    }

    private Pipe p;

    public void initPipe(Pipe p){
        this.p = p;
    }

    public void lancer(){
        Comp1 calcul = new Comp1(pipe1,pipe2);
        Thread thread1 = new Thread(calcul);
        try{
            thread1.start();
            thread1.join();
        }catch(Exception e){}
    }
}
