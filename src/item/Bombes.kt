package item

import jeu.TirageDes
import personnage.Personnage

class Bombes {
    fun utiliser(cible: Personnage,armure: Armure,personnage: Personnage){
        val degats = TirageDes(3,8).lance()
        val nombombe = "Bombe"
        val description = "effets"
        val degatsTotal = degats - (armure.calculProtection() + personnage.defense )
    }

}