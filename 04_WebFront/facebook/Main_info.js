const strLength = document.getElementById("intro-text")
const texta = document.getElementById("texta")


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
const infoInput = document.getElementById("info-input")
const intro = document.getElementById("intro-my")
const introArea = document.getElementById("input-intro")
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


document.querySelector(".info-2-1").addEventListener("click", () => {
    infoInput.style.display = "block";

})


