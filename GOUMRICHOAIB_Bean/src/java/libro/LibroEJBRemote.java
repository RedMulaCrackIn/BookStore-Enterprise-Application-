/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package libro;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sicka
 */
@Remote
public interface LibroEJBRemote {
    
    public void aggiungiLibro (Libro l);

    public void aggiornaLibro (Libro l);

    public void rimuoviLibro (Libro l);

    public Libro trovaPerId( int id);

    public List<Libro> trovaPerTitolo( String titolo);

    public List<Libro> trovaTutti();

    public List <Libro> trovaPerIsbn(String Isbn);

    public List <Libro> trovaPerPrezzo (float prezzo);

    public List <Libro> trovaPerTipologia (String tipologia);
    
}
