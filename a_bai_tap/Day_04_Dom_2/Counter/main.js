/////////////////////////////////Counter/////////////////////////////////

// Yêu cầu
// Giá trị mặc định của counter ban đầu = 0

// Bấm vào Cộng tăng counter lên 1

// Bấm vào Trừ giảm counter đi 1

// Nếu counter > 0 có màu green
// Nếu counter = 0 có màu #333333
// Nếu counter < 0 có màu red

 const counter = document.getElementById('counter');
 const prevBtn = document.querySelector('.prevBtn');
 const nextBtn = document.querySelector('.nextBtn');
 let count = 0;

 function updateCounter() {
     counter.textContent = count;
     if (count > 0) {
         counter.style.color = 'green';
     } else if (count < 0) {
         counter.style.color = 'red';
     } else {
         counter.style.color = '#333333';
     }
 }

 prevBtn.addEventListener('click', () => {
     count--;
     updateCounter();
 });

 nextBtn.addEventListener('click', () => {
     count++;
     updateCounter();
 });

 updateCounter();