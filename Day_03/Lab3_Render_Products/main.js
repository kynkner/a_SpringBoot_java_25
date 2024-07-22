const products = [
    {
        id: 1,
        name: 'Iphone 12',
        price: 20000000,
        brand: 'Apple',
        thumbnall: 'https://plus.unsplash.com/premium_photo-1702910930523-897e2c217108?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
        rating: 4.5
    },
    {
        id: 2,
        name: 'Iphone 13',
        price: 40000000,
        brand: 'Apple',
        thumbnall: 'https://images.unsplash.com/photo-1703796970924-7d50bcde828e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw1fHx8ZW58MHx8fHx8',
        rating: 4.55
    },
    {
        id: 3,
        name: 'Iphone 14',
        price: 50000000,
        brand: 'Apple',
        thumbnall: 'https://plus.unsplash.com/premium_photo-1702910930523-897e2c217108?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
        rating: 4.7
    },
    {
        id: 4,
        name: 'Iphone 15',
        price: 60000000,
        brand: 'Apple',
        thumbnall: 'https://images.unsplash.com/photo-1703796970924-7d50bcde828e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw1fHx8ZW58MHx8fHx8',
        rating: 4.8
    },
    {
        id: 5,
        name: 'Iphone 16',
        price: 1321560000,
        brand: 'Apple',
        thumbnall: 'https://plus.unsplash.com/premium_photo-1702910930523-897e2c217108?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
        rating: 4.885
    },
    {
        id: 6,
        name: 'Iphone 17',
        price: 2036123000,
        brand: 'Apple',
        thumbnall: 'https://images.unsplash.com/photo-1703796970924-7d50bcde828e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw1fHx8ZW58MHx8fHx8',
        rating: 3.2
    },
    {
        id: 7,
        name: 'Iphone 17',
        price: 2036123000,
        brand: 'Apple',
        thumbnall: 'https://images.unsplash.com/photo-1703796970924-7d50bcde828e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw1fHx8ZW58MHx8fHx8',
        rating: 3.2
    },
];

const formatPrice = (price) => {
    return price.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });

};

const productsListEl = document.querySelector('.product-list');

const renderProducts = () => {
    let html = "";
    products.forEach((p) => {
        html += `
        <div class="col-md-3">
        <div class="course-item shadow-sm rounded mb-4">
            <div class="course-item-image">
                <img src="${p.thumbnall}"
                    alt="${p.name}" />
            </div>
            <div class="course-item-info p-3">
                <h2 class="fs-5 mb-4 text-dark">
                    ${p.name}
                </h2>
                <div
                    class="d-flex justify-content-between align-items-center fw-light text-black-50">
                    <p class="type">${p.brand}</p>
                    <p class="rating">
                        <span>${p.rating}</span>
                        <span class="text-warning"><i class="fa-solid fa-star"></i></span>
                    </p>
                </div>
                <p class="price text-danger fs-5">
                    ${formatPrice(p.price)}
                </p>
            </div>
        </div>
    </div>
        `
    });
    productsListEl.innerHTML = html;
};

renderProducts();
