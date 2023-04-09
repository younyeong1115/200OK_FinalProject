# :ring:&nbsp;200OK Jewelry  Shop 

[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fyounyeong1115%2F200OK_FinalProject&count_bg=%23F573A3&title_bg=%23E9ADD2&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)

<br>

## :speech_balloon:서비스 소개
Spring Boot로 구현한 쥬얼리쇼핑몰입니다.

<br>


## 💻기술 스택
<div>
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white"/>
<img src="https://img.shields.io/badge/mysql-4479A1?style=flat-square&logo=mysql&logoColor=white"/><br>


<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=JavaScript&logoColor=white"/>
<img src="https://img.shields.io/badge/axios-5A29E4?style=flat-square&logo=axios&logoColor=white"/>
<img src="https://img.shields.io/badge/HTML-E34F26?style=flat-square&logo=HTML5&logoColor=white"/>
<img src="https://img.shields.io/badge/CSS-1572B6?style=flat-square&logo=CSS3&logoColor=white"/>



</div>

<br>


## :date:개발 기간
2023.03.13 ~ 2023.04.09

<br>


## :running:팀원 소개
<h4> 🍀 이윤영 : https://github.com/younyeong1115 </h4>
<h4> :hamster: 김영림 : https://github.com/RimKim </h4>

<br>


## 🔎설계


### 1️⃣ 데이터베이스 설계
<br><br><br>

<div align="center">
<img width="60%" src="https://user-images.githubusercontent.com/92067780/230749582-fc7e920d-8f01-4dc3-865d-7d5350bed860.png"/>
</div>

### 2️⃣ 목업 설계
<br><br><br>

## 📚주요 기능
###  ✔️ 회원가입
<img width="70%" height = "300px" src="https://user-images.githubusercontent.com/122211031/230764556-3207cb04-cc32-4476-8dd3-f3289b689ac9.gif"/>

###  ✔️ 로그인
▪️  보안을 강화하기 위해 인터셉터(interceptor) 기능을 활용하여 로그인 프로세스를 처리하고 있습니다.<br>
▪️  일반로그인, sns 로그인 두가지 방식으로 로그인이 가능합니다.<br>
▪️  sns로 최초 로그인하는 경우 kakao가 제공하는 사용자 정보 외에 필요한 정보를 회원가입폼을 이용하여 입력 받게 됩니다.<br><br>
<img width="70%" height = "300px" src="https://user-images.githubusercontent.com/92067780/230707093-ea17f22c-3e96-4ce4-9cf5-87791585a12c.gif"/>

###  ✔️ 이메일 인증
<img width="70%" height = "300px" src="https://user-images.githubusercontent.com/122211031/230764694-e875b71e-ecc5-44e0-9f8f-be98c45ec71e.gif"/>

###  ✔️ 장바구니
▪️  상품 상세보기에서 장바구니 담기 가능합니다.<br>
▪️  체크박스에 체크 된 상품만 가격 합계 계산 및 주문서로 넘어 가게됩니다.<br><br>
<img width="70%" height = "300px" src="https://user-images.githubusercontent.com/92067780/230707305-612b37ac-c333-4e7c-ad9c-0137fe6cf35d.gif"/>

###  ✔️ 배송지관리
▪️  하나의 배송지만 기본 배송지로 설정 가능합니다.<br>
▪️  기본 배송지가 존재하는 경우 주문서에서 기본배송지로 자동으로 입력되고 체크박스 클릭시 빈칸으로 초기화됩니다.<br><br>
<img width="70%" height = "300px" src="https://user-images.githubusercontent.com/92067780/230707289-2817cc11-6bb7-4e05-9106-292f9ebdb9af.gif"/>

###  ✔️ 결제

###  ✔️ 관리자
▪️  관리자로 로그인 한 경우 마이페이지에서 관리자 홈으로 이동 가능합니다.( 일반 유저의 경우 버튼이 보이지 않습니다. )<br>
▪️  판매량 BEST5,WORST5 상품을 구글 chart api를 통해 출력합니다. <br>
▪️  회원,상품,주문에 대한 관리가 가능합니다.  <br><br>
<img width="70%" height = "300px" src="https://user-images.githubusercontent.com/92067780/230707321-efd4ac86-8442-4fae-987e-1a7e137997f3.gif"/>

## 💥트러블 슈팅

## :pencil2:개선할점
