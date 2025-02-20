class Cross{
    constructor(x, y, size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.angle = 0;
        this.color = 70;
    }

    display() {
        push();
        translate(this.x, this.y);
        rotate(this.angle);
        stroke(this.color);
        line(-this.size / 2, -this.size / 2, this.size / 2, this.size / 2);
        line(-this.size / 2, this.size / 2, this.size / 2, -this.size / 2);
        pop();
    }

    move(direction) {
        let distance = dist(mouseX, mouseY, this.x, this.y);
        if(distance < mouseDistance && (pmouseX - mouseX != 0 || pmouseY - mouseY != 0)) {
            this.angle += direction;
        } else if(this.angle % 90 != 0) {
            this.angle += direction;
        }
    }
}
