
    <?php
    define('HOST','localhost');
    define('USER','id5054141_sahilpratap7200');
    define('PASS','sahil173573');
    define('DB','id5054141_emp_record');
     
    $con = mysqli_connect(HOST,USER,PASS,DB);
     
    $sql = "select * from emp_record";

    $res = mysqli_query($con,$sql);
     
    $result = array();
     
    while($row = mysqli_fetch_array($res))
{
    array_push($result,
    array('id'=>$row[0],
    'userName'=>$row[1],
    'email'=>$row[2],
    'password'=>$row[3]
    ));
    }
    echo json_encode(array("result"=>$result));
     
    mysqli_close($con);
    ?> 
	
	
	