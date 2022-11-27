<?php

$hostName='localhost';
$userName='root';
$userPass='';
$dbName='userdata';

$con=mysqli_connect($hostName,$userName,$userPass,$dbName);

    

    $formnumber=$_POST['formnumber'];
    $password=md5($_POST['password']);

        
    
    $checkUser="SELECT * FROM form WHERE formnumber = '$formnumber'";
    $result=mysqli_query($con,$checkUser);
    
    if(mysqli_num_rows($result)>0){
        
        $checkUserquery="SELECT formnumber FROM form WHERE formnumber='$formnumber' and password='$password'";
        $resultant=mysqli_query($con,$checkUserquery);

        if(mysqli_num_rows($resultant)>0){
            while($row=$resultant->fetch_assoc())
                $response['form']=$row;
                $response['error']="200";
                $response['message']="login successfully";
            

        }
        else{
            $response['form']=(object)[];
            $response['error']="400";
        $response['message']="invalid details";
        }
       
    }
    else{
        $response['form']=(object)[];
         $response['error']="400";
        $response['message']="user does not exist";
    }

    
echo json_encode($response);

?>
