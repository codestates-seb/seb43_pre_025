# Stack Overflow Clone Project

이 프로젝트는 스택 오버플로우(Stack Overflow) 웹사이트의 클론 프로젝트입니다. 다음과 같은 기능들을 포함합니다.

---

## 필요한 기능

### 기능
- 로그인 기능
    - 사용자가 로그인할 수 있는 기능
- 로그아웃 기능
    - 사용자가 로그아웃할 수 있는 기능
- 회원가입 기능
    - 새로운 사용자가 계정을 생성할 수 있는 기능
- 회원정보 수정 기능
    - 사용자가 자신의 프로필 정보를 수정할 수 있는 기능
- 회원탈퇴 기능
    - 사용자가 자신의 계정을 삭제할 수 있는 기능
- 질문 기능
    - 사용자가 질문을 게시할 수 있는 기능
- 답변 기능
    - 사용자가 질문에 대한 답변을 게시할 수 있는 기능
- 댓글 기능
    - 사용자가 질문 또는 답변에 대한 댓글을 게시할 수 있는 기능
- 검색 기능
  - 질문을 검색하는 기능

### 부기능
- 알람 기능
    - 댓글이 달렸을 경우 알람이 오는 기능
-  태그 기능
    - 질문의 태그를 설정하는 기능
- 답변 채택 기능
  - 질문자가 원하는 답변을 채택하는 기능
- Top Question 
  - 답변이나 조회수, 투표수가 많은 질문을 상위에 보여주는 기능
- News API
  - News API를 이용해 개발 이슈를 알려주는 기능
- 추천 투표 기능
  - 사용자가 질문 또는 답변에 대해 추천。비추천 투표를 할 수 있는 기능


---

## URI

각 기능에 대한 URI는 다음과 같습니다.

|  기능	  |                         URI                          |
|:-----:|:----------------------------------------------------:|
|  로그인  |                    	/users/login                     |
| OAuth |                    	/oauth2/auth/                    |
| 회원가입  |                    	/users/signup                    |
| 로그아웃  |                    	/users/logout                    |
| 회원정보  |             	/users/{user-id}/{username}             |
|  질문   |           	/questions/{question-id}/title            |
|  답변   |     	/questions/{question-id}/answer/{answer-id}     |
|  추천   | 	/questions/{question-id} <br> /answers/{answers-id} |
|  태그   |                        /tags                         |

---

### 디렉토리 설정

- 기능 기반 패키지
    - ex) domain.repository
    - ex) domain.service
    - ex) domain.controller
    - ex) domain.entity
    - ex) domain.dto
    - ex) domain.mapper

- utils, aop, security, cofig 등
    - ex) common.utils
    - ex) common.config

---

### ERD

