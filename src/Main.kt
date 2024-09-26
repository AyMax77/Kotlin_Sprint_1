import item.Armes
import item.Armure
import item.Bombes
import item.Potions
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
//Créations des armes
val arclong = Armes("Arc long", "Arc long",qualiteCommun,typeArcLong)
val arbaletelegere = Armes("Arbalète légère","Arbalète pas très lourde",qualiteCommun, typeArbalete)
val epeecourte = Armes("Epée courte","Une petite épée", qualiteCommun,typeEpeeCourte)
val marteauguerre = Armes("Marteau de guerre","Gros marteau", qualiteCommun,typeMarteauGuerre)
val lance = Armes ("Lance","Lance",qualiteCommun,typeLance)
val hache = Armes("Hache","Hache à 2 mains", qualiteCommun,typeHache)
val dague = Armes("Dague", "Dague", qualiteCommun,typedague)
val baton = Armes("Bâton", "Long bâton", qualiteCommun,typeBaton)
val epeelongue = Armes("Epee Longue","Longue épée", qualiteCommun,typeEpeeLongue)

//Créations des types armures
val typeRembourer = TypeArmure("Rembouré",1)
val typeCuir = TypeArmure("cuir",2)
val typeCuirClouté = TypeArmure("Cuir clouté",3)
val typeChemiseachaine = TypeArmure("Chemise à chaîne",4)
val typePectoral = TypeArmure("Pectoral",5)
val typeCotedemailles = TypeArmure("Cote de maille",6)

//Créations des armures
val Rembourer = Armure("Armure Rembourer","Rembourer",qualiteCommun,typeRembourer)
val Cuir = Armure("Armure en cuir","C'est du cuir",qualiteCommun,typeCuir)
val CuirCloute = Armure("Armure en cuir clouté","C'est du cuir avec des clous",qualiteRare,typeCuirClouté)
val ChemiseAChaine = Armure("Chemise Dragon","Magnifique chemise avec des Dragons",qualiteLegendaire,typeChemiseachaine)
val Pectoral = Armure("Développé couché","Ca pousse à la salle !!",qualiteEpic,typePectoral)
val cotteDeMaille = Armure("Cotte de maille","Armure portée par les chevalier",qualiteEpic,typeCotedemailles)

//Création des bombes
val incendiaire = Bombes("Incendiaire",4,6,"Une flasque qui contient un liquide inflammable.")
val flasque_dacide = Bombes("Flasques d'acide",2,8,"Une flasque qui contient une puissante substance corrosive.")
val grenade = Bombes("Grenade",5,6,"Un bidule qui explose une fois lancé.")

val potion = Potions(25,"Potion","Potion qui s'applique en spray")
val super_potion = Potions(50,"Super Potion","Potion qui s'applique en paumade et qui rend 50 pv")
val hyper_potion = Potions(75,"Hyper potion","Potion qui se boit qui rend 75 pv")
val potion_Max = Potions(500,"Potion Max", "Potion qui rend la totalité des PV en sniffant une poudre")
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
        endurance = 6,
        inventaire = mutableListOf(dague,),
        armePrincipal = epeelongue,
        armure = cotteDeMaille,
        armurePrincipal = cotteDeMaille)
    val kobold = Personnage(
        "Kob le Kobold",
        pointDeVie = 10,
        pointDeVieMax = 10,
        attaque = 4,
        defense = 4,
        vitesse = 11,
        endurance = 6,
        inventaire = mutableListOf(hache),
        armePrincipal = hache,
        armure = Cuir,
        armurePrincipal = Cuir)
    val troll = Personnage(
        "Groll",
        pointDeVie = 80,
        pointDeVieMax = 80,
        attaque = 15,
        defense = 10,
        vitesse = 5,
        endurance = 10,
        inventaire = mutableListOf(arclong),
        armePrincipal = arclong,
        armure = CuirCloute,
        armurePrincipal = CuirCloute)
    val orc = Personnage(
        "Lorc",
        pointDeVie = 40,
        pointDeVieMax = 40,
        attaque = 10,
        defense = 9,
        vitesse = 6,
        endurance = 8,
        inventaire = mutableListOf(marteauguerre),
        armePrincipal = marteauguerre,
        armure = Pectoral,
        armurePrincipal = Pectoral)

    val jeu = Jeu(listOf(gobelin,kobold,troll,orc))
    //Lancement du jeu
    jeu.lancerCombat()
}