$(document).ready(function(){
	
	$("h1").text("Hello from JS");
	
	$("button").click(function(){
        $.getJSON("http://localhost:8080/MVCProject/rest/gas", function(result){
            $.each(result, function(i, field){
//            	JSON.parse(field);
            		JSON.stringify(field);
                $("#li").append(field + " ");
            	});
        	});
	});
});
