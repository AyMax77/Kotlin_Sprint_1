package personnage
import item.Armes
import item.Armure
import item.Bombes
import item.Item
import item.Potions

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
    var armePrincipal : Armes ?,
    var armure: Armure ?,

) {


     fun afficherInventaire(){
        println("Inventaire de : ${nom}")
         for(i in inventaire){
             var count = 0
             println("$i => ${inventaire[count]}")
             count += 1
         }
     }


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
                this.armure= armure
            }
        }
    }

     fun calculeDefense():Int{
         if(this.armure == null){
             return this.defense/2
         }
         else {
             defense = defense + armure!!.calculProtection() + this.defense / 2
             return this.defense;
         }
     }

    fun loot(adversaire: Personnage){
        if (adversaire.pointDeVie <= 0){
            this.inventaire.addAll(adversaire.inventaire)
            adversaire.armure = null
            adversaire.armePrincipal = null

        }
    }

     // Méthode pour attaquer un adversaire
     fun attaque(adversaire: Personnage) {
         var degat=0
       if( this.armePrincipal==null){
           degat=this.attaque/2
       }
         else {


           degat = this.attaque / 2 + armePrincipal!!.calculerDegats()
       }
         degat = degat - adversaire.calculeDefense()
         if(degat<=0) degat = 1
         adversaire.pointDeVie-=degat
         if (adversaire.pointDeVie == 0) {
             adversaire.pointDeVie=0
             println("${adversaire.nom} n'a plus de PV")
             return
         }
        println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degat points de dégâts.")
     }

    fun avoirPotion(): Boolean {
        for (item in this.inventaire) {
            if (item is Potions) {
                return true
            }
        }
        return false
    }

    fun avoirbombe(): Boolean {
        for (item in this.inventaire) {
            if (item is Bombes) {
                return true
            }
        }
        return false
    }

    fun boirePotion() {
        if (avoirPotion()) {
            var potions: MutableList<Potions> = mutableListOf()
            for (item in this.inventaire) {
                if (item is Potions) {
                    potions.add(item)
                }
            }
            println("Liste des potions")
            var i = 0
            for (unePotion in potions) {
                println("$i => ${unePotion.nom}")
            }
            println("Saisir la potion")
            var indexPotion = readln().toInt()
            var laPotion = potions[indexPotion]
            laPotion.utiliser(this)
        }
    }




    override fun toString(): String {
        return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse)"
    }


}