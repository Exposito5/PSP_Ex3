package fio_ex3;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Fios_Ex3 {


    

    public static void main(String[] args) throws InterruptedException {
        
        Thread_Creator t = new Thread_Creator("Hilo Padre");        //instanciamos la clase Thread_Creator con el hilo padre
        
        t.start();      //iniciamos la ejecución del hilo padre que llamará a los hilos hijos
       
    }
}    
