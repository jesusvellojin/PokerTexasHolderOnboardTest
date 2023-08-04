package com.Pruebatecnica.PokerTexasHolderOnboardTest.service;

import com.Pruebatecnica.PokerTexasHolderOnboardTest.model.ManoGanadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class OnePair {


    @Autowired
    HighCard highCard;

    public ManoGanadora onePair(String hand1, String hand2 ){
        ManoGanadora manoGanadora = new ManoGanadora();
        String[] cartas = hand1.split(" ");
        String[] cartas2 = hand2.split(" ");
        List<String> arraylista = Arrays.asList(cartas);
        List<String> arraylista2 = Arrays.asList(cartas2);
        List<String> lista = new ArrayList<>(arraylista);
        List<String> lista2 = new ArrayList<>(arraylista2);
        List<String> array = new ArrayList<>();

        int con=0;
        int con2=0;
        Boolean hayParDos=false;
        Boolean hayParDos2=false;

        List<String> parDos= new ArrayList<>();
        List<String> parDos2= new ArrayList<>();
        List<String> parDosOrdenada= new ArrayList<>();
        List<String> parDosOrdenada2= new ArrayList<>();
        List<String> cartasParDos= new ArrayList<>();
        List<String> cartasParDos2= new ArrayList<>();
        List<String> desenpate1= new ArrayList<>();
        List<String> desenpate2= new ArrayList<>();

        ////////////////////////////////////////////////////////////mano1

        HashMap<String, Integer> mapCarta = elementosPar(lista);
        int banValor=0;
        for (String i:mapCarta.keySet()) {
            banValor=mapCarta.get(i);


            if (banValor==2){
                con++;
                parDos.add(i);

            }
        }

      //  parDosOrdenada= ordenar(parDos);

        //Hay dos pares
        if(con==0){
            hayParDos=false;
        }
        if (con==1){
            hayParDos=true;
            for (int i = 0; i < parDos.size() ; i++) {
                for (int j = 0; j < lista.size() ; j++) {
                    String ban1 = lista.get(j);
                    String valorCarta1 = ban1.substring(0, ban1.length() - 1);
                    if (parDos.get(i).equalsIgnoreCase(valorCarta1)){
                        cartasParDos.add(ban1);
                    }
                }
            }

            //desempate(cartasParDos,lista);

        }

        ////////////////////////////////////////////////////////mano2
        HashMap<String, Integer> mapCarta2 = elementosPar(lista2);

        for (String i:mapCarta2.keySet()) {
            int banValor2=mapCarta2.get(i);

            if (banValor2==2){

                con2++;
                parDos2.add(i);

            }
        }

        //parDosOrdenada2= ordenar(parDos2);


        if(con2==0){
            hayParDos2=false;
        }

        //Hay dos pares
        if (con2==1){
            hayParDos2=true;
            for (int i = 0; i < parDos2.size() ; i++) {
                for (int j = 0; j < lista2.size() ; j++) {
                    String ban2 = lista2.get(j);
                    String valorCarta2 = ban2.substring(0, ban2.length() - 1);
                    if (parDos2.get(i).equalsIgnoreCase(valorCarta2)){
                        cartasParDos2.add(ban2);
                    }
                }
            }

            //desempate(cartasParDos,lista);

        }

        if (hayParDos.equals(Boolean.TRUE) && hayParDos2.equals(Boolean.TRUE)){
            HashMap cartasvalor = cartasValor();
            Integer numero1=0;
            Integer numero2=0;
            int bander=1;
            for (int i = 0; i < cartasParDos.size()-1; i+=2) {
                String ban1 = cartasParDos.get(i);
                String valorCarta1 = ban1.substring(0, ban1.length() - 1);
                String ban2 = cartasParDos2.get(i);
                String valorCarta2 = ban2.substring(0, ban2.length() - 1);


                numero1= (Integer) cartasvalor.get(valorCarta1);
                numero2= (Integer) cartasvalor.get(valorCarta2);

                if (numero1>numero2){
                    manoGanadora.setWinnerHand(hand1);
                    manoGanadora.setWinnerHandType("OnePair");
                    array.add(cartasParDos.get(i));
                    array.add(cartasParDos.get(i+1));
                    manoGanadora.setCompositionWinnerHand(array);
                    return manoGanadora;

                }
                if (numero2>numero1){
                    manoGanadora.setWinnerHand(hand2);
                    manoGanadora.setWinnerHandType("OnePair");
                    array.add(cartasParDos2.get(i));
                    array.add(cartasParDos2.get(i+1));
                    manoGanadora.setCompositionWinnerHand(array);
                    return manoGanadora;
                }
                if ((numero1==numero2)){
                    desenpate1=desempate(cartasParDos,lista);
                    desenpate2=desempate(cartasParDos2,lista2);
                    parDosOrdenada= ordenar(desenpate1);
                    parDosOrdenada2= ordenar(desenpate2);

                    for (int j = 0; j < parDosOrdenada.size(); j++) {

                        String ban12 = parDosOrdenada.get(j);
                        String valorCarta12 = ban12.substring(0, ban12.length() - 1);
                        String ban22 = parDosOrdenada2.get(j);
                        String valorCarta22 = ban22.substring(0, ban22.length() - 1);


                        numero1= (Integer) cartasvalor.get(valorCarta12);
                        numero2= (Integer) cartasvalor.get(valorCarta22);



                        if (numero1>numero2){
                            manoGanadora.setWinnerHand(hand1);
                            manoGanadora.setWinnerHandType("OnePair");
                            array.add(ban12);
                            manoGanadora.setCompositionWinnerHand(array);
                            return manoGanadora;

                        }
                        if (numero2>numero1){
                            manoGanadora.setWinnerHand(hand2);
                            manoGanadora.setWinnerHandType("OnePair");
                            array.add(ban22);
                            manoGanadora.setCompositionWinnerHand(array);
                            return manoGanadora;

                        }


                    }


                }

            }


        }
        if ((hayParDos.equals(Boolean.TRUE) && hayParDos2.equals(Boolean.FALSE))){
            manoGanadora.setWinnerHand(hand1);
            manoGanadora.setWinnerHandType("OnePair");

            manoGanadora.setCompositionWinnerHand(cartasParDos);
            return manoGanadora;
        }
        if ((hayParDos.equals(Boolean.FALSE) && hayParDos2.equals(Boolean.TRUE))){
            manoGanadora.setWinnerHand(hand1);
            manoGanadora.setWinnerHandType("OnePair");

            manoGanadora.setCompositionWinnerHand(cartasParDos2);
            return manoGanadora;
        }
        if ((hayParDos.equals(Boolean.FALSE) && hayParDos2.equals(Boolean.FALSE))){

            return highCard.highCard(hand1, hand2);
        }











        return manoGanadora;

    }



    private HashMap<String, Integer> elementosPar(List<String> lista){
        int par1=1;
        HashMap<String, Integer> mapCarta = new HashMap<>();
        List<String> valor= new ArrayList<>();
        valor.add("2");
        valor.add("3");
        valor.add("4");
        valor.add("5");
        valor.add("6");
        valor.add("7");
        valor.add("8");
        valor.add("9");
        valor.add("10");
        valor.add("J");
        valor.add("Q");
        valor.add("K");
        valor.add("A");
        for (int i = 0; i < valor.size() ; i++) {
            for (int j = 0; j < lista.size(); j++) {
                String ban1 = lista.get(j);
                String valorCarta1 = ban1.substring(0, ban1.length() - 1);
                if (valor.get(i).equalsIgnoreCase(valorCarta1)){
                    // si existe
                    if (mapCarta.containsKey(valorCarta1)){
                        par1++;
                        mapCarta.put(valorCarta1, par1);
                    }
                    // si no existe
                    else  {
                        mapCarta.put(valorCarta1,1);
                    }

                }

            }
            par1=1;

        }


        return mapCarta;

    }

    public List<String> ordenar(List<String> desordenada){
        HashMap cartasvalor = cartasValor();
        Integer numero1=0;
        Integer numero2=0;
        for (int i = 0; i < desordenada.size()-1; i++) {
            for (int j = 0; j <desordenada.size()-1; j++) {

                String ban1 = desordenada.get(j);
                String valorCarta1 = ban1.substring(0, ban1.length() - 1);
                String ban2 = desordenada.get(j+1);
                String valorCarta2 = ban2.substring(0, ban2.length() - 1);
                numero1= (Integer) cartasvalor.get(valorCarta1);
                numero2= (Integer) cartasvalor.get(valorCarta2);
                if (numero1<numero2){
                    String aux = desordenada.get(j);
                    desordenada.set(j,desordenada.get(j+1));
                    desordenada.set(j+1,aux);
                }


            }
        }
        return desordenada;
    }


    private HashMap<String, Integer> cartasValor(){
        HashMap<String, Integer> cartasValor = new HashMap<>();
        cartasValor.put("2",2);
        cartasValor.put("3",3);
        cartasValor.put("4",4);
        cartasValor.put("5",5);
        cartasValor.put("6",6);
        cartasValor.put("7",7);
        cartasValor.put("8",8);
        cartasValor.put("9",9);
        cartasValor.put("10",10);
        cartasValor.put("J",11);
        cartasValor.put("Q",12);
        cartasValor.put("K",13);
        cartasValor.put("A",14);
        return cartasValor;
    }

    public List<String> desempate(List<String> manoPar,List<String> manoCompleta){

        for (int i = 0; i < manoPar.size(); i++) {
            String prueba=manoPar.get(i);
            manoCompleta.remove(prueba);


        }
        return manoCompleta;
    }
}