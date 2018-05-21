/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac_mon.main;

import org.lwjgl.LWJGLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.glu.GLU;

import pac_mon.main.game.Game;


/**
 * Composant
 * @author Skyde
 */
public class Component {
    
    private boolean running; // etat du composant
    
    private final String title; // titre du composant
    public static int scale; // echelle d'affichage
    public static int width; // largeur du composant
    public static int height; // hauteur du composant
    
    public static int time; // temps (en ticks)
    private boolean tick; // creation d'un tick
    private boolean render; // creation d'une frame
    
    private final DisplayMode mode; // mode d'affichage
    
    private final Game game; // jeu
    
    /**
     * Construction du composant
     */
    public Component() {
        this.running = false;
        
        this.title = "PaC'MoN";
        Component.scale = 3;
        Component.width= 720 / Component.scale;
        Component.height = 480 / Component.scale;
        
        Component.time = 0;
        this.tick = false;
        this.render = false;
        
        this.mode = new DisplayMode(width*scale, height*scale);
        
        this.game = new Game();
    }
    
    /**
     * Permet de gerer l'affichage 2D
     * @param width : largeur de la fenetre
     * @param height : hauteur de la fenetre
     */
    private void view2D(int width, int height) {
        glViewport(0, 0, width * scale, height * scale);
        
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluOrtho2D(0, width, height, 0);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
    }
    
    /**
     * Permet d'afficher le composant
     */
    public void display() {
        /* Affiche le composant */
        try {
            Display.setDisplayMode(mode);
            Display.setResizable(true);
            Display.setFullscreen(true);
            Display.setTitle(title);
            Display.create();
        } catch (LWJGLException ex) {
            Logger.getLogger(Component.class.getName()).log(Level.SEVERE, null, ex); // erreur
        }        
    }
    
    /**
     * Permet de demarrer le composant
     */
    public void run() {
        display(); // affiche le composant
        running = true; // le composant est en etat de marche
        loop(); // boucle du composant
    }
    
    /**
     * Permet d'arreter le composant
     */
    public void stop() {
        Display.destroy();
        System.exit(0);
    }
    
    /**
     * Boucle du composant
     */
    private void loop() {
        game.init();
        
        long timer = System.currentTimeMillis(); // timer en ms
        
        long momentA = System.nanoTime(); // mesure de temps A
        long momentB; // mesure de temps B
        double elapsed; // temps ecoule entre les deux mesures
        
        double  ticksPerSecond = 60.0; // nombre de ticks par seconde
        double Second = Math.pow(10, 9); // 1 seconde en ns
        double timePerTick = Second / ticksPerSecond; // duree d'un tick
        
        int ticks = 0; // compteur de ticks
        int frames = 0; // compteur de frames
        
        /* Tant que le composant est en etat de marche */
        while(running) {
            if (Display.isCloseRequested()) {
                running = false;
            } else {
                Display.update(); // maintien l'affichage a jour
                width = Display.getWidth() / scale; // met a jour la largeur du composant
                height = Display.getHeight() / scale; // met a jour la hauteur du composant
                
                tick = false;
                render = false;
                
                momentB = System.nanoTime();
                elapsed = momentB - momentA; // met a jour le temps ecoule
                
                /* Si le temps ecoule est superieur a la duree d'un tick */
                if (elapsed > timePerTick) {
                    momentA += timePerTick;
                    tick = true; // creation d'un tick
                    ticks++; // on ajoute un tick au compteur
                } else {
                    render = true; // creation d'une frame
                    frames++; // on ajoute une frame au compteur
                }
                
                if (tick) {
                    onTick(); // on met a jour le temps
                }
                if (render) {
                    render(); // on effectue le rendu
                }
                
                /* Si 1 seconde s'est ecoule */
                if (System.currentTimeMillis() - timer > 1000) {
                    timer = System.currentTimeMillis(); // on reinitialise le timer
                    Display.setTitle(title+" | Ticks: "+ticks+" | FPS: "+frames); // on affiche les compteurs
                    ticks = 0; // on reinitialise le compteur de ticks
                    frames = 0; // on reinitialise le compteur de frames
                }
            }
        }
        stop(); // arrete le composant
    }
    
    /**
     * Incremente le temps (en ticks)
     */
    private void onTick() {
        time++;
        game.update();
    }
    
    /**
     * Permet d'afficher le rendu
     */
    private void render() {
        view2D(width, height); //gere l'affichage 2d
        glClear(GL_COLOR_BUFFER_BIT); // met a jour le rendu
        //--
        
        game.render();
    }
    
}
