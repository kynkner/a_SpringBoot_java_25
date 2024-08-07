# BTVN : Hoàn thành tìm kiếm của ứng dụng TodoList
## Yêu cầu
- Học viên hoàn thiện việc triển khai các chức năng của ứng dụng TodoList sang gọi API
- Bổ sung thêm chức năng “Tìm kiếm todo theo title” sử dụng fulltext search trong Json Server
## các chức năng:
- Dòng 1: Tạo dữ liệu cho ứng dụng TodoList

```ruby 
let todos = [];
const API_URL = "http://localhost:8000/todos";
```
- Dòng 4: Goi API để lấy dữ liệu và hiển thị ra ngoài giao diện
```ruby
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
```
- Dòng 15: Hiển thị ds todo ra ngoài giao diện
```ruby
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
    });
    todoContainer.innerHTML = html;
};
```
- Dòng 60: Thêm công việc
```ruby
const inputTodo = document.getElementById("input-todo");
const btnAdd = document.getElementById("btn-add");
btnAdd.addEventListener("click", async () => {
    const title = inputTodo.value.trim();
    if (title.length == 0) {
        alert("Tên công việc không được để trống");
        return;
    }

    const newTodo = {
        title: title,
        status: false
    };

    # //Gọi AIP để thêm công việc mới
    try {
        let response = axios.post(API_URL, newTodo);
        todos.push(response.data);
        renderTodos(todos);
        inputTodo.value ="";
    } catch (error) {
        console.log(error);
    }
});
```
- Dòng 100: Xóa công việc
```ruby
const deleteTodo = async(id) => {
    const isDelete = confirm("Bạn có chắc chắn muốn xóa công việc này không?");
    if(!isDelete) return;

    # // Gọi API để xóa công việc
    try {
        await axios.delete(`${API_URL}/${id}`);
        const index = todos.findIndex(todo => todo.id === id);
    todos.splice(index, 1);
    renderTodos(todos);
    } catch (error) {
        console.log(error);
    }
};
```
- Dòng 118: Cập nhật tiêu đề công việc 
```ruby
const editTodo = async(id) => {
    const todo = todos.find(todo => todo.id === id);
    let newTitle = prompt("Cập nhật tiêu đề công việc", todo.title);

    if(newTitle === null) return;
    if (newTitle.trim().length == 0) {
        alert("Tên công việc không được để trống");
        return;
    }

    # //Gọi API để cập nhật công việc 
   
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
```
- Dòng 144: Thay đổi trạng thái công việc
```ruby
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
```
- Dòng 160: Tìm kiếm todo theo title
```ruby
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

```