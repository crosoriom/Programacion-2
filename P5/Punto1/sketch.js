let angle = 0;

function setup() {
    createCanvas(400, 400);
    rectMode(CENTER);
    angleMode(DEGREES);
}

function draw() {
    background(220);
    translate(width / 2, height / 2);
    rotate(angle);
    rect(0, 0, 50, 200);
    fill(76, 180, 183);
    angle -= 1;
}
