class Circle {
    static pi: number = 3.14;
    
    static calculateArea(radius:number) {
        return this.pi * radius * radius;
    }
}

console.log(Circle.pi); // returns 3.14
console.log(Circle.calculateArea(5)); // returns 78.5
