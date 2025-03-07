class ClassicMode {
  constructor() {
    this.score = 0;
    this.setsFound = 0;
  }

  onSetFound() {
    this.score += 10;
    this.setsFound++;
  }

  onInvalidSelection() {
    this.score -= 5;
  }
}

class TimedMode extends ClassicMode {
  constructor() {
    super();
    this.timeLeft = 60;
  }
