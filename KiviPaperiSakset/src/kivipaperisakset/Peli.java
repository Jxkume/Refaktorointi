package kivipaperisakset;

/**
 *
 * KiviPaperiSakset -pelin paaluokka, joka sisaltaa pelin logiikan ja toiminnallisuuden
 *
 * @author Jhon Rastrojo
 */
public class Peli {


    private static final int VOITTOKYNNYS = 3;
    private static int tasapelit = 0;
    
    
    /**
     * Paametodi, joka kaynnistaa pelin.
     * @param args komentorivin argumentit (ei kayteta tassa pelissa)
     */
    public static void main(String args[]) {
 
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja(); 

        boolean peliLoppui = false; 
        int pelatutPelit = 0;

        do {
            pelatutPelit++;
            pelaaEra(p1, p2, pelatutPelit);
            if (onkoPeliPaattynyt(p1, p2)) {
                peliLoppui = true;
            }
        } while (!peliLoppui);
    }

    /**
     * Metodi, joka pelaa yhden eran kivi-paperi-sakset -pelia.
     * @param p1 Pelaaja 1
     * @param p2 Pelaaja 2
     * @param pelatutPelit Pelattujen pelien maara
     */
    public static void pelaaEra(Pelaaja p1, Pelaaja p2, int pelatutPelit) {
    	
        System.out.println("\nErä: " + pelatutPelit + " ==============================\n");
        System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");
        
        String p1Valinta = p1.pelaajanSatunnainenValinta(); 
        String p2Valinta = p2.pelaajanSatunnainenValinta();
        
        System.out.println("Pelaaja 1: " + p1Valinta + "\n");
        System.out.println("Pelaaja 2: " + p2Valinta + "\n");

        if (p1Valinta.equals(p2Valinta)) {
            tasapelit++;
            System.out.println("\n\t\t\t Tasapeli \n");
        } else if ((p1Valinta.equals("kivi") && p2Valinta.equals("sakset")) ||
                (p1Valinta.equals("paperi") && p2Valinta.equals("kivi")) ||
                (p1Valinta.equals("sakset") && p2Valinta.equals("paperi"))) {
            System.out.println(" --- Pelaaja 1 voittaa\n");
            p1.lisaaVoitto();
        } else {
            System.out.println(" --- Pelaaja 2 voittaa\n");
            p2.lisaaVoitto();
        }
        
        System.out.println("Pelaaja 1:lla on " + p1.getVoitot() + " voittoa.");
        System.out.println("Pelaaja 2:lla on " + p2.getVoitot() + " voittoa.");

    }
    
    /**
     * Metodi, joka tarkistaa onko peli paattynyt.
     * @param p1 Pelaaja 1
     * @param p2 Pelaaja 2
     * @return true, jos jompikumpi pelaajista on saavuttanut voittokynnyksen, muuten false
     */
    public static boolean onkoPeliPaattynyt(Pelaaja p1, Pelaaja p2) {
        if (p1.getVoitot() == VOITTOKYNNYS || p2.getVoitot() == VOITTOKYNNYS) {
            System.out.println("\nKOLME VOITTOA - PELI PÄÄTTYY");
            if (p1.getVoitot() == VOITTOKYNNYS) {
                System.out.println("\nPelaaja 1 VOITTAA");
            } else {
                System.out.println("\nPelaaja 2 VOITTAA");
            }
            return true;
        }
        return false;
    }

}

