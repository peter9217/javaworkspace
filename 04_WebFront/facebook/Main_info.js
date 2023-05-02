const strLength = document.getElementById("intro-text");
const texta = document.getElementById("texta");


function info(num){
    const infoList = document.getElementById("main-info").children;
    for(var n=0; n<7; n++){
    infoList[n].style.display = "none";
    }
    switch (num) {
        case 0:
            document.getElementsByClassName("info-experience-1")[0].style.display="block"
            break;
        case 1:
            document.getElementsByClassName("info-experience-2")[0].style.display="block"
            break;
        case 2:
            document.getElementsByClassName("info-experience-3")[0].style.display="block"
            break;
        case 3:
            document.getElementsByClassName("info-experience-4")[0].style.display="block"
            break;
        case 4:
            document.getElementsByClassName("info-experience-5")[0].style.display="block"
            break;
        case 5:
            document.getElementsByClassName("info-experience-6")[0].style.display="block"
            break;
        case 6:
            document.getElementsByClassName("info-experience-7")[0].style.display="block"
            break;
        default:
            break;
    }
}

const infoInput = document.getElementById("info-input");
const intro = document.getElementById("intro-my");
const introArea = document.getElementById("input-intro");
function infoMy(){
    intro.style.display = "none";
    introArea.style.display = "block";
}

function infoCan(){
    introArea.style.display = "none";
    intro.style.display = "block";
}

document.getElementById("intro-save").addEventListener("click", ()=>{
    if(strLength.value.length<100){
        intro.innerText=document.getElementById("intro-text").value;
        introArea.style.display = "none";
        intro.style.display = "block";
    }else{
        alert("글자 수를 초과했습니다.")
    }
})

document.getElementById("intro-text").addEventListener("input", ()=>{
    const strLength = document.getElementById("intro-text").value.length
    texta.innerText = 100 - strLength + "자 남음";
    texta.style.color = "black";

    if(100-strLength <0 ){
        texta.style.color = "red";
        texta.innerText = 100 - strLength + "자 초과 ";
    }
})


const infom = document.getElementsByClassName("info-2-1");
const hobbyl = document.getElementById("what-hobby")
Array.from(infom).forEach((target) => target.addEventListener("click", function(){ 
			jsSearch('test', target); 
		})
	);

function jsSearch(str, target){		
    
    document.getElementById("info-modal").style.display="block";
    document.getElementById("info-modali").style.display="block";

    hobbyl.innerText=(target.innerText).substring(4);
    hobbyl.style.fontSize="19px";


    // alert((target.innerText).substring(4));
};    

document.getElementById("info-modal").addEventListener("click", () => {
    document.getElementById("info-modal").style.display="none";
    document.getElementById("info-modali").style.display="none";
})
document.getElementById("info-cancel").addEventListener("click", () => {
    document.getElementById("info-modal").style.display="none";
    document.getElementById("info-modali").style.display="none";
})
document.getElementById("info-confirm").addEventListener("click", () => {
    document.getElementById("info-modal").style.display="none";
    document.getElementById("info-modali").style.display="none";



})
// function info(){
    //     document.getElementById("info-job").innerText = "red";
// }
// const imset = document.getElementById("imgset")
// document.getElementById("imBtn").addEventListener("click" () => {
    
    

    document.getElementById("hobby-checked").addEventListener("click", () => {
        document.getElementById("add-hobby").removeAttribute('checked');
    })


    슬라이드
const slides = document.querySelector('#fr-border'); //전체 슬라이드 컨테이너
const slideImg = document.querySelectorAll('.who'); //모든 슬라이드들
let currentIdx = 0; //현재 슬라이드 index
const slideCount = slideImg.length; // 슬라이드 개수
const prev = document.querySelector('.prev'); //이전 버튼
const next = document.querySelector('.next'); //다음 버튼
const slideWidth = 202; //한개의 슬라이드 넓이
const slideMargin = 20; //슬라이드간의 margin 값

//전체 슬라이드 컨테이너 넓이 설정
slides.style.width = (slideWidth + slideMargin) * slideCount + 'px';

function moveSlide(num) {
  slides.style.left = -num * 400 + 'px';
    currentIdx = num;
}

prev.addEventListener('click', function () {
  /*첫 번째 슬라이드로 표시 됐을때는 
  이전 버튼 눌러도 아무런 반응 없게 하기 위해 
  currentIdx !==0일때만 moveSlide 함수 불러옴 */

  if (currentIdx !== 0) moveSlide(currentIdx - 1);
});

next.addEventListener('click', function () {
    /* 마지막 슬라이드로 표시 됐을때는 
    다음 버튼 눌러도 아무런 반응 없게 하기 위해
    currentIdx !==slideCount - 1 일때만 
  moveSlide 함수 불러옴 */
    if (currentIdx !== slideCount - 1) {
    moveSlide(currentIdx + 1);
    }
});

