package lab4;

import java.util.Arrays;
import java.util.Comparator;
import java.lang.*;



public class main {

    public static void main(String[] args) {
        Clothes[] cloth = new Clothes[4];

        cloth[0] = new Clothes( "jeans",  "trousers",  32,"jeans");
        cloth[1] = new Clothes(  "jacket",  "outwear",  48,"cashmere");
        cloth[2] = new Clothes(  "sneakers",  "shoes", 35,"leather");
        cloth[3] = new Clothes(  "jacket",  "outwear", 42,"wool");

        System.out.println("-----Basic Output-----\n");
        for (Clothes clothes: cloth) {
            System.out.println(clothes);
        }

        Arrays.sort(cloth, Comparator.comparing(Clothes::getName));

        System.out.println("\n---Sorting by name---\n");
        for (Clothes clothes : cloth){
            System.out.println(clothes.getName());
        }

        Arrays.sort(cloth, Comparator.comparing(Clothes::getSize).reversed());

        System.out.println("\n---Soted by size---");
        for (Clothes clothes : cloth) {
            System.out.println(clothes.getSize());
        }
    }

}
