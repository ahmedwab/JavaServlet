function validate() {




var p = document.getElementById("name").value; 
if (p.size()>130) alert("name is too big");

p = document.getElementById("credit").value; 

if (p.size()<0) alert("invalid credits");

}
