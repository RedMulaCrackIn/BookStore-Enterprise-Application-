/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libro;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author sicka
 */
@MessageDriven ( mappedName = "jms/javaee7/Topic")
public class LibroMDB implements MessageListener
{ 

    @Inject 
    LibroEJB ejb; 
    @Override //aggiunta
    public void onMessage(Message msg)
    {  
       try{

       MessageWrapper message = msg.getBody(MessageWrapper.class); 

       Integer id = message.getId(); 

       Libro l = ejb.trovaPerId(id);//mancato parametro da passare 

       ejb.rimuoviLibro(l);//moficato il nome del metodo che era "ejb.remove(l)"

     }catch(JMSException ex) { 

        ex.printStackTrace();

    } 

} 


} 