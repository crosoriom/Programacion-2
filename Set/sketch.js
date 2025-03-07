let game;

let currentScreen = "Menu";

function setup() {
    createCanvas(800, 600);

    game = new Game("classic");
    game.startGame();
}

function draw() {
    game.display();
}

function mouseClicked() {
    game.handleClick();
}
