function doSimpleAjax(address){

	 var request = new XMLHttpRequest();
	var data='';
	/* add your code here to grab all parameters from form*/
	data += "name=" + document.getElementById("name").value + "&";
	data += "credit=" + document.getElementById("credit").value + "&ajax=true";
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

function validate() {




var p = document.getElementById("name").value; 
if (p.size()>130) alert("name is too big");

p = document.getElementById("credit").value; 

if (p<0) alert("invalid credits");

}

