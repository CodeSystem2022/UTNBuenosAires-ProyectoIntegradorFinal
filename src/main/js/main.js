
//PRODUCTOS
const productos= [
    {
        id: "notebook-01",
        titulo: "Notebook 01",
        imagen: "./img/notebook-asus.jpeg",
        categoria: {
            nombre: "Notebooks",
            id: "notebook"
        },
        precio: 350000
    },
    {    
        id: "notebook-02",
        titulo: "Notebook 02",
        imagen: "./img/notebook-hp.webp",
        categoria: {
            nombre: "Notebooks",
            id: "notebook"
        },
        precio: 265999
    },

    {   
        id: "notebook-03",
        titulo: "Notebook 03",
        imagen: "./img/notebook_lenovo.webp",
        categoria: {
            nombre: "Notebooks",
            id: "notebook"
        },
        precio: 405000
    },
    {    
        id: "Monitor-01",
        titulo: "Monitor 01",
        imagen: "./img/Accesorios/monitor samsung.png",
        categoria: {
            nombre: "Accesorios",
            id: "Monitor Samsung"
        },
        precio: 280000
    },
    {    
        id: "Monitor-02",
        titulo: "Monitor 02",
        imagen: "./img/Accesorios/monitor gigabyte.png",
        categoria: {
            nombre: "Accesorios",
            id: "Monitor Gigabyte"
        },
        precio: 250000
    },
    {    
        id: "Monitor-03",
        titulo: "Monitor 03",
        imagen: "./img/Accesorios/monitor asus.jpg",
        categoria: {
            nombre: "Accesorios",
            id: "Monitor Gigabyte"
        },
        precio: 200000
    },
    {    
        id: "Mouse-01",
        titulo: "Mouse 01",
        imagen: "./img/Accesorios/mouse inalambrico.jpeg",
        categoria: {
            nombre: "Accesorios",
            id: "Mouse Inalambrico"
        },
        precio: 1000
    },
    {    
        id: "Mouse-02",
        titulo: "Mouse 02",
        imagen: "./img/Accesorios/mouse razer.png",
        categoria: {
            nombre: "Accesorios",
            id: "Mouse Razer"
        },
        precio: 2000
    },
    {    
        id: "CPU-01",
        titulo: "CPU 01",
        imagen: "./img/Accesorios/cpu-gamer.png",
        categoria: {
            nombre: "Accesorios",
            id: "CPU gamer"
        },
        precio: 500000
    }


    
];
/*Traemos desde el html  */
const contenedorProductos = document.querySelector("#contenedor-productos");
const BotonesCategoria = document.querySelectorAll(".boton-categoria");


function cargarProductos(){
    productos.forEach(producto => { /*El forEach recorre todo el array */

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

    });
}

cargarProductos();  /*Llamamos a la función */

BotonesCategoria.forEach(boton => {
    boton.addEventListener("click",(e) =>{
       
        BotonesCategoria.forEach(boton => boton.classList.remove("active")); /*Le sacamos el active del boton que esta seleccionado */
        e.currentTarget.classList.add("active");
    })
})