package libro;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = Libro.TROVA_PER_ID, query = "SELECT l FROM Libro l WHERE l.id = ?1"),
    @NamedQuery(name = Libro.TROVA_PER_TITOLO, query = "SELECT l FROM Libro l WHERE l.titolo = :titolo"),
    @NamedQuery(name = Libro.TROVA_TUTTI, query = "SELECT l FROM Libro l"),
    @NamedQuery(name = Libro.TROVA_PER_ISBN, query = "SELECT l FROM Libro l WHERE l.isbn = :isbn"),
    @NamedQuery(name = Libro.TROVA_PER_PREZZO, query = "SELECT l FROM Libro l WHERE l.prezzo > :prezzo"),
    @NamedQuery(name = Libro.TROVA_PER_TIPOLOGIA, query = "SELECT l FROM Libro l WHERE l.tipoLibro = :tipoLibro")
 
        
})
public class Libro implements Serializable {
    public static final String TROVA_PER_ID = "Libro.trovaPerId";
    public static final String TROVA_PER_TITOLO = "Libro.trovaPerTitolo"; /*modifica dato che era "Libro.trovaPerId";*/
    public static final String TROVA_TUTTI = "Libro.trovaTutti";
    public static final String TROVA_PER_ISBN = "Libro.trovaPerIsbn";
    public static final String TROVA_PER_PREZZO = "Libro.trovaPerPrezzo";
    public static final String TROVA_PER_TIPOLOGIA = "Libro.trovaPerTipologia";

    @Id
    private int id;
    private String titolo;
    private String tipoLibro;
    private String isbn;
    private float prezzo;
    private int quantita;     
    private LocalDateTime dataTempo; //mofifica in LocalDateTime, di conseguenza anche il parametro del costruttore/getter/setter
    public Libro() {}

    public Libro(int id, String titolo, String tipoLibro, String isbn, float prezzo, int quantita, LocalDateTime dataTempo) {
        this.id = id;
        this.titolo = titolo;
        this.tipoLibro = tipoLibro;
        this.isbn = isbn;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.dataTempo = dataTempo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(String tipoLibro) {
        this.tipoLibro = tipoLibro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public LocalDateTime getData() {
        return dataTempo;
    }

    public void setData(LocalDateTime dataTempo) {
        this.dataTempo = dataTempo;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titolo=" + titolo + ", tipoLibro=" + tipoLibro + ", isbn=" + isbn + ", prezzo=" + prezzo + ", quantita=" + quantita + ", data=" + dataTempo + '}';
    }
        
}
