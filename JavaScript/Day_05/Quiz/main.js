const questions = [
    {
        id: 1,
        title: "1 + 1 = ?",
        choices: [1, 2, 3, 4, 5],
        answer: 2
    },
    {
        id: 2,
        title: "Năm 2024 có phải năm nhuận không?",
        choices: ["Có", "Không"],
        answer: "Có"
    },
    {
        id: 3,
        title: "Năm 2030 có phải năm nhuận không?",
        choices: ["Có", "Không"],
        answer: "Không"
    },
    {
        id: 4,
        title: "1 + 2 = ?",
        choices: [1, 2, 3, 4, 5],
        answer: 3
    },
    {
        id: 5,
        title: "1 + 3 = ?",
        choices: [1, 2, 3, 4, 5],
        answer: 4
    },
    {
        id: 6,
        title: "1 + 4 = ?",
        choices: [1, 2, 3, 4, 5],
        answer: 5
    },
];

let currentQuestionIndex = 0;

const renderQuestion = () => {
    const question = questions[currentQuestionIndex];

    // Hiển thị câu hỏi
    const titleEl = document.querySelector("#question p");
    titleEl.innerHTML = `Câu ${currentQuestionIndex + 1}: ${question.title}`;

    // Hiển thị các lựa chọn
    const choicesEl = document.querySelector(".choices");
    let html = "";
    question.choices.forEach((choice, index) => {
        html += `
            <div class="choice-item">
                <input type="radio" name="choice" id="${index}" value="${choice}" />
                <label for="${index}">${choice}</label>
            </div>
        `;
    });
    choicesEl.innerHTML = html;
};
renderQuestion();

// Yêu cầu
// Học viên hoàn thành ứng dụng quiz bao gồm các chức năng còn lại:

// Xử lý khi bấm vào nút Câu tiếp theo
// Cảnh báo cho người dùng nếu bấm mà chưa chọn đáp án
// Nếu người dùng đã chọn câu trả lời -> Hiển thị thông tin câu hỏi tiếp theo
// Nếu là câu hỏi cuối cùng thì ẩn đi và hiển thị nút Kết thúc
// Nút Kết thúc
// Hiển thị khi là câu hỏi cuối cùng trong danh sách câu hỏi
// Khi bấm vào thì thông báo kết quả số lượng câu trả lời đúng/Tổng số câu hỏi


let correctAnswers = 0;
const btnNext = document.getElementById('btn-next');
const btnFinish = document.getElementById('btn-finish');
 
function test (){
    const selectedChoice = document.querySelector('input[name="choice"]:checked');

    if (!selectedChoice) {
        alert('Vui lòng chọn đáp án!');
        return;
    }
    
    if (selectedChoice.value == questions[currentQuestionIndex].answer) {
        correctAnswers++;
    }
    currentQuestionIndex++;
}

btnNext.addEventListener('click', () => {
    test();
    if (currentQuestionIndex == questions.length - 1) {
        btnNext.classList.add('hide');
        btnFinish.classList.remove('hide');
        renderQuestion();
    } else {
        renderQuestion();
    }
});
btnFinish.addEventListener('click', () => {
    test();
    alert(`Bạn đã trả lời đúng ${correctAnswers} câu trên tổng số ${questions.length} câu.`);
});
