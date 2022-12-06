package serveur;
import java.awt.Dimension;

import javax.swing.JFrame;

import serveur.PanelServeur;

public class FenetreServeur extends JFrame{
    PanelServeur ps;

    public FenetreServeur(){
        // ps = new PanelServeur()
        Dimension d = getToolkit().getScreenSize();
        setSize(d);
        setTitle("Client screen");
        setResizable(false);
        setVisible(true);
    }

    public PanelServeur getPs() {
        return ps;
    }

    public void setPs(PanelServeur ps) {
        this.ps = ps;
        this.add(ps);
    }
}
