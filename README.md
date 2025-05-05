# 늘보람 (Daily Boram) | AI 기반 소설 연재 플랫폼

![image](<./image.png>)  <!-- TODO: 프로젝트 대표 이미지 삽입 -->

**GitHub:** https://github.com/Daily-Boram/daily-boram-spring

## 프로젝트 소개
늘보람 (Daily Boram)은 작가들이 AI 기술을 활용하여 소설 표지 및 등장인물 이미지를 생성하고, 작품을 손쉽게 연재할 수 있도록 지원하는 웹 플랫폼입니다. Stable Diffusion 모델을 기반으로 독창적인 캐릭터 이미지 생성을 돕고, 사용자 친화적인 연재 환경을 제공합니다.

**SOFTWAVE 2022 부스 운영 및 COEX 전시 참가**

## 주요 기능
- **AI 소설 표지 생성**: 소설의 분위기와 내용에 맞는 표지를 AI가 생성합니다.
- **AI 등장인물 이미지 생성**: 텍스트 설명을 바탕으로 소설 속 등장인물의 비주얼을 AI가 구현합니다.
- **소설 연재 및 관리**: 작가가 시리즈 및 에피소드 단위로 작품을 게시하고 관리할 수 있습니다.
- **사용자 인증**: Naver OAuth2.0을 이용한 간편 로그인 기능을 제공합니다.
- **커뮤니티 기능**: 독자들이 작품에 대한 댓글을 작성하고 '좋아요'를 통해 선호도를 표현할 수 있습니다.
- **작품 검색 및 탐색**: 제목, 장르 등 다양한 기준으로 작품을 검색하고 탐색할 수 있습니다.
- **사용자 프로필**: 작가 및 독자의 프로필 정보와 작성/구매 내역을 관리합니다.

## 기술 스택
- **백엔드**: Spring Boot (Java), Spring Security, JPA
- **데이터베이스 쿼리**: QueryDSL
- **AI 모델**: Stable Diffusion
- **AI 서버**: FastAPI
- **인증**: OAuth2 (Naver Login), JWT (Json Web Token)
- **API 클라이언트**: OpenFeign
- **기타**: Lombok, Spring Data JPA Auditing

## 시스템 아키텍처

1.  **Spring Boot 백엔드**: 핵심 비즈니스 로직 처리, 사용자 관리, 소설 데이터 관리, 인증/인가, API 제공.
2.  **AI 서버 (FastAPI)**: Stable Diffusion 모델을 사용하여 이미지 생성 요청 처리. Spring Boot 백엔드와 API 통신.
3.  **데이터베이스**: 사용자 정보, 소설 시리즈/에피소드, 댓글, 좋아요 등 데이터 저장 (JPA/QueryDSL 사용).
4.  **Naver API**: OAuth2 인증을 위한 외부 연동.

## 개발 과정
1.  **도메인 모델링**: User, Series, Episode, Character, Content, Comment, Like (Series/Episode), Genre, Purchase 등 핵심 엔티티 설계 및 JPA 매핑.
2.  **인증/인가 구현**: Spring Security와 JWT를 활용한 인증 시스템 구축 및 Naver OAuth2 연동.
3.  **핵심 기능 개발**:
    *   시리즈/에피소드 CRUD 기능 구현.
    *   댓글 및 좋아요 기능 구현 (SeriesLike, EpisodeLike).
    *   사용자 프로필 관리 및 조회 기능 구현.
4.  **AI 연동**: Stable Diffusion 모델을 활용하는 별도의 AI 서버(FastAPI)와 OpenFeign을 이용한 API 통신 구현.
5.  **데이터 조회 최적화**: QueryDSL을 활용하여 메인 페이지 정렬(최신순, 인기순, 랜덤), 검색 기능 등 복잡한 데이터 조회 로직 구현.
6.  **API 설계**: 각 기능별 RESTful API 엔드포인트 설계 및 구현 (Controller, Service, Repository 패턴).
7.  **예외 처리**: Global Exception Handler를 통한 체계적인 오류 관리 및 응답 표준화.
8.  **전시 준비**: SOFTWAVE 2022 전시를 위한 기능 안정화 및 데모 준비.

## 설치 및 실행 방법

### 필수 환경
-   Java Development Kit (JDK) 11 또는 이후 버전
-   Maven 또는 Gradle (프로젝트 빌드 도구에 따라)
-   관계형 데이터베이스 (MySQL)
-   (선택사항) AI 이미지 생성을 위한 별도 AI 서버 환경 (Python, PyTorch/TensorFlow, Stable Diffusion 모델 등)

### 설치
1.  **저장소 클론**
    ```bash
    git clone https://github.com/Daily-Boram/daily-boram-spring.git
    cd daily-boram-spring
    ```
2.  **설정 파일 구성**
    *   `src/main/resources/application.yml` (또는 `application.properties`) 파일 생성 및 수정.
    *   데이터베이스 연결 정보 (URL, username, password) 입력.
    *   JWT 비밀키 (`jwt.jwt-secret`) 설정.
    *   Naver OAuth2 클라이언트 ID (`spring.security.oauth2.client.registration.naver.client-id`) 및 Secret (`spring.security.oauth2.client.registration.naver.client-secret`) 설정.
    *   (선택사항) AI 서버 API 엔드포인트 설정.

3.  **프로젝트 빌드**
    *   Maven 사용 시:
        ```bash
        ./mvnw clean package
        ```
    *   Gradle 사용 시:
        ```bash
        ./gradlew clean build
        ```

### 실행
1.  **Spring Boot 애플리케이션 실행**
    ```bash
    java -jar target/dailyboramspring-*.jar
    # 또는 IDE에서 직접 실행
    ```
2.  **(선택사항) AI 서버 실행**
    *   별도로 구축된 AI 서버(FastAPI 등) 실행.

3.  **웹 서비스 접속**
    *   설정된 포트(기본 8080) 및 프론트엔드 주소로 접속.

## 사용 예시 (플로우)
1.  사용자가 웹사이트에 접속하여 Naver 계정으로 로그인합니다.
2.  작가는 '새 시리즈 만들기'를 통해 소설 제목, 요약, 장르 등을 입력합니다.
3.  (선택사항) AI 생성 기능을 이용하여 표지 또는 등장인물 이미지를 생성하고 시리즈에 추가합니다.
4.  작가는 에피소드를 작성하고, 등장인물의 대사 등을 포함하여 게시합니다.
5.  독자는 게시된 소설을 검색하거나 메인 페이지에서 탐색하여 읽습니다.
6.  독자는 마음에 드는 시리즈나 에피소드에 '좋아요'를 누르거나 댓글을 작성하여 소통합니다.
7.  사용자는 '내 프로필'에서 자신이 작성한 시리즈 목록이나 구매(읽기) 내역 등을 확인할 수 있습니다.

## 한계점 및 향후 개선 방향
-   **AI 모델 성능**: 현재 연동된 AI 모델의 성능에 따라 결과물의 품질이 달라질 수 있으며, 지속적인 모델 개선 및 파인튜닝이 필요합니다.
-   **결제 시스템**: 현재 'cookie' 필드로 구현된 포인트/재화 시스템을 실제 결제 시스템과 연동하여 확장할 수 있습니다.
-   **고급 기능**: 작품 추천 시스템, 작가 후원 기능, 통계 기능 등 사용자 경험 향상을 위한 추가 기능 개발을 고려할 수 있습니다.
