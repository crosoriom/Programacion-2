class Block {
    constructor(x, y, size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.angle = 0;
        this.color = 76;
    }

    display() {
        push();
        translate(this.x, this.y);
        rotate(this.angle);
        noFill();
        stroke(this.color);
        rect(0, 0, this.size - offset, this.size - offset);
        pop();
    }

    move(direction) {
        let distance = dist(mouseX, mouseY, this.x, this.y);
        if(distance < mouseDistance && (pmouseX - mouseX != 0 || pmouseY - mouseY != 0)) {
            this.color = 166;
            this.angle += direction;
        } else if(this.angle % 90 != 0) {
            this.angle += direction;
            this. color -= 1;
        } else {
            this.color = 76;
        }
    }
}
