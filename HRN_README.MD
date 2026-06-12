# Generate public and private key
openssl genrsa -out privateKey.pem 2048
openssl rsa  -pubout  -in privateKey.pem -out publicKey.pem

# MySQL
docker pull mysql:latest
docker run --name my-mysql -e MYSQL_ROOT_PASSWORD=my0988_76iuDH@ -p 3306:3306 -d mysql:latest

# Create react app
npm create vite@latest
# Run react app
npm run dev

# Install
npm install axios
npm install @mui/x-charts
npm i @emotion/react @emotion/styled

# Test data
USE quarkusjwt;
INSERT INTO Customer(id, name, address) 
VALUES 
(1,"PASTEF Gmbh","Dakr"),
(2,"APR Gmbh","Matam"),
(3,"PDS Gmbh","Kolda"),
(4,"AWALE Gmbh","Thies"),
(5,"PTP Gmbh","Ziguinchor"),
(6,"TAXAWOU SENEGAL Gmbh","Saint-Louis"),
(7,"PPC Gmbh","Thies"),
(8,"PSS Gmbh","Louga"),
(9,"PLS Gmbh","Diourbel "),
(10,"REENU-REW Gmbh","Tambacounda "),
(11,"UDS Gmbh","Kaffrine "),
(12,"AND-JEF Gmbh","Kédougou ");

INSERT INTO Service(id, name)
VALUES
(1,"Beratung"),
(2,"Schulung"),
(3,"Entwicklung");

INSERT INTO CustomerOrder (id, customer_id, service_id, price)
VALUES
(1, 1,1,6362.87),
(2, 1,2,2345.98),
(3,1,3,6362.87),

(4, 2,1,8765.95),
(5,2,2,1500.23),
(6,2,3,7262.45),

(7,3,1,2983.23),
(8,3,2,5322.22),
(9,3,3,8372.65);