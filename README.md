# API 명세서
## 등록 api
url : /api/schedules
method : POST
비밀번호 인증 : X
request body :
[
{
    "user": "홍길동",
    "todo": "마케팅 회의 진행",
    "password": "1234",
    "date": "YYYY-MM-DD HH:MM:SS"
}
]
response body :
[
{
    "id": 1,
    "user": "홍길동",
    "todo": "마케팅 회의 진행",
    "date": "YYYY-MM-DD HH:MM:SS"
}
]
status code : 200

## 전체 조회 api
url : /api/schedules
method : GET
비밀번호 인증 : X
request body :
[
{
    "user": "홍길동",
    "date": "YYYY-MM-DD HH:MM:SS"
}
]
response body : 
[
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
]

## 단일 조회 api
url : /api/schedules/{id}
method : GET
비밀번호 인증 : X
request body :
[
{
    "id": 1
}
]
response body :
[
{
    "id": 1,
    "user": "홍길동",
    "todo": "마케팅 회의 진행",
    "date": "YYYY-MM-DD HH:MM:SS"
}
]

## 수정 api
url : /api/schedules/{id}
method : PUT
비밀번호 인증 : O
request body :
[
{
    "user": "홍길동",
    "todo": "수정된 회의 내용"
    "password": "1234"
}
]
response body :
[
{
    "id": 1,
    "user": "홍길동",
    "todo": "수정된 회의 내용",
    "re-date": "YYYY-MM-DD HH:MM:SS"
}
]
[
{
    "status": "fail",
    "message": "비밀번호가 일치하지 않습니다."
}
]

## 삭제 api
url : /api/schedules/{id}
method : DELETE
비밀번호 인증 : O
request body :
[
{
    "password": "1234"
}
]
response body :
[
{
    "status": "success",
    "message": "일정이 성공적으로 삭제되었습니다."
}
]
[
{
    "status": "fail",
    "message": "비밀번호가 일치하지 않습니다."
}
]



