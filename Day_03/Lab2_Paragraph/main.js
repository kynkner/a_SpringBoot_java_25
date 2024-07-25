// 1. Highlight tất cả các từ có độ dài lớn hơn hoặc bằng 5 ký tự trong đoạn văn (background = “yellow”)
const p = document.querySelector('p');
const content = p.innerText;
console.log(content);

const words = content.split(' ');
console.log(words);
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
