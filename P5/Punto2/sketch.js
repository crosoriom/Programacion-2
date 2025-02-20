let angle = 0;
let mouseDistance = 50;

function setup() {
    createCanvas(400, 400);
    rectMode(CENTER);
    angleMode(DEGREES);
}

function draw() {
    background(220);
    let distance = dist(mouseX, mouseY, width / 2, height / 2);
    translate(width / 2, height / 2);
    if(distance < mouseDistance) {
        angle -= 1;
    }
    rotate(angle);
    rect(0, 0, 50, 200);
    fill(76, 180, 183);
}
