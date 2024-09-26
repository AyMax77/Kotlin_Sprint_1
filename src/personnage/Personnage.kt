package personnage
import item.Armes
import item.Armure
import item.Item
// salutation les collègues
 class Personnage(
    val nom: String,
    var pointDeVie: Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    var inventaire : MutableList<Item> = mutableListOf(),
    var armePrincipal : Armes,
    var armure: Armure,
    var armurePrincipal: Armure
) {
     fun equiperArme(armes: Armes) {
         var arme = armes
         for (item in inventaire) {
             if (item == arme) {
                 this.armePrincipal = arme
             }
         }
     }

    fun equiperArmure(armures: Armure) {
        var armure = armures
        for (item in inventaire) {
            if (item == armure) {
                this.armurePrincipal = armure
            }
        }
    }

     fun calculeDefense():Int{
         defense = defense + armure.calculProtection()+this.defense/2
        return this.defense;
     }

     // Méthode pour attaquer un adversaire
     fun attaque(adversaire: Personnage) {
       var degats= this.attaque/2 + armePrincipal.calculerDegats()
         degats = degats - adversaire.calculeDefense()
         if(degats<=0) degats = 1
         adversaire.pointDeVie-=degats
         if (adversaire.pointDeVie == 0) {
             adversaire.pointDeVie=0
             println("${adversaire.nom} n'a plus de PV")
             return
         }
        println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")
    }

    override fun toString(): String {
        return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse)"
    }


}