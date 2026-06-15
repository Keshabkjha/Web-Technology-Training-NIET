var Company = /** @class */ (function () {
    function Company(contName) {
        this.country = "India";
        this.name = contName;
    }
    Company.prototype.showDetails = function () {
        console.log(this.name + " : " + this.country);
    };
    return Company;
}());
var comp = new Company("JavaTpoint");
comp.showDetails(); // JavaTpoint : India  
//comp.name = "TCS"; //Error, name can be initialized only within constructor  
