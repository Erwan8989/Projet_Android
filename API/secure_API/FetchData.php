<?php 

include_once "DataBase.php";

// Récupération des données


$query = $connect -> prepare ("select * from user");
$query = execute();
$query = bind_result($id, $message, $date);
$data = array();

while ($query -> fetch()){
    $temp = array();
    $temp ['id'] = $id;
    $temp ['message'] = $message;
    $temp ['date'] = $date;
    array_push($data, $temp);
}

echo json_encode($data);


?>