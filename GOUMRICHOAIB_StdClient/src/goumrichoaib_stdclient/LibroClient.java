/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package goumrichoaib_stdclient;

import java.util.List;
import java.util.Scanner;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import libro.Libro;
import libro.LibroEJBRemote;

/**
 *
 * @author sicka
 */

public class LibroClient 
{  
    private static LibroEJBRemote ejb;

    /**
     *
     * @param args
     * @throws NamingException
     */
    public static void main(String[] args)throws NamingException
    {

          Context ctx = new InitialContext();
           //modifica nome EJB Module e package
          ejb = (LibroEJBRemote) ctx.lookup("java:global/GOUMRICHOAIB_Bean/LibroEJB!libro.LibroEJBRemote");

          String isbn ="978-88-99279-26-4";

          System.out.println("Tutte le vendite del ISBN fortinito"); 

          List<Libro> lista1 = ejb.trovaPerIsbn(isbn);

          for(Libro l : lista1 ) 
          {
               System.out.println(l);
          }

          Scanner sc = new Scanner(System.in);

          System.out.println("inserisci il prezzo ");

          Float f = sc.nextFloat(); 

          List<Libro> lista2 = ejb.trovaPerPrezzo(f);

          for(Libro l : lista2) 
          {

               System.out.println(l);

          }

     }
    
}