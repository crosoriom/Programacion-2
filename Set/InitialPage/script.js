document.addEventListener("DOMContentLoaded", () => {
    // Elementos de la pantalla inicial
    const btnJugar = document.getElementById("btn-jugar")
    const btnInstrucciones = document.getElementById("btn-instrucciones")
    const btnPuntajes = document.getElementById("btn-puntajes")
  
    // Pantallas
    const pantallaInicial = document.getElementById("pantalla-inicial")
    const pantallaJuego = document.getElementById("pantalla-juego")
    const pantallaInstrucciones = document.getElementById("pantalla-instrucciones")
    const pantallaPuntajes = document.getElementById("pantalla-puntajes")
  
    // Botones para volver
    const botonesVolver = document.querySelectorAll(".btn-volver")
  
    // Función para mostrar una pantalla y ocultar las demás
    function mostrarPantalla(pantalla) {
      // Ocultar todas las pantallas
      pantallaInicial.classList.add("oculto")
      pantallaJuego.classList.add("oculto")
      pantallaInstrucciones.classList.add("oculto")
      pantallaPuntajes.classList.add("oculto")
  
      // Mostrar la pantalla seleccionada
      pantalla.classList.remove("oculto")
    }
  
    // Event listeners para los botones de la pantalla inicial
    btnJugar.addEventListener("click", () => {
      mostrarPantalla(pantallaJuego)
    })
  
    btnInstrucciones.addEventListener("click", () => {
      mostrarPantalla(pantallaInstrucciones)
    })
  
    btnPuntajes.addEventListener("click", () => {
      mostrarPantalla(pantallaPuntajes)
    })
  
    // Event listeners para los botones de volver
    botonesVolver.forEach((boton) => {
      boton.addEventListener("click", () => {
        mostrarPantalla(pantallaInicial)
      })
    })
  
    // Efecto de sonido al hacer clic en los botones (opcional)
    const botones = document.querySelectorAll(".btn")
    botones.forEach((boton) => {
      boton.addEventListener("click", function () {
        // Aquí podrías agregar un efecto de sonido
        // Por ejemplo: new Audio('click.mp3').play();
  
        // Efecto visual al hacer clic
        this.style.transform = "scale(0.95)"
        setTimeout(() => {
          this.style.transform = ""
        }, 100)
      })
    })
  
    // Función para cargar los mejores puntajes (simulado)
    function cargarMejoresPuntajes() {
      // Aquí podrías cargar los puntajes desde localStorage o una API
      const puntajes = [
        { nombre: "Jugador 1", puntos: 1000 },
        { nombre: "Jugador 2", puntos: 850 },
        { nombre: "Jugador 3", puntos: 720 },
        { nombre: "Jugador 4", puntos: 650 },
        { nombre: "Jugador 5", puntos: 520 },
      ]
  
      const listaPuntajes = document.getElementById("lista-puntajes")
      listaPuntajes.innerHTML = ""
  
      puntajes.forEach((puntaje) => {
        const li = document.createElement("li")
        li.textContent = `${puntaje.nombre}: ${puntaje.puntos} pts`
        listaPuntajes.appendChild(li)
      })
    }
  
    // Cargar los puntajes al iniciar
    cargarMejoresPuntajes()
  })
  
  