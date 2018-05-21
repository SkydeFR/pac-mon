/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac_mon.main.game.menu;

import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author Skyde
 */
public class Menu {
    
    public static Menus menu;
    
    /**
     * Liste des différents menus
     */
    public enum Menus {

        /**
         * Menu principal
         */
        PRINCIPAL,
        
        /**
         * Le jeu
         */
        GAME
    }
    
    public Menu(Menus _menu) {
        Menu.menu = _menu;
    }
    
    
    /**
     * Initialisation du menu (avant la boucle component)
     */
    public void init() {
        
    }
    
    /**
     * Mise a jour du menu (a chaque tick)
     */
    public void update() {
        
    }
    
    /**
     * Affiche le menu (a chaque frame)
     */
    public void render() {
        switch (menu) {
            case PRINCIPAL :
                // Afficher menu principal
                glClearColor(0.2f, 0.2f, 0.6f, 1.0f); // met a jour le background
                
                // si on appuie sur le bouton "nouvelle partie"
                if (false) {
                    menu = Menus.GAME;
                }
                break;
            default :
                System.out.println("Type de menu non implémenté");
        }
    }
    
}
