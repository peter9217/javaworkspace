document.getElementById("createBtn").addEventListener("click", ()=>{
    const arr = new Array(6)
    for(var i =0; i<7; i++){
        const m = Math.floor(Math.random()*45+1);
        if(arr.indexOf(m)==-1 ){
            container.children[i].innerText = m;
            arr[i]=m;
        }else{i--;}
    }
})