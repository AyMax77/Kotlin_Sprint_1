import item.Qualite
import item.TypeArmes
import item.TypeArmure
import jeu.Jeu
import personnage.Personnage

//Création des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 3, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 4, "\u001B[33m")

//TODO Sprint 1 Mission 2A et 2B Création des types d'armes/armures
//Créations des types d'armes
val typedague = TypeArmes(1,4,3,18)
val typeBaton = TypeArmes(1,6,2,20)
val typeLance = TypeArmes(1,8,3,20)
val typeArbalete = TypeArmes(1,8,2,19)
val typeEpeeCourte = TypeArmes(1,6,2,19)
val typeHache = TypeArmes(1,6,3,20)
val typeEpeeLongue = TypeArmes(1,8,2,19)
val typeMarteauGuerre = TypeArmes(1,8,3,20)
val typeArcLong = TypeArmes(1,8,3,20)

//Créations des types armures
val typeRembourer = TypeArmure("Rembouré",1)
val typeCuir = TypeArmure("cuir",2)
val typeCuirClouté = TypeArmure("Cuir clouté",3)
val typeChemiseachaine = TypeArmure("Chemise à chaîne",4)
val typePectoral = TypeArmure("Pectoral",5)
val typeCotedemailles = TypeArmure("Cote de maille",6)
//TODO Sprint 2 : Création de sorts

fun main(args: Array<String>) {
    // TODO Intemission 4 : Création des items ( armes, armures potions, bombes )
    //TODO On ajoute les monstres a la liste de monstres du jeu
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
        "Lorc",
        pointDeVie = 40,
        pointDeVieMax = 40,
        attaque = 10,
        defense = 9,
        vitesse = 6,
        endurance = 8)

    val jeu = Jeu(listOf( gobelin,kobold,troll,orc))
    //Lancement du jeu
    jeu.lancerCombat()
}