class Board {
    constructor() {
        this.cards = [];
        this.quadrille = null;
        this.highlightedSet = [];
    }

    display() {
        if(!this.quadrille || this.quadrille.length !== this.cards.length) {
            this.quadrille = createQuadrille(4, Math.ceil(this.cards.length / 4), (cell) => {
                this.cards[cell.index].display(cell);
            });
        }
        this.quadrille.display();
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
}
