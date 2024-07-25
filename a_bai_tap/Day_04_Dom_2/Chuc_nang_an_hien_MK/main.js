/////////////////////////////Chức năng hiển thị mật khẩu//////////////////////////////

// Yêu cầu :

// Khi người dùng nhập password và bấm nút “Show”, lúc này hiển thị password và nội dung button chuyển từ “Show” --> “Hide”
// Ngược lại khi người dùng bấm vào nút “Hide”, lúc này ẩn password và nội dung button chuyển từ “Hide” --> “Show”
// Nếu làm được Show - Hide button -> chuyển qua làm với icon : https://fontawesome.com/search?q=eye&o=r&m=free

document.getElementById('toggleButton').addEventListener('click', function() {
    var passwordInput = document.getElementById('password');
    var toggleButton = document.getElementById('toggleButton');

    if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
        toggleButton.innerHTML = '<i class="fas fa-eye-slash"></i> Hide';
    } else {
        passwordInput.type = 'password';
        toggleButton.innerHTML = '<i class="fas fa-eye"></i> Show';
    }
});