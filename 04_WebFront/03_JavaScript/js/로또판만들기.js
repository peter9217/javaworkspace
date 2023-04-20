const lottoBoard =document.getElementById("lottoBoard");
document.getElementById("createBtn").addEventListener("click", ()=>{
    lottoBoard.innerHTML = "";
    const arr = new Array(45)
    const div = document.createElement("div");
    div.classList.add("number");
    for(var n =0; n<45; n++){
            const div = document.createElement("div");
            div.classList.add("number");
            lottoBoard.prepend(div);
            
        }
        for(var n =0; n<45; n++){
            const m = Math.floor(Math.random()*45+1);
        if(arr.indexOf(m)==-1 ){
            arr[n]=m;
            document.getElementById("lottoBoard").children[n].innerText= m;
        }else{n--;}

        div.addEventListener("click", e => {
            e.target.classList.toggle("active");
        })
    }
});1