
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author roccointini
 */
public class Main {
    public static void main(String[] args) {
        
        List <Integer> lista = new ArrayList<>();
        int nElem = 10;
        
        for(int i = 0; i < nElem; ++i){
            lista.add(i+1);
        }
        
        System.out.println("Stampa dell'ArrayList:");
        
        for(Integer i : lista){
            System.out.println(i);
        }
        
        System.out.println("L'ArrayList è vuota? " + lista.isEmpty());
        System.out.println("Ci sono " +  lista.size() + " elementi nell' ArrayList");
        
        
        lista.add(6);
        System.out.println("Ci sono " +  lista.size() + " elementi nell' ArrayList");
        
        System.out.println("La lista contiene il valore 7? " + lista.contains(7));
        System.out.println("Posizione del valore 6: " + lista.indexOf(6));
        System.out.println("Elemento dell'ArrayList alla posizione 8: " + lista.get(8));
        
        lista.addFirst(12);
        lista.addLast(20);
        
        
        System.out.println("Ristampa della lista: ");
        for(Integer i : lista){
            System.out.println(i);
        }
        
        lista.remove(Integer.valueOf(7));
        lista.remove(0);
        
        System.out.println("Ristampa della lista parte 2: ");
        for(Integer i : lista){
            System.out.println(i);
        }
        
        System.out.println("Indice dell'elemento 29: " + lista.indexOf(29));
        
        System.out.println("Primo elemento della lista: " +  lista.getFirst());
        System.out.println("Ultimo elemento della lista: " +  lista.getLast());
        
        lista.removeFirst();
        lista.removeLast();
        
        for(Integer i : lista){
            System.out.println(i);
        }
        
        System.out.println("Primo elemento della lista: " +  lista.getFirst());
        System.out.println("Ultimo elemento della lista: " +  lista.getLast());
        
        
        /*stampe alternative*/
        lista.forEach(System.out::println);
        System.out.println("\n------------------------------\n");
        lista.forEach(elem -> System.out.println(elem));
        
        System.out.println("Indice dell'ultimo 6 della lista: " +lista.lastIndexOf(6));
            
        List<Integer> listaContrario = lista.reversed();
        System.out.println("\n------------------------------\n");
        
        listaContrario.forEach(System.out::println);
        
        lista.clear();
        
        System.out.println("\n------------------------------\n");
        
        lista.forEach(System.out::println);
        
    }
}
