# 식재료 절약단(졸업 프로젝트)
- Web Frontend 파트

## 프로젝트 설명
### 기간
2023.02 ~ 2023.11

### 팀 구성
- Web Frontend - 김기범(React)
- App Frontend - 조성훈(React)
- Backend - 정형목

### 식재료 절약단이란?
- 잘못된 주문 및 유통기한이 경과하는 식재료의 낭비를 최소화하기 위해 개발된 웹사이트 입니다.
- 식당 관리자는 웹 페이지를 통해 판매할 음식을 등록, 수정 및 삭제할 수 있습니다.
- 소비자는 애플리케이션을 통해 식당 이용일을 예약할 수 있으며, 예약이 완료되면 관리자 웹페이지에서 해당 예약에 대한 정보가 계산되어 익일 식재료 예측을 시각적으로 확인할 수 있습니다.

### 협업 도구들
- pigma 
- postman
- Swagger

## 주요 기능들
- 프로젝트 시연 영상 : https://www.youtube.com/watch?v=I1x_S3VARak
1. 로그인
   - jwt 방식을 활용하여 토큰을 쿠키에 저장하는 방식으로 로그인 기능을 구현하였습니다.
2. 익일 필요 식재료 및 예약 정보 확인
   - react apexchart 라이브러리를 사용하여 시각화하였습니다.
![스크린샷 2023-12-11 오후 6 50 49](https://github.com/kkb4363/SenierProject/assets/101088024/bbc56762-3580-4dc9-961a-38bc973a765a)
3. 음식 메뉴 추가, 수정, 삭제, 품절, 재판매
   - 관리자는 판매할 음식을 추가, 수정 등 이 가능합니다.
   - 음식을 추가할 때, 서버에 저장된 식재료 목록에 포함된 경우 자동으로 해당 음식에 대한 식재료 정보가 추가되게끔 구현하였습니다.
![ezgif com-video-to-gif](https://github.com/kkb4363/SenierProject/assets/101088024/22534f4f-6726-49bd-b52c-a906e2c20502)
4. 반응형
   - mui bootstrap을 사용하여 반응형 웹사이트를 구현하였습니다.
![ezgif com-video-to-gif](https://github.com/kkb4363/SenierProject/assets/101088024/6ab52c7b-15b5-4e89-b5a2-eaa297ca6d2b)
5. api 통신
   - useQuery 라이브러리를 사용하여 백엔드서버랑 연동이 되게 구현하였습니다.
