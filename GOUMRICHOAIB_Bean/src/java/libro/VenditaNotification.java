/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libro;

import javax.enterprise.event.Observes;

/**
 *
 * @author sicka
 */
public class VenditaNotification {
    public void notify(@Observes Libro c) //Inserimento di Libro al posto di @VenditaRomanzo
    {

        System.out.println("Nuova Vendita di un romanzo " + c.getTitolo() + " data tempo : "+ c.getData() );

    } 
    
}
