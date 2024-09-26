package item

import personnage.Personnage

/**
 * @param nom represente le nom de l'Item
 * @param description represente le nom de l'Item selectionner
 */
open class Item(val nom:String,val description:String){
    open fun utiliser(cible: Personnage){
        println("$nom ne peut pas être utilisé.")
    }

    override fun toString(): String {
        return "${nom}(nom = $nom, description = $description"
    }
}