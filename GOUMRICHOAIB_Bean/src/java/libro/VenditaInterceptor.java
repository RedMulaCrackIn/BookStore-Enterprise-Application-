/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libro;

import java.util.List;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author sicka
 */
@Interceptor
@VenditaRomanzo  // Annotazione personalizzata (facoltativa)
public class VenditaInterceptor {

    @Inject
    private LibroEJB ejb;

    @Inject
    private Event<Libro> event;

    @AroundInvoke
    public Object vendita(InvocationContext ic) throws Exception {
      
        List<Libro> lista = ejb.trovaPerTipologia("Romanzo");

        for (Libro l : lista) {
            if (l.getTipoLibro().equals("Romanzo")) {
                
                event.fire(l);  
            }
        }
        return ic.proceed();
    }
}