### BookStoreEJB
**Descrizione del Progetto:**

Il progetto *BookStoreEJB* è un'applicazione Java EE progettata per la gestione delle vendite di libri in un sistema di libreria. Utilizza una serie di tecnologie e componenti enterprise per risolvere le problematiche comuni di gestione delle vendite, come la persistenza dei dati, la gestione delle vendite tramite EJB (Enterprise JavaBeans), l'integrazione con JMS (Java Message Service), e il monitoraggio delle chiamate tramite interceptors.

### Caratteristiche principali:
1. **Gestione dell'Archivio Persistente con JPA**:
   - Utilizza Java Persistence API (JPA) per memorizzare e gestire le vendite dei libri. I dati delle vendite (ID vendita, Titolo, Tipo libro, ISBN, Prezzo, Quantità, DataTempo) sono archiviati in un database denominato "EsameDB".
   - È prevista una chiave primaria per ogni vendita (ID vendita) e query personalizzate per recuperare le vendite per identificativo libro, titolo e per ottenere tutte le vendite registrate.
   - Viene implementato un bean Singleton che inizializza l'archivio e assicura che i dati siano accessibili in modo centralizzato.

2. **Bean Stateless per Gestione delle Vendite**:
   - Viene creato un Stateless EJB che offre metodi per aggiungere nuove vendite di libri e recuperare informazioni sulle vendite. Le funzionalità includono l'inserimento, la ricerca per ISBN, la ricerca per titolo, e la restituzione di tutte le vendite.

3. **Client per Visualizzare le Vendite**:
   - Un client consente di visualizzare le vendite di un libro specifico, filtrando per ISBN.
   - Inoltre, è possibile visualizzare tutte le vendite di libri che superano una certa soglia di prezzo, parametrizzata dall'utente.

4. **Interceptor per Monitoraggio delle Chiamate**:
   - Un interceptor personalizzato tiene traccia delle chiamate ai metodi del bean stateless. Ogni volta che un metodo viene invocato, viene stampato il nome del metodo e il numero di chiamate. 
   - Se una nuova vendita riguarda un "Romanzo", l'interceptor genera un evento che stampa un messaggio con il titolo del libro e la data e ora della vendita.

5. **Gestione Messaggi tramite JMS**:
   - Il sistema integra JMS (Java Message Service) per gestire l'eliminazione di una vendita. Un topic denominato `jms/javaee7/Topic` viene utilizzato per inviare messaggi che indicano l'eliminazione di una vendita. Se la vendita non esiste, viene generato un errore.

6. **Client per l'Invio di Messaggi JMS**:
   - Un client consente di inviare un messaggio JMS per eliminare una vendita dal sistema. Se la vendita da eliminare non esiste, viene emesso un errore su standard output.

### Tecnologie Utilizzate:
- **Java EE**: Per la gestione delle transazioni e dei componenti server-side (EJB).
- **JPA (Java Persistence API)**: Per la gestione della persistenza dei dati.
- **JMS (Java Message Service)**: Per la gestione dei messaggi e la comunicazione asincrona.
- **Interceptor**: Per il monitoraggio delle chiamate ai metodi del bean stateless.
- **TomEE o WildFly**: Server applicativo per eseguire l'applicazione.

### Struttura del Database:
- **DataSource**: `jdbc/EsameDS`
- **Persistent Unit**: `EsamePU`
- **Database**: `EsameDB`
- **ConnectionFactory**: `jms/javaee7/ConnectionFactory`
- **Topic JMS**: `jms/javaee7/Topic`

### Funzionalità del Sistema:
- Aggiungere e visualizzare vendite di libri.
- Monitorare e tracciare le operazioni di vendita, specialmente per i "Romanzi".
- Inviare e ricevere messaggi JMS per l'eliminazione di vendite.
- Realizzare query avanzate per visualizzare vendite in base a parametri come ISBN, titolo e prezzo.

### Setup e Esecuzione:
1. **Configurazione Database**: Il sistema si connette a un database chiamato "EsameDB" utilizzando un DataSource chiamato `jdbc/EsameDS`. È necessario configurare correttamente il database con le tabelle appropriate e una connessione JDBC.
2. **Installazione**: È necessario disporre di un server applicativo compatibile con Java EE, come TomEE o WildFly, per eseguire l'applicazione.
3. **Configurazione JMS**: Assicurarsi che la configurazione di JMS sia corretta, con il topic `jms/javaee7/Topic` e la `ConnectionFactory` chiamata `jms/javaee7/ConnectionFactory`.

### Come Contribuire:
Il progetto è open-source e accogliamo con piacere contributi e miglioramenti da parte della comunità. Se desideri contribuire, puoi fare un fork del progetto, apportare le modifiche necessarie e inviare una pull request.

---

Questo progetto rappresenta un'applicazione di gestione vendite di libri con una solida architettura basata su Java EE, che sfrutta tecnologie moderne come JPA, JMS e EJB per garantire scalabilità, modularità e una facile gestione delle operazioni di vendita.
