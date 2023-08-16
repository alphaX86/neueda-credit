import React from "react";
import { VictoryPie } from "victory";

export default function Piechart({ data }) {
    return(
            <VictoryPie 
                data={data} 
                colorScale={["tomato", "orange", "gold", "cyan", "navy", "blue"]}
             />
    )
}
