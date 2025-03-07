class Game {
    constructor(mode) {
        this.deck = new Deck();
        this.board = null;
        this.selectedCards = [];
        this.setsFounds = 0;
        this.mode = mode;
    }

    startGame() {
        this.deck.generateDeck();
        this.deck.shuffleDeck();
        this.dealInitialCards();
    }

    dealInitialCards() {
        do {
            this.board = new Board(this.deck.dealCards(12));
        } while(!this.deck.hasValidSet(this.board.cards) && this.deck.cards.length > 0);
    }

    addCardsToBoard() {
        if(this.deck.cards.length === 0) return;

        const newCards = this.deck.dealCards(3);
        this.board.addCards(newCards);

        if(!this.deck.hasValidSet(this.board.cards)) {
            this.deck.cards.push(...newCards);
            this.board.removeCards(newCards);
            this.addCardsToBoard();
        }
    }

    handleClick(x, y) {
        const cell = this.quadrille.getCell(x, y);
        if(!cell) return;

        const clickedCard = this.board.cards[cell.index];
        if(this.selectedCards.includes(clickedCard))
            this.selectedCards.pop(clickedCard);
        else
            this.selectedCards.push(clickedCard);
        this.board.highlightSet(this.selectedCards);

        if(this.selectedCards.length === 3) {
            if(this.deck.isValidSet(this.selectedCards)) {
                this.board.removeCards(this.selectedCards);
                this.setsFounds++;
                this.addCardsToBoard();
            }
            this.board.clearHighLight();
            this.selectedCards = [];
        }
    }

    hint() {
        this.selectedCards = [];

        let setHint = this.deck.findValidSet(this.board.cards);
        this.board.highlightSet(setHint);
    }
}
