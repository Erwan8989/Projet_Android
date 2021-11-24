<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['email']) && isset($_POST['mdp'])) {
    if ($db->dbConnect()) {
        if ($db->logIn("users", $_POST['email'], $_POST['mdp'])) {
            echo "Connexion réussit";
        } else echo "Email ou mot de passe faux";
    } else echo "Erreur: Inscription  à la base de donnée";
} else echo "Tout les champs sont requis";
?>
