const botonesCategoria = document.querySelectorAll(".boton-categoria");
const tituloPrincipal = document.querySelector("#titulo-principal");
let botonesAgregar = document.querySelectorAll(".producto-agregar");
const numerito = document.querySelector("#numerito");


/**
 * Funcionamiento de respuesta ante clicks en sección categorias
 */
botonesCategoria.forEach(boton => {
    boton.addEventListener("click", (e) => {

        /** Le sacamos el active del boton que esta seleccionado y se lo ponemos al otro */
        botonesCategoria.forEach(boton => boton.classList.remove("active"));
        e.currentTarget.classList.add("active");

        /** Si la categoria no es todos, listamos por categoria */
        if (e.currentTarget.id != "todos") {

            /** Seteamos el titulo al nombre de la categoria */
            tituloPrincipal.innerText = e.currentTarget.id;
            const categoriaSeleccionada = (e.currentTarget.id).toUpperCase();
            // console.log(categoriaSeleccionada);

            /** Genera productos por categoria */
            generarProductosPorCategoria(categoriaSeleccionada);

        } else {

            /** Todos los productos */
            tituloPrincipal.innerText = "Todos los productos";
            generarTodosLosProductos();
        }
    });
});

function actualizarBotonesAgregar() {
    botonesAgregar = document.querySelectorAll(".producto-agregar");

    botonesAgregar.forEach(boton => {
        boton.addEventListener("click", agregarAlCarrito);
    });
}

let productosEnCarrito;

let productosEnCarritoLS = localStorage.getItem("productos-en-carrito");

if (productosEnCarritoLS) {
    productosEnCarrito = JSON.parse(productosEnCarritoLS);
    actualizarNumerito();
} else {
    productosEnCarrito = [];
}

function encontrarProducto(producto, id) {
    return producto.id === id;

}

async function agregarAlCarrito(e) {
    const productos = await traerProductos();
    const idBoton = e.target.name;
    const productoAgregado = productos.find(producto => producto.id == idBoton);

    if (productosEnCarrito.some(producto => producto.id == idBoton)) {
        const index = productosEnCarrito.findIndex(producto => producto.id == idBoton);
        productosEnCarrito[index].cantidad++;
    } else {
        productoAgregado.cantidad = 1;
        productosEnCarrito.push(productoAgregado);
    }

    actualizarNumerito();

    localStorage.setItem("productos-en-carrito", JSON.stringify(productosEnCarrito));
}

function actualizarNumerito() {
    let nuevoNumerito = productosEnCarrito.reduce((acc, producto) => acc + producto.cantidad, 0);
    numerito.innerText = nuevoNumerito;
}

