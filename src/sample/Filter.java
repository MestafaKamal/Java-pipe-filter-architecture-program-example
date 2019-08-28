package sample;


/*Filter class*/
abstract class Filter implements Runnable{
    
    Pipe outPipe;
    Pipe inPipe;
}
