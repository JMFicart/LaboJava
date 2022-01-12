package be.technifutur.gestioninscriptions;

public enum ListeMessage {

    Msg001(" existe déjà !"),
    Msg002(" pas trouvé !"),
    Msg003("Confirmez-vous la suppression de cet enregistrement ? (Y/N) "),
    Msg004("Ce n'est pas une option valide !"),
    Msg005("Saisir le nom de l'activité = "),
    Msg006("Saisir la nécessité d'une registration (Y/N) = "),
    Msg007("Type d'activité = "),
    Msg008("Registration    = "),
    Msg009("Nom de l'activité, Type d'activité, Date de début, Date de fin"),
    Msg010("Type d'activité, Registration"),
    Msg011("Nom de l'activité = "),
    Msg012("Type d'activité   = "),
    Msg013("Date de début     = "),
    Msg014("Date de fin       = "),
    Msg015("Il n'y a pas d'option = "),
    Msg016(" n'est pas numérique !"),
    Msg017("Menu principal"),
    Msg018("Gestion Activités"),
    Msg019("Gestion Horaires"),
    Msg020("Quitter"),
    Msg021("Créer un type d'activité"),
    Msg022("Chercher un type d'activité"),
    Msg023("Supprimer un type d'activité"),
    Msg024("Lister le fichier des activités"),
    Msg025("Créer un horaire"),
    Msg026("Modifier un horaire"),
    Msg027("Supprimer un horaire"),
    Msg028("Choix : "),
    Msg029("Lister le fichier des horaires"),
    Msg030("Le nom du type d'activité ne peut être nul !"),
    Msg031("Ce type d'activité n'existe pas ! "),
    Msg032("Saisir le nom de l'horaire = "),
    Msg033("Le nom de l'horaire ne peut être nul !"),
    Msg034("Saisir la date et l'heure de début (DD/MM/YYYY HH:MM) = "),
    Msg035("Mauvais format de date !");

    private String message ;

    private ListeMessage(String abreviation) {
        this.message = abreviation ;
    }

    public String getMsg() {
        return  this.message ;
    }
}