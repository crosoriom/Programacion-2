class Card {
    constructor(shape, color, number, shading) {
        this.shape = shape;
        this.color = color;
        this.number = number;
        this.shading = shading;
    }

    display() {
        switch(this.shading) {
            case "solid":
            case "stripped":
            case "open":
            case default:
        }
        switch(this.shape) {
            case "triangle":
            case "circle":
            case "square":
            case default:
        }
        switch(this.color) {
            case "red":
                fill(255, 0, 0);
            case "green":
                fill(0, 255, 0);
            case "blue":
                fill(0, 0, 255);
            case default:
        }
    }
}
