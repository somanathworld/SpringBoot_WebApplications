
function validate(frm){

	//empty form validation error message
	document.getElementById("enameErr").innerHTML="";
	document.getElementById("jobErr").innerHTML="";
	document.getElementById("salErr").innerHTML="";
	document.getElementById("deptnoErr").innerHTML="";

	//read form data
	let name = frm.ename.value;
	let desg = frm.job.value;
	let salary = frm.sal.value;
	let dno = frm.deptno.value;
	let validationFlag = true;

	//form validation logic client side
	if(name==""){
		document.getElementById("enameErr").innerHTML="Employee name is required.(js)";
		validationFlag = false;
	}else if(name.length<5){
		document.getElementById("enameErr").innerHTML="Employee name must have minimum of 5 characters.(js)";
		validationFlag = false;
	}

	if(desg==""){
		document.getElementById("jobErr").innerHTML="Employee job is required.(js)";
		validationFlag = false;
	}else if(desg.length<5){
		document.getElementById("jobErr").innerHTML="Employee job must have minimum of 5 characters.(js)";
		validationFlag = false;
	}
	
	if(salary==""){
		document.getElementById("salErr").innerHTML="Employee salary is required.(js)";
		validationFlag = false;
	}else if(isNaN(salary)){
		document.getElementById("salErr").innerHTML="Employee salary must be numeric value.(js)";
		validationFlag = false;
	}else if(salary<20000 || salary>100000){
		document.getElementById("salErr").innerHTML="Employee salary must be given in the range 20,000 to 1,00,000.(js)";
		validationFlag = false;		
	}
	
	if(dno==""){
		document.getElementById("deptnoErr").innerHTML="Employee department number is required.(js)";
		validationFlag = false;
	}else if(isNaN(dno)){
		document.getElementById("deptnoErr").innerHTML="Employee department number must be numeric value.(js)";
		validationFlag = false;
	}else if(dno<10 || dno>90){
		document.getElementById("deptnoErr").innerHTML="Employee department number must be given in the range 10 to 90.(js)";
		validationFlag = false;		
	}
	
	frm.vFlag.value="yes";
	return validationFlag;
	
	
}