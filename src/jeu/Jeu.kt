package jeu

import cotteDeMaille
import epeelongue
import hyper_potion
import personnage.Personnage
import item.Item
import item.Armes
import item.Armure
import item.Potions
import item.TypeArmure



class Jeu(monstres: List<Personnage>) {
    //Le personage du joueur
    lateinit var joueur: Personnage
    //La liste des monstre a combatre
     var combats: MutableList<Combat> = mutableListOf()
    //Le score
    var score: Int = 0

    // Corps du constructeur
    init {
        // Lancement de la création du personage du joueur
        this.creerPersonnage()
        // Pour chaque monstre dans la liste de monstres
        for (unMonstre in monstres){
            // On créer un combat
            val unCombat= Combat(this,unMonstre)
            combats.add(unCombat)
        }
    }

    fun lancerCombat() {
        for (unCombat in this.combats) {
            unCombat.executerCombat()
            // Mettre à jour le score en fonction du nombre de tours
            val tours = unCombat.nombreTours
            score += calculerScore(tours)
        }
        println("Score final du joueur: $score")
    }

    private fun calculerScore(tours: Int): Int {
        // Par exemple, vous pouvez attribuer plus de points pour moins de tours
        return 500 - tours * 10
    }

    /**
     *  Méthode pour créer le personnage du joueur en demandant les informations à l'utilisateur

     */
    fun creerPersonnage(): Personnage {
        println("Création de votre personnage:")
        var points = 40
        println("Veuillez rentrer votre nom: ")
       val futurNom= readln()!!.toString()
        /**
         * @r
         */
        do {
            println("Vous avez 40 points pour attaque,defense,endurance et vitesse")
            println("Veuillez rentrer votre: attaque: ")
            var Futurattaque= readln()!!.toInt()
            points -= Futurattaque
            if(points<0) points = 0
            println("Il vous reste $points")
            println("Veuillez rentrer votre defense: ")
            var FuturDef= readln()!!.toInt()
            points -= FuturDef
            if(points<0) points = 0
            println("Il vous reste $points")
            println("Veuillez rentrer votre endurance: ")
            var Futurendurance = readln()!!.toInt()
            points -= Futurendurance
            if(points<0) points = 0
            println("Il vous reste $points")
            println("Veuillez rentrer votre vitesse: ")
            var Futurvitesse= readln()!!.toInt()
            points -= Futurvitesse
            if(points<0) points = 0
            println("Il vous reste $points")
            var FuturPVMax = 50 + 10*Futurendurance
            val hero = Personnage(
                futurNom,
                FuturPVMax,
                FuturPVMax,
                Futurattaque,
                FuturDef,
                Futurendurance,
                Futurvitesse,
                mutableListOf(epeelongue, hyper_potion),
                epeelongue,
                cotteDeMaille,
                armurePrincipal = cotteDeMaille
            )
            this.joueur = hero
            return hero
        } while(points >= 0)

    }
    

}