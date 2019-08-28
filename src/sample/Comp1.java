package sample;


/*
* Comp1 is the module that makes the calculating operations on data. It passes the result to Comp2
* */
public class Comp1 extends Filter {

    public Comp1(Pipe entree, Pipe sortie){
        super();
        this.inPipe = entree;
        this.outPipe = sortie;
    }

    public void run(){
        String inData = inPipe.envoyer();
        String[] strings = inData.split(";");
        String selection = strings[0];
        int a = 0, b = 0;

        if (selection.equals("!")) {
            a = Integer.valueOf(strings[1]);
            b = 0;
        } else {
            a = Integer.valueOf(strings[1]);
            b = Integer.valueOf(strings[2]);
        }
        String op;
        int result;
        switch (selection){
            case "+":
                op = "Somme";
                result = somme(a, b);
                break;
            case "*":
                op = "Produit";
                result = produit(a, b);
                break;
            default :
                op = "Factorielle";
                result = factorielle(a);
        }
        if(op.equals("Factorielle") ) outPipe.ajouter(op +" ; "+ a + " ; " + result );
        else outPipe.ajouter(op +" ; "+ a + " ; " + b + " ; " + result );
        lancer();

    }

    public void lancer(){
        Comp2 trace = new Comp2(outPipe, inPipe);
        Thread thread2 = new Thread(trace);
        try{
            thread2.start();
            thread2.join();
        }catch(Exception e){}
    }


    private int somme(int a, int b){
        return a+b;
    }

    private int produit(int a, int b){
        return a*b;
    }

    private int factorielle(int a){
        if (a < 2) {
            return 1;
        }
        return a * factorielle(a - 1);
    }
}
