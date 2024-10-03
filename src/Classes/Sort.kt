package Classes
import jeu.TirageDes
import personnage.Personnage
import item.Item

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
}