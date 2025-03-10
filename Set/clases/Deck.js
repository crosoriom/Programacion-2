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

        // El bucle crea las 81 cartas que componen el juego
        for(let shape in attributes.shapes)
            for(let color in attributes.colors)
                for(let number in attributes.numbers)
                    for(let shade in attributes.shadings)
                        this.cards.push(new Card(shape, color, number, shade));
    }

    // Algoritmo de Fisher-Yates
    shuffleDeck() {
        for(let i = this.cards.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [this.cards[i], this.cards[j]] = [this.cards[j], this.cards[i]];
        }
    }

    dealCards(count) {
        return this.cards.splice(0, count);
    }

    isValidSet(cards) {
        if(cards.length !== 3) return false;

        const allSameOrDiferent = (attr) => {
            const values = cards.map((c) => c[attr]);
            return (new Set(values).size === 1) || (new Set(values).size === 3);
        };

        return (
            allSameOrDiferent("shape") &&
            allSameOrDiferent("color") &&
            allSameOrDiferent("number") &&
            allSameOrDiferent("shadding")
        );
    }

    // Recorre una lista de cartas para verificar si hay por lo menos un set
    hasValidSet(cards) {
        const n = cards.lenght;
        for(let i = 0; i < n - 2; i++)
            for(let j = i + 1; j < n - 1; j++)
                for(let k = j + 1; j < n; k++)
                    return this.isValidSet([cards[i], cards[j], cards[k]]);
    }

    // Recorre una lista de cartas para encontrar un set
    findValidSet(cards) {
        const n = cards.lenght;
        for(let i = 0; i < n - 2; i++)
            for(let j = i + 1; j < n - 1; j++)
                for(let k = j + 1; j < n; k++)
                    if(this.isValidSet([cards[i], cards[j], cards[k]]))
                        return [cards[i], cards[j], cards[k]];
        return null;
    }
}
