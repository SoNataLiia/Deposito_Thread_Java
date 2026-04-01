public class Deposito {
    //Cúanto agua hay ahora
    private int litros = 0;
    //esta inicio llenado
    private boolean llenadoActivo = true;
    // no está inicio vaciado
    private boolean vaciadoActivo = false;
    //velocidad actual de lleno
    private int ritmoLleno = 10;
    //velocidad actual de vaciado
    private int ritmoVaciado = 0;


    public synchronized void llenar() throws InterruptedException{
        // si llenado no está activo -> dormir
        while (!llenadoActivo){
            wait();
        }
        //añadir agua
        litros += ritmoLleno;
        System.out.println("Llenado " + litros + " litros.");
        // 1: llegamos a 900 -> activar vaciado a 5 l/s
        if(litros >= 900 && litros < 1000 && !vaciadoActivo){
            vaciadoActivo = true;
            ritmoVaciado = 5;
            System.out.println("Se activo vaciado.");
        }
        //2: llegamos a 1000 -> parar llenado
        if(litros >= 1000){
            litros = 1000;
            llenadoActivo = false;
            ritmoVaciado = 10;
            System.out.println("Parando llenando y esta vaciado 10 l/s.");
        }
        notifyAll();

    }

    public synchronized void vaciar() throws InterruptedException{
        // si vaciado no está activo -> dormir
        while (!vaciadoActivo){
            wait();
        }
        // vaciar agua
        litros -= ritmoVaciado;
        System.out.println("Vaciado " + litros + " litros");
        // 3: llegamos a 100 -> activar llenado a 5 l/s
        if(litros <= 100 && !llenadoActivo){
            llenadoActivo = true;
            ritmoLleno = 5;
            System.out.println("Se activa llenado 5 l/s.");
        }
        //4: llegamos a 0 -> parar vaciado
        if(litros <= 0){
            litros = 0;
            vaciadoActivo = false;
            ritmoLleno = 10;
            System.out.println("Vacío. Llenado activado a 10 l/s.");
        }
        notifyAll();
    }
}
