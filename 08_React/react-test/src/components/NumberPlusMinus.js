import React, { useState } from 'react';

function Test1(){
    let [count, setCount] = useState(0);

    const handlePlusClick = () => {
        setCount(()=>count+1)
    };
    const handleMinusClick = () => {
        setCount(()=>count-1)
    };

    return(
        <>
            <span id="test1">
                <button onClick={handleMinusClick}>-</button>
                {count}
                <button onClick={handlePlusClick}>+</button>
            </span>
        </>
    );
    
}

export default Test1;