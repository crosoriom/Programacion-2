class Block {
    constructor(x, y, size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.angle = 0;
    }

    display() {
        translate(this.x, this.y);
        rotate(this.angle);
        rect(0, 0, this.size, this.size);
        fill(76, 180, 183);
    }

    move(direction) {
        let distance = dist(mouseX, mouseY, this.x, this.y);
        if(distance < mouseDistance) {
            this.angle += direction;
        }
    }
}
