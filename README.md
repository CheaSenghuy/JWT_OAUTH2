
# SPRING JWT + OAUTH2


## Run Locally

Clone the project

```bash
  git clone https://github.com/CheaSenghuy/JWT_OAUTH2.git
```
RUN SCRIPT in folder resources
sciprt.sh

```bash
  sciprt.sh
```
you will get folder name certs for keys
## Database on Docker

If you have docker you can run docker compose up on your terminal
docker compose up to create container for database
with the configuration on application.yml already there
if you run on local change it to username & password to ur local username & password
```
  docker compose up
```


## API Reference

#### Get all items

```http
  POST /api/v1/password
```

| Body | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `` | `string` | **Required**. Make your a password encrypt|

#### Get item

```http
  POST /api/v1/auth/signup
```

| Parameter       | Type     | Description                       |
| :--------       | :------- | :-------------------------------- |
| `username`      | `string` | **Required**. username for login  |
| `password`      | `string` | **Required**. password get from /api/v1/password  |


```http
  POST /api/v1/auth/login
```

| Parameter       | Type     | Description                       |
| :--------       | :------- | :-------------------------------- |
| `username`      | `string` | **Required**. username for login  |
| `password`      | `string` | **Required**. password that encrypt |



```http
  GET /api/v1/demo
```
EndPoint for testing you can access or not

