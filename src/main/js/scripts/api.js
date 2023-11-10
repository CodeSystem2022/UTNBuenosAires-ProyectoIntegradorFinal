/**
 * Traemos desde el html el contenedor de productos
 */
const contenedorProductos = document.getElementById('contenedor-productos');
const formularioLogin = document.getElementById('myModal');

const URLproductos = "http://127.0.0.1:8080/producto/getProductos"
const URLcategorias = "http://127.0.0.1:8080/producto/getCategorias"
const URLusuarioPorUsername = "http://127.0.0.1:8080/usuario/obtenerUsuario"

// const options = {method: 'GET'};

// fetch('http://127.0.0.1:8080/producto/getProductos', options)
//   .then(response => response.json())
//   .then(response => console.log(response))
//   .catch(err => console.error(err));

/**
 * Función asincrona para traer datos desde cualquier URL API Rest
 */
const getApi = async (URL) => {
    // console.log(window.localStorage.getItem("token"));
    const response = await fetch(URL, {
        // mode: 'no-cors',
        method: 'GET',
        headers: {
            "Content-Type": "application/json",
            "AUTHORIZATION": `Bearer ${window.localStorage.getItem("token")}`
        },
    });
    // console.log(response);
    // console.log(response.status);

    if (response.status == 403) {
        contenedorProductos.innerHTML = "<h2>Debe estar logeado para ver la información.</h2>";
        formularioLogin.style.display = 'block';

    } else {
        // TODO borrar luego
        console.log("Status Respuesta:");
        console.log(response.status);
    }

    const data = await response.json();
    // Nos devuelve un array
    return data;
}


const getUsuario = async (URL) => {
    // console.log(window.localStorage.getItem("token"));
    const response = await fetch(`${URL}/${window.localStorage.getItem("username")}`, {
        // mode: 'no-cors',
        method: 'GET',
        headers: {
            "Content-Type": "application/json",
            "AUTHORIZATION": `Bearer ${window.localStorage.getItem("token")}`
        },
    });
    // console.log(response);
    // console.log(response.status);


    const data = await response.json();
    console.log(data);
    // Nos devuelve un array
    return data;
}





/**
 * Función para crear cada producto desde la API
 */
const crearProducto = (producto) => {
    const product = document.createElement('div');
    product.classList.add("producto");

    const imgProducto = document.createElement('img');
    imgProducto.classList.add('producto-imagen')
    imgProducto.src = producto.imagen;
    imgProducto.alt = producto.nombre;

    const containerDescripcion = document.createElement('div');
    containerDescripcion.classList.add('producto-detalles');

    const nombreProducto = document.createElement('h3');
    nombreProducto.classList.add('producto-titulo');
    nombreProducto.textContent = producto.nombre;

    const precioProducto = document.createElement('p');
    precioProducto.classList.add('producto-precio');
    precioProducto.textContent = "$ " + producto.precio;

    const botonAgregar = document.createElement('button');
    botonAgregar.classList.add('producto-agregar');
    botonAgregar.name = producto.id;
    botonAgregar.innerHTML = "Agregar";

    // Agregamos nombre y precio como hijos al contenedor de descripción 
    containerDescripcion.appendChild(nombreProducto);
    containerDescripcion.appendChild(precioProducto);
    containerDescripcion.appendChild(botonAgregar);

    // Agregamos la imagen y la descripcion como hijos al producto
    product.appendChild(imgProducto);
    product.appendChild(containerDescripcion);

    // Agregamos el producto al contenedor como hijo 
    contenedorProductos.appendChild(product);
}

/**
 * Función para traer cada producto desde getApi()
 * Al invocar una función asíncrona, ésta deve ser asíncrona tambien
 */
const generarTodosLosProductos = async () => {
    contenedorProductos.innerHTML = '';
    const data = await getApi(URLproductos);
    data.map(producto => {
        crearProducto(producto);
    });
    // generarListadoDeCategorias();
    actualizarBotonesAgregar();

}
// TODO barra menu superior
const generarBarraUsuario = async () => {
    const data = await getUsuario(URLusuarioPorUsername);
    console.log("barrausuario");
    console.log(data);
}


async function generarProductosPorCategoria(categoria) {
    contenedorProductos.innerHTML = '';
    const data = await getApi(URLproductos);
    data.map(producto => {
        if (producto.categoria == categoria) {
            crearProducto(producto);
        }
    });
    actualizarBotonesAgregar();
}

/**
 * Variable asíncrona para obtener los productos de la base de datos
 */
const traerProductos = async () => {
    const data = await getApi(URLproductos);
    return data;
}

/**
 * Variable asíncrona para listar categorias mediante API REST
 * por el momento no utilizada
 */
const generarListadoDeCategorias = async () => {
    const data = await getApi(URLcategorias);
    data.map(categoria => {
        console.log(categoria);
    })
}

function chequearUsuario() {
    // TODO BORRAR
    console.log(localStorage.getItem("username"));
    console.log(localStorage.getItem("token"));

    /**
     * Validación de usuario
     * Si no tiene guardados en localStorage valores para username y token, nos envia
     * al formulario de login/registro
     */

    if (window.localStorage.getItem("username") != null && window.localStorage.getItem("token") != null) {
        /**
         * TODO
         * Función para mostrar la barra de usuario, a implementar
         */
        generarBarraUsuario();

        /**
         * Muestra los productos en nuestro landing page
         */
        generarTodosLosProductos();
    }

    else {

        /**
         * Sino encuentra datos guardados que validen la identidad del usuario, 
         * lo invita a logearse en su cuenta o registrar una nueva
         */

        // Muestra el formulario para login
        formularioLogin.style.display = 'block';
    }
}

/**
 * Evento que llama a realizar la validación del usuario
 * via token
 */
window.addEventListener('DOMContentLoaded', chequearUsuario);