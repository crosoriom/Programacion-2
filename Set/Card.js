class Card {
    constructor(shape, color, number, shading) {
        this.shape = shape;
        this.color = color;
        this.number = number;
        this.shading = shading;
        this.highlighted = false;
    }

    display(cell) {
        const {x, y, size} = cell;
        push();
        translate(x, y);
        noStroke();

        if(this.highlighted) {
            fill(128, 0, 128, 100);
            rectMode(CENTER);
            rect(0, 0, size * 0.9, size * 0.9);
        }

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
                    rectMode(CENTER);
                    rect(x, y, size / 4, size / 4);
                case "circle":
                    circle(point.x, point.y, size / 4);
                case "triangle":
                    triangle(
                        x - size / 8, y + size / 8,
                        x + size / 8, y + size / 8,
                        x, y - size / 8
                    );
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

    setHighlighted(state) {
        this.selected = state;
    }
}
