let mouseDistance = 50;
let figureSize = 10;
let blocks = [];

function createBlocks(rows, columns, figure) {
    for(let i = 0; i < rows; i++) {
        blocks[i] = [];
        for(let j = 0; j < columns; j++) {
            if(figure === "square") {
                blocks[i][j] = new Block(figureSize / 2 + i * figureSize,figureSize / 2 + j * figureSize, figureSize)
            } else if (figure === "cross") {
                blocks[i][j] = new Cross(figureSize / 2 + i * figureSize,figureSize / 2 + j * figureSize, figureSize)
            }
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
    createBlocks(width / figureSize, height / figureSize, cross);
}

function draw() {
    background(0);
    moveBlocks(-1);
}
