package Classes

import item.Armes
import item.Armure
import item.Item
import personnage.Personnage

class Mage (nom: String,
            pointDeVie: Int,
            pointDeVieMax: Int,
            attaque: Int,
            defense: Int,
            endurance: Int,
            vitesse: Int,
            inventaire : MutableList<Item> = mutableListOf(),
            armePrincipal : Armes ?,
            armure: Armure ?,
    val grimoire : MutableList<Sort>): Personnage(nom,pointDeVie,pointDeVieMax,attaque,defense,endurance,vitesse,inventaire,armePrincipal,armure) {

    override fun toString(): String {
        return "Mage ${super.toString()} (grimoreEquipe = $grimoire"
    }
            }

