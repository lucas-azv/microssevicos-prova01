# GET all products
curl -X GET "http://localhost:8080/product"

# GET a product by ID
curl -X GET "http://localhost:8080/product/60e9c456d1c9b52c88d2f3e2"

# POST to create a new product
curl -X POST "http://localhost:8080/product" -H "Content-Type: application/json" -d '{"name": "iPhone 14", "category": "Smartphones", "price": 999.99, "stock": 50}'

# PUT to update an existing product
curl -X PUT "http://localhost:8080/product/60e9c456d1c9b52c88d2f3e2" -H "Content-Type: application/json" -d '{"name": "iPhone 14 Pro", "category": "Smartphones", "price": 1099.99, "stock": 40}'

# DELETE a product
curl -X DELETE "http://localhost:8080/product/60e9c456d1c9b52c88d2f3e2"

# GET all categories
curl -X GET "http://localhost:8080/product/categories"

# POST to create a new category
curl -X POST "http://localhost:8080/product/categories" -H "Content-Type: application/json" -d '{"name": "Electronics"}'

# PUT to update an existing category
curl -X PUT "http://localhost:8080/product/categories/60e9c456d1c9b52c88d2f3e3" -H "Content-Type: application/json" -d '{"name": "Gadgets"}'

# DELETE a category
curl -X DELETE "http://localhost:8080/product/categories/60e9c456d1c9b52c88d2f3e3"

# GET all shopping records
curl -X GET "http://localhost:8080/shopping"

# GET a shopping record by ID
curl -X GET "http://localhost:8080/shopping/60e9c456d1c9b52c88d2f4e2"

# POST to create a new shopping record
curl -X POST "http://localhost:8080/shopping" -H "Content-Type: application/json" -d '{"userIdentifier": "user123", "productIdentifier": "product456", "date": "2024-12-01", "totalAmount": 200.00}'

# GET shopping records by user
curl -X GET "http://localhost:8080/shopping/shopByUser?userIdentifier=user123"

# GET shopping records by date
curl -X GET "http://localhost:8080/shopping/shopByDate?date=2024-12-01"

# GET shopping records by product identifier
curl -X GET "http://localhost:8080/shopping/productIdentifier/product456"

# GET shopping records by filter
curl -X GET "http://localhost:8080/shopping/search?dataInicio=2024-12-01&dataFim=2024-12-31&valorMinimo=100.00"

# GET report by date
curl -X GET "http://localhost:8080/shopping/report?dataInicio=2024-12-01&dataFim=2024-12-31"

# GET all users
curl -X GET "http://localhost:8080/api/v1/users"

# GET a user by ID
curl -X GET "http://localhost:8080/api/v1/users/id/60e9c456d1c9b52c88d2f5e2"

# POST to create a new user
curl -X POST "http://localhost:8080/api/v1/users" -H "Content-Type: application/json" -d '{"name": "John Doe", "email": "john@example.com", "password": "securepassword"}'

# PUT to update an existing user
curl -X PUT "http://localhost:8080/api/v1/users" -H "Content-Type: application/json" -d '{"id": "60e9c456d1c9b52c88d2f5e2", "name": "John Doe", "email": "john.doe@example.com", "password": "newsecurepassword"}'

# DELETE a user
curl -X DELETE "http://localhost:8080/api/v1/users/id/60e9c456d1c9b52c88d2f5e2"