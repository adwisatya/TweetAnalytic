    var quotes = [
        "Hanya ada dua pilihan untuk pemenang yakni berhenti sejenak atau lanjut berjuang",
        "Tidak ada yang lebih menyenangkan daripada mememperjuangkan apapun yang engkau inginkan",
        "Pecundang membandingkan dirinya dengan orang lain sedangkan pemenang membandingkan dirinya dengan dirinya sendiri",
        "Impian adalah kenyataan yang belum sepenuhnya terealisasikan",
        "Hanya kegigihan yang dapat mengalahkan segala rintangan",
        ];
        
	var i = 0;
	
	setInterval(function() {
		$("#textslide").html(quotes[i]);
		if (i == quotes.length)
			i=0;
		else
			i++;
	}, 3000);
	

	function tampilkan(id){
			if(document.getElementById(id).style.display == 'none')
				document.getElementById(id).setAttribute("style", "display:block");
			else
				document.getElementById(id).setAttribute("style", "display:none");
	};