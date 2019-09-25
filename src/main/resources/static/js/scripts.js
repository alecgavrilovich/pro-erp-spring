
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
			novaVrednostZZP("dummy", kolicinaNoveStavke, cenaNoveStavke, cenaZaKomNoveStavke, 0, "dummy");
					
		},
		error: function() {

			console.log("error");
					
		}

	});
			
	ocistiPoljaNoveStavke();
			
});


		
$("#ocistiFormuZaStavku").on("click", function() {
			
	ocistiPoljaNoveStavke()
				
});
	
$(document).on("click", ".dugmeZaIzmenu", function() {
	
	// $(".button-save-edit").text("Izmeni");
	$("#dugmeZaNovuStavku").attr("hidden", "hidden");
	$("#dugmeZaIzmenuStavke").removeAttr("hidden");
	
	let redniBrStZaIzmenu = $(this).parent().attr("id");
	
	let statusStavke = "#status_" + redniBrStZaIzmenu;
	let sifraPrStavke = "#sifraPr_" + redniBrStZaIzmenu;
	let kolicinaStavke = "#kolicina_" + redniBrStZaIzmenu;
	let cenaStavke = "#cena_" + redniBrStZaIzmenu;
	let cenaZaKomStavke = "#cenaZaKom_" + redniBrStZaIzmenu;
	
	let prZaIzmenu = $(sifraPrStavke).text();
	let kolicinaZaIzmenu = $(kolicinaStavke).text();
	let cenaIzmenu = $(cenaStavke).text();
	let cenaZaKomZaIzmenu = $(cenaZaKomStavke).text();
	
	$("#sifraPrNoveStavke").val(prZaIzmenu);
	$("#kolicinaNoveStavke").val(kolicinaZaIzmenu);
	$("#cenaNoveStavke").val(cenaIzmenu);
	$("#cenaZaKomNoveStavke").val(cenaZaKomZaIzmenu);
	$("#redniBrStZaIzmenu").val(redniBrStZaIzmenu);
	
});


$("#dugmeZaIzmenuStavke").on("click", function() {
	
	let sifraPrStavke = $("#sifraPrNoveStavke").val();
	let kolicinaStavke = $("#kolicinaNoveStavke").val();
	let cenaStavke = $("#cenaNoveStavke").val();
	let cenaZaKomStavke = $("#cenaZaKomNoveStavke").val();
	let valutaZZP = $("#valutaZZP").val();
	let redniBrStZaIzmenu = $("#redniBrStZaIzmenu").val();

	
	let idStatusStavke = "#status_" + redniBrStZaIzmenu;
	let idSifraPrStavke = "#sifraPr_" + redniBrStZaIzmenu;
	let idKolicinaStavke = "#kolicina_" + redniBrStZaIzmenu;
	let idCenaStavke = "#cena_" + redniBrStZaIzmenu;
	let idCenaZaKomStavke = "#cenaZaKom_" + redniBrStZaIzmenu;
	
	let idVrednostStavke = "#vrednost_" + redniBrStZaIzmenu;
	let vrednostStavke = $(idVrednostStavke).text();
	
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

			$(idStatusStavke).text(2);
			$(idSifraPrStavke).text(sifraPrStavke);
			$(idKolicinaStavke).text(kolicinaStavke);
			$(idCenaStavke).text(cenaStavke);
			$(idCenaZaKomStavke).text(cenaZaKomStavke);
			
			$("#dugmeZaIzmenuStavke").attr("hidden", "hidden");
			$("#dugmeZaNovuStavku").removeAttr("hidden");
			ocistiPoljaNoveStavke()
			
			novaVrednostZZP(vrednostStavke, kolicinaStavke, cenaStavke, cenaZaKomStavke, 2, idVrednostStavke)
			
			$("#" + redniBrStZaIzmenu).css("background-color", "white");
					
		},
		error: function() {

			console.log("error");
					
		}
		
		

	});
			
});


$(document).on("click", ".dugmeZaBrisanje", function() {
	
	let redniBrStZaBrisanje = $(this).parent().attr("id");
	
	let statusStavke = "#status_" + redniBrStZaBrisanje;
	
	let idVrednostStavke = "#vrednost_" + redniBrStZaBrisanje;
	let vrednostStavke = $(idVrednostStavke).text();

	$.ajax({
		
		method: "POST",
		url: "http://localhost:8090/zzp/obrisiStavku",
		data: {
			statusStavke: 3,
			redniBrStavke: redniBrStZaBrisanje
		},
		success: function(response) {

			$(statusStavke).text(3);
			
			$("#" + redniBrStZaBrisanje).css("background-color", "grey");
			
			novaVrednostZZP(vrednostStavke, 0, 0, 0, 3, idVrednostStavke)
			
		},
		error: function() {

			console.log("error");
					
		}

	});
	
});


$(document).on("click", ".pronadji-pr", function(e) {
	
	e.preventDefault();
	
	let prId = $(this).attr("id");

	$.ajax({
		
		method: "GET",
		url: "http://localhost:8090/webService/vratiProizvod/" + prId,
		data: {
			prId: prId
		},
		success: function(response) {
			
			let prNode = '<div class="container">'+ 
			
			'<form><div class="form-row"><div class="form-group col-md-6"><label>Sifra proizvoda</label><p>'+ response.id +'</p></div></div>' +
			'<div class="form-row"><div class="form-group col-md-6"><label>Opis proizvoda</label><p>'+ response.opisPr +'</p></div></div>' +
			'<div class="form-row"><div class="form-group col-md-6"><label>Jedinica Mere</label><p>'+ response.jmId +'</p></div></div></form>' +
			
			'<a class="btn btn-success mb-2" href="/proizvod/lista" >Nazad</a>' +
			
			'</div>';
			
			$("#listaProizvoda").remove();
			$(".container").append(prNode);
			
		},
		error: function() {

			console.log("error");
					
		}
		
		

	});
	
});

// ================================================================

function ocistiPoljaNoveStavke() {
	
	let statusFormeZaStavku =  $(".button-save-edit").text();
	
	$(".polje-nove-stavke").val("");
	
	
	if (statusFormeZaStavku === "Izmeni") {
		
		$("#dugmeZaIzmenuStavke").attr("hidden", "hidden");
		$("#dugmeZaNovuStavku").removeAttr("hidden");
		
	}
	
	
}

function novaVrednostZZP(staraVredStavke, kolicina, cena, cenaZaKom, status, idVrednostStavke) {
	
	let staraVrednostZZP = $("#vrednostZZP").val();
	let vrednostStavke;
	let novaVrednostZZP;
	
	vrednostStavke = (cena/cenaZaKom) * kolicina;
	
	if (status === 0) {
		
		novaVrednostZZP = Number(staraVrednostZZP) + vrednostStavke;
		
	} else if (status === 2) {
		
		staraVrednostZZP = Number(staraVrednostZZP) - Number(staraVredStavke);
		
		novaVrednostZZP = staraVrednostZZP + vrednostStavke;
		
		
		
		$(idVrednostStavke).text(vrednostStavke);
		
	} else if (status === 3) {
		
		vrednostStavke = Number(staraVredStavke);
		novaVrednostZZP = Number(staraVrednostZZP) - Number(staraVredStavke);
		
	}
	
	
	novaVrednostZZP = Math.round( ( novaVrednostZZP + Number.EPSILON ) * 100 ) / 100;
	vrednostStavke = Math.round( ( vrednostStavke + Number.EPSILON ) * 100 ) / 100;
	
	$("#vrednostZZP").val(novaVrednostZZP);
	$(idVrednostStavke).text(vrednostStavke);

}


	
	