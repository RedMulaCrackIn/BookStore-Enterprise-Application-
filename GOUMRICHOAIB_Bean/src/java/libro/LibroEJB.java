package libro;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class LibroEJB implements LibroEJBRemote {

    @Inject
    private EntityManager em;

    @Override
    @Counter
    @VenditaRomanzo
    public void aggiungiLibro(Libro l) {
        em.persist(l);
    }

    @Override
    @Counter 
    public void aggiornaLibro(Libro l) {
        em.merge(l);
    }

    @Override
    @Counter 
    public void rimuoviLibro(Libro l) {
        em.remove(em.merge(l));
    }

    @Override
    @Counter 

        
    public Libro trovaPerId(int id) {
        TypedQuery<Libro> query = em.createNamedQuery(Libro.TROVA_PER_ID, Libro.class);
        query.setParameter(1, id);
    
        List<Libro> result = query.getResultList();

        // Se la lista è vuota, restituisci null
        if (result.isEmpty()) {
            return null;
        }
        return query.getSingleResult();

    }
            
    

    @Override
    @Counter 
    public List<Libro> trovaPerTitolo(String titolo) {
        TypedQuery<Libro> query = em.createNamedQuery(Libro.TROVA_PER_TITOLO, Libro.class);
        query.setParameter("titolo", titolo); // Corretto nome parametro -> era "titloto"
        return query.getResultList();
    }

    @Override
    @Counter 
    public List<Libro> trovaTutti() {
        TypedQuery<Libro> query = em.createNamedQuery(Libro.TROVA_TUTTI, Libro.class);
        return query.getResultList();
    }

    @Override
    @Counter 
    public List<Libro> trovaPerIsbn(String isbn) {
        TypedQuery<Libro> query = em.createNamedQuery(Libro.TROVA_PER_ISBN, Libro.class);
        query.setParameter("isbn", isbn);
        return query.getResultList();
    }

    @Override
    @Counter 
    public List<Libro> trovaPerPrezzo(float prezzo) {
        TypedQuery<Libro> query = em.createNamedQuery(Libro.TROVA_PER_PREZZO, Libro.class);
        query.setParameter("prezzo", prezzo);
        return query.getResultList();
    }

    @Override
    @Counter 
    public List<Libro> trovaPerTipologia(String tipologia) {
        TypedQuery<Libro> query = em.createNamedQuery(Libro.TROVA_PER_TIPOLOGIA, Libro.class);
        query.setParameter("tipoLibro", tipologia);
        return query.getResultList();
    }
}
