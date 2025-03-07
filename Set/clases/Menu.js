class Menu {
    constructor() {
        this.buttons = [
            {text: "Jugar", y: 200},
            {text: "Instrucciones", y: 270},
            {text: "Mejores Puntajes", y: 340}
        ];
    }

    display() {
        background(220);
        text(36);
        textAlign(CENTER);
        fill(0);
        text("SET GAME", width / 2, 100);

        this.buttons.forEach(btn => {
            fill(50);
            rectMode(CENTER);
            rect(width / 2, btn.y, 200, 50, 10);

            fill(200);
            textSize(20);
            textAlign(CENTER, CENTER);
            text(btn.text, width / 2, btn.y);
        });
    }
}
