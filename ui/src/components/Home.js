import React from 'react'
import { Link } from 'react-router-dom'
import Barchart from './Barchart';
import Piechart from './Piechart';

export default function Home(){
    const data = [
        {quarter: 1, earnings: 13000},
        {quarter: 2, earnings: 16500},
        {quarter: 3, earnings: 14250},
        {quarter: 4, earnings: 19000}
      ];
    return(
        <div>
            <p>Home page</p>
        </div>
    )
}