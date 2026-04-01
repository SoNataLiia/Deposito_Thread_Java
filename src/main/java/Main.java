import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Deposito  deposito = new Deposito();

        Thread hiloLlenado = new Thread(new HiloLlenado(deposito));
        Thread hiloVaciado = new Thread(new HiloVaciado(deposito));

        hiloLlenado.start();
        hiloVaciado.start();
    }
}
