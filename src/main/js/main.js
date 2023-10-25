
//PRODUCTOS
const productos= [
    {
        id: "notebook-01",
        nombre: "Notebook 01",
        imagen: "./img/notebook-asus.jpeg",
        categoria: {
            nombre: "Notebooks",
            id: "Notebooks"
        },
        precio: 350000
    },
    {    
        id: "notebook-02",
        nombre: "Notebook 02",
        imagen: "./img/notebook-hp.webp",
        categoria: {
            nombre: "Notebooks",
            id: "Notebooks"
        },
        precio: 265999
    },

    {   
        id: "notebook-03",
        nombre: "Notebook 03",
        imagen: "./img/notebook_lenovo.webp",
        categoria: {
            nombre: "Notebooks",
            id: "Notebooks"
        },
        precio: 405000
    },
    {    
        id: "Monitor-01",
        nombre: "Monitor 01",
        imagen: "./img/Accesorios/monitor samsung.png",
        categoria: {
            nombre: "Monitores",
            id: "Monitores"
        },
        precio: 280000
    },
    {    
        id: "Monitor-02",
        nombre: "Monitor 02",
        imagen: "./img/Accesorios/monitor gigabyte.png",
        categoria: {
            nombre: "Monitores",
            id: "Monitores"
        },
        precio: 250000
    },
    {    
        id: "Monitor-03",
        nombre: "Monitor 03",
        imagen: "./img/Accesorios/monitor asus.jpg",
        categoria: {
            nombre: "Monitores",
            id: "Monitores"
        },
        precio: 200000
    },
    {    
        id: "Mouse-01",
        nombre: "Mouse 01",
        imagen: "./img/Accesorios/mouse ligitech.png",
        categoria: {
            nombre: "Accesorios",
            id: "Accesorios"
        },
        precio: 1000
    },
    {    
        id: "Mouse-02",
        nombre: "Mouse 02",
        imagen: "./img/Accesorios/mouse razer.png",
        categoria: {
            nombre: "Accesorios",
            id: "Accesorios"
        },
        precio: 2000
    },
    {    
        id: "Otros-productos-01",
        nombre: "Otros-productos 01",
        imagen: "./img/Accesorios/cpu-gamer.png",
        categoria: {
            nombre: "Otros productos",
            id: "Otros-productos"
        },
        precio: 500000
    },
    {    
      id: "Otros-productos-02",
      nombre: "Otros-productos 02",
      imagen: "./img/OtrosProductos/playstation5.webp",
      categoria: {
          nombre: "Otros productos",
          id: "Otros-productos"
      },
      precio: 500000
    }


    
];
/*Traemos desde el html  */
const contenedorProductos = document.querySelector("#contenedor-productos");
const botonesCategoria = document.querySelectorAll(".boton-categoria");
const tituloPrincipal = document.querySelector("#titulo-principal");
let botonesAgregar = document.querySelectorAll(".producto-agregar");
const numerito = document.querySelector("#numerito");

function traerProductos() {
    // const xhr = new XMLHttpRequest();
    // function onRequestHandler() {
    //     if (this.readyState === 4 && this.status === 200) {
    //         const data = JSON.parse(this.response);
    //         console.log(data)
    //     }
    // }
    //
    // xhr.addEventListener("load", onRequestHandler);
    // xhr.open("GET","http://localhost:8080/producto/getProductos");
    // xhr.send();




    let listadoActualizado = [];
    let url = 'http://localhost:8080/producto/getProductos'
    fetch(url)
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            let productos = data;

            productos.map(function(producto) {
                console.log(producto)
                listadoActualizado.push(producto)
            });
            return listadoActualizado;
        })
    // const userAction = async () => {
    //     const response = await fetch(url, {
    //         method: 'POST',
    //         body: '', // string or object
    //         headers: {
    //             'Content-Type': 'application/json'
    //         }
    //     });
    //     console.log(response)
    //     const myJson = await response.json(); //extract JSON from the http response
    //     console.log(myJson)
    //
        // do something with myJson
    // }

}


function cargarProductos(ProductosElegidos){
    traerProductos();
    contenedorProductos.innerHTML ="";

    ProductosElegidos.forEach(producto => { /*El forEach recorre todo el array */

        const div = document.createElement("div");
        div.classList.add("producto");
        div.innerHTML = `
            <img class="producto-imagen" src="${producto.imagen}" alt="${producto.nombre}">
            <div class="producto-detalles">
                <h3 class="producto-titulo"> ${producto.nombre}</h3>
                <p class="producto-precio">${producto.precio}</p>
                <button class="producto-agregar" id="${producto.id}">Agregar</button>
            </div>
        `;

        contenedorProductos.append(div);

    })

    actualizarBotonesAgregar();
}
productos_actualizados = traerProductos();
cargarProductos(productos);  /*Llamamos a la función */

botonesCategoria.forEach(boton => {
    boton.addEventListener("click", (e) => {
        botonesCategoria.forEach(boton => boton.classList.remove("active")); /*Le sacamos el active del boton que esta seleccionado */
        e.currentTarget.classList.add("active");

        if (e.currentTarget.id != "todos") {
            const productoCategoria = productos.find(producto => producto.categoria.id === e.currentTarget.id);
            tituloPrincipal.innerText = productoCategoria.categoria.nombre;

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

let productosEnCarrito;

let productosEnCarritoLS = localStorage.getItem("productos-en-carrito");

if (productosEnCarritoLS) {
    productosEnCarrito = JSON.parse(productosEnCarritoLS);
    actualizarNumerito();
} else {
    productosEnCarrito = [];
}


function agregarAlCarrito(e) {

    const idBoton = e.currentTarget.id;
    const productoAgregado = productos.find(producto => producto.id === idBoton);

    if(productosEnCarrito.some(producto => producto.id === idBoton)){
        const index = productosEnCarrito.findIndex(producto => producto.id === idBoton);
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

