/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac_mon;

/**
 * PaC'MoN Project
 * @author Skyde
 */
public class PaC_MoN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean demo = true; //Afficher ou non la fenêtre de test "Démo"
        /* DEBUT Fenêtre Démo */
        if (demo) {
            Demo myDemo = new Demo();
            myDemo.setVisible(true);
            myDemo.setLocationRelativeTo(null);
        }
        /* FIN Fenêtre Démo */
        
        //test_Julien
        
    }
    
}
