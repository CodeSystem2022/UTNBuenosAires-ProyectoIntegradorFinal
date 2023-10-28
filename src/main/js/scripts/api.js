/**
 * Traemos desde el html el contenedor de productos
 */
const contenedorProductos = document.getElementById('contenedor-productos');
const URLproductos = "http://127.0.0.1:8080/producto/getProductos"
const URLcategorias = "http://127.0.0.1:8080/producto/getCategorias"

// const options = {method: 'GET'};

// fetch('http://127.0.0.1:8080/producto/getProductos', options)
//   .then(response => response.json())
//   .then(response => console.log(response))
//   .catch(err => console.error(err));

/**
 * Función asincrona para traer datos desde cualquier URL API Rest
 */
const getApi = async (URL) => {
    const response = await fetch(URL);
    // console.log(response);
    const data = await response.json();
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

const traerProductos = async () => {
    const data = await getApi(URLproductos);
    return data;
}


const generarListadoDeCategorias = async () => {
    const data = await getApi(URLcategorias);
    // console.log(data);
    data.map(categoria => {
        console.log(categoria);
    })

}

/**
 * Evento que llama a generar todos los productos cuando carga la pagina
 */
window.addEventListener('DOMContentLoaded',generarTodosLosProductos);