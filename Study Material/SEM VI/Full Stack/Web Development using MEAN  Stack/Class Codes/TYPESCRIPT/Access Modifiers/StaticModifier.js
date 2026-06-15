var Circle = /** @class */ (function () {
    function Circle() {
    }
    Circle.calculateArea = function (radius) {
        return this.pi * radius * radius;
    };
    Circle.pi = 3.14;
    return Circle;
}());
console.log(Circle.pi); // returns 3.14
console.log(Circle.calculateArea(5)); // returns 78.5
