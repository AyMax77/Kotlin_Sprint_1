package Classes

import item.Armes
import item.Armure
import item.Item
import personnage.Personnage

class Voleur (nom: String,
              pointDeVie: Int,
              pointDeVieMax: Int,
              attaque: Int,
              defense: Int,
              endurance: Int,
              vitesse: Int,
              armePrincipal: Armes?,
              inventaire: MutableList<Item> = mutableListOf(),
              armure: Armure,
              ): Personnage(nom,pointDeVie,pointDeVieMax,attaque,defense,endurance,vitesse,inventaire,armePrincipal,armure) {
     fun voler(cible: Personnage){
         var tirage = (cible.inventaire.indices).random()
         var item = this.inventaire[tirage]
         if(item==cible.armePrincipal){
             cible.armure = null
             this.inventaire.add(item)
             println("${this.nom} a voler $item a ${cible.nom}")
         } else if (item == cible.armePrincipal){
             cible.armure = null
             this.inventaire.add(item)
             println("${this.nom} a voler $item a ${cible.nom}")
         } else {
             println("${this.nom} a rien dans son inventaire")
         }
     }
}
