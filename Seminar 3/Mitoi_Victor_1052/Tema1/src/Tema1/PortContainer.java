package Tema1;

public class PortContainer implements Cloneable,Numarabil,Descarcare{

    private String eticheta;
    private Container[] tipContainer;
    private int[] nrContainere;

    public PortContainer(String eticheta, Container[] tipContainer, int[] nrContainere) {
        this.eticheta = eticheta;
        this.tipContainer = tipContainer;
        this.nrContainere = nrContainere;
    }

    public PortContainer(String eticheta) {
        this.eticheta = eticheta;
    }

    public PortContainer(Container[] tipContainer) {
        this.tipContainer = tipContainer;
    }

    public PortContainer(int[] nrContainere) {
        this.nrContainere = nrContainere;
    }

    public String getEticheta() {
        return eticheta;
    }

    public void setEticheta(String eticheta) {
        this.eticheta = eticheta;
    }

    public void setNrContainer(int index,int nr){nrContainere[index]=nr;}

    public Container[] getTipContainer() {
        return tipContainer;
    }

    public void setTipContainer(Container[] tipContainer) {
        this.tipContainer = tipContainer;
    }

    public int[] getNrContainere() {
        return nrContainere;
    }

    public int getNrContainer(int index){
        return nrContainere[index];
    }

    public void setNrContainere(int[] nrContainere) {
        this.nrContainere = nrContainere;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        PortContainer clona= (PortContainer) super.clone();
        clona = new PortContainer(this.eticheta,this.tipContainer,this.nrContainere);
        for(int i=0;i<4;i++)
            clona.setNrContainer(i,this.getNrContainer(i));
        return clona;
    }

    public PortContainer() {
    }

    @Override
    public String toString() {
        return this.eticheta + ", " + this.nrContainere[0] + ", " + this.nrContainere[1] + ", " + this.nrContainere[2] + ", " + this.nrContainere[3] + ", " + this.tipContainer[0].toString() + ", " + this.tipContainer[1].toString() + ", " + this.tipContainer[2].toString() + ", " + this.tipContainer[3].toString();
    }

    public int getCapacitate(){
        int capacitate;
        capacitate=10*nrContainere[0]+25*nrContainere[1]+50*nrContainere[2]+100*nrContainere[3];
        return capacitate;
    }

    public int DescarcaContainer(PortContainer p, Macara m){
//        if(m.getTipContainer()==Container.Mic_10mc)
//           return p.getNrContainer(0);
//        else if(m.getTipContainer()==Container.Mediu_25mc)
//            return p.getNrContainer(1);
//        else if(m.getTipContainer()==Container.Mare_50mc)
//            return p.getNrContainer(2);
//       else if(m.getTipContainer()==Container.Jumbo_100mc)
//          return p.getNrContainer(3);
//        return 0;
    	
    	switch (m.getTipContainer()) {
		case Mic_10mc:
			return p.getNrContainer(0);
		case Mediu_25mc:
			return p.getNrContainer(1);
		case Mare_50mc:
			return p.getNrContainer(2);
		case Jumbo_100mc:
			return p.getNrContainer(3);
		default:
			return 0;
		}

    }

    public int getContainer(Container c){
    	
    	switch (c) {
		case Mic_10mc:
			return nrContainere[0];
		case Mediu_25mc:
			return nrContainere[1];
		case Mare_50mc:
			return nrContainere[2];
		case Jumbo_100mc:
			return nrContainere[3];
		default:
			return -1;
		}
    	
    }

    public void setContainer(Container c){
    	switch (c) {
		case Mic_10mc:
			nrContainere[0]=-1;
			break;
		case Mediu_25mc:
			nrContainere[1]=-1;
			break;
		case Mare_50mc:
			nrContainere[2]=-1;
			break;
		case Jumbo_100mc:
			nrContainere[3]=-1;
			break;
		default:
			break;
		}
    }

    public int getTotal(){
        int suma=0;
        for(int i=0;i<4;i++){
            suma+=this.nrContainere[i];
        }
        return suma;
    }
}
