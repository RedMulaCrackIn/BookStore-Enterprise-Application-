/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libro;

 
import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author sicka
 */
@Singleton
@Startup
@DataSourceDefinition(
    className ="org.apache.derby.jdbc.EmbeddedDataSource", 
    name ="java:global/jdbc/EsameDS",
    user ="APP", password ="APP",
    databaseName ="EsameDB-3",
    properties = {"connectionAttributes=;create=true"} 
)
public class DatabasePopulator {
    
    @Inject
    private LibroEJB ejb;
     
    private Libro l1,l2,l3,l4,l5,l6;

    @PostConstruct 
    public void populateDB() {

        l1 = new Libro(1, "Alice nel paese delle meraviglie", "Romanzo","978-88-99279-26-4", 20.50f, 2, LocalDateTime.of(2024,12,6,17,45));
        l2 = new Libro(2, "Il Piccolo Principe", "Favola", "978-88-454-5000-5", 15.30f, 5, LocalDateTime.of(2024, 11, 15, 10, 30));
        l3 = new Libro(3, "1984", "Distopico", "978-88-7767-000-1", 18.90f, 3, LocalDateTime.of(2024, 10, 20, 14, 15));
        l4 = new Libro(4, "Moby Dick", "Avventura", "978-88-99456-12-7", 22.00f, 4, LocalDateTime.of(2024, 9, 12, 9, 00));
        l5 = new Libro(5, "Orgoglio e Pregiudizio", "Romanzo", "978-88-12345-67-8", 19.50f, 6, LocalDateTime.of(2024, 8, 5, 16, 45));
        l6 = new Libro(6, "Don Chisciotte", "Classico", "978-88-54321-98-6", 25.00f, 7, LocalDateTime.of(2024, 7, 15, 18, 00));
        
        
        
        
        ejb.aggiungiLibro(l1);
        ejb.aggiungiLibro(l2);
        ejb.aggiungiLibro(l3);
        ejb.aggiungiLibro(l4);
        ejb.aggiungiLibro(l5);
        ejb.aggiungiLibro(l6);

    }

    @PreDestroy

    public void clearDB()
    {
        ejb.rimuoviLibro(l1);//inizialmente era scritto ejb.remove(l1)
        ejb.rimuoviLibro(l2);
        ejb.rimuoviLibro(l3);
        ejb.rimuoviLibro(l4);
        ejb.rimuoviLibro(l5);
        ejb.rimuoviLibro(l6);
    }

}
