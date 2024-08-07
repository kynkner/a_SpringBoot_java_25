// Tạo dữ liệu cho ứng dụng TodoList
let todos = [];
const API_URL = "http://localhost:8000/todos";
//Goi API để lấy dữ liệu và hiển thị ra ngoài giao diện
const getalltodos = async () => {
    try{
        let response = await axios.get(API_URL);
        todos = response.data;
        renderTodos(todos);
    }catch(error){
        console.log(error);
    }
};
getalltodos();
// Hiển thị ds todo ra ngoài giao diện
const todoContainer = document.querySelector("ul");
const renderTodos = (todos) => {
    if (todos.length == 0) {
        todoContainer.innerHTML = "<li>Không có công việc nào trong danh sách</li>";
        return;
    }

    let html = "";
    todos.forEach(todo => {
        html += `
            <li>
                <input 
                    onchange="toggleStatus(${todo.id})"
                    type="checkbox" 
                    ${todo.status ? "checked" : ""}
                />
                <span class=${todo.status ? "active" : ""}>${todo.title}</span>
                <button onclick="editTodo(${todo.id})">Edit</button>
                <button onclick="deleteTodo(${todo.id})">Delete</button>
            </li>
        `;
        // if (todo.status) {
        //     html += `
        //         <li>
        //             <input type="checkbox" checked/>
        //             <span class="active">${todo.title}</span>
        //             <button>Edit</button>
        //             <button>Delete</button>
        //         </li>
        // `;
        // } else {
        //     html += `
        //         <li>
        //             <input type="checkbox" />
        //             <span>${todo.title}</span>
        //             <button>Edit</button>
        //             <button>Delete</button>
        //         </li>
        // `;
        // }
    });
    todoContainer.innerHTML = html;
};

// Thêm công việc
const inputTodo = document.getElementById("input-todo");
const btnAdd = document.getElementById("btn-add");

// const createId = () => {
//     // return Math.floor(Math.random() * 1000000);
//     if (todos.length === 0) {
//         return 1;
//     }
//     return Math.max(...todos.map(todo => todo.id)) + 1;
// }

btnAdd.addEventListener("click", async () => {
    const title = inputTodo.value.trim();
    if (title.length == 0) {
        alert("Tên công việc không được để trống");
        return;
    }

    const newTodo = {
        // id: createId(),
        title: title,
        status: false
    };

    //Gọi AIP để thêm công việc mới
    try {
        let response = axios.post(API_URL, newTodo);
        todos.push(response.data);
        renderTodos(todos);
        inputTodo.value ="";
    } catch (error) {
        console.log(error);
    }

    // todos.push(newTodo);
    // renderTodos(todos);
    // inputTodo.value = "";
});

// Xóa công việc
const deleteTodo = async(id) => {
    const isDelete = confirm("Bạn có chắc chắn muốn xóa công việc này không?");
    if(!isDelete) return;

    //Gọi API để xóa công việc
    try {
        await axios.delete(`${API_URL}/${id}`);
        const index = todos.findIndex(todo => todo.id === id);
    todos.splice(index, 1);
    renderTodos(todos);
    } catch (error) {
        console.log(error);
    }

    
};

// Cập nhật tiêu đề công việc
const editTodo = async(id) => {
    const todo = todos.find(todo => todo.id === id);
    let newTitle = prompt("Cập nhật tiêu đề công việc", todo.title);

    if(newTitle === null) return;
    if (newTitle.trim().length == 0) {
        alert("Tên công việc không được để trống");
        return;
    }

    //Gọi API để cập nhật công việc
    const data = {
        title: newTitle,
        status: todo.status
    }

    try {
    let response = await axios.put(`${API_URL}/${id}`, data);
    todo.title = response.data.title;
    renderTodos(todos);
    } catch (error) {
        console.log(error);
    }
};

// Thay đổi trạng thái công việc
const toggleStatus = async(id) => {
    const todo = todos.find(todo => todo.id === id);
    const data = {
        title: todo.title,
        status: todo.status
    }
    try {
        await axios.put(`${API_URL}/${id}`, data);
        todo.status = !todo.status;
        renderTodos(todos);    
    } catch (error) {
        console.log(error);
    }
    
};
//Bổ sung thêm chức năng “Tìm kiếm todo theo title” sử dụng fulltext search trong Json Server
const inputSearch = document.getElementById("input-search");
const btnSearch = document.getElementById("btn-search");

btnSearch.addEventListener("click", async () => {
    const query = inputSearch.value.trim();
    if (query.length == 0) {
        alert("Nội dung tìm kiếm không để trống");
        return;
    }

    try {
        let response = await axios.get(`${API_URL}?q=${query}`);
        renderTodos(response.data);
    } catch (error) {
        console.log(error);
    }
});

// Hiển thị ds todo ra ngoài giao diện khi vào trang
getalltodos();
