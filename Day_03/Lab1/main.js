// 1. Truy cập vào thẻ h1 có id=“heading” thay đổi màu chữ thành ‘red’, và in hoa nội dung của thẻ đó
const heading = document.getElementById('heading');
heading.style.color = 'red';
heading.style.textTransform = 'uppercase';
// 2. Thay đổi màu chữ của tất cả thẻ có class “para” thành màu “blue” và có font-size = “20px”
const paraElements = document.querySelectorAll('.para');
paraElements.forEach(para => {
    para.style.color = 'blue';
    para.style.fontSize = '20px';
});
// 3. Thêm thẻ a link đến trang ‘facebook’ ở đằng sau thẻ có class “para-3”
const para3 = document.querySelector('.para-3');
const link = document.createElement('a');
link.href = 'https://www.facebook.com';
link.textContent = 'Facebook';
para3.appendChild(link);
// 4. Thay đổi nội dung của thẻ có id=“title” thành “Đây là thẻ tiêu đề”
const title = document.getElementById('title');
title.textContent = 'Đây là thẻ tiêu đề';
// 5.Thêm class “text-bold” vào thẻ có class=“description” (định nghĩa class “text-bold” có tác dụng in đậm chữ)
const description = document.querySelector('.description');
description.classList.add('text-bold');
const style = document.createElement('style');
style.innerHTML = `
    .text-bold {
        font-weight: bold;
    }
`;
document.head.appendChild(style);
// 6. Thay thế thẻ có class=“para-3” thành thẻ button có nội dung là “Click me”
const button = document.createElement('button');
button.textContent = 'Click me';
para3.parentNode.replaceChild(button, para3);
// 7.Copy thẻ có class=“para-2” và hiển thị ngay đằng sau thẻ đó
const para2 = document.querySelector('.para-2');
const copy = para2.cloneNode(true);
para2.parentNode.insertBefore(copy, para2.nextSibling);
// 8. Xóa thẻ có class=“para-1”
const para1 = document.querySelector('.para-1');
para1.remove();