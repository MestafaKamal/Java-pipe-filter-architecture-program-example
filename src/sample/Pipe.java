package sample;

import java.util.LinkedList;
import java.util.Queue;

public class Pipe {

    Queue<String> entree = new LinkedList<>();

    public void ajouter(String s){
        entree.add(s);
    }

    public String  envoyer(){
        return entree.poll();
    }

}
