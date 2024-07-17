// Danh sách các sản phẩm có trong giỏ hàng
let products = [
    {
        name: "Iphone 13 Pro Max", // Tên sản phẩm
        price: 3000000, // Giá mỗi sản phẩm
        brand: "Apple", // Thương hiệu
        count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
]

// 1. In ra thông tin các sản phẩm trong giỏ hàng theo cấu trúc sau
// Tên - Giá - Thương Hiệu - Số lượng
// Ví dụ : OPPO Find X3 Pro - 19500000 - OPPO - 3
products.forEach(products => {
    console.log(`${products.name} - ${products.price} - ${products.brand} - ${products.count}`);
});

// 2. Tính tổng tiền tất cả sản phẩm trong giỏ hàng
// Tổng tiền mỗi sản phẩm = price * count
let totalAmout = products.reduce((total, products) => total + products.price * products.count, 0);
console.log(`Tong tien san pham la: ${totalAmout}`);

// 3. Tìm các sản phẩm của thuơng hiệu "Apple"
let apple = products.filter(products => products.brand === "Apple");
console.log(apple);

// 4. Tìm các sản phẩm có giá > 20000000
let total = products.filter(products => products.price > "20000000")
// 5. Tìm các sản phẩm có chữ "pro" trong tên (Không phân biệt hoa thường)
let pro = products.filter(products => products.name.toLowerCase().includes("pro"));
console.log(pro);
// 6. Thêm 1 sản phẩm bất kỳ vào trong mảng product
    products.push({
        name: "Oppo Reamle 7",
        price: 7500000,
        brand:"OPPO",
        count: 6,
    });
    console.log(products);
// 7. Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng
    products = products.filter(products => products.brand !== "Samsung");
    console.log(products);
// 8. Sắp xếp giỏ hàng theo price tăng dần
    products.sort((a,b) => (a.price - b.price));
    console.log(products)
// 9. Sắp xếp giỏ hàng theo count giảm dần
products.sort((a, b) => b.count - a.count);
console.log(products)
// 10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
let random =  products.sort(() => 0.5 - Math.random()).slice(0, 2);
console.log(random);