class Box<T> {
    private boxes = [];

    public add(element: T) {
        this.boxes.push(element);
    }

    public remove() {
        this.boxes.pop();
    }

    public count(): number{
        return this.boxes.length;
    }
}