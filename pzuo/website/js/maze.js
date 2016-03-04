$(document).ready(function() {
	
	$(".boundary,h1,h2").mouseover(function(){
			$(".boundary").css("backgroundColor","red");
			alert("you lose");
		});
	$("#start").click(function(){
		$(".boundary").css("backgroundColor","#eeeeee");
	});
	$("#end").mouseover(function(){
		alert("you win");
	});
});