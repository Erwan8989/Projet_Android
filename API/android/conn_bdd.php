<?php
$user = "root";
$pass = "";



    $bdd = new PDO('mysql:host=localhost;dbname=projet_android', $user, $pass);
    
    $insert= $bdd->prepare("INSERT INTO utilisateurs (pseudo, mail, mdp) VALUES (:pseudo, :mail, :mdp)");

    $insert->execute(array(
        ':pseudo' => $_GET["pseudo"],
        ':mail' => $_GET["mail"],
        ':mdp' => $_GET["mdp"]));

    
        if(isset($_SERVER['HTTPS']) && $_SERVER['HTTPS'] === 'on')
        {
            $url = "https";
        }
        else
        {
            $url = "http"; 
        }  
        $url .= "://"; 
        $url .= $_SERVER['HTTP_HOST']; 
        $url .= $_SERVER['REQUEST_URI']; 
        echo $url;

        
?>