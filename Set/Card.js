class Card {
    constructor(shape, color, number, shading) {
        this.shape = shape;
        this.color = color;
        this.number = number;
        this.shading = shading;
    }

    display(cell) {
        const {x, y, size} = cell;
        push();
        translate(x, y);
        noStroke();

        switch(this.shading) {
            case "solid":
                fill(this.color);
            case "stripped":
                fill(255);
                stroke(this.color);
                strokeWeight(2);
            case "open":
                noFill();
                stroke(this.color);
        }

        const points = this.calculatePoints(size);
        points.forEach((point) => {
            switch(this.shape) {
                case "square":
                    this.drawSquare(point.x, point.y, size / 4);
                case "circle":
                    circle(point.x, point.y, size / 4);
                case "triangle":
                    this.drawTriangle(point.x, point.y, size / 4);
            }
        });

        pop();
    }

    calculatePoints(size) {
        const spacing = size / 4;
        const points = [];

        switch(this.number) {
            case 1:
                points.push({x: 0, y: 0});
            case 2:
                points.push({x: 0, y: spacing / 2});
                points.push({x: 0, y: -spacing / 2});
            case 3:
                points.push({x: 0, y: spacing});
                points.push({x: 0, y: 0});
                points.push({x: 0, y: -spacing});
        }
        return points;
    }

    drawSquare(x, y, size) {
        rectMode(CENTER);
        rect(x, y, size, size);
    }

    drawTriangle(x, y, size) {
        triangle(
            x - size / 2, y + size / 2,
            x + size / 2, y + size / 2,
            x, y - size / 2
        );
    }
}
