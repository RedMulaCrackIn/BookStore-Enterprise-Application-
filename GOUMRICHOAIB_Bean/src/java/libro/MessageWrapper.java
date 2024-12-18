/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libro;

import java.io.Serializable;

/**
 *
 * @author sicka
 */
public class MessageWrapper implements Serializable{
    
    private int id;

    public MessageWrapper(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
   
    
}
