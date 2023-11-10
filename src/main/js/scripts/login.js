const URLlogin = "http://127.0.0.1:8080/auth/login";
const URLregister = "http://127.0.0.1:8080/auth/register";

const usernameForm = document.getElementById("username");
const passwordForm = document.getElementById("password");

const btnLogin = document.getElementById("btnLogin");


btnLogin.addEventListener("click", e => {
  // Cancela el evento por defecto
  e.preventDefault();
  login();
});


btnRegistrar.addEventListener("click", e => {
  // Cancela el evento por defecto
  e.preventDefault();
  registrar();
});


$("#signup").click(function () {
  $("#first").fadeOut("fast", function () {
    $("#second").fadeIn("fast");
  });
});

$("#signin").click(function () {
  $("#second").fadeOut("fast", function () {
    $("#first").fadeIn("fast");
  });
});


$(function () {
  $("form[name='login']").validate({
    rules: {
      username: {
        required: true,
      },
      password: {
        required: true,
      }
    },
    messages: {
      username: "Ingrese un nombre de usuario válido",
      password: "Ingrese un password"
    },
    // submitHandler: function (form) {
    //   // form.submit();
    // }
  });
});



$(function () {

  $("form[name='registration']").validate({
    rules: {
      username: "required",
      firstname: "required",
      lastname: "required",
      password: {
        required: true,
        minlength: 5
      },
      email: {
        required: true,
        email: true
      },
      direccion: "required",
      telefono: "required"
    },


  



    messages: {
      username: "Ingrese un nombre de usuario",
      firstname: "Ingrese su nombre",
      lastname: "Ingrese su apellido",
      password: {
        required: "Ingrese la contraseña",
        minlength: "Debe tener como mínimo 5 caracteres"
      },
      email: "Ingrese un correo válido",
      direccion: "Ingrese su dirección",
      telefono: "Ingrese su teléfono"
    },

    submitHandler: function (form) {
      form.submit();
    }
  });
});



async function login() {
  // console.log(usernameForm.value);
  // console.log(passwordForm.value);
  const response = await fetch(URLlogin, {
    method: "POST",
    headers: {
      'Content-Type': 'application/json'
    },


    body: JSON.stringify({
      username: usernameForm.value,
      password: passwordForm.value
    })

  })
  const data = await response.json();
  console.log(data);

  window.localStorage.setItem("token", data.token);
  window.localStorage.setItem("username", usernameForm.value);

  console.log(window.localStorage.getItem("usuario"));
  console.log(window.localStorage.getItem("token"));
}

async function registrar() {
  
  const response = await fetch(URLregister, {
    method: "POST",
    headers: {
      'Content-Type': 'application/json'
    },


    body: JSON.stringify({
      username: usernameR.value,
      nombre: firstname.value,
      apellido: lastname.value,
      password: passwordR.value,
      email: email.value,
      direccion: direccion.value,
      telefono: telefono.value

    })

  })
  const data = await response.json();
  console.log(data);

  // window.localStorage.setItem("token", data.token);
  // window.localStorage.setItem("username", usernameR.value);
  
  // console.log(window.localStorage.getItem("usuario"));
  // console.log(window.localStorage.getItem("token"));
}
