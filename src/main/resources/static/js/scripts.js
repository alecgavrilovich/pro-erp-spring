
		$("#dugmeZaNovuStavku").on("click", function() {
		
			let sifraPrNoveStavke = $("#sifraPrNoveStavke").val();
			let kolicinaNoveStavke = $("#kolicinaNoveStavke").val();
			let cenaNoveStavke = $("#cenaNoveStavke").val();
			let cenaZaKomNoveStavke = $("#cenaZaKomNoveStavke").val();
			let valutaNovogZZP = $("#valutaZZP").val();
			
			
//			let node = "<tr>" +
//			"<td>" + sifraZZP2 + " </td>" +
//			"<td>" + 10 + " </td>" +
//			"<td>" + 1 + " </td>" +
//			"<td>" + sifraPrNoveStavke + " </td>" +
//			"<td>" + "test" + " </td>" +
//			"<td>" + kolicinaNoveStavke + " </td>" +
//			"<td>" + cenaNoveStavke + " </td>" +
//			"<td>" + cenaZaKomNoveStavke + " </td>" +
//			"<td>" + 100 + " </td>" +
//			"<td>" + valutaNovogZZP + " </td>" +
//			"</tr>";
			
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
	
	$(".polje-nove-stavke").val("");
	
}

function novaVrednostZZP(kolicina, cena, cenaZaKom) {
	
	let staraVrednost = $("#vrednostZZP").val();
	let vrednostStavke = 0;
	let novaVrednost = 0;
	
	vrednostStavke = (cena/cenaZaKom) * kolicina;
	
	novaVrednost = Number(staraVrednost) + vrednostStavke;
	
	$("#vrednostZZP").val(novaVrednost);
	
}

	
	

	
	