// Câu 1. Tạo 1 thẻ p có id=“text”, có nội dung bất kỳ (có thể tạo bằng HTML hay Javascript - tùy chọn). Yêu cầu
const text = document.getElementById('text');
// Đặt màu văn bản thành #777
text.style.color = '#777';
// Đặt kích thước phông chữ thành 2rem
text.style.fontSize = '2rem';
// Đặt nội dung HTML thành Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript.
text.innerHTML = 'Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript';
// Câu 2. Sử dụng vòng lặp để đặt màu chữ cho tất cả thẻ li thành màu blue (tạo thẻ ul-li bằng html)

// <ul>
//     <li>Item 1</li>
//     <li>Item 2</li>
//     <li>Item 3</li>
// </ul>
Array.from(document.querySelectorAll('#text + ul')).map(li =>{
    li.style.color ="blue";
});
// Câu 3. Cho mã HTML có nội dung như sau (tạo thẻ ul-li bằng html):

// <ul id="list">
//    <li>Item 1</li>
//    <li>Item 2</li>
//    <li>Item 3</li>
//    <li>Item 4</li>
//    <li>Item 5</li>
//    <li>Item 6</li>
//    <li>Item 7</li>
// </ul>

// Sử dụng javascript để thực hiện những công việc sau
    const ul = document.getElementById('list');
// 1. Thêm 3 thẻ <li> có nội dung Item 8, Item 9, Item 10 vào cuối danh sách
    for(let i = 8; i < 11; i++){
        const li = document.createElement("li");
        li.textContent = "Item" + i;
        ul.appendChild(li);
    };
// 2. Sửa nội dung cho thẻ <li> 1 thành màu đỏ (color)
    ul.firstElementChild.style.color ='red';
// 3. Sửa background cho thẻ <li> 3 thành màu xanh (background-color)
    ul.children[2].style.backgroundColor = "green";
// 4. Remove thẻ <li> 4
    ul.removeChild(ul.children[3]);
// 5. Thêm thẻ <li> mới thay thế cho thẻ <li> 4 bị xóa ở bước trước, thẻ <li> mới có nội dung bất kỳ
const newli = document.createElement('li');
newli.textContent = "New Item";
ul.insertBefore(newli, ul.children[3]);