/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package goumrichoaib_jmsclient;

/**
 *
 * @author sicka
 */
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import libro.LibroEJB;
import libro.LibroEJBRemote;

import libro.MessageWrapper;

public class LibroJMSClient {

  
    
    private static LibroEJBRemote ejb;
    public static void main(String[] args) throws NamingException {
        
        Context ctx = new InitialContext();
        
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
        ejb = (LibroEJBRemote) ctx.lookup("java:global/GOUMRICHOAIB_Bean/LibroEJB!libro.LibroEJBRemote");
        int id = 1;
        
        if(ejb.trovaPerId(id) == null)  
        {

        System.err.println("Errore, vendita non esistente"); 
        return;
        }
        
        MessageWrapper message = new MessageWrapper(id);
        
        try(JMSContext jmsCxt = cf.createContext()) // mancato assegnamento oggetto al metodo createContext()
        {
            jmsCxt.createProducer().send(topic, message);
        }
    }
}


