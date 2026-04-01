public class HiloVaciado implements Runnable{
    private Deposito  deposito;
    public HiloVaciado(Deposito deposito){
        this.deposito = deposito;
    }

    @Override
    public void run(){
        while (true){
            try{
            deposito.vaciar();
            Thread.sleep(500);
            }catch (InterruptedException e){
                break;

            }
        }

    }


}
