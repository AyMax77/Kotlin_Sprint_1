package item
import jeu.TirageDes
import personnage.Personnage


class Armes (
    val nom : String,
    val qualite: Qualite,
    val type : TypeArmes
){
    fun calculerDegats(): Int{
        var degats = 0

        val de1 = TirageDes(1, 8)
        val tirage1 = de1.lance()
        val de2 = TirageDes(1,20)
        val tirage2 = de2.lance()
        if (tirage2 > this.type.activationCritique){
            degats = tirage2 * this.type.multiplicateurcritique
            println("Coup critique")
        } else{
            degats = tirage2
        }
        degats = degats + this.qualite.bonusRarete

        return degats
    }
    fun utiliser(cible: Personnage){

    }
}






