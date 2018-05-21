/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac_mon.main.graphics;

import static org.lwjgl.opengl.GL11.*;

/**
 * Rendu
 * @author Skyde
 */
public class Renderer {

    /**
     * Cree un carre
     * @param x : coordonne x
     * @param y : coordonne y
     * @param w : largeur w
     * @param h : hauteur h
     * @param c : couleur
     */
    public static void quadData(int x, int y, int w, int h, float[] c) {
        glColor4f(c[0], c[1], c[2], c[3]);
        glVertex2f(x, y); //haut gauche
        glVertex2f(x+w, y); //haut droit
        glVertex2f(x+w, y+h); //bas droit
        glVertex2f(x, y+h); //bas gauche
    }
    
    /**
     * Dessine un carre
     * @param x : coordonne x
     * @param y : coordonne y
     * @param w : largeur w
     * @param h : hauteur h
     * @param c : couleur
     */
    public static void renderQuad(int x, int y, int w, int h, float[] c) {
        glBegin(GL_QUADS);
            Renderer.quadData(x, y, w, h, c); // donnees du carre
        glEnd();
    }
}
