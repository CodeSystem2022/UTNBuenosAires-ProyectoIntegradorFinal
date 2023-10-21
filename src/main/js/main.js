
//PRODUCTOS
const productos= [
    {
        id: "notebook-01",
        titulo: "Notebook 01",
        imagen: "./img/notebook-asus.jpeg",
        categoria: {
            nombre: "Notebooks",
            id: "Notebooks"
        },
        precio: 350000
    },
    {    
        id: "notebook-02",
        titulo: "Notebook 02",
        imagen: "./img/notebook-hp.webp",
        categoria: {
            nombre: "Notebooks",
            id: "Notebooks"
        },
        precio: 265999
    },

    {   
        id: "notebook-03",
        titulo: "Notebook 03",
        imagen: "./img/notebook_lenovo.webp",
        categoria: {
            nombre: "Notebooks",
            id: "Notebooks"
        },
        precio: 405000
    },
    {    
        id: "Monitor-01",
        titulo: "Monitor 01",
        imagen: "./img/Accesorios/monitor samsung.png",
        categoria: {
            nombre: "Monitor Samsung",
            id: "Monitores"
        },
        precio: 280000
    },
    {    
        id: "Monitor-02",
        titulo: "Monitor 02",
        imagen: "./img/Accesorios/monitor gigabyte.png",
        categoria: {
            nombre: "Monitor Gigabyte",
            id: "Monitores"
        },
        precio: 250000
    },
    {    
        id: "Monitor-03",
        titulo: "Monitor 03",
        imagen: "./img/Accesorios/monitor asus.jpg",
        categoria: {
            nombre: "Monitor Asus",
            id: "Monitores"
        },
        precio: 200000
    },
    {    
        id: "Mouse-01",
        titulo: "Mouse 01",
        imagen: "./img/Accesorios/mouse ligitech.png",
        categoria: {
            nombre: "Mouse Inalambrico",
            id: "Accesorios"
        },
        precio: 1000
    },
    {    
        id: "Mouse-02",
        titulo: "Mouse 02",
        imagen: "./img/Accesorios/mouse razer.png",
        categoria: {
            nombre: "Mouse Razer",
            id: "Accesorios"
        },
        precio: 2000
    },
    {    
        id: "CPU-01",
        titulo: "CPU 01",
        imagen: "./img/Accesorios/cpu-gamer.png",
        categoria: {
            nombre: "CPU gamer",
            id: "Otros productos"
        },
        precio: 500000
    },
    {    
      id: "Consola-01",
      titulo: "Consola 01",
      imagen: "./img/OtrosProductos/playstation5.webp",
      categoria: {
          nombre: "Playstation 5",
          id: "Otros productos"
      },
      precio: 500000
    }


    
];
/*Traemos desde el html  */
const contenedorProductos = document.querySelector("#contenedor-productos");
const botonesCategoria = document.querySelectorAll(".boton-categoria");
const tituloPrincipal = document.querySelector("#titulo-principal");
let botonesAgregar = document.querySelectorAll(".producto-agregar");

function cargarProductos(ProductosElegidos){

    contenedorProductos.innerHTML ="";

    ProductosElegidos.forEach(producto => { /*El forEach recorre todo el array */

        const div = document.createElement("div");
        div.classList.add("producto");
        div.innerHTML = `
            <img class="producto-imagen" src="${producto.imagen}" alt="${producto.titulo}">
            <div class="producto-detalles">
                <h3 class="producto-titulo"> ${producto.titulo}</h3>
                <p class="producto-precio">${producto.precio}</p>
                <button class="producto-agregar" id="${producto.id}">Agregar</button>
            </div>
        `;

        contenedorProductos.append(div);

    })
}

cargarProductos(productos);  /*Llamamos a la función */

botonesCategoria.forEach(boton => {
    boton.addEventListener("click", (e) => {
        botonesCategoria.forEach(boton => boton.classList.remove("active")); /*Le sacamos el active del boton que esta seleccionado */
        e.currentTarget.classList.add("active");

        if (e.currentTarget.id !== "todos") {
            const productoCategoria = productos.find(producto => producto.categoria.id === e.currentTarget.id);
            tituloPrincipal.innerText = productoCategoria.categoria.id;

            const productosBoton = productos.filter(producto => producto.categoria.id === e.currentTarget.id);
            cargarProductos(productosBoton);
        } else {
            tituloPrincipal.innerText = "Todos los productos";
            cargarProductos(productos);
        }
    });
});

function actualizarBotonesAgregar() {
    botonesAgregar = document.querySelectorAll(".producto-agregar");

    botonesAgregar.forEach(boton => {
        boton.addEventListener("click", agregarAlCarrito);
    });
}

const productosEnCarrito = [];

function agregarAlCarrito(e) {

  const idBoton = e.currentTarget.id;
  const productoAgregado = productos.find(producto => producto.id === idBoton);

  productosEnCarrito.push(productoAgregado);
}