class Game {
    constructor() {
        this.deck = new Deck();
        this.board = [];
        this.selectedCards = [];
        this.quadrille = null;
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

        this.quadrille = createQuadrille(4, 3, (cell) => {
            this.board[cell.index].display(cell);
        });
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
}
