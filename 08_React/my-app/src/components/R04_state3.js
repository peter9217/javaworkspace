import React, {useState} from "react";

const Id = ({handler}) => {

    //  props로 전달한 값 중 key가 handler인 요소의 value 반환
    // console.log(handler);
    // console.log(props.handler);
    return(
        <>
            <div className="wrapper">
                <label htmlFor="id">id : </label>
                <input type="text" id="id" onChange={handler}/>
            </div>
        </>
    
    );

};

const Pw = ({handler}) => {
    return(
        <>
            <div className="wrapper">
                <label htmlFor="pw">Pw : </label>
                <input type="password" id="pw" onChange={handler}/>
            </div>
        </>
    
    );

};

// 상태 끌어올리기
const StateLiftingUp =  () => {

    const [id, setId] = useState('');
    const [pw, setPw] = useState('');

    const idHandler = (e) => {
        setId(e.target.value);
    }

    const pwHandler = (e) => {
        setPw(e.target.value);
    }
    console.log("id : " + id )
    console.log("pw : " + pw )
    return(
        <>
            <Id  handler={idHandler}/>
            <Pw  handler={pwHandler}/>

            <div className="wrapper">
                <button disabled={id.length ===0 || pw.length===0}>Login</button>
            </div>
        </>
    );
}

export default StateLiftingUp;