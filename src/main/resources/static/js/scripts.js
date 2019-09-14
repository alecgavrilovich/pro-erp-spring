
		$("#dugmeZaNovuStavku").on("click", function() {

			let sifraZZP2 = $("#sifraZZP").text();
		
			let sifraPrNoveStavke = $("#sifraPrNoveStavke").val();
			let kolicinaNoveStavke = $("#kolicinaNoveStavke").val();
			let cenaNoveStavke = $("#cenaNoveStavke").val();
			let cenaZaKomNoveStavke = $("#cenaZaKomNoveStavke").val();
			let valutaNovogZZP = $("#valutaZZP").val();
			
			let node = "<tr>" +
			"<td>" + sifraZZP2 + " </td>" +
			"<td>" + 10 + " </td>" +
			"<td>" + 1 + " </td>" +
			"<td>" + sifraPrNoveStavke + " </td>" +
			"<td>" + "test" + " </td>" +
			"<td>" + kolicinaNoveStavke + " </td>" +
			"<td>" + cenaNoveStavke + " </td>" +
			"<td>" + cenaZaKomNoveStavke + " </td>" +
			"<td>" + 100 + " </td>" +
			"<td>" + valutaNovogZZP + " </td>" +
			"</tr>";
			
			$("#stavkeZZP").append(node);

			$.ajax({
				method: "POST",
				url: "http://localhost:8090/zzp/dodajStavku",
				data: {
					sifraPr: sifraPrNoveStavke,
					kolicina: kolicinaNoveStavke,
					cena: cenaNoveStavke,
					valuta: valutaNovogZZP

				},
				success: function(response) {

					console.log(response);
				},
				error: function() {

					console.log("error");
				}

			});
			
		});

	
	$("#ocistiFormuZaStavku").on("click", function() {
		
		$(".polje-nove-stavke").val("");
		
    });	
	