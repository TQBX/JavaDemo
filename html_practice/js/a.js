

console.log(Number.MAX_VALUE); //1.7976931348623157e+308
console.log(Number.MIN_VALUE); //5e-324

console.log(Number.NEGATIVE_INFINITY); // -Infinity
console.log(-Infinity); // -Infinity

console.log(Number.POSITIVE_INFINITY); // Infinity
console.log(Infinity); //Infinity

console.log(Number.NaN); //NaN


console.log(NaN == "abc");//false
console.log(NaN == 123);//false
console.log(NaN == NaN);//false

console.log(isNaN("abc"));//true
console.log(isNaN(123));//false


var str = "abc";
console.log(str.length);//3
console.log(str.split(" "));


console.log(true || false);     // false
console.log(true && false);     //false
console.log(true | false);      //1
console.log(true & false);      //0
console.log(!true);             //false

var a;
console.log(a);                 //undefined
console.log(a === undefined);    //true

console.log(null == undefined); //true
console.log(null === undefined);//false

