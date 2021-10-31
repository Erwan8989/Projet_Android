<?php

require "DataBase.php";

$db = new DataBase();
if (isset($_POST['email']) && isset($_POST['password']) && isset($_POST['pseudo'])) {
    if ($db->dbConnect()) {
        if ($db->signUp("utilisateurs", $_POST['email'], $_POST['password'] ,$_POST['pseudo'])) {
            echo "Sign Up Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";

?>
