<?php
$con=mysqli_connect("localhost","id5054141_sahilpratap7200","sahil173573",
"id5054141_emp_record")or die("connection not successfull");

mysqli_select_db($con,"id5054141_emp_record")or die("database not found");

if(isset($_POST['userName']) && isset($_POST['email']) && isset($_POST['password']))
{

$userName=$_POST['userName'];
$email=$_POST['email'];
$pass=$_POST['password'];

$qry="insert into emp_record (userName,email,password) values('$userName','$email','$pass')";

mysqli_query($con,$qry)or die("Query Problem");
}
else
{
echo "waiting for data...";
}
?>