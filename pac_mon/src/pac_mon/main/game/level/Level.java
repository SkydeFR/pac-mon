/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac_mon.main.game.level;

import java.util.ArrayList;
import static org.lwjgl.opengl.GL11.glClearColor;
import pac_mon.main.Component;
import pac_mon.main.game.level.items.Item;
import static pac_mon.main.game.level.items.Item.Items.*;
import static pac_mon.main.graphics.Calcul.*;

/**
 * Niveau
 * @author Skyde
 */
public class Level {
    
    private ArrayList<Item> items; // liste des items du niveau
    
    /**
     * Constructeur du niveau
     */
    public Level() {
        this.items = new ArrayList<>();
        
        generate(); // on genere le niveau
    }
    
    /**
     * Generation du niveau
     */
    public void generate() {
        
        boolean test = true;
        
        if (test) {
            /* Test de génération d'items en mouvement */
            int width = Component.width*Component.scale-88;
            int height = Component.height*Component.scale-149;
            int size;
            for (int i=0; i<10000; i++) {
                size = round(random(1,10));
                items.add(new Item(round(random(0, width)), round(random(0, height)), random(-2,2), random(-2,2), size));
            }
        } else {
            items.add(new Item(25, 25, DOT));
            items.add(new Item(60, 30, FRUIT));
            items.add(new Item(40, 50, POWER));
        }
        
    }
    
    /**
     * Initialisation du niveau
     */
    public void init() {
        
    }
    
    /**
     * Mise a jour du niveau
     */
    public void update() {
        
    }
    
    /**
     * Affiche le rendu du niveau
     */
    public void render() {
        glClearColor(0.2f, 0.2f, 0.2f, 1.0f); // met a jour le background
        
        for (Item item : items) {
            item.render(); // affiche le rendu des items
        }
    }
}
