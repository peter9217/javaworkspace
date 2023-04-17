document.getElementById("content").addEventListener("input", ()=>{
    
    document.getElementById("count").innerText = document.getElementById("content").value.length;
    
    if(document.getElementById("content").value.length >100){
        document.getElementById("count").classList.add("error");
        document.getElementById("error").style.color="red";
    }else{
        document.getElementById("count").classList.remove("error");
    }

    //요소.classList.toggle('클래스명')
    // - 요소에 클래스가 없으면 추가 ( true 반환)
    // - 요소에 클래스가 있으면 제거 ( false 반환)
})