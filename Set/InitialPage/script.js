document.addEventListener("DOMContentLoaded", () => {
    // Elementos de la pantalla inicial
    const btnJugar = document.getElementById("btn-jugar")
    const btnInstrucciones = document.getElementById("btn-instrucciones")
    const btnPuntajes = document.getElementById("btn-puntajes")
  
    // Pantallas
    const pantallaInicial = document.getElementById("pantalla-inicial")
    const pantallaSelectorModo = document.getElementById("pantalla-selector-modo")
    const pantallaJuego = document.getElementById("pantalla-juego")
    const pantallaInstrucciones = document.getElementById("pantalla-instrucciones")
    const pantallaPuntajes = document.getElementById("pantalla-puntajes")
  
    // Botones para volver
    const botonesVolver = document.querySelectorAll(".btn-volver")
    const btnVolverSelector = document.querySelector(".btn-volver-selector")
  
    // Botones de modo de juego
    const btnModoClasico = document.getElementById("btn-modo-clasico")
    const btnModoTiempo = document.getElementById("btn-modo-tiempo")
    const btnModoZen = document.getElementById("btn-modo-zen")
  
    // Elementos del juego
    const tituloModoJuego = document.getElementById("titulo-modo-juego")
    const contenidoJuego = document.getElementById("contenido-juego")
  
    // Función para mostrar una pantalla y ocultar las demás
    function mostrarPantalla(pantalla) {
      // Ocultar todas las pantallas
      pantallaInicial.classList.add("oculto")
      pantallaSelectorModo.classList.add("oculto")
      pantallaJuego.classList.add("oculto")
      pantallaInstrucciones.classList.add("oculto")
      pantallaPuntajes.classList.add("oculto")
  
      // Mostrar la pantalla seleccionada
      pantalla.classList.remove("oculto")
    }
  
    // Función para iniciar un modo de juego
    function iniciarModoJuego(modo) {
      tituloModoJuego.textContent = `Modo ${modo}`
  
      // Aquí puedes configurar el contenido específico para cada modo
      switch (modo) {
        case "Clásico":
          contenidoJuego.innerHTML = "<p>Has iniciado el modo Clásico. ¡Completa todos los niveles!</p>"
          break
        case "Por Tiempo":
          contenidoJuego.innerHTML =
            '<p>Has iniciado el modo Por Tiempo. ¡Tienes 3 minutos!</p><div id="temporizador">03:00</div>'
          break
        case "Zen":
          contenidoJuego.innerHTML = "<p>Has iniciado el modo Zen. Juega a tu ritmo sin presiones.</p>"
          break
      }
  
      mostrarPantalla(pantallaJuego)
    }
  
    // Event listeners para los botones de la pantalla inicial
    btnJugar.addEventListener("click", () => {
      mostrarPantalla(pantallaSelectorModo)
    })
  
    btnInstrucciones.addEventListener("click", () => {
      mostrarPantalla(pantallaInstrucciones)
    })
  
    btnPuntajes.addEventListener("click", () => {
      mostrarPantalla(pantallaPuntajes)
    })
  
    // Event listeners para los botones de modo de juego
    btnModoClasico.addEventListener("click", () => {
      iniciarModoJuego("Clásico")
    })
  
    btnModoTiempo.addEventListener("click", () => {
      iniciarModoJuego("Por Tiempo")
    })
  
    btnModoZen.addEventListener("click", () => {
      iniciarModoJuego("Zen")
    })
  
    // Event listeners para los botones de volver
    botonesVolver.forEach((boton) => {
      boton.addEventListener("click", () => {
        mostrarPantalla(pantallaInicial)
      })
    })
  
    // Botón para volver al selector de modo desde el juego
    btnVolverSelector.addEventListener("click", () => {
      mostrarPantalla(pantallaSelectorModo)
    })
  
    // Manejo de tabs en la pantalla de puntajes
    const tabBtns = document.querySelectorAll(".tab-btn")
    const tabContents = document.querySelectorAll(".tab-content")
  
    tabBtns.forEach((btn) => {
      btn.addEventListener("click", function () {
        // Desactivar todos los botones y contenidos
        tabBtns.forEach((b) => b.classList.remove("active"))
        tabContents.forEach((c) => c.classList.remove("active"))
  
        // Activar el botón actual
        this.classList.add("active")
  
        // Activar el contenido correspondiente
        const modo = this.getAttribute("data-modo")
        document.getElementById(`puntajes-${modo}`).classList.add("active")
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
      // Esta función ya no es necesaria ya que ahora tenemos tabs con contenido estático
      // Pero podría ser útil si quieres cargar puntajes dinámicamente desde localStorage o una API
    }
  })
    