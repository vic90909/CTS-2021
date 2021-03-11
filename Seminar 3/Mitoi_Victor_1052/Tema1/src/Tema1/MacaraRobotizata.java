package Tema1;

public class MacaraRobotizata extends Thread {
    private PortContainer port;
    private Macara macara;

    public MacaraRobotizata(PortContainer portContainer, Macara macara) {
        this.port = portContainer;
        this.macara = macara;
    }

    public PortContainer getPortContainer() {
        return port;
    }

    public void setPortContainer(PortContainer portContainer) {
        this.port = portContainer;
    }

    public Macara getMacara() {
        return macara;
    }

    public void setMacara(Macara macara) {
        this.macara = macara;
    }

    public synchronized void operareMacara(){
        if(macara.isInOperare()==true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else
	        if(port.getContainer(macara.getTipContainer())!=0){
	            macara.blocheazaOperare();
	            System.out.println("Inainte de descarcare pentru "+String.valueOf(macara.getTipContainer())+" "+port.DescarcaContainer(port,macara));
	            port.setContainer(macara.getTipContainer());
	            macara.eliberareOperare();
	
	            System.out.println("----------------->Dupa descarcare pentru "+String.valueOf(macara.getTipContainer())+" "+port.DescarcaContainer(port,macara));
	
	
	            notifyAll();
	
	        }

    }
    @Override
    public void run(){
        while(port.getTotal()!=0){
            try {
                sleep(macara.getTimpManipulare());
                operareMacara();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
