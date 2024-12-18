/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libro;

/**
 *
 * @author sicka
 */
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Counter 
public class CounterInterceptor {

    private static final java.util.Map<String, Integer> methodCallCount = new java.util.HashMap<>();
    @AroundInvoke
    public Object counter(InvocationContext ic) throws Exception {
        
        String methodName = ic.getMethod().getName();    
        methodCallCount.put(methodName, methodCallCount.getOrDefault(methodName, 0) + 1); // aggiunta metodo put per inserire il metodo e il numero di volte chiamato.
        System.out.println("Il metodo " + methodName + " è stato chiamato " + methodCallCount.get(methodName) + " volte"); // aggiunta di stampa
        return ic.proceed();
    }
}
