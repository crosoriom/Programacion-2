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
        
        const baseX = 0, baseY = 0, cellSize = 100;
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

    highlightSet(cells) {
        this.clearHighLight();
        this.highlightedSet = cells.map(cell => this.cards[cell]);
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

    getCardAtPosition() {
        const row = this.quadrille.mouseRow();
        const col = this.quadrille.mouseCol();

        return this.quadrille.memory2D[row][col];
    }
}
