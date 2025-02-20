class Block {
    constructor(x, y, size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.angle = 0;
    }

    display() {
        push();
        translate(this.x, this.y);
        rotate(this.angle);
        fill(76, 180, 183);
        rect(0, 0, this.size, this.size);
        pop();
    }

    move(direction) {
        let distance = dist(mouseX, mouseY, this.x, this.y);
        if(distance < mouseDistance) {
            this.angle += direction;
        } else if(this.angle % 90 != 0) {
            this.angle += direction;
        }
    }
}
