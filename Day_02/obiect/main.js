console.log("asjhbdas")

let user = {
    name:"Nguyen van a",
    age: 23,
    email: "abc@gmail.com",
    address: {
        province:"Ha Noi",
        district:"Cau Giay",
        ward:"Dich Vong",
        detail:"So 1, ngo 1, pho 1"
    },
    lauguages: ["Tieng anh", "tieng nhat", "tieng han"],
    eat:function(fool){
        console.log(`Eating ${fool}`);
    },
    showInfo: function(){
        console.log(`Xin chao, toi ten la ${this.name}, nam nay toi ${this.age} tuoi, email cua toi la ${this.email}`);
    }
}

console.log(user.address.ward);
console.log(user.lauguages[1]);
user.eat("pho");
user.showInfo();

console.log(Object.keys(user));
console.log(Object.values(user));
