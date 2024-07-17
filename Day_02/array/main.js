console.log("jkasbdjhasd")

// Khai báo array rỗng
let arr = [];

// Khai báo array
let number = [];

// Gán giá trị cho các phần tử của array thông qua chỉ số
number[0] = 1;
number[1] = "Nguyen Dung";
number[2] = true;

console.log(number);

// Khai báo và khởi tạo giá trị cho array
let myArr = [1, 2, 3, 4, true, false, "Nguyễn Văn A"];
console.log(myArr);

//Lấy giá trị của phần tử
let numbers1 = [1, 2, 3, 4, 5];
console.log(numbers1[0]) // 1
console.log(numbers1[1]) // 2
console.log(numbers1[4]) // 5
console.log(numbers1[numbers1.length - 1]) // 5

//Cập nhật giá trị cho phần tử mảng
let numbers2 = [1, 2, 3, 4, 5];
numbers2[0] = 10;
numbers2[1] = 20;

console.log(numbers2); // [10, 20, 3, 4, 5]

/*
Bài 1: Viết function để kiểm tra 1 giá trị có nằm trong mảng hay không?

checkElementExist([1,2,3,4,5], 5) => true
checkElementExist([1,2,3,4,5], 6) => false
*/
function checkElementExist(arr, value){
    return arr.includes(value);
};

function checkElementExist(arr, value){
    for(let i = 0; i<= arr.length; i++){
        if(arr[i] == value){
            return true;
        }
    }
    return false;
};
console.log(checkElementExist([1,2,3,4,5], 5));
console.log(checkElementExist([1,2,3,4,5], 6));
/*
Bài 2: Viết function truyền vào 1 mảng các số, và 1 giá trị bất kỳ. Trả về mảng mới với các giá trị lớn hơn giá trị truyền vào

getElementGreater([1,2,3,4,5], 3) => [4,5]
getElementGreater([1,2,3,4,5], 5) => []
*/
function getElementGreater(arr, value){
    let result = [];
    for(let i = 0; i <= arr.length; i++){
        if(arr[i] > value){
            result.push(arr[i]);
        }
    }
    return result;
}
console.log(getElementGreater([1,2,3,4,5], 3));
console.log(getElementGreater([1,2,3,4,5], 5));
/*
Bài 3: Viết function để tạo mã màu HEX ngẫu nhiên.

randomHexCode() => #728a98
randomHexCode() => #a72938
*/
function randomHexCode() {
    const randomvalue = () => Math.floor(Math.random() * 256);

    const red = randomvalue().toString(16).padStart(2,'0');
    const green = randomvalue().toString(16).padStart(2,'0');
    const blue = randomvalue().toString(16).padStart(2,'0');

    const hexCode = `#${red}${green}${blue}`;

    return hexCode;
}
console.log(randomHexCode());
console.log(randomHexCode());
/*
Bài 4: Viết function để tạo mã màu RGB ngẫu nhiên.

randomRgbCode() => rgb(213,43,133)
randomRgbCode() => rgb(12,32,122)
*/
function randomRgbCode(){
    const randomvalue = () => Math.floor(Math.random() * 256);

    const red = randomvalue();
    const green = randomvalue();
    const blude = randomvalue();

    return `rgb(${red},${green},${blude})`;
}
console.log(randomRgbCode());
console.log(randomRgbCode());
/*Bài 1: Viết function tìm số lớn nhất trong mảng*/

function max(arr){
    arr.sort((a,b) => b - a);
    return arr[0];
}
console.log(max([4,2,5,6,2,7]));
// Bài 2: Viết function tìm số nhỏ nhất trong mảng

function min(arr){
    arr.sort((a,b) => a - b);
    return arr[0];
}
console.log(min([4,2,5,6,2,7]));
/*Bài 3: Viết function cho phép truyền vào 1 mảng các số, kết quả trả về là 1 mảng mới với các số là số dư tương ứng khi chia mảng cũ cho 2
Ví dụ : [4,2,5,6,2,7] => [0,0,1,0,0,1]
*/
    function surplus(arr){
        let result = [];
        for(let i = 0; i < arr.length; i++){
            result.push(arr[i] % 2);
        }
        return result;
    }
    console.log(surplus([4,2,5,6,2,7]));
/*
Bài 4: Viết function truyền vào 1 chuỗi, hãy sao chép đó chuỗi lên 10 lần (Sử dụng array để làm)

Ví dụ: repeatString(‘a’) => Kết quả trả về là ‘aaaaaaaaaa’
*/
function repeatString(arr){
   let arr1 = Array.from({length : 10}, () => arr);
   
   let result = arr1.join('');
   return result;
};
console.log(repeatString("a"));
/*
Bài 5: Viết function truyền vào 1 chuỗi, hãy sao chép đó chuỗi lên 10 lần, ngăn cách nhau bởi dấu gạch ngang (Sử dụng array để làm)

Ví dụ: repeatString(‘a’) => Kết quả trả về là ‘a-a-a-a-a-a-a-a-a-a’
*/
function repeatString1(arr){
    let arr1 = Array.from({length : 10}, () => arr);
    
    let result = arr1.join('-');
    return result;
 };
console.log(repeatString1("a"));
 
/*
Bài 6: Viết function truyền vào 1 chuỗi, kiểm tra xem chuỗi đó có phải chuỗi đối xứng hay không (chuỗi đối xứng là chuỗi đọc xuôi hay ngược đều như nhau, không tính khoảng trắng, không phân biệt hoa thường), kết quả trả về true hoặc false.

function isSymmetricString(string){
   // Your Code
}

Ví dụ

“Race car” => true, => racecar chuoi dao nguoc la: racecar
“hello world” => false.
*/

function isSymmetricString(string){
    let removeSpace = string.replace(/\s+/g, '').toLowerCase();
    
    let reverseString = removeSpace.split('').reverse().join('');

    return removeSpace === reverseString;
}
 console.log(isSymmetricString("Race car"));
 console.log(isSymmetricString("hello world"));
/*
Bài 7: Viết function truyền vào 1 số nguyên, hãy sắp xếp lại các chữ số trong số nguyên đó sao cho ra 1 số nhỏ nhất có thể (không tính số 0 đầu tiên).

Ví dụ Array + sort

53751 -> 13557
14350 -> 10345
203950 -> 200359
*/
function numbermin(n){
    let digits = n.toString().split('');
    digits.sort();
    
    if(digits[0] === '0'){
        for(let i = 1; i < digits.length; i++){
            if(digits[i] !== '0'){
                [digits[0], digits[i]] = [digits[i],digits[0]];
                break;
            }
        }
    }
    return parseInt(digits.join(''), 10);
};

console.log(numbermin(53751)); 
console.log(numbermin(14350)); 
console.log(numbermin(203950));
