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
        let corner = (this.size - offset) / 2;
        line(-corner, corner, corner, -corner);
        line(-corner, -corner, corner, corner);
        pop();
    }

    move(direction) {
        let distance = dist(mouseX, mouseY, this.x, this.y);
        if(distance < mouseDistance && (pmouseX - mouseX != 0 || pmouseY - mouseY != 0)) {
            this.color = 160;
            this.angle += direction;
        } else if(this.angle % 90 != 0) {
            this.angle += direction;
            this.color -= 1;
        } else {
            this.color = 70;
        }
    }
}
