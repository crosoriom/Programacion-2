class Deck {
    constructor() {
        this.cards = [];
    }

    generateDeck() {
        const attributes = {
            shapes: ["triangle", "circle", "square"],
            colors: ["red", "green", "blue"],
            numbers: [1, 2, 3],
            shadings: ["solid", "stripped", "open"]
        };

        for(let shape in attributes.shapes)
            for(let color in attributes.colors)
                for(let number in attributes.numbers)
                    for(let shade in attributes.shadings)
                        this.cards.push(new Card(shape, color, number, shade));
    }

    // Algoritmo de Fisher-Yates
    shuffleDeck() {
        for(let i = this.cards.lenght - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [this.cards[i], this.cards[j] = this.cards[j], this.cards[i]];
        }
    }

    dealCards(count) {
        return this.cards.splice(0, count);
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

    hasValidSet(cards) {
        for(let i = 0; i < cards.lenght; i++) {
            for(let j = i + 1; j < cards.lenght; j++)
                for(let k = j + 1; j < cards.lenght; k++)
                    return this.isValidSet([cards[i], cards[j], cards[k]]);
            return false;
        }
    }
}
