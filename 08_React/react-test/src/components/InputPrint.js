import React, {useState} from "react";

const Id = () => {

    const [name, setName] = useState('');
    const [input, setInput] = useState('위 텍스트 필드에 값을...');

    const setNam= ()=>{
        console.log(name)
        setInput(name)
    }

    return (
        <div>
            <input type="text" onChange={e=>setName(e.target.value)}/>
            <button onClick={setNam}>보내기</button>
            <div id="test2">
                <h2>{input}</h2>
            </div>

        </div>

    );
}
const Test2 = () => {
    return(
        <div>
            <Id />
        </div>
    )
}


export default Test2;