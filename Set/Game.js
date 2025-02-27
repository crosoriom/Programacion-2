class Game {
    constructor() {
        this.deck = [];
        this.board = [];
        this.selectedCards = [];
        this.mode = mode;
        this.quadrille = NULL;
    }

    generateDeck() {
        const shapes = ["triangle", "circle", "square"];
        const colors = ["red", "green", "blue"];
        const numbers = [1, 2, 3];
        const shadings = ["solid", "stripped", "open"];

        for(let shape in shapes)
            for(let color in colors)
                for(let number in numbers)
                    for(let shade in shadings)
                        this.deck.push(new Card(shape, color, number, shade));
    }

    shuffleDeck() {
        for(let i = this.deck.lenght - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [this.deck[i], this.deck[j] = this.deck[j], this.deck[i]];
        }
    }

    dealCards() {
        do {
            this.board = this.deck.splice(0, 12);
        } while(!isValidSet(this.board));

        this.quadrille = createQuadrille(4, 3, (cell) => {
        })
    }

    isValidSet(cards) {
        const allSameOrDiferent = (attr) => {
            const values = cards.map((c) => c[attr]);
            return new Set(values).size === 1 || new Set(values).size === 3;
        };

        return (
            allSameOrDiferent("shape") &&
            allSameOrDiferent("color") &&
            allSameOrDiferent("number") &&
            allSameOrDiferent("shadding")
        );
    }


}
