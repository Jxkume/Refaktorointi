package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import kivipaperisakset.Pelaaja;
import kivipaperisakset.Peli;

/**
 * Testiluokka KiviPaperiSakset projektille
 * 
 * @author Jhon Rastrojo
 */
public class PeliTest {

	 /**
     * Tama testi testaa paattyyko peli odotetusti, annettujen pelaajien voittojen perusteella.
     * @param voitotp1 pelaaja 1:n voittojen maara
     * @param voitotp2 pelaaja 2:n voittojen maara
     * @param odotettuTulos odotettu tulos: true jos peli paattyy, muuten false
     */
    @ParameterizedTest
    @MethodSource("testitapausGeneraattori")
    public void testOnkoPeliPaattynyt(int voitotp1, int voitotp2, boolean odotettuTulos) {
        Pelaaja p1 = new Pelaaja(); 
        Pelaaja p2 = new Pelaaja();

        for (int i = 0; i < voitotp1; i++) {
            p1.lisaaVoitto();
        }
        for (int i = 0; i < voitotp2; i++) {
            p2.lisaaVoitto();
        }

        assertEquals(odotettuTulos, Peli.onkoPeliPaattynyt(p1, p2));
    }

    /**
     * Metodi, joka tuottaa 3 erilaista testitapausta
     * @return Stream palauttaa testitapaukset
     */
    private static Stream<Object[]> testitapausGeneraattori() {
        return Stream.of(		
            // Eka muuttuja: pelaajan 1 voitot, Toka muuttuja: pelaajan 2 voitot, kolmas muttuja: odotettu tulos
            new Object[] { 3, 0, true },  // Pelaaja 1 voittaa
            new Object[] { 0, 3, true },  // Pelaaja 2 voittaa
            new Object[] { 2, 2, false }  // Tasapeli
        );
    }
    
    /**
     * Testaa palauttaako pelaajan satunnainen valinta odotetun arvon
     */
    @Test
    public void testPelaajanSatunnainenValinta() {
        Pelaaja pelaaja = new Pelaaja();
        String valinta = pelaaja.pelaajanSatunnainenValinta();
        assertNotNull(valinta);
        assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"));
    }
    
    /**
     * Testi testaa toimiiko voittojen lisaaminen odotetusti.
     */
    @Test
    public void testLisaaVoitto() {
        Pelaaja pelaaja = new Pelaaja();

        pelaaja.lisaaVoitto();
        assertEquals(1, pelaaja.getVoitot());

        pelaaja.lisaaVoitto();
        pelaaja.lisaaVoitto();
        assertEquals(3, pelaaja.getVoitot());
    }
    
    /**
     * Testaa toimiiko voittojen alustaminen odotetusti
     */
    @Test
    public void testGetVoitot() {
        Pelaaja pelaaja = new Pelaaja();

        assertEquals(0, pelaaja.getVoitot());
    }
    
}
