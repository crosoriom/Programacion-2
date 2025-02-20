let mouseDistance = 50;
let squareSize = 10;
let blocks = [];

function createBlocks(rows, columns) {
    for(let i = 0; i < rows; i++) {
        blocks[i] = [];
        for(let j = 0; j < columns; j++) {
            blocks[i][j] = new Block(squareSize / 2 + i * squareSize,squareSize / 2 + j * squareSize, squareSize)
        }
    }
}

function moveBlocks(direction) {
    for(let i = 0; i < blocks.length; i++) {
        const rows = blocks[i];
        for(let j = 0; j < rows.length; j++) {
            blocks[i][j].move(direction);
            blocks[i][j].display();
        }
    }
}

function setup() {
    createCanvas(600, 600);
    rectMode(CENTER);
    angleMode(DEGREES);
    createBlocks(width / squareSize, height / squareSize);
}

function draw() {
    background(0);
    moveBlocks(-1);
}
