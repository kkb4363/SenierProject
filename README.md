# 한밭대학교 컴퓨터공학과 KJJ팀

**팀 구성**

- 20207117 김기범
- 20207122 조성훈
- 20182174 정형목

## <u>Teamate</u> Project Background
- 구내식당의 인기
<img width="643" alt="스크린샷 2023-10-20 오후 12 30 36" src="https://github.com/HBNU-SWUNIV/come-capstone23-kjj/assets/101088024/abfeed3e-71a0-4329-846e-a209f56de9f1">

- ### 필요성
  - 구내식당은 저렴한 가격을 포함한 여러 장점으로 많은 인기를 끌고 있다. 또한 치솟는 물가 상황 속에서 그 수요는 더욱 높아지고 있다.
  - 하지만 구내식당의 경우 수요가 유동점이라는 점 때문에 식재료 관리에 어려움을 겪고 있다. 현재 대부분의 구내식당이 과거의 경험을 기반으로 수요를 예측하고 식재료를 발주하고 있다.
  - 이러한 방식으로는 정확도가 떨어질 수 밖에 없고, 식재료의 과다 발주로 인한 음식물 쓰레기 발생과 금전적 손실을 피할 수 없다.
- 따라서 우리는 구내식당 관리자와 이용객을 대상으로 하여 이용객의 예약 정책 및 정보를 바탕으로 필요 식재료 양을 산출하고, 기존 소모하던 식재료 양과 시스템을 통해 절감 된 식재료 양을 비교 시각화 하여 제공
- 또한 식재료 절약에 따른 금전적 이익을 이용객에게 포인트 및 적립으로 제공함.

## System Design
- 시스템 구조도
<img src="https://github.com/HBNU-SWUNIV/come-capstone23-kjj/assets/94634916/0346becc-f8d1-464b-b8c9-5cc4a49f7f05" />

- 전체 시스템 구성  
<img src="https://github.com/HBNU-SWUNIV/come-capstone23-kjj/assets/94634916/215b4737-4f37-448e-9733-94db5279f64d" />

- 전체 시스템 흐름도
<img src="https://github.com/HBNU-SWUNIV/come-capstone23-kjj/assets/94634916/d6e9bb54-e08f-4c6a-ad62-79dea596f8f1" />

- ### System Requirements

  - 구내식당 관리자는 음식 메뉴를 등록/수정/삭제/품절할 수 있음
  - 이용객의 예약 현황을 확인하고 식재료 발주량을 추천받을 수 있음
  - 이용객은 시스템을 통해 음식 메뉴를 조회 및 예약할 수 있음. 또한 예약 이용 시 포인트가 적립되어 추후 결제 시 사용할 수 있음
  - 시스템은 이용객의 예약 정보 및 정책 데이터를 기반으로 정산 및 필요한 식재료 양 산출을 진행함
  - 또한 기존 대비 절감된 식재료 양을 시각화하여 제공

## Case Study

## Conclusion

- ### 다른 식당이나 사업장에도 확장 가능한 효율적인 시스템 개발을 통해 지속 가능한 식재료 관리 촉진
- ### 식재료를 적정 소비하기 위한 수요 데이터 제공

## Project Outcome
![웹](https://github.com/HBNU-SWUNIV/come-capstone23-kjj/assets/101088024/d075023f-7849-4151-b649-2c4b2cb482b7)
![앱](https://github.com/HBNU-SWUNIV/come-capstone23-kjj/assets/101088024/e0198d1d-7319-4845-96ca-968e896b1a49)

- ### 20XX 년 OO학술대회

## Git rules

- ### merge

  - assigness: 담당하는 사람
  - labele: 해당하는 labels 선택
  - projects, milestone 탭은 선택 x
  - 리뷰는 개인 리뷰 후 이상없으면 merge

- ### merge name rules

1.  제목과 본문은 띄어쓰기로 구분한다.
2.  제목은 50글자 이내로 제한한다.
3.  제목의 첫 글자는 소문자로 작성한다.
4.  제목 끝에는 마침표를 넣지 않는다.
5.  제목은 명령문으로 사용하며 과거형을 사용하지 않는다.
6.  제목은 영어로만 작성한다.

- merge name 규칙 -> type(제목): text(본문)
- merge name 예시 -> feat: design update

- ### type 종류
- feat: 새로운 기능에 대한 커밋
- fix: 버그 수정에 대한 커밋
- build: 빌드 관련 파일 수정 / 모듈 설치 또는 삭제에 대한 커밋
- chore: 그 외 자잘한 수정에 대한 커밋
- ci: ci 관련 설정 수정에 대한 커밋
- docs: 문서 수정에 대한 커밋
- style: 코드 스타일 혹은 포맷 등에 관한 커밋
- refactor: 코드 리팩토링에 대한 커밋
- test: 테스트 코드 수정에 대한 커밋
- perf: 성능 개선에 대한 커밋
