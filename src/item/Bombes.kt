package item

import jeu.TirageDes
import personnage.Personnage

/**
 * @param nom qui represente le nom de la bombe qui sera utilisée.
 * @param maxDes est la representation du nombre de face avec les dés.
 * @param description est un texte qui represente les information correspondante aux differentes bombes qui seront utilisée
 * @param nombreDes est le nombre de dés utilisé
 */

class Bombes(nom:String,var nombreDes: Int,var maxDes: Int,description: String): Item(nom,description){
    override fun utiliser(cible: Personnage){
        val degats = TirageDes(3,8).lance()
        val degatsTotal = degats - ( cible.calculeDefense() )
    }
}