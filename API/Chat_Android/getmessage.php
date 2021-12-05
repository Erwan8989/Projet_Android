<?php
require "DataBase.php";
$db = new DataBase();

    $db->dbConnect();
    $db->getData('messages');
