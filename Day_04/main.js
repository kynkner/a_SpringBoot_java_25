const sayHello = () => {
    alert('Xin chao cac ban 1');
};

const btn2 = document.getElementById('btn2');
btn2.onclick = () => {
    alert('Xin chao cac ban 2');
};

const btn3 = document.getElementById('btn3');
btn3.addEventListener('click', () => {
    alert('Xin chao cac ban 3');
});