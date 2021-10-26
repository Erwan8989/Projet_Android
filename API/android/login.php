<?php

$user = "root";
$pass = "";

    $bdd = new PDO('mysql:host=localhost;dbname=projet_android', $user, $pass);

$query = $bdd->prepare("SELECT * FROM utilisateurs WHERE email = ?");
$query->execute([$_POST['email']]);
$user = $query->fetch();

if ($user && password_verify($_POST['mdp'], $user['mdp']))
{
    echo "Identifiant valid!";
} else {
    echo "Identifiant invalid!";
}

// $servername="localhost";
// $mysql_user="root";
// $mysql_pass="";
// $dbname="projet_android";

// $conn=mysqli_connect($servername, $mysql_user, $mysql_pass, $dbname);
// if($conn){
//     echo("connection success");
// }else{
//     echo("connection not success");
// }


// $email=$_POST['email'];
// $pass_word=$_POST['password'];
// $query="SELECT 'email', 'password' FROM 'phprequest' WHERE email='$email' and password='$pass_word'";
// $result=mysqli_query($conn, $query);

// if(mysqli_num_rows($result) > 0){
//     echo("login success");
// }else{
//     echo("login failed");
// }


?>