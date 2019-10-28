import React, { Component } from 'react';

import './Device.css'
import DeviceDropDown from '../DeviceDropDown/DeviceDropDown'


class Device extends Component {

  // there is no different if we intialize the 'state' here or in the constructor
  state = {
    deviceDetailsArr : undefined
  };

  deviceSelectionHandler=(deviceId)=> {    
    // if ('deviceId' === "") that's mean the user select 'None' in deviceDropDown, so we intialize
    // state.deviceDetails to undefined, so now will happen rerender and when we ask 'this.state.deviceDetails ?'
    // the answer will be false.   
    if (deviceId === "") {
      this.setState({ deviceDetailsArr: undefined });
    // in case the user select device.  
    }else{   
      fetch(`http://localhost:7171/device/detailsByInterviewRequirements?deviceID=${deviceId}`,{  
        method: "GET",
        // headers: headers,
      })
      .then((response) => {
        // if the server return the answer we want without Exception 
        if (response.ok) {
          // we convert the response to String because in the resolt there is 'special characters' that not enable convert to Json.
            return response.text();
        } else {
          // we got Exception in the sever, so we convert the Response to JSON to be able to work with the Response as an 
          // Object, then get from that Object the 'errorMessage' attribute, and throw that to the catch to show that to the user.
          return response.json().then(objectError => {throw new Error(objectError.errorMessage)})
        }
      })
      // we'll want to display that string to the client as key and value so we delete all the unnecessary signs(characters)
      .then(str => str.replace(/“|”|"|\[|\]|{|}/g, ''))
      // we split the long string to an array of of (kind like key and value) Strings 
      .then(str => str.split(', '))
      // initializing 'state.deviceDetailsArr', once the state change we rerender, and when we
      // ask (in 'render') 'this.state.deviceDetailsArr ?' we'll get 'true',
      .then(strArr => this.setState({ deviceDetailsArr: strArr }))
      // in case the server falls down or the server responses anything but 'ok' status.   
      .catch((errorData) => {
        // if we can't even fetch (maybe because the server is down), or we got an exception in the server that we didn't 
        // send with specific message, so the 'errorData.message' is empty or null.      
        if(errorData.message === "Failed to fetch" | errorData.message === "" | errorData.message === "null"){
          errorData = "for a technical reason we can't provide you that information now, please try again later";
        }
        alert(errorData)
      })
    }
    
  }
  
render() {
    return (
// change name      
      <div className="Device">
        <DeviceDropDown
          deviceSelectionHandler={this.deviceSelectionHandler}
        />
        {
          // if state.deviceDetailsArr NOT empty (undefined)
          this.state.deviceDetailsArr ?
            // if true show the user the 'this.state.deviceDetailsArr' in a table of key and value.
            <table border="5">
              <tr>
                {/*here we loop in 'deviceDetailsArr' to create <th> with the value in every cell*/}
                {this.state.deviceDetailsArr.map( deviceDetail => {
                  // we get only the key into <th>
                  let key = deviceDetail.split(': ')[0];
                  return <th>{key}</th>;
                } )}      
              </tr>
              <tr>
                {this.state.deviceDetailsArr.map( deviceDetail => {
                  // we get only the value into <td>
                  let value = deviceDetail.split(': ')[1];
                  return <td>{value}</td>;
                } )}      
              </tr>
            </table>       
          // else
          :
          <div> no device selected</div>
        }



         
      </div>
    );
  }
}

export default Device;
