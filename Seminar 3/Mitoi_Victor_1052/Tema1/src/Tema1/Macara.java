package Tema1;

public class Macara extends Thread {
    private Container tipContainer;
    private int timpManipulare;
    private boolean inOperare;

    public Container getTipContainer() {
        return tipContainer;
    }

    public boolean isInOperare() {
        return inOperare;
    }

    public void blocheazaOperare() {
        this.inOperare = true;
    }

    public void eliberareOperare() {
        this.inOperare = false;
    }

    public void setTipContainer(Container tipContainer) {
        this.tipContainer = tipContainer;
    }

    public int getTimpManipulare() {
        return timpManipulare;
    }

    public void setTimpManipulare(int timpManipulare) {
        this.timpManipulare = timpManipulare;
    }

    public Macara(Container tipContainer, int timpManipulare) {
        this.tipContainer = tipContainer;
        this.timpManipulare = timpManipulare;
    }



}
