package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Comp2 extends Filter {

    public Comp2(Pipe entree, Pipe sortie){
        super();
        this.inPipe = entree;
        this.outPipe = sortie;
    }

    public void run(){
        String inData = inPipe.envoyer();
        String[] strings = inData.split(";");
        try {
            BufferedWriter f = new BufferedWriter( new FileWriter("trace.txt",true));
            f.write(inData);
            f.newLine();
            f.close();
        }
        catch (Exception e) { }

        String res = "";
        if(strings[0].contains("Factorielle")) {
            res = strings[2];
        } else {
            res = strings[3];
        }
        outPipe.ajouter(res);
    }
}
