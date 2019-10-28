import React from 'react';
import './DeviceDetails.css';

const deviceDetails=(device)=>(

    <table>
        <tr>{
            // we go over the object keys of the first device ooject key and put every key in <th>.
            Object.keys(device[Object.keys(device)[0]]).map(function(key, index) {
                return <th> {key} </th>
            })        
        }</tr>
        <tr>{
            // we go over the object values of the first device ooject key and put every value in <td>.
            Object.values(device[Object.keys(device)[0]]).map(function(val, index) {
                // if the type of value is Object so we can't put it in <td> so we conver it to string first 
                if (typeof val === "object") {
                    val = JSON.stringify(val);
                }
                if (typeof val === "boolean" | typeof val === "number") {
                    val = val.toString();
                }
                return <td> {val} </td>
            })    
        }</tr>
    </table>

);

export default deviceDetails;