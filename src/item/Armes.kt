package item
import jeu.TirageDes
import personnage.Personnage


class Armes (
    nom : String,
    description:String,
    val qualite: Qualite,
    val type : TypeArmes
):Item(nom,description){

    /**Une méthode qui permet de calculer les degat d'une arme
     * @return Int les degat de l'arme
     */
    fun calculerDegats(): Int{
        var degats = 0

        val de1 = TirageDes(this.type.nombresDes, this.type.valeurDeMax)
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
    override fun utiliser(cible: Personnage){

    }
}






