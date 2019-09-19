
$("#dugmeZaNovuStavku").on("click", function() {
		
	let sifraPrNoveStavke = $("#sifraPrNoveStavke").val();
	let kolicinaNoveStavke = $("#kolicinaNoveStavke").val();
	let cenaNoveStavke = $("#cenaNoveStavke").val();
	let cenaZaKomNoveStavke = $("#cenaZaKomNoveStavke").val();
	let valutaNovogZZP = $("#valutaZZP").val();
			
	$.ajax({
				
		method: "POST",
		url: "http://localhost:8090/zzp/dodajStavku",
		data: {
			sifraPr: sifraPrNoveStavke,
			kolicina: kolicinaNoveStavke,
			cena: cenaNoveStavke,
			cenaZaKom: cenaZaKomNoveStavke,
			valuta: valutaNovogZZP
		},
		success: function(response) {
					
			$("#stavkeZZP").append(response);
			novaVrednostZZP(kolicinaNoveStavke, cenaNoveStavke, cenaZaKomNoveStavke)
					
		},
		error: function() {

			console.log("error");
					
		}

	});
			
	ocistiPoljaNoveStavke();
			
});

// Ocisti unete vrednosti za novu/izmenu stavke
		
$("#ocistiFormuZaStavku").on("click", function() {
			
	ocistiPoljaNoveStavke()
				
});
		
function ocistiPoljaNoveStavke() {
	
	//let statusFormeZaStavku =  $(".button-save-edit").text();
	
	$(".polje-nove-stavke").val("");
	
	
//	if (statusFormeZaStavku === "Izmeni") {
//		
//		$(".button-save-edit").text("Dodaj");
//		// $("#dugmeZaIzmenuStavke").prop("id", "dugmeZaNovuStavku");
//		
//	}
	
	
}

function novaVrednostZZP(kolicina, cena, cenaZaKom) {
	
	let staraVrednost = $("#vrednostZZP").val();
	let vrednostStavke = 0;
	let novaVrednost = 0;
	
	vrednostStavke = (cena/cenaZaKom) * kolicina;
	
	novaVrednost = Number(staraVrednost) + vrednostStavke;
	
	$("#vrednostZZP").val(novaVrednost);
	
}

	
$(".dugmeZaIzmenu").on("click", function() {
	
	$(".button-save-edit").text("Izmeni");
	//$("#dugmeZaNovuStavku").prop("id", "dugmeZaIzmenuStavke");
	
	let redniBrStavke = $(this).parent().attr("id");
	console.log(redniBrStavke);
	
	let statusStavke = "#status_" + redniBrStavke;
	let sifraPrStavke = "#sifraPr_" + redniBrStavke;
	let kolicinaStavke = "#kolicina_" + redniBrStavke;
	let cenaStavke = "#cena_" + redniBrStavke;
	let cenaZaKomStavke = "#cenaZaKom_" + redniBrStavke;
	
	let prZaIzmenu = $(sifraPrStavke).text();
	let kolicinaZaIzmenu = $(kolicinaStavke).text();
	let cenaIzmenu = $(cenaStavke).text();
	let cenaZaKomZaIzmenu = $(cenaZaKomStavke).text();
	
	$("#sifraPrNoveStavke").val(prZaIzmenu);
	$("#kolicinaNoveStavke").val(kolicinaZaIzmenu);
	$("#cenaNoveStavke").val(cenaIzmenu);
	$("#cenaZaKomNoveStavke").val(cenaZaKomZaIzmenu);
	$("#redniBrStZaIzmenu").val(redniBrStavke);
	
});	


$("#dugmeZaIzmenuStavke").on("click", function() {
	
	console.log("test12");
	
	let sifraPrStavke = $("#sifraPrNoveStavke").val();
	let kolicinaStavke = $("#kolicinaNoveStavke").val();
	let cenaStavke = $("#cenaNoveStavke").val();
	let cenaZaKomStavke = $("#cenaZaKomNoveStavke").val();
	let valutaZZP = $("#valutaZZP").val();
	let redniBrStZaIzmenu = $("#redniBrStZaIzmenu").val();
	
	let finalniRedniBr = "#" + redniBrStZaIzmenu;
			
	$.ajax({
				
		method: "POST",
		url: "http://localhost:8090/zzp/izmeniStavku",
		data: {
			sifraPr: sifraPrStavke,
			kolicina: kolicinaStavke,
			cena: cenaStavke,
			cenaZaKom: cenaZaKomStavke,
			valuta: valutaZZP,
			redniBr: redniBrStZaIzmenu
		},
		success: function(response) {
					
			$(finalniRedniBr).replaceWith(response);
			
			// novaVrednostZZP(kolicinaNoveStavke, cenaNoveStavke, cenaZaKomNoveStavke)
					
		},
		error: function() {

			console.log("error");
					
		}

	});
			
	// ocistiPoljaNoveStavke();
			
});

	
	