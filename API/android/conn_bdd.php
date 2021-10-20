<?php

$user = "root";
$pass = "";



    $bdd = new PDO('mysql:host=localhost;dbname=projet_android', $user, $pass);
   

    // try {
    //     $bdd = new PDO('mysql:host=localhost;dbname=projet_android', $user, $pass);
    //     foreach($bdd->query('SELECT * from utilisateur') as $row) {
    //         print_r($row);
    //     }
    //     $bdd = null;

    // } catch (PDOException $e) {
    //     print "Erreur !: " . $e->getMessage() . "<br/>";
    //     die();
    // }


    
?>