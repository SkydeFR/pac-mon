/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac_mon.main.game;

import static org.lwjgl.opengl.GL11.glClearColor;
import pac_mon.main.graphics.Renderer;

/**
 *
 * @author Skyde
 */
public class Level {
    
    public Level() {
        
    }
    
    public void init() {
        
    }
    
    public void update() {
        
    }
    
    public void render(int time) {
        glClearColor(0.2f, 0.2f, 0.2f, 1.0f); // met a jour le background
        
        /** DEBUT TEST TEMPORAIRE **/
        int spd1 = (int)(time / 1.9);
        int spd2 = (int)(time / 2.4);
        float[] orange = new float[]{1.0f, 0.5f, 0.0f, 1.0f};
        float[] rouge = new float[]{1.0f, 0.0f, 0.0f, 1.0f};
        
        Renderer.renderQuad(30+spd2, 30+spd2, 16, 16, orange);
        Renderer.renderQuad(67+spd1, 22+spd1, 16, 16, rouge);
        /** FIN TEST TEMPORAIRE **/
    }
}
