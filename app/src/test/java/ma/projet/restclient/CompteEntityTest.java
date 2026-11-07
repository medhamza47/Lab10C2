package ma.projet.restclient;

import ma.projet.restclient.entities.Compte;
import ma.projet.restclient.entities.CompteList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CompteEntityTest {

    @Test
    public void testCompteGettersAndSetters() {
        Compte compte = new Compte();
        compte.setId(10L);
        compte.setSolde(1500.50);
        compte.setType("COURANT");
        compte.setDateCreation("2026-11-07");

        assertEquals(Long.valueOf(10L), compte.getId());
        assertEquals(1500.50, compte.getSolde(), 0.001);
        assertEquals("COURANT", compte.getType());
        assertEquals("2026-11-07", compte.getDateCreation());
        assertTrue(compte.toString().contains("1500.5"));
    }

    @Test
    public void testCompteListGettersAndSetters() {
        Compte c1 = new Compte(1L, 200.0, "COURANT", "2026-11-01");
        Compte c2 = new Compte(2L, 500.0, "EPARGNE", "2026-11-02");

        List<Compte> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);

        CompteList compteList = new CompteList();
        compteList.setComptes(list);

        assertNotNull(compteList.getComptes());
        assertEquals(2, compteList.getComptes().size());
        assertEquals(Long.valueOf(1L), compteList.getComptes().get(0).getId());
        assertEquals(Long.valueOf(2L), compteList.getComptes().get(1).getId());
    }
}

