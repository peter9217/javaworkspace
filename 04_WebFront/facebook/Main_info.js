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
document.getElementById("hobby-btn").addEventListener("click", () => {
    window.open()
})

/* <form >
        <label for="java">Java</label>
        <input type="checkbox" name="skill" id="java" value="자바" checked><br>
        <label for="db">DB</label>
        <input type="checkbox" name="skill" id="db" value="디비" checked><br>
        <label for="html">HTML</label>
        <input type="checkbox" name="skill" id="html" value="HTML5"><br>
        <button>제출</button>
    </form> */



    import { useState } from 'react';
    import ModalBasic from '../src/common/ModalBasic';
    
    // 모달을 노출하는 페이지
    function Modal() {
        // 모달창 노출 여부 state
        const [modalOpen, setModalOpen] = useState(false);
    
        // 모달창 노출
        const showModal = () => {
            setModalOpen(true);
        };
    
        return (
            <div>
                <button onClick={showModal}>모달 띄우기</button>
                {modalOpen && <ModalBasic setModalOpen={setModalOpen} />}
            </div>
        );
    }
    
    export default Modal;
     
    
    
    import styles from './ModalBasic.module.css';
    
    function ModalBasic({ setModalOpen, id, title, content, writer }: PropsType) {
        // 모달 끄기 
        const closeModal = () => {
            setModalOpen(false);
        };
    
        return (
            <div className={styles.container}>
                <button className={styles.close} onClick={closeModal}>
                    X
                </button>
                <p>모달창입니다.</p>
            </div>
        );
    }
    export default ModalBasic;
    
    /* 모달창을 화면 중앙. 최상단에 노출 */
    .container {
      /* 모달창 크기 */
      width: 300px;
      height: 200px;
    
      /* 최상단 위치 */
      z-index: 999;
      
      /* 중앙 배치 */
      /* top, bottom, left, right 는 브라우저 기준으로 작동한다. */
      /* translate는 본인의 크기 기준으로 작동한다. */
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
    
      /* 모달창 디자인 */
      background-color: gray;
      border: 1px solid black;
      border-radius: 8px;
    }
    
    .close {
      position: absolute;
      right: 10px;
      top: 10px;
    }