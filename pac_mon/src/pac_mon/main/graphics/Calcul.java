/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac_mon.main.graphics;

/**
 * Methodes de calculs
 * @author Skyde
 */
public class Calcul {
    
    /**
     * Retourne un nombre aleatoire compris entre min et max inclus
     * @param min : borne minimale
     * @param max : borne maximale
     * @return : le nombre aleatoire
     */
    public static float random(int min, int max) {
        return (float)(min + (Math.random() * (max - min) ));
    }
    
    /**
     * Retourne un nombre aleatoire compris entre min et max inclus
     * @param min : borne minimale
     * @param max : borne maximale
     * @return : le nombre aleatoire
     */
    public static float random(double min, double max) {
        return (float)(min + (Math.random() * (max - min) ));
    }
    
    /**
     * Retourne l'arrondi a l'entier le plus proche d'un nombre
     * @param nb : le nombre a traiter
     * @return : l'arrondi a l'entier le plus proche
     */
    public static int round(float nb) {
        return Math.round(nb);
    }
    
}
