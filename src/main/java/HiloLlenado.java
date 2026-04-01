public class HiloLlenado implements Runnable{
    private Deposito deposito;
    public HiloLlenado(Deposito deposito){
        this.deposito = deposito;
    }
    @Override
    public void run(){
        while (true){
            try{
                deposito.llenar();
                Thread.sleep(500);
            }catch (InterruptedException e){
                break;
            }
        }
    }
}
