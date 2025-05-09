# API 명세서
## 등록 api
- url : /api/schedules
- method : POST
- request body :
```json
{
    "user": "홍길동",
    "todo": "마케팅 회의 진행",
    "password": "1234",
    "date": "YYYY-MM-DD HH:MM:SS"
}
```

- response body :
```json
{
    "id": 1,
    "user": "홍길동",
    "todo": "마케팅 회의 진행",
    "date": "YYYY-MM-DD HH:MM:SS"
}
```
- status code : 201 CREATED

## 전체 조회 api
- url : /api/schedules 
- method : GET
- request body :
```json
{
    "user": "홍길동",
    "date": "YYYY-MM-DD HH:MM:SS"
}
```
- response body :
```json
{
    "id": 1,
    "user": "홍길동",
    "todo": "마케팅 회의 진행",
    "date": "YYYY-MM-DD HH:MM:SS"
},
{
    "id": 2,
    "user": "홍길동",
    "todo": "개발 일정 마무리",
    "date": "YYYY-MM-DD HH:MM:SS"
}
```
- STATUS CODE : 200 OK

## 단일 조회 api
- url : /api/schedules/{id} 
- method : GET
- request body :
```json
{
    "id": 1
}
```
- response body :
```json
{
    "id": 1,
    "user": "홍길동",
    "todo": "마케팅 회의 진행",
    "date": "YYYY-MM-DD HH:MM:SS"
}
```
- STATUS CODE : 200 OK
- FAIL STATUS CODE : 404 NOT FOUND

## 수정 api
- url : /api/schedules/{id} 
- method : PUT
- request body :
```json
{
    "user": "홍길동",
    "todo": "수정된 회의 내용"
    "password": "1234"
}
```
- response body :
```json
{
    "id": 1,
    "user": "홍길동",
    "todo": "수정된 회의 내용",
    "re-date": "YYYY-MM-DD HH:MM:SS"
}
```
- STATUS CODE : 200 OK
```json
{
    "status": "fail",
    "message": "비밀번호가 일치하지 않습니다."
}
```
- FAIL STATUS CODE : 401 Unauthorized



## 삭제 api
- url : /api/schedules/{id} 
- method : DELETE
- request body :
```json
{
    "password": "1234"
}
```
- response body :
```json
{
    "status": "success",
    "message": "일정이 성공적으로 삭제되었습니다."
}
```
- STATUS CODE : 200 OK
```json
{
    "status": "fail",
    "message": "비밀번호가 일치하지 않습니다."
}
```
- FAIL STATUS CODE : 401 Unauthorized

# ERD
![img.png](img.png)