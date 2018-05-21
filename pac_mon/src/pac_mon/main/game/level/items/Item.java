/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac_mon.main.game.level.items;

import pac_mon.main.Component;
import pac_mon.main.graphics.Renderer;
import static pac_mon.main.graphics.Calcul.*;

/**
 * Item
 * @author Skyde
 */
public class Item {
    
    private final int x, y;
    private final double xSpeed, ySpeed;
    private final int size;
    private final float[] color;
    
    private Items item;
    
    /**
     * Liste des différents type d'items
     */
    public enum Items {

        /**
         * Les consommables basiques
         */
        DOT,

        /**
         * Les consommables bonus
         */
        FRUIT,

        /**
         * Les consommables avec effet
         */
        POWER
    }
    

    /**
     * Construction d'un item immobile avec type prédéfini
     * @param _x : coordonne x de l'item
     * @param _y : coordonne y de l'item
     * @param _item : type d'item
     */
    public Item(int _x, int _y, Items _item) {
        this.x = _x;
        this.y = _y;
        this.xSpeed = 0;
        this.ySpeed = 0;
        this.item = _item;
        
        switch (item) {
            case DOT :
                this.size = 3;
                this.color = new float[]{1.0f, 1.0f, 0.0f, 1.0f};
                break;
            case FRUIT :
                this.size = 6;
                this.color = new float[]{1.0f, 0.0f, 0.0f, 1.0f};
                break;
            case POWER :
                this.size = 4;
                this.color = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
                break;
            default:
                this.size = 16;
                this.color = new float[]{1, 1, 1, 1};
        }
    }
    
    /**
     * Construction d'un item en mouvement (pour faire des tests)
     * @param _x : coordonne x de l'item
     * @param _y : coordonne y de l'item
     * @param _xSpeed : valeur de la vitesse en x de l'item
     * @param _ySpeed : valeur de la vitesse en y de l'item
     * @param _size : taille de l'item
     */
    public Item(int _x, int _y, double _xSpeed, double _ySpeed, int _size) {
        this.x = _x;
        this.y = _y;
        this.xSpeed = _xSpeed;
        this.ySpeed = _ySpeed;
        this.size = _size;
        this.item = null;

        this.color = new float[]{random(0,1), random(0,1), random(0,1), 1}; // couleur aleatoire
    }
    
    /**
     * Affiche le rendu de l'item
     */
    public void render() {
        int myX, myY;
        
        if (item != null) {
            /* Item immobile : coordonnes fixes */
            myX = x;
            myY = y;
        } else {
            /* Item en mouvement : on prend en compte la vitesse */
            myX = x + (int)(Component.time * xSpeed);
            myY = y + (int)(Component.time * ySpeed);           
        }
        
        boolean isOnScreen = (myX+size > 0 && myY+size > 0 && myX < Component.width && myY < Component.height); // si l'item est au moins partiellement sur l'ecran
        
        if (isOnScreen) {
            Renderer.renderQuad(myX, myY, size, size, color); // on fait le rendu de l'item
        }
    }
    
}
