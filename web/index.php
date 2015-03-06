<?php
	set_time_limit(0);
?><!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Pemuja Koin Ajaib Tweet Analytics</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<script src="js/bootstrap.js"></script>
	<script src="js/slidetext.js"></script>
	<style>
		html, body {
		  height: 100%;
		  width: 100%;
		  padding: 0;
		  margin: 0;
		}

		#full-screen-background-image {
		  z-index: -999;
		  min-height: 100%;
		  min-width: 1024px;
		  width: 100%;
		  height: auto;
		  position: fixed;
		  top: 0;
		  left: 0;
		}

		#wrapper {
		  position: relative;
		  width: 800px;
		  min-height: 400px;
		  margin: 100px auto;
		  color: #333;
		}
	</style>
</head>
<body>
<!--
<div onClick="tampilkan('gambar');tampilkan('main')">
	<img src="images/front1.png" id="gambar" style="width:100%;">
</div>
-->
<div id="main" style="display:block;">
<div style="margin-left:50px;margin-right:50px">
	<div class="hero-unit-slide" style="margin-bottom:5px;background:none">
		<blockquote>
		<p>
		<div class="pull-right" id="textslide" style="margin-bottom:7px;font-family:futura md;font-size:16pt;color:#C1C1C1">
			<em>Impian manusia tak pernah berakhir</em>
		</div>
		</p>
		</blockquote>
	</div>
	<div align="center" class="container-fluid">
		<h1>Pemuja Koin Ajaib Tweet Analytic</h1>

		<table cellpadding="5" cellspacing="5" valign="center" border="0">
			<tr>
				<td width="50%" valign="top">
					<form input method="POST" class="form-inline">
						<table cellpadding="5" cellspacing="5" valign="right" border="0" align="right">
							<tr>
								<td>
									Hashtag target:
								</td>
								<td>
									<input type="text" name="hashtag" onMouseOver="tampilkan('hashtagTT')" onmouseout="tampilkan('hashtagTT')">
								</td>
							</tr>
							<tr>
								<td>
									<i>Keyword</i> macet:
								</td>
								<td>
									<input type="text" name="keyword1" onMouseOver="tampilkan('keywordTT')" onmouseout="tampilkan('keywordTT')">
								</td>
							</tr>
							<tr>
								<td>
									<i>Keyword</i> tutup:
								</td>
								<td>
									<input type="text" name="keyword2" onMouseOver="tampilkan('keywordTT')" onmouseout="tampilkan('keywordTT')">
								</td>
							</tr>
							<tr>
								<td>
									<i>Keyword</i> kecelakaan:
								</td>
								<td>
									<input type="text" name="keyword3" onMouseOver="tampilkan('keywordTT')" onmouseout="tampilkan('keywordTT')">
								</td>
							</tr>
							<tr>
								<td>
									
								</td>
								<td align="right">
									<input type="submit" name="analisis" value="Analisis" class="btn" onClick="tampilkan('progress');tampilkan('hasil');">
								</td>
							</tr>
						</table>
					
				</td>
				<td width="50%" valign="top">
					<table>
						<tr>
							<td>
								Algoritma:
							</td>
							<td>
								<select name="algoritma">
								  <option value="BM">Boyer-Moore</option>
								  <option value="KMP">KMP</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								Proxy:
							</td>
							<td>
								<input type="text" name="proxy" value="host:port:username:password">
							</td>
						</tr>
						<tr>
							<td>
								Proxy enable (?) : 
							</td>
							<td align="right">
								<input type="checkbox" name="cbox" value="1">
								</form>
							</td>
						</tr>
						<tr>
							<td>
								<p id="hashtagTT" style="display:none">
								Hashtag merupakan filtering constain dalam pencarian.Setiap tweet yang mengandung hashtag akan diambil dan menjadi dasar analisis.
								</p>
								<p id="keywordTT" style="display:none">
								Keyword merupakan kata kunci yang akan digunakan untuk mengategorikan tweet.
								</p>
								<div id="progress" style="display:none">
									<img src="images/loader.gif">
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<div id="hasil" style="background-color:white;">
		
			<?php
			if(isset($_POST['analisis'])){
				
				$hashtag	=	$_POST['hashtag'];
				$keyword1	=	$_POST['keyword1'];
				$keyword2	=	$_POST['keyword2'];
				$keyword3	=	$_POST['keyword3'];
				$algoritma	=	$_POST['algoritma'];
				
				$handle	=	 fopen("input.txt","w");
				fwrite($handle,"$hashtag\r\n");
				fwrite($handle,"$keyword1\r\n");
				fwrite($handle,"$keyword2\r\n");
				fwrite($handle,"$keyword3\r\n");
				fwrite($handle,"$algoritma");
				fclose($handle);
				
				if(isset($_POST['cbox'])){
					$isi	=	$_POST['proxy'];
				}else{
					$isi	=	"";
				}
				$handle	=	 fopen("proxy.txt","w");
				fwrite($handle,$isi);
				fclose($handle);
				$outputJava	=	file("output.txt");
				print '<div style="display:none">';
				system("java -jar TweetAnalyzer.jar");
				print '</div>';
			?>
			<pre>
			<?
				
				foreach($outputJava as $baris){
					if(!preg_match("/https/",$baris)){
						print $baris;
					}else{
						$arrayOfOutput	=	 explode("|||",$baris);
						print "<a href=$arrayOfOutput[0]>$arrayOfOutput[1]</a>";
					}
				}
				
				
			}
			?>
		</pre>
	</div>
	<div class="hero-unit-slide" style="font-style:normal;padding:5px" onClick="tampilkan('proxy')" >
		<h4 id="pencipta" class="text-center">Proxy</h4>
	</div>
	<!--
	<div id="proxy" style="display:none;background-color:white;">
		<form method="POST">
			<center><b>PLEASE SET PROXY </b></center>
			<table valign="top" align="center">
				<tr>
					<td valign="top">
						<input type="text" name="proxy" value="host:port:username:password">
					</td>
					<td valign="top">
						<input type="submit" name="setProxy" value="Set Proxy" class="btn">
					</td>
				</tr>
			</table>
		</form>
	</div>
	-->
	<div class="hero-unit-slide" style="font-style:normal;padding:5px" onClick="tampilkan('AboutUs');scroll('pencipta')" >
		<h4 id="pencipta" class="text-center">About Us</h4>
	</div>
	<div id="AboutUs" style="display:none;background-color:white;">
		<center><img src="images/AboutUs.png"></center>
	</div>
	
	<div class="hero-unit-slide tidak-kotak" align="center" style="vertical-align:bottom;margin-top:10px;color: inherit;background-color: white;height:150px">
		<hr align="center" style="width:85%;border-color: #9E9E9E;padding:0px;margin-bottom:0px">
		<div class="hero-unit-slide" style="font-style:normal;text-align:center;padding: 0px;margin-bottom:0px;background-color:white;">
			<h5>Kritik dan saran: <a href="mailto:a.dwisaty4@yahoo.com">admin@pemujakoin.com</a></h5>
		</div>
	</div>
</div>
</div>
</body>
</html>
