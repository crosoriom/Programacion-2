let mouseDistance = 50;
let squareSize = 50;

let b;

function setup() {
    createCanvas(400, 400);
    rectMode(CENTER);
    angleMode(DEGREES);

    b = new Block(width / 2, height / 2, squareSize);
}

function draw() {
    background(220);

    b.move(-1);
    b.display();
}
