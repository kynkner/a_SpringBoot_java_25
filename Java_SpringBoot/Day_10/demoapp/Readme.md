## Bean là gì??
- Được coi là thành phần xương sống của ứng dụng Spring
- Là đối tượng được khởi tạo, lắp ráp quản lý bởi Spring IoC container
## Tạo ra bean như thế nào??
- Sử dụng các anotation đánh dấu lên class(Class level): @Component, @Controller, @RestController, @Service, @Repository,...
- Sử dụng annotation @Bean trên method(method level) trong class @Configuration
## Sử dụng bean như thế nào???
- Bean thường được sử dụng trong 1 bean khác (dependency) (A -> B)
- Classroom(A){
    SinhVien (B)
    Giảng viên (B)
    Tư vấn viên (B)
}
- 3 cách sử dụng bean:
    + Field-based Injection : Sử dụng phổ biến
    + Constructor-based Injection : Sử dụng phổ biến
    + Setter-based Injection