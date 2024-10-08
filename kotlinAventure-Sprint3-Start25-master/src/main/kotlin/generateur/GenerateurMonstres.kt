package generateur

import model.personnage.Personnage
import java.nio.file.Files
import java.nio.file.Paths
import armures
import armes


class GenerateurMonstres (val cheminfichier:String){

    fun generer(): MutableMap<String, Personnage> {
        val mapObjets = mutableMapOf<String, Personnage>()

        // Lecture du fichier CSV, le contenu du fichier est stocké dans une liste mutable :
        val cheminCSV = Paths.get(this.cheminfichier)
        val listeObjCSV = Files.readAllLines(cheminCSV)

        // Instance des objets :
        for (i in 1..listeObjCSV.lastIndex) {
            val ligneObjet = listeObjCSV[i].split(";")
            val cle = ligneObjet[0].lowercase()
            var inventaire = ligneObjet[8].split(",")
            val objet = Personnage(nom = ligneObjet[0], pointDeVie = ligneObjet[1].toInt(), pointDeVieMax = ligneObjet[2].toInt() ,attaque = ligneObjet[3].toInt() ,defense = ligneObjet[3].toInt() , endurance = ligneObjet[4].toInt() , vitesse = ligneObjet[5].toInt() , armeEquipee = armes[ligneObjet[6]], armureEquipe =  armures[ligneObjet[7]],inventaire = ligneObjet[8] ,
            mapObjets[cle] = objet
        }
        return mapObjets
    }
}
