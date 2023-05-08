<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/resources/css/main-style.css">

<!-- font awesome 라이브러리 추가 + key 등록 -->
<script src="https://kit.fontawesome.com/9c2aaccfe5.js" crossorigin="anonymous"></script>
    
<header>

            <section>
                <!-- 클릭 시 메인페이지로 이동하는 로고 -->
                <a href="/">
                </a>
            </section>
            <section>
                <!-- 검색어 입력할 수 있는 요소 배치 -->
                <article class="search-area">
                    <!-- 
                        action : 내부 input의 작성된 값을 제출할 경로/주소
                        method : 어떤 방식(GET/POST)으로 제출할지 지정 
                        - GET : input 태그 값을 주소에 담아서 제출(주소에 보임)
                        - POST : input 태그 값을 주소에 담지 않고 제출(주소에 안보임)
                                -> HTTP body에 담아서 제출
                    -->
                    <form action="#" method="GET">
                        <fieldset> <!-- form 태그 내 영역 구분 -->
                            <!-- 
                                input의 name 속성 == 제출 시 key 값
                                input에 입력된 내용 == 제출 시 value 값

                                autocomplete="off" : 브라우저가 제공하는 자동완성 기능 off
                            -->
                            <input type="search" name="query" id="query" placeholder="검색어를 입력해주세요" autocomplete="off">
                            <!-- 검색 버튼 -->
                            <button id="searchBtn" class="fa-solid fa-magnifying-glass"></button>
                        </fieldset>
                    </form>
                </article>
            </section>




            <section></section>
        
            <%-- 우측 상단 드롭다운 메뉴 --%>
            <div class="header-top-menu">
                <c:choose>
                    <c:when test="${empty loginMember}">
                <%-- 로그인 x --%>
                <a href="/">메인 페이지</a> | <a href="/member/login">로그인</a>
                    </c:when>
                
                    <c:otherwise>
                <%-- 로그인 o --%>
                <label for="headerMenuToggle">
                    ${loginMember.memberNickname}<i class="fa-solid fa-caret-down"></i>
                </label>

                <input type="checkbox" id="headerMenuToggle">
                <div class="header-menu"> 
                    <a href="/myPage/info">내정보</a>
                    <a href="/member/logout">로그아웃</a>
                </div>
                    </c:otherwise>
                </c:choose>


            </div>
        
        </header>

        <nav>
            <ul>
                <%-- <li><a href="#">공지사항</a></li>
                <li><a href="#">자유 게시판</a></li>
                <li><a href="#">질문 게시판</a></li>
                <li><a href="#">FAQ</a></li>
                <li><a href="#">1:1문의</a></li> --%>

                <%-- interceptor를 이용해서 조회된 boardTypeList를 application scope --%>
                <c:forEach var="boardType" items="${boardTypeList}">
                    <li>
                        <a href="/board/${boardType.BOARD_CODE}">${boardType.BOARD_NAME}</a>
                    </li>
                
                </c:forEach>
            </ul>
        </nav>
        