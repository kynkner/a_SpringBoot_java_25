console.log("Hello Word");

let age;
age = 35;
console.log(age);
let email = "nguyentuandung241002@gmail.com";
console.log(email);

let name = "Nguyen Dung";
let year = 2002;
console.log(`Xin chào các bạn, mình tên là ${name}. Năm nay ${2024 - year} tuổi`);

//function
//c1: regular function
function sum(a, b){
    return a + b;
}

//c2: function expresstion
let sum1 = function(a, b){
    return a + b;
}

//c3: Arrow function(ES6) 
let sum2 = (a,b) =>{
    return a + b;
}
/*
Bài 1: Viết function nhập vào biến mark có giá trị từ 0 -> 100. Kiểm tra giá trị của biến mark và in ra nội dụng sau

”A” nếu mark >= 85
”B” nếu 70 <= mark < 85 (70 <= mark && mark < 85)
”C” nếu 40 <= mark < 70 (40 <= mark && mark <70)
Các trường hợp còn lại in ra “D”
*/

console.log(sum(10, 20));
console.log(sum1(11, 21));
console.log(sum2(12, 22));

let mark = Math.floor(Math.random() * 101);
console.log(mark)
if(mark >= 85){
    console.log("A");  
}if (70 <= mark < 85){
    console.log("B");
} if(40<= mark < 70){
    console.log("C");
}else{
    console.log("D");
};

// Bài 2: Viết function truyền vào 2 số a, b. In ra màn hình số có giá trị lớn hơn
 function max(a, b){
    if(a > b){
        console.log(a);
    }else{
        console.log(b);
    }
 };
// Bài 3: Viết function nhập vào 1 số. Kiểm tra số đó là số âm, số dương hay là số 0.
function inspect(n){
    if(n < 0){
        console.log("so am");
    }if(n > 0){
        console.log("so duong");
    }else{
        console.log("so 0");
    }    
}
// Bài 4: Viết function nhập vào 1 số. Kiểm tra số đó là số chẵn hay số lẻ.

// Bài 5: Viết function nhập vào 1 số. Kiểm tra số đó có đồng thời chia hết cho 3 và 5 không.

// Bài 6: Viết function nhập vào 3 số a, b, c. Kiểm tra xem c có bằng a + b không?