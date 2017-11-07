/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fio_ex3;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author artur
 */
public class Thread_Creator extends Thread {

    Thread_Creator f;   //crear variable de la clase Thread_Creator
    static int n = 1;   //instanciar la varible n para el numero de hilos hijos
    Random rd = new Random();   //invocar el random para generar el tiempo de espera aleatorio

    public Thread_Creator(String str) {
        super(str);
    }

    public void run() {     //a partir de aquí se ejecuta el hilo padre que llamamos en la main
        if (n >= 1 && n < 5) {      //este if comprueba el numero de hilos para comprobar si hay que crear hilos hijos o no
            f = new Thread_Creator("Hijo número " + n);   //aquí se crean los hilos hijos
            f.start();      //aquí los hilos hijos se ejecutan
        }
        n++;    //se acumula la variable n que marca el numero de hilos que se han ejecutado
        
                try {
            f.join();       //se hace join de los hilos hijos
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread_Creator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException exi) {      //esta excepción impide que salte null
        }

        for (int i = 1; i < 11; i++) {      //este for se ejecuta 10 veces para escribir el nombre de los hilos
            try {
                sleep((rd.nextInt(6)+1)*100);     //el hilo duerme durante 600 ms estaba cansado
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread_Creator.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(i + " " + getName());        //pasa por pantalla el nombre de cada hilo para comprobar su correcto funcionamiento
        }
        System.out.println("Fin de ejecución de " + this.getName());        //pasa por pantalla la indicación de la triste muerte de un hilo


    }
}