![image](https://user-images.githubusercontent.com/83208807/232409376-cac76745-1ecc-4695-8bf9-1e8904c52b3e.png)

---

## CRUD

### 댓글 - CRUD

N : 1 (Many to One)

- 답변 <>

- 질문 <>

- 유저

---

### 유저 - CRUD

1 : N (One to Many)

- 댓글

- 답변

- 추천

- 질문

---

### 답변 - CRUD

N : 1 (Many to One)

- 유저

- 질문


1 : N (One to Many)

- 추천 <>

- 댓글 <>

---

### 질문 - CRUD

N : 1 (Many to One)

- 유저

1 : N (One to Many)

- 댓글 <>

- 답변 <>

- 추천 <>

- 태그 <>

---

### 추천 - CU

N : 1 (Many to One)

- 유저

- 질문

- 답변

---

### 태그 - CRUD

N : 1 (Many to One)

- 질문

---


## 기능 요구 사항

- 한 회원은 한 번에 한 개의 질문을 생성할 수 있으며, 여러 개의 질문을 생성할 수 있습니다.
- 한 질문에는 여러 개의 답변이 생성될 수 있으며, 모든 글에는 여러 개의 답변이 생성될 수 있습니다.
- 모든 글에는 여러 개의 추천이 생성될 수 있으며, 한 회원은 한 글에 대해 추천을 한 번만 할 수 있습니다.
- 한 회원은 일정 시간마다 글의 한 번 조회수를 올릴 수 있습니다.
- 한 질문에는 하나의 답변을 채택할 수 있습니다.

---

## DB 테이블 

### Users

|  테이블  |    	컬럼     |    	데이터 타입    | 	널 허용 |  	PK  | 	FK | 	Unique |
|:-----:|:----------:|:-------------:|:-----:|:-----:|:---:|:-------:|
| Users |    	id     |   	integer    |  	No  | 	Yes	 |  	  |   Yes   |
|       |   email    | 	varchar(255) | 	No	  |   	   |     |  	Yes   |
|       |  username  | 	varchar(30)  | 	No	  |   	   |     |  	Yes   |
|       |  password  | 	varchar(255) | 	No	  |   	   |     |   	No   |
|       | created_at |  	timestamp   | 	No	  |   	   |     |   	No   | 
|       | updated_at |  	timestamp	  |  No	  |   	   |     |   	No   | 

### Questions

|    테이블    |    	컬럼     |    	데이터 타입    | 	널 허용 | 	PK  | 	FK  | 	Unique  |
|:---------:|:----------:|:-------------:|:-----:|:----:|:----:|:--------:|
| Questions |    	id     |   	integer    | 	No	  | Yes	 |      |   	Yes   |     |
|           |  user_id   |   	integer	   |  No	  |  	   | Yes	 | Users.id |
|           |   title	   | varchar(255)	 |  No	  |      |  	   |   	No    |     
|           |  content	  |     text      | 	No	  |  	   |      |   	No    |   
|           |   views	   |    integer    | 	No		 |      |      |   	No    |  
|           | created_at |  	timestamp   | 	No	  |  	   |      |   	No    |  
|           | updated_at |  	timestamp   | 	No	  |  	   |      |   	No    |  

### Answers

|   테이블   |     	컬럼     |  	데이터 타입   | 	널 허용 |  	PK  | 	FK |    	Unique    |
|:-------:|:-----------:|:----------:|:-----:|:-----:|:---:|:-------------:|
| Answers |     	id     |  	integer  |  	No  | 	Yes	 |     |     	Yes      |  
|         |   user_id   |  	integer  | 	No	  |   	   | Yes |   	Users.id   | 
|         | question_id | 	integer	  |  No	  |   	   | Yes | 	Questions.id |   
|         |   content   |   	text    | 	No	  |   	   |     |      	No      |       
|         | is_accepted |  	boolean  | 	No	  |   	   |     |      	No      |  
|         | created_at  | 	timestamp | 	No	  |   	   |     |      	No      |  
|         | updated_at  | 	timestamp | 	No	  |   	   |     |      	No      |     

### Votes

|  테이블   |     	컬럼      |    	데이터 타입    | 	널 허용 | 	PK | 	FK |    	Unique    |
|:------:|:------------:|:-------------:|:-----:|:---:|:---:|:-------------:|
| Votes	 |     id	      |    integer    | 	No	  | Yes |  	  |     	Yes      |
|        |   user_id    |   	integer    | 	No	  |  	  | Yes |   Users.id    | 
|        | question_id  |   	integer	   | Yes	  |  	  | Yes | 	Questions.id |   
|        |  answer_id   |   	integer	   | Yes	  |  	  | Yes |  	Answers.id  |   
|        | votable_type | 	varchar(255) |  	No  |     |     |     			No     | 
|        |  created_at  |  	timestamp   | 	No	  |  	  |     |      	No      |   
|        |  updated_at  |  	timestamp   | 	No	  |  	  |     |      	No      |     

### Comments

|   테이블   |     	컬럼     |   	데이터 타입   | 	널 허용 |  	PK  |  	FK  |   	Unique    |
|:-------:|:-----------:|:-----------:|:-----:|:-----:|:-----:|:------------:|
| Comment |     id      |   integer   |  	No  | 	Yes	 |       |     	Yes     |
|         |   user_id   |  	integer   |  	No  |  		   | Yes	  |   Users.id   |      
|         | question_id |  	integer   | 	Yes	 |       | 	Yes	 | Questions.id |
|         |  answer_id  |  	integer   | 	Yes	 |       | 	Yes	 |  Answers.id  |
|         |   content   |   	text	    |  No	  |       | 		No  |              |
|         | created_at  | 	timestamp	 |  No	  |   	   |  	No  |              |
|         | updated_at  | 	timestamp  |  No	  |       | 		No  |              |

### Tag

| 테이블 |     	컬럼      |    	데이터 타입    | 	널 허용 | 	PK  | 	FK  |   	Unique   |
|:---:|:------------:|:-------------:|:-----:|:----:|:----:|:-----------:|
| Tag |     	id	     |    integer    | 	No	  | Yes	 |  	   |     Yes     |
|     | question_id	 |   integer	    | No		  |      | Yes	 | Question.id |  
|     |  tag_name	   | varchar(255)	 | No		  |      |  	   |     Yes     |
|     | created_at	  |  timestamp	   | No		  |      |      |     	No     |
|     | updated_at	  |   timestamp   | 	No	  |      |      |    		No     |

