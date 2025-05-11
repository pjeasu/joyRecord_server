# 📌 프로젝트 설명
JoyRecord는 사용자가 감상한 영화, 드라마, 게임, 스포츠 경기 등을 손쉽게 기록하고 관리할 수 있는 플랫폼입니다.
이전의 기록을 돌아보며 추억할 수 있도록 카테고리별 정리, 감상평 작성, 캘린더 보기 등의 기능을 사용할 수 있습니다.

PC 화면 기준으로 만들어졌고 모바일 화면은 현재 작업중입니다.

>🆙2025-02-26 : 차트로 연도, 월 별로 조이(게시글)분포를 확인 할 수 있는 joy Chart 기능이 추가되었습니다.<br>
>🆙2025-02-28 : 모바일로 접속시 화면이 깨지는 현상을 수정하였습니다.<br>
>🆙2025-03-09 : 사진 첨부 기능을 추가하였습니다. (모바일 환경은 현재 테스트 중 입니다.)<br>
>🆙2025-05-07 : AWS EC2 용량부족 관련 오류 해결 및 사이트 정상화 진행

<br>


🔗 **JoyRecord:** 👉 **https://joyrecord.netlify.app/**
> 현재 사이트는 테스트 중이며
>  (boorabo / 0000) 로 로그인하여 사이트를 둘러 보실 수 있습니다.

<br>

## 📌 JoyRecord Server
JoyRecord 서버는 **Spring Boot** 기반으로, MySQL을 활용한 데이터 관리 및 JWT 인증 시스템을 사용했습니다. 

<br>
<table>
  <tr>
    <td><img width="100%" alt="화면 캡처_캘린더화면" src="https://github.com/user-attachments/assets/f46bd0ac-4503-4183-baf9-37c3657a6bd8" /></td>
    <td><img width="100%" alt="화면 캡처_글상세보기" src="https://github.com/user-attachments/assets/e8f03727-910c-485a-9ab1-a0ad6bbf8c90" /></td>
  </tr>
  <tr>
    <td><img width="100%" alt="화면 캡처_리스트" src="https://github.com/user-attachments/assets/828046f1-43d8-43b0-846e-d3ebbfdc4461" /></td>
    <td><img width="100%" alt="화면 캡처_조이차트" src="https://github.com/user-attachments/assets/b97d3c9e-1e66-4b45-91a1-dd7524eb09a9" /></td>
  </tr>
</table>
<br>

## 🛠️ 기술 스택  
- **Backend:** Spring Boot 3, Spring Security, Mybatis  
- **Database:** MySQL  
- **Auth:** JWT (JSON Web Token)
- **DevOps**: Docker, AWS EC2

<br>


## 📑 주요 기능  
- ✅ 사용자 **회원가입 및 로그인** (JWT 인증)  
- ✅ 영화, 드라마, 게임, 스포츠 경기 **기록 및 조회**  
- ✅ **관리자 기능** (회원 관리, 취미 관리, 기록 데이터 관리)  


<br>

## 📚데이터 베이스 ERD
![JoyRecord (1)](https://github.com/user-attachments/assets/04bb38ed-ed5b-4379-ae83-f2e8273a2c04)


<br>

## 💼 API 문서
https://documenter.getpostman.com/view/17400613/2sAYXFhHDV


<br>


🔗 **클라이언트(프론트엔드) 리포지토리:** 👉 [**JoyRecord Client**](https://github.com/pjeasu/joyRecord_client)
