$( document ).ready(function() {
	
    $(".clickable-row").on("click", function() {
    	location.replace($(this).attr("data-href"))
    })
   
    
});