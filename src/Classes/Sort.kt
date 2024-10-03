package Classes
import jeu.TirageDes
import personnage.Personnage
import item.Item
import item.Armes
import item.Armure
import item.TypeArmes
import item.TypeArmure
import item.Qualite
import qualiteEpic
import qualiteCommun
import qualiteRare
import qualiteLegendaire
import typeEpeeLongue

class Sort(val nom:String,var effet:(Personnage, Personnage ) -> Unit) {


    val bouledefeu = Sort("Boule de Feu", { caster, cible ->
        run {
            val tirageDes = TirageDes(3, 6)
            var degat = tirageDes.lance()
            degat = maxOf(1, degat - cible.calculeDefense())
            cible.pointDeVie -= degat
            println("La boule de feu inflige $degat à ${cible.nom}")
        }
    })
    val missilemagique = Sort("Missile magique", { caster, cible ->
        run {
            var compteur = 0
            while(compteur <= 2){
                val tirageDes = TirageDes(1, 6)
                var degat = tirageDes.lance()
                degat = maxOf(1, degat - cible.calculeDefense())
                cible.pointDeVie -= degat
                println("Les missiles magiques infligent $degat à ${cible.nom}")
                compteur += 1
            }

        }
    })
    val invocationarme = Sort("Invocation arme magique", {caster, cible ->
        run {
            val aleatoire = TirageDes(1,20).lance()
            if(aleatoire <= 5){
                val epeecommun = Armes("Epée longue","Longue épée", qualiteCommun, typeEpeeLongue)
                cible.inventaire.add(epeecommun)
            }
            else if(aleatoire <= 10){
                val epeerare = Armes("Epée longue","Longue épée", qualiteRare, typeEpeeLongue)
                cible.inventaire.add(epeerare)
            }
            else if(aleatoire <= 15) {
                val epeeepic = Armes("Epée longue", "Longue épée", qualiteEpic, typeEpeeLongue)
                cible.inventaire.add(epeeepic)
            }else {
                val epeelegendaire = Armes("Epée longue", "Longue épée", qualiteLegendaire, typeEpeeLongue)
                cible.inventaire.add(epeelegendaire)
                println("Une arme magique a été rajouté à votre inventaire")
            }

        }
    })
}