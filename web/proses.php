<?php

				
				$hashtag	=	$_POST['hashtag'];
				$keyword1	=	$_POST['keyword1'];
				$keyword2	=	$_POST['keyword2'];
				$keyword3	=	$_POST['keyword3'];
				$algoritma	=	$_POST['algoritma'];
				
				$handle	=	 fopen("input.txt","w");
				fwrite($handle,"$hashtag\n");
				fwrite($handle,"$keyword1\n");
				fwrite($handle,"$keyword2\n");
				fwrite($handle,"$keyword3\n");
				fwrite($handle,"$algoritma\n");
				fclose($handle);
	//header("Location: index.php");
?>