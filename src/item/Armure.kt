package item

import personnage.Personnage

class Armure(nom:String,description:String,val qualite: Qualite,val type: TypeArmure) : Item(nom,description){
    fun calculProtection():Int{
        return type.BonusProtec + qualite.bonusRarete
    }

    override fun utiliser(cible: Personnage){

    }
}