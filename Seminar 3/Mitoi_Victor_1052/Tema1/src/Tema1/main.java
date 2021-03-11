package Tema1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class main{

    public static void main(String[] args){
        int[] nr={100,50,25,10};
        int[] nr2={15,5,20,50};
        int[] nr3={2,6,18,54};

        Container[] vector={Container.Mic_10mc,Container.Mediu_25mc,Container.Mare_50mc,Container.Jumbo_100mc};

        PortContainer port1=new PortContainer("Constanta",vector,nr);
        PortContainer port2=new PortContainer("Medgidia",vector,nr2);
        PortContainer port3=new PortContainer("Istambul",vector,nr3);
        System.out.println(port1.toString());
        System.out.println(port1.getCapacitate());


        Macara macara1=new Macara(Container.Mic_10mc,10);
        Macara macara2=new Macara(Container.Mediu_25mc,25);
        Macara macara3=new Macara(Container.Mare_50mc,50);
        Macara macara4=new Macara(Container.Jumbo_100mc,100);
        
        System.out.println(port1.DescarcaContainer(port1,macara1));
        System.out.println(port1.DescarcaContainer(port1,macara2));
        System.out.println(port1.DescarcaContainer(port1,macara3));
        System.out.println(port1.DescarcaContainer(port1,macara4));

        System.out.println(port1.getContainer(Container.Jumbo_100mc));

        ArrayList<PortContainer> flota =new ArrayList<PortContainer>();
        flota.add(port1);
        flota.add(port2);
        flota.add(port3);

        try {
            PortContainer port4 = (PortContainer) port1.clone();
            System.out.println("CLONA::::    " + port4.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFLOTA");
        for (PortContainer i : flota){
            System.out.println(i.toString());
        }
        System.out.println("FLOTA\n");


        try {
            FileWriter outfile =new FileWriter("PortContainer.csv",false);
            BufferedWriter bufferedWriter=new BufferedWriter(outfile);

            for(PortContainer i : flota){
                bufferedWriter.write(i.toString());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            outfile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        ArrayDeque<PortContainer> flota2=new ArrayDeque<PortContainer>();

        try {
            FileReader inFile=new FileReader("PortContainer.csv");
            BufferedReader bufferedReader =new BufferedReader(inFile);

            Scanner scanner=new Scanner(bufferedReader);
            while(scanner.hasNext()){
                String linie=scanner.nextLine();
                Scanner LineScanner=new Scanner(linie);
                LineScanner.useDelimiter(", ");

                PortContainer local = new PortContainer();
                local.setEticheta(LineScanner.next());

                int[] auxNr=new int[4];
                for(int i=0;i<4;i++){
                    auxNr[i]=LineScanner.nextInt();
                }

                local.setNrContainere(auxNr);

                Container[] auxContainer=new Container[4];
                for(int i=0;i<4;i++){
                    auxContainer[i]=Container.valueOf(LineScanner.next());
                }
                local.setTipContainer(auxContainer);

                flota2.offerLast(local);
                LineScanner.close();
            }
            scanner.close();
            bufferedReader.close();
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PortContainer iter=null;
        System.out.println("FLOTA2");
        while(!flota2.isEmpty()){
            iter=flota2.pollFirst();
            System.out.println(iter.toString());
        }
        System.out.println("FLOTA2\n");
        System.out.println("---------------------\nTRATARE MULTITHREADURI\n---------------------");

        Thread[] macarale=new MacaraRobotizata[4];
        macarale[0]=new MacaraRobotizata(port1,macara1);
        macarale[1]=new MacaraRobotizata(port1,macara2);
        macarale[2]=new MacaraRobotizata(port1,macara3);
        macarale[3]=new MacaraRobotizata(port1,macara4);

        for(int i=0;i<4;i++){
            macarale[i].start();
        }
    }
}
