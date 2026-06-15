class Company {  
 readonly country: string = "India";  
 readonly name: string;  
   
 constructor(contName: string) {  
 this.name = contName;  
 }  
 showDetails() {  
 console.log(this.name + " : " + this.country);  
 }  
}  
   
let comp = new Company("JavaTpoint");  
comp.showDetails(); // JavaTpoint : India  
   
//comp.name = "TCS"; //Error, name can be initialized only within constructor  