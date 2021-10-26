<?php

$user = "root";
$pass = "";

    $bdd = new PDO('mysql:host=localhost;dbname=projet_android', $user, $pass);
    
    $insert= $bdd->prepare("INSERT INTO utilisateurs (pseudo, email, mdp) VALUES (:pseudo, :email, :mdp)");

    $insert->execute(array(
        ':pseudo' => $_GET["pseudo"],
        ':email' => $_GET["email"],
        ':mdp' => $_GET["mdp"]));

    if($bdd){
        echo("registered successfully");}
    else {
        echo("error in registration");}
    
?>