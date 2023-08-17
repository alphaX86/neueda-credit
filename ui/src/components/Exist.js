import React from "react";
import View from "./View";


export default function Exist() {
    return(
        <div>
            <p>Existing user page</p>
        <button className="navButton" id="Users" onClick={userFunction}>Analyze Customer info</button>
        <button className="navButton" id="Transactions">Analyze Transactions </button>
        </div>

    )
}

function userFunction(){
    return window.location.href = View
}