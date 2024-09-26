package item

import jeu.TirageDes
import personnage.Personnage
import kotlin.math.min

/**
 *@param soin qui represente la restauration de santé du personnage
 *@param nompotion qui represente le nom de la potion qui sera utilisé
 * @param description
 *
 */

class Potions(  val soin :Int,
                val nompotion :String,
                 description :String,): Item(nompotion,description) {
    override fun utiliser(cible: Personnage){
        var pointDeVieTotal = cible.pointDeVie + this.soin
        pointDeVieTotal= min(cible.pointDeVieMax, pointDeVieTotal)

        cible.pointDeVie=pointDeVieTotal
    }
}