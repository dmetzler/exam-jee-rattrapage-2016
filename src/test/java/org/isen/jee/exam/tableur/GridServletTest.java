package org.isen.jee.exam.tableur;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.isen.jee.exam.tableur.harness.JettyHarness;
import org.junit.Test;

public class GridServletTest extends JettyHarness {

	/**
     * En implémentant la méthode `doGet()` faire en sorte que la servlet
     * affiche la valeur d'une cellule
     *
     * GET http://localhost:9090/grid?cell=A1
     *
     * @throws Exception
     */
    @Test
    public void une_cellule_vide_renvoie_une_valeur_vide() throws Exception {
        assertEquals("", get(getServletUri()+"?cell=A1"));
    }

    /**
     * En implémentant la méthode `doPut()` faire en sorte que la servlet
     * fixe la valeur d'un cellule
     *
     * POST http://localhost:9090/grid?cell=A1&value="valeur"
     *
     * @throws Exception
     */
    @Test
    public void on_peut_fixer_une_valeur_de_cellule() throws Exception {
    	setValue("A1", "valeur");
        assertEquals("valeur", get(getServletUri()+"?cell=A1"));
    }


    /**
     * En implémentant la méthode `doDelete()` faire en sorte que la servlet
     * supprime la valeur d'une cellule
     *
     * DELETE http://localhost:9090/grid?cell=A1
     *
     * @throws Exception
     */
    @Test
    public void on_peut_supprimer_un_valeur() throws Exception {
    	setValue("A1","valeur");
    	setValue("A2","valeur2");

        assertEquals("valeur", get(getServletUri()+"?cell=A1"));
        assertEquals("valeur2", get(getServletUri()+"?cell=A2"));

        delete(getServletUri()+"?cell=A1");

        assertEquals("", get(getServletUri()+"?cell=A1"));
        assertEquals("valeur2", get(getServletUri()+"?cell=A2"));

    }




    /**
     * En modifiant la méthode `doPut()` faire en sorte que la servlet
     * incrémente termine la partie pour la requête suivante :
     *
     * PUT http://localhost:9090/grid?cell=A3&eval=true
     *
     * @throws Exception
     */
    @Test
    public void on_peut_evaluer_la_valeur_dune_cellule() throws Exception {
    	setValue("A1","1");
    	setValue("A2","3");
    	setValue("A3","=A1+A2");
    	assertEquals("4", get(getServletUri()+"?cell=A3&eval=true"));
    	assertEquals("=A1+A2", get(getServletUri()+"?cell=A3"));

    }




	/**
     * En implémentant la méthode doDelete() faire en sorte que la servlet
     * réintialise le jeu pour la requête suivante :
     *
     * DELETE http://localhost:9090/grid
     *
     * @throws Exception
     */
    @Test
    public void on_peut_reinitialiser_la_grille_globalement() throws Exception {
    	setValue("A1","1");
    	setValue("A2","3");
    	delete(getServletUri());
    	assertEquals("", get(getServletUri()+"?cell=A1"));
    	assertEquals("", get(getServletUri()+"?cell=A2"));

    }


    private void setValue(String cellAddress, String value) {
		Map<String, String> params = new HashMap<>();
        params.put("cell", cellAddress);
        params.put("value", value);
        put(getServletUri(), params);
	}




    private String getServletUri() {
        return getBaseUri() + "/grid";
    }



}
