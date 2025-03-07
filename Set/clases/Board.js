class Board {
    constructor(cards) {
        this.cards = cards;
        this.quadrille = null;
        this.highlightedSet = [];
    }

    display() {
        // Si no se ha creado la cuadrilla, la crea. Si está creada, se encarga de redimensionarla según el número de cartas presentes si es necesario.
        if(!this.quadrille || this.quadrille.length !== this.cards.length) {
            const rows = Math.ceil(this.cards.length / 4);
            this.quadrille = createQuadrille(Array(rows).fill().map((_, rowIndex) =>
                Array(4).fill().map((_, colIndex) => {
                    const index = rowIndex * 4 + colIndex;
                    return index < this.cards.length ? index : undefined;
                })
            ));
        }
        
        const baseX = 100, baseY = 100, cellSize = 100;
        for(let row = 0; row < this.quadrille.height; row++)
            for(let col = 0; col < this.quadrille.width; col++) {
                let cell = this.quadrille.memory2D[row][col];
                if(cell !== undefined && cell < this.cards.length) {
                    push();
                    translate(baseX + col * cellSize + cellSize / 2, baseY + row * cellSize + cellSize / 2);
                    this.cards[cell].display({
                        x: 0,
                        y: 0,
                        size: cellSize
                    });
                    pop();
                }
            }
    }

    highlightSet(cards) {
        this.clearHighLight();
        this.highlightedSet = cards;
        this.highlightedSet.forEach(card => card.setHighlighted(true));
    }

    clearHighLight() {
        this.highlightedSet.forEach(card => card.setHighlighted(false));
        this.highlightedSet = [];
    }

    addCards(cards) {
        cards.forEach(card => this.cards.push(card));
        this.quadrille = null;
    }

    removeCards(cards) {
        this.cards = this.cards.filter(card => !cards.includes(card));
        this.quadrille = null;
    }

    getCardAtPosition(x, y) {
        const gridX = Math.floor((x - 100) / 100);
        const gridY = Math.floor((y - 100) / 100);

        if(gridX >= 0 && gridX < 4 && gridY >= 0 && gridY < 3) {
            const index = gridY * 4 + gridX;
            if(index < this.cards.length)
                return this.cards[index];
        }
        return null;
    }
}
