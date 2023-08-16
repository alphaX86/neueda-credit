import React from "react";
import { VictoryBar, VictoryChart } from "victory";

export default function Barchart({ data, x, y }) {
    return (
        <div>
            <VictoryChart domainPadding={20}>
                <VictoryBar data={data} x={x} y={y} />
            </VictoryChart>
        </div>
    );
}
