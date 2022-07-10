function validateForm() {
  var fname = document.forms["messageform"]["firstname"].value;// creating variable fname which has value of first name
  var lname = document.forms["messageform"]["lastname"].value;//creating variable lname which has the value of lname
  var email = document.forms["messageform"]["email"].value;//creating the variable email which has the value of email

  if (fname == "" || lname == "" || email == "") {
    alert("Empty fields detected. Please fill up the form properly");//Displays the alert message when the form is sent empty
  } else {
    alert("Thank you very much!");//Displays the alert message when the form is sent with proper value
  }
}


