package kivipaperisakset;

import java.util.Random;

/**
 *
 * Pelaaja-luokka, joka edustaa yhta pelissa pelaavaa pelaajaa.
 *
 * @author Jhon Rastrojo
 */
public class Pelaaja {

    private int voitot;      
    
    /** 
     * Pelaajan konstruktori joka alustaa voittojen maaran nollaksi.
     */
    public Pelaaja() { 
    	this.voitot = 0; 
    }

    /**
     * Metodi joka valitsee satunnaisesti kiven, paperin tai sakset.
     * @return pelaajan valitsema valinta
     */
    public String pelaajanSatunnainenValinta() {
        Random random = new Random();
        int valinta = random.nextInt(3);
        switch (valinta) {
            case 0: 
                return "kivi";
            case 1:
            	return "paperi";
            case 2: 
                return "sakset";
            default:
            	return "";
        }
    }

    /**
     * Metodi joka lisaa pelaajalle voiton.
     */
    public void lisaaVoitto() {
         voitot++;
    }

    /**
     * Metodi joka palauttaa pelaajan voittojen maaran.
     * @return pelaajan voittojen maara
     */
    public int getVoitot() {
        return voitot;
    }
}
