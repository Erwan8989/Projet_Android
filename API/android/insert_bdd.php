<?php


    include ("conn_bdd.php");

    $insert= $bdd->prepare("INSERT INTO utilisateur (pseudo, mail, mdp) VALUES (:pseudo, :mail, :mdp)");

    $insert->execute(array(
        ':pseudo' => $_GET["pseudo"],
        ':mail' => $_GET["mail"],
        ':mdp' => $_GET["mdp"]));
    

    

