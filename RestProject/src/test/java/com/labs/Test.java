package com.labs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test {

    public static void main (String[] args){
        //cocorivo(check -> check, true);

        //Liste de voiture
        List<Voiture> listVoiture = new ArrayList<Voiture>();
        listVoiture.add(new Voiture("renault"));
        listVoiture.add(new Voiture("mercedes"));
        listVoiture.add(new VoitureSansPermis("bentley"));

        List<VoitureSansPermis> listVoitureSP = new ArrayList<VoitureSansPermis>();
        listVoitureSP.add(new VoitureSansPermis("fiat"));
        listVoitureSP.add(new VoitureSansPermis("peugeot"));


        affiche(listVoiture);
        affiche(listVoitureSP);
    }

    static void affiche(List<? extends Voiture> list){
        for(Voiture v : list)

            System.out.println(v.getMarque());

    }

    public static void cocorivo(Predicate<Boolean> validation, Boolean t){
        if(validation.test(t)){
            System.out.println("yes");
        }
    }

    public static class Voiture {

        private String marque;

        public Voiture(String marque) {
            this.marque = marque;
        }

        public String getMarque() {
            return marque;
        }

        public void setMarque(String marque) {
            this.marque = marque;
        }
    }

    public static class VoitureSansPermis extends Voiture{

        public VoitureSansPermis(String marque) {
            super(marque);
        }
    }
}
