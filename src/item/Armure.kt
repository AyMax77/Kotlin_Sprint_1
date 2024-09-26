package item

import personnage.Personnage

class Armure(val nom:String,val description:Int,val qualite: Qualite,val type: TypeArmure) {
    fun calculProtection():Int{
        return type.BonusProtec + qualite.bonusRarete
    }

    fun utiliser(cible: Personnage){

    }
}