<?php
	include("connect.php");
	$hasil	=	 mysql_query("SELECT no,judul FROM artikel");
	if(!$_GET['state']){
		header("Location: manage.php?state=manage");
	}
	switch ($_GET['state']){
		case "editor" : 
						$nomor	=	$_GET['id'];
						$hasil=mysql_query("SELECT * FROM artikel where no=$nomor");
						while($baris=mysql_fetch_array($hasil))
						{
							$judul	=	$baris['judul'];
							$isi	=	$baris['isi'];
							print "Judul :  <form method=post><textarea name=judul>$judul</textarea><br/>";
							print "<textarea name=isi cols=75 rows=12>$isi</textarea><br/>";
							print "<input type=submit name=update value=Update></form> ";
							
							
						}
						if(isset($_POST['update'])){
							$ujudul	=	$_POST['judul'];
							$uisi	=	$_POST['isi'];
							$hasil	=	 mysql_query("UPDATE artikel set judul='$ujudul',isi='$uisi' where no='$nomor'");
						}
						print "<a href=manage.php> | Back</a>";
						break;
		case "add" : 
					print "Judul :  <form method=post><input type=text name=judul><br/>";
					print "<textarea name=isi cols=75 rows=12></textarea><br/>";
					print "Gambar:<input type=text name=gambar><br/>";
					print "<input type=submit name=update value=Add></form> ";
					if(isset($_POST['update'])){
						$ujudul	=	$_POST['judul'];
						$uisi	=	$_POST['isi'];
						$gambar	=	$_POST['gambar'];
						$hasil	=	 mysql_query("INSERT INTO artikel (judul,isi,gambar) VALUE ('$ujudul','$uisi','$gambar')");
					}
					print "<a href=manage.php> | Back</a>";
					break;
		case "del" : 
					$nomor	=	$_GET['id'];
					$hasil=mysql_query("DELETE FROM artikel where no=$nomor");
					print "<a href=manage.php> | Back</a>";
					header("Location: manage.php");
					break;
		default : 
					print "<a href=manage.php?state=add>Add</a><br/>";
					while($baris	=	 mysql_fetch_array($hasil)){
						$no	=	$baris['no'];
						$judul	=	$baris['judul'];
						
						print "Judul: $judul | <a href=manage.php?state=editor&id=$no>Edit</a>| <a href=manage.php?state=del&id=$no>Delete</a><br/> ";
					}
		break;
	}
?>