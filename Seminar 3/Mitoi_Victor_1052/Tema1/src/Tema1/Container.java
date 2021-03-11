package Tema1;

public enum Container {
    Mic_10mc("Mic_10mc"),
    Mediu_25mc("Mediu_25mc"),
    Mare_50mc("Mare_50mc"),
    Jumbo_100mc("Jumbo_100mc");

    public String valoare;
    Container(String valoare){
        this.valoare=valoare;
    }
}
