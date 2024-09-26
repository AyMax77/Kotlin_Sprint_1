import item.Qualite
import jeu.Jeu
import personnage.Personnage

//Créattion des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")

//TODO Sprint 1 Mission 2A et 2B Création des types d'armes/armures

//TODO Sprint 2 : Création de sorts

fun main(args: Array<String>) {
    // TODO Intemission 4 : Création des items ( armes, armures potions, bombes )

    //Création des monstres
    val gobelin = Personnage(
        "Gob le gobelin",
        pointDeVie = 20,
        pointDeVieMax = 20,
        attaque = 5,
        defense = 4,
        vitesse = 11,
        endurance = 6)
    val kobold = Personnage(
        "Kob le Kobold",
        pointDeVie = 10,
        pointDeVieMax = 10,
        attaque = 4,
        defense = 4,
        vitesse = 11,
        endurance = 6)
    val troll = Personnage(
        "Groll",
        pointDeVie = 80,
        pointDeVieMax = 80,
        attaque = 15,
        defense = 10,
        vitesse = 5,
        endurance = 10)
    val orc = Personnage(
        "Morc",
        pointDeVie = 40,
        pointDeVieMax = 40,
        attaque = 10,
        defense = 9,
        vitesse = 6,
        endurance = 8)


    // TODO Intermission 1 : Ajouter d'autres monstres

    //TODO On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( gobelin,kobold,troll,orc))
    //Lancement du jeu
    jeu.lancerCombat()
}