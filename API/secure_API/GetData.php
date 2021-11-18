<?php

include_once "DataBase.php";

class GetData{}

$message = $_POST ['message'];
$date = $_POST ['date'];

$query = mysqli_query($con, "INSERT INTO test(text) values ('$message', '$date')");
if($query) {
    $response = new GetData();
    $response -> sucess = 1;
    $response -> message = "envoi réussi";
    die(json_encode($response));
}

else {

    $response = new GetData();
    $response -> sucess = 0;
    $response -> message = "Une error est apparu";
    die(json_encode($response));

}

mysqli_close ($con);


?>