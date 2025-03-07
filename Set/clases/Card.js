class Card {
    constructor(shape, colorStr, number, shading) {
        this.shape = shape;
        this.number = number;
        this.shading = shading;
        this.highlighted = false;

        switch(colorStr) {
            case "red":
                this.color = color(200, 50, 50);
                break;
            case "green":
                this.color = color(50, 200, 50);
                break;
            case "blue":
                this.color = color(50, 50, 200);
                break;
        }
    }

    display(cell) {
        const {x, y, size} = cell;
        push();
        translate(x, y);
        stroke(0);
        strokeWeight(1);
        fill(255);
        rectMode(CENTER);
        rect(0, 0, size * 0.9, size * 0.9, 10);

        // Dibuja las formas
        const points = this.calculatePoints(size);
        points.forEach((point) => {
            push();
            translate(point.x, point.y);

            switch(this.shading) {
                case "solid":
                    fill(this.color);
                    noStroke();
                    break;
                case "stripped":
                    this.drawStrippedPattern(size / 6, this.color);
                    stroke(this.color);
                    strokeWeight(2);
                    break;
                case "open":
                    noFill();
                    stroke(this.color);
                    strokeWeight(2);
                    break;
            }

            switch(this.shape) {
                case "square":
                    rectMode(CENTER);
                    rect(0, 0, size / 6, size / 6);
                    break;
                case "circle":
                    circle(0, 0, size / 6);
                    break;
                case "triangle":
                    triangle(
                        -size / 12, size / 12,
                        size / 12, size / 12,
                        0, -size / 12
                    );
                    break;
            }

            pop();
        });
        // Resalta la carta cuando está seleccionada
        if(this.highlighted) {
            fill(120, 0, 150, 50);
            rectMode(CENTER);
            rect(0, 0, size * 0.9, size * 0.9, 10);
        }
        pop();
    }

    calculatePoints(size) {
        const spacing = size / 4;
        const points = [];

        switch(this.number) {
            case 1:
                points.push({x: 0, y: 0});
                break;
            case 2:
                points.push({x: 0, y: spacing / 2});
                points.push({x: 0, y: -spacing / 2});
                break;
            case 3:
                points.push({x: 0, y: spacing});
                points.push({x: 0, y: 0});
                points.push({x: 0, y: -spacing});
                break;
        }
        return points;
    }

    drawStrippedPattern(size, color) {
        noFill();
        stroke(color);
        strokeWeight(1);
        for(let i = -size / 2; i <= size / 2; i += 4)
            line(i, -size / 2, i, size / 2);
    }

    setHighlighted(state) {
        this.selected = state;
    }
}
