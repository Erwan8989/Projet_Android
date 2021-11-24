<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['email']) && isset($_POST['pseudo']) && isset($_POST['mdp'])) {
    if ($db->dbConnect()) {
        if ($db->signUp("users", $_POST['email'], $_POST['pseudo'], $_POST['mdp'])) {
            echo "Inscription  réussite";
        } else echo "Erreur de connexion àà la base donnéee";
    } else echo "Erreur: Inscription  à la base de donnée";
} else echo "Tout les champs sont requis";
?>
