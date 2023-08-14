import React from "react";
import Exist from "./Exist";

export default function Navbar() {
    return(
        <div>
            <button className="navButton" id="addButton" onClick={userFunction}>Add Customer</button>
            <button className="navButton" id="viewButton">View Existing Customer(s)</button>
        </div>
    )
}

function userFunction(){
    return window.location.href = Exist
}