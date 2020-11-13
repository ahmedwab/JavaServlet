function validate() {



var ok = true;
var p = document.getElementById("principal").value; 


if (isNaN(p) || p <= 0) {	
	alert("Principal invalid!"); 
	
	document.getElementById("principal-error").style.display ="inline";
	document.getElementById("principal-error").style.color = "red";
	ok=false;

}


else {
	document.getElementById("principal-error").style.display = "none";
}

if (!ok) return false;

p = document.getElementById("interest").value; 


if (isNaN(p) || p <= 0 || p >= 100) {
	alert("Interest Invalid. Must be in (0,100).");
	document.getElementById("interest-error").style.display ="inline";
	document.getElementById("interest-error").style.color = "red";
	ok = false;


}

else {
	document.getElementById("interest-error").style.display = "none";
}


if (!ok) return false;


p = document.getElementById("period").value; 


if (isNaN(p) || p < 0) {
	alert("Period Invalid. Must be greater than 0");
	document.getElementById("period-error").style.display ="inline";
	document.getElementById("period-error").style.color = "red";
	ok = false;


}




return ok;

}




function doSimpleAjax(address){

	 var request = new XMLHttpRequest();
	var data='';
	/* add your code here to grab all parameters from form*/
	data += "principal=" + document.getElementById("principal").value + "&";
	data += "interest=" + document.getElementById("interest").value + "&";
	data += "period=" + document.getElementById("period").value + "&";
	data += "grace=" + document.getElementById("grace").value + "&"; 
	data += "calculate=false";
	request.open("GET", (address + "?" + data), false); 
	request.onreadystatechange = function() {
		handler(request); 
	};
	
	request.send(null);
	


	
	}
	

function handler(request){

	if ((request.readyState == 4) && (request.status == 200)){
		var target = document.getElementById("response");
		target.innerHTML = request.responseText; 
	}
	
	
}


