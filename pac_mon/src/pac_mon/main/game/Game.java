/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac_mon.main.game;

import pac_mon.main.game.level.Level;
import pac_mon.main.game.menu.Menu;
import static pac_mon.main.game.menu.Menu.Menus.*;

/**
 * Jeu
 * @author Skyde
 */
public class Game {
    
    private Menu menu;
    private Level level;
    
    /**
     * Construction du jeu
     */
    public Game() {
        this.level = new Level();
        this.menu = new Menu(GAME);
    }
    
    /**
     * Initialisation du jeu (avant la boucle component)
     */
    public void init() {
        //level.init();
        //menu.init();
    }
    
    /**
     * Mise a jour du jeu (a chaque tick)
     */
    public void update() {
        //level.update();
        //menu.init();
    }
    
    /**
     * Affiche le rendu du jeu (a chaque frame)
     */
    public void render() {
        if (Menu.menu == GAME) {
            level.render();  
        } else {
            menu.render();
        }
    }
    
}
