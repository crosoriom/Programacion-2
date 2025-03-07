class Game {
    constructor(mode) {
        this.deck = new Deck();
        this.board = null;
        this.selectedCards = [];
        this.setsFound;
        this.mode = mode;
        this.score;
    }

    startGame() {
        this.deck.generateDeck();
        this.deck.shuffleDeck();
        this.dealInitialCards();
        this.score = 0;
        this.setsFound = 0;
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

    display() {
        background(240);

        if(this.board) {
            this.board.display();
        }
    }

    handleClick() {
        const cell = this.board.getCardAtPosition();
        if(cell === null || cell === undefined) return;

        const clickedCard = this.board.cards[cell];
        if(this.selectedCards.includes(clickedCard))
            this.selectedCards = this.selectedCards.filter(card => card !== clickedCard);
        else
            this.selectedCards.push(clickedCard);

        const selectedCells = this.selectedCards.map(card => this.board.cards.indexOf[card]);
        this.board.highlightSet(selectedCells);
        if(this.selectedCards.length === 3) {
            if(this.deck.isValidSet(this.selectedCards)) {
                this.board.removeCards(this.selectedCards);
                this.setsFound++;
                this.addCardsToBoard();
            }
            this.board.clearHighLight();
            this.selectedCards = [];
        }
    }

    hint() {
        this.selectedCards = [];
        this.score = Math.max(0, this.score - 5);

        const setHint = this.deck.findValidSet(this.board.cards);
        this.board.highlightSet(setHint[0]);
    }
}
