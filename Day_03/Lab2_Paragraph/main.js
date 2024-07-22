// 1. Highlight tất cả các từ có độ dài lớn hơn hoặc bằng 5 ký tự trong đoạn văn (background = “yellow”)
const p = document.querySelector('p');
const content = p.innerText;
console.log(content);

const words = content.split(' ');
console.log(words);

// Cach 1 dung forEach

// const newwords = [];
// words.forEach(word => {
//     if(word.length >= 5){ // Khach => <span style"background-color: yellow">Khach</span>
//         newwords.push(`<span style = "background-color: yellow">${word}</span>`)
//     }else{
//             newwords.push(word);
//     }
// });


// Cach 2 dung map

// const newwords = words.map((word) => {
//     if(word.length >= 5){ // Khach => <span style"background-color: yellow">Khach</span>
//         return `<span style = "background-color: yellow">${word}</span>`
//     }else{
//         return word;
//     }
// })

// Cach 3 dung toan tu 3 ngoi

const newwords = words.map((word) => {
    return word.length >= 5 ? `<span style = "background-color: yellow">${word}</span>` : word;
})

console.log(newwords);

p.innerHTML = newwords.join(" ");
// 2. Thêm link hiển thị text “facebook” link đến trang facebook.com ở sau thẻ p

p.insertAdjacentHTML("afterend", `<a href ="https://www.facebook.com/reel/354928826875251">facebook</a>`)

// 3. Đếm số từ có trong đoạn văn. Tạo 1 thẻ div để hiển thị số từ

const character = ["(",")",",",".","-"];
const wordsWithoutCharacters = words.filter((word) => {
        return !character.includes(word);
});


console.log(wordsWithoutCharacters);
p.insertAdjacentHTML("afterend", `<div>${wordsWithoutCharacters.length} words</div>`)

// 4. Thay thế ký hiệu (, - dấu phẩy) => 🤔 và (. - dấu chấm) => 😲

p.innerHTML = p.innerHTML.replaceAll(",","🤔");
p.innerHTML = p.innerHTML.replaceAll(".","😲");