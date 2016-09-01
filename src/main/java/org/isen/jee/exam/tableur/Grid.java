package org.isen.jee.exam.tableur;


public interface Grid {

	/**
	 * Fixe la valeur d'une cellule en fonction de l'adresse.
	 * @param cellAddress
	 * @param value
	 */
	void setValue(String cellAddress, String value);

	/**
	 * Récupère la valeur d'une cellule en fonction de son adresse.
	 * @param cellAddress
	 * @return
	 */
	String getValue(String cellAddress);

	/**
	 * Supprimer la valeur d'une cellule.
	 * @param cellAddress
	 */
	void delete(String cellAddress);

	/**
	 * Retourne le type d'une cellule.
	 * @param string
	 * @return
	 */
	CellType getType(String string);

	/**
	 * Evalue la valeur d'une cellule. Dans le cas d'un nombre, renvoie
	 * la valeur de ce nombre, dans le cas d'une formule on
	 * évalue la formule.
	 * @param string
	 * @return
	 */
	Integer eval(String string);

}
