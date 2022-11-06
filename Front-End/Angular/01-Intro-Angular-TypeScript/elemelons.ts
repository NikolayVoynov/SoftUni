abstract class Melon {
    public weight: number;
    public melonSort: string;

    constructor(weight: number, melonSort: string) {
        this.weight = weight;
        this.melonSort = melonSort;
    }

}

class Watermelon extends Melon {
    private elementIndex: number;
    
    constructor(weight: number, melonSort: string) {
        super(weight, melonSort);
    }

    private getElementIndex(): number {
        return this.weight * this.melonSort.length;
    }

    toString(): void {
        console.log('Element: Water');
        console.log('Sort: ' + this.melonSort);
        console.log('Element Index: ' + this.getElementIndex());
    }
}

class Firemelon extends Melon {
    private elementIndex: number;

    constructor(weight: number, melonSort: string) {
        super(weight, melonSort);
    }

    private getElementIndex(): number {
        return this.weight * this.melonSort.length;
    }

    toString(): void {
        console.log('Element: Fire');
        console.log('Sort: ' + this.melonSort);
        console.log('Element Index: ' + this.getElementIndex());
    }
}

class Earthmelon extends Melon {
    private elementIndex: number;

    constructor(weight: number, melonSort: string) {
        super(weight, melonSort);
    }

    private getElementIndex(): number {
        return this.weight * this.melonSort.length;
    }

    toString(): void {
        console.log('Element: Earth');
        console.log('Sort: ' + this.melonSort);
        console.log('Element Index: ' + this.getElementIndex());
    }
}

class Airmelon extends Melon {
    private elementIndex: number;

    constructor(weight: number, melonSort: string) {
        super(weight, melonSort);
    }

    private getElementIndex(): number {
        return this.weight * this.melonSort.length;
    }

    toString(): void {
        console.log('Element: Air');
        console.log('Sort: ' + this.melonSort);
        console.log('Element Index: ' + this.getElementIndex());
    }
} 


let watermelon : Watermelon = new Watermelon(12.5, "Kingsize");
console.log(watermelon.toString());
