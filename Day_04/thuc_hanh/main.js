// Yêu cầu:

// Lắng nghe sự kiện click ở 3 nút button theo 3 cách sau :

// Button “Change content” sử dụng “HTML-attribute”
// Button “Change color” sử dụng “DOM property”
// Button “Change background” sử dụng “addEventListener”
// Thực hiện các chức năng sau:

const p = document.querySelector('p');


// Yêu cầu 1:
// Khi nhấn vào button “Change content” hiển thị một nội dung quote bất kỳ

const changeContent = () => {
    const quotes = [
        'Đây là nội dung mới 0',
        'Đây là nội dung mới 1',
        'Đây là nội dung mới 2',
        'Đây là nội dung mới 3',
        'Đây là nội dung mới 4',
        'Đây là nội dung mới 5',
        'Đây là nội dung mới 6',
    ];
    
    const rdIndex = Math.floor(Math.random() * quotes.length);
    p.innerText = quotes[rdIndex];
};

// Yêu cầu 2:
// Khi nhấn vào button “Change color” thì thay đổi màu của thẻ p (sử dụng màu HEX - cần viết 1 function để random màu HEX)
const randomHexColor = () => {
    return "#" + Math.floor(Math.random() * 16777215).toString(16);
};

const btn2 = document.getElementById("btn-2");
btn2.onclick = () => {
p.style.color = randomHexColor();
};

// Yêu cầu 3:

// Khi nhấn vào button “Change background” thì thay đổi màu background-color của thẻ p (sử dụng màu RGB - cần viết 1 function để random màu RGB)

const btn3 = document.getElementById("btn-3");
btn3.addEventListener("click", () => {
    p.style.backgroundColor = randomHexColor();
});