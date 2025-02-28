class Game {
    constructor() {
        this.deck = new Deck();
        this.board = new Board();
        this.selectedCards = [];
    }

    startGame() {
        this.deck.generateDeck();
        this.deck.shuffleDeck();
        this.dealInitialCards();
    }

    dealInitialCards() {
        do {
            this.board = this.deck.dealCards(12);
        } while(!this.deck.hasValidSet(this.board) && this.deck.cards.length > 0);
    }

    addCardsToBoard() {
        if(this.deck.cards.length === 0) return;

        const newCards = this.deck.dealCards(3);
        this.board.push(...newCards);

        if(!this.deck.hasValidSet(this.board)) {
            this.deck.cards.push(...newCards);
            this.board.splice(-3);
            this.addCardsToBoard();
        }
    }

    handleClick(x, y) {
        const cell = this.quadrille.getCell(x, y);
        if(!cell) return;

        const clickedCard = this.board.cards[cell.index];
        if(this.selectedCards.includes(clickedCard)) return;
        this.selectedCards.push(clickedCard);
        this.board.highlightSet(this.selectedCards);
    }
}
