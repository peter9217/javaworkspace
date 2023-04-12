// 인라인 이벤트 모델 확인하기
function test1(el){ // el == element ==전달 받은 요소
    el.style.backgroundColor = 'black';
    el.style.color = 'white';
}

// 고전 이벤트 모델 확인하기

// 아이디가 'test2a'인 요소를 얻어오기
document.getElementById('test2a') // -> null 
document.getElementById('test2a').onclick = function(){
    // function(){} : 익명 함수(이름이 없는 함수)
    //                      재사용 목적이 아닌 특정 이벤트에 대한 기능을 만들 때 주로 사용 
    alert("고전 이벤트 모델로 출력된 내용입니다.");
}

// test2a의 클릭 이벤트 동작 제거(이벤트 제거)
document.getElementById("test2b").onclick = function(){

    document.getElementById("test2a").onclick = null;
    alert("이벤트 제거");
}

//고전 이벤트 모델 단점 확인하기
// -> 한 요소에 여러 이벤트 핸들러를 연결할 수 없음
// 왜? 마지막으로 작성한 핸들러가 앞서 작성된 핸들러를 덮어씌움
const c = document.getElementById("test2c"); // 버튼 요소를 얻어옴

c.onclick = function(){
    c.style.backgroundColor='pink'; // 배경색 핑크
}

c.onclick = function(){
    c.style.fontSize = '40px'; //폰트 크기 40px

}

// 표쥰 이벤트 모델 확인하기
/* [표준 이벤트 모델 작성 방법]
    요소.addEventListener(감지할 이벤트, 이벤트 핸들러);
    ex)
    test3.addEventListener("click", 익명 function(){   
    })


    */
const test3 = document.getElementById('test3');
// #test3 클릭 시 width를 20px 만큼 증가
test3.addEventListener("click",function(){
    //요소.clientWidth : 요소의 너비 (CSS로 지정된 값도 읽어옴 readonly)  
    //요소.clientHeight : 요소의 높이 (CSS로 지정된 값도 읽어옴 readonly)
    test3.style.width = test3.clientWidth + 20 + "px"; /* (현재 너비) */
})

test3.addEventListener("click", function(){
    // this : 이벤트가 발생한 요소 (여기서는 #test3)
    this.style.height = test3.clientHeight + 20 + "px";
});

test3.addEventListener("click", function(e){
    // 이벤트 핸들러의 매개변수 e 또는 event -> 현재 발생한 이벤트에 대한 모든 정보를 담고 있는 객체
    // == 이벤트 객체
    // e.target : 이벤트가 발생한 현재 요소 (==this)
    // console.log(e);

    const currentWidth = e.target.clientWidth;
    const currentHeight = e.target.clientHeight;

    // 현재 너비가 500px을 초과하면 너비/높이를 200px로 초기화
    if(currentWidth > 480) {
        e.target.style.width = "200px";
        e.target.style.height = "200px";
    }

})

const num1 = document.getElementById("num1");
const num2 = document.getElementById("num2");
// const result = document.getElementByClassName("result");
// document.getElementById("p").addEventListener('click', function(){
//     // result.innerText = Number(num1.value) + Number(num2.value);
//     result.innerText = new Function("return " + Number(num1.value) + e.target.innerText + Number(num2.value))();
// });
// const opL = document.getElementsByClassName("op");
// for(let i =0; i<opL.length; i++){
//     // console.log(opL[i]);
// opL[i].addEventListener('click', function(e){
//     result.innerText = new Function("return " + Number(num1.value) + e.target.innerText + Number(num2.value))();
// })
// }
// document.getElementsByClassName("op")[0].addEventListener


// for(let op of opList){
//     op.addEventListener('click', function(e){
//         result.innerText =new Function("return " + Number(num1.value) + e.target.innerText + Number(num2.value))();
//     });
// }



const col = document.getElementsByClassName("color");
const box = document.getElementsByClassName("box");
for(let i=0; i<col.length; i++){
    
    col[i].addEventListener('keyup', function(){
        box[i].style.backgroundColor = col[i].value;
    }
    
)}

// a태그 기본 이벤트 제거
document.getElementById("moveGoogle").addEventListener("click", function(e){
    // e: 이벤트 객체
    e.preventDefault();
    //Default : 기본
    //prevent : 막다
});

// form태그 기본 이벤트 제거1
//  -> submit 버튼을 없애고 일반 button이 클릭 되었을 때 조건이 맞으면 submit 하게 만들기


// document.getElementById("btn").addEventListener("click", function(){
//     // 작성된 아이디, 비밀번호 얻어오기
//     const id = document.querySelector("[name='id']").value;
//     const pw = document.querySelector("[name='pw']").value;
//     if(id=='user01' && pw == 'pass01'){
//         // 아이디, 비밀번호가 일치할 때 form 태그 제출
//         // submit() : form 태그 제출

//         document.testForm.submit();
//     }else{
//         alert("ㄴㄴ");
//     }
// })


// form태그 기본 이벤트 제거2 (인라인 이벤트 모델)
function fnCheck(){
    const id = document.querySelector("[name='id']").value;
    const pw = document.querySelector("[name='pw']").value;
    if(id=='user01' && pw == 'pass01'){
        // 아이디, 비밀번호가 일치할 때 form 태그 제출
        // submit() : form 태그 제출

        return true; // true를 반환해서 제출 수행h
    }else{
        alert("ㄴㄴ");
        return false; // false를 반환해서 제출을 막음
    }
}


// form태그 기본 이벤트 제거3 (표준 이벤트 모델)
// -> name이 testForm인 form태그에서 submit 이벤트가 발생했을 때
document.testForm.addEventListener("submit", function(e){
    // e : 이벤트 객체
    console.log(e)
    e.preventDefault(); // 기본 이벤트 막기
    
})






