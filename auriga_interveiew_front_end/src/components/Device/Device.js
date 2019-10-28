import React, { Component } from 'react';

import DeviceDropDown from '../DeviceDropDown/DeviceDropDown'
import DeviceDetails from './../DeviceDetails/DeviceDetails';
import DeviceName from './../DeviceName/DeviceName';


class Device extends Component {

  state = {
    // here we keep all the devices we got from the 'fake url' ()
    deviceArray: [],   
    // here we keep the device the user select
    selectedDevice: undefined
  };

  constructor() {
    super();

    // we get all devices from that url
    fetch("https://api.cybergator.co.uk/testing/devices")
      .then(res => res.json())
      // initializing state.deviceArray
      .then(bodyRes => this.setState({ deviceArray: bodyRes }))
      // maybe here we can send to Function in server-side to check if the DB equals to that resolt, if not -update.
      
      // if the url was real we delete the next line
      // and go to Function in server side to get the deviceArray from tere, if that not work we send 'error' to the client.
      .catch(() =>this.setState({ deviceArray: [{ "2b727991-5ddb-4a42-82eb-13bbb2876a28": { "agentVersion": "0.1.0", "alertIds": ["0a45fa06-87ad-4ef7-ae30-f05d42beca22", "16597623-a5d1-4a21-8304-58c458aefd3b"], "architecture": "x64", "collector": {"tenantId": "496e3cfd-672c-47ae-9dfb-0d840b0aed80", "collectorId": "5316b276-18cc-4692-b89b-26ae22a0c4ef", "collectorName": "Test_Collector"}, "cpuModel": "Intel(R) Xeon(R) CPU E5-2673 v3 @ 2.40GHz", "cpuNumber": 1, "description": "Auriga Test Device", "deviceId": "2b727991-5ddb-4a42-82eb-13bbb2876a28", "discoveryDate": "2019-05-21T16:02:56.819", "externalIp": "144.0.1.163", "externalIpCordLat": "52.35", "externalIpCordLong": "4.9167", "externalIpDateUpdated": "2019-06-10T09:33:07.932", "ipAddresses": [{"ipAddress": "1.0.0.4", "ipFamily": "IPv4", "macAddress": "01:1d:3a:20:da:2d"},{"ipAddress": "10.0.0.1", "ipFamily": "IPv4", "macAddress": "02:1d:3a:20:da:2d"}], "isAgentConnected": true, "lastSeenDate": "2019-06-10T09:46:00.176Z", "name": "AurigaDC01", "osCode": "Windows_NT", "platform": "win32", "registeredDate": "2019-05-21T16:02:56.819", "release": "6.3.9600", "updatesScriptLastRun": "2019-06-10T09:24:10" }}, { "2b727991-5ddb-4a42-82eb-13bbb2876a28": { "agentVersion": "0.2.0", "alertIds": ["0a45fa06-87ad-4ef7-ae30-f05d42beca22", "16597623-a5d1-4a21-8304-58c458aefd3b"], "architecture": "x64", "collector": {"tenantId": "496e3cfd-672c-47ae-9dfb-0d840b0aed80", "collectorId": "5316b276-18cc-4692-b89b-26ae22a0c4ef", "collectorName": "Test_Collector"}, "cpuModel": "Intel(R) Xeon(R) CPU E5-2673 v3 @ 2.40GHz", "cpuNumber": 1, "description": "Auriga Test Device", "deviceId": "2b727991-5ddb-4a42-82eb-13bbb2876a28", "discoveryDate": "2019-05-21T16:02:56.819", "externalIp": "144.0.1.163", "externalIpCordLat": "52.35", "externalIpCordLong": "4.9167", "externalIpDateUpdated": "2019-06-10T09:33:07.932", "ipAddresses": [{"ipAddress": "1.0.0.4", "ipFamily": "IPv4", "macAddress": "01:1d:3a:20:da:2d"},{"ipAddress": "10.0.0.1", "ipFamily": "IPv4", "macAddress": "02:1d:3a:20:da:2d"}], "isAgentConnected": true, "lastSeenDate": "2019-06-10T09:46:00.176Z", "name": "AurigaDC02", "osCode": "Windows_NT", "platform": "win32", "registeredDate": "2019-05-21T16:02:56.819", "release": "6.3.9600", "updatesScriptLastRun": "2019-06-10T09:24:111" }},{ "2b727991-5ddb-4a42-82eb-13bbb2876a28": { "agentVersion": "0.1.0", "alertIds": ["0a45fa06-87ad-4ef7-ae30-f05d42beca22", "16597623-a5d1-4a21-8304-58c458aefd3b"], "architecture": "x64", "collector": {"tenantId": "496e3cfd-672c-47ae-9dfb-0d840b0aed80", "collectorId": "5316b276-18cc-4692-b89b-26ae22a0c4ef", "collectorName": "Test_Collector"}, "cpuModel": "Intel(R) Xeon(R) CPU E5-2673 v3 @ 2.40GHz", "cpuNumber": 1, "description": "Auriga Test Device", "deviceId": "2b727991-5ddb-4a42-82eb-13bbb2876a28", "discoveryDate": "2019-05-21T16:02:56.819", "externalIp": "144.0.1.163", "externalIpCordLat": "52.35", "externalIpCordLong": "4.9167", "externalIpDateUpdated": "2019-06-10T09:33:07.932", "ipAddresses": [{"ipAddress": "1.0.0.4", "ipFamily": "IPv4", "macAddress": "01:1d:3a:20:da:2d"},{"ipAddress": "10.0.0.1", "ipFamily": "IPv4", "macAddress": "02:1d:3a:20:da:2d"}], "isAgentConnected": true, "lastSeenDate": "2019-06-10T09:46:00.176Z", "name": "AurigaDC03", "osCode": "Windows_NT", "platform": "win32", "registeredDate": "2019-05-21T16:02:56.819", "release": "6.3.9600", "updatesScriptLastRun": "2019-06-10T09:24:1034" }}] }));

  }

  deviceSelectionHandler=(deviceName)=> {
    // we pul out the device from 'state.deviceArray' who have the same name like the user select, and initializing state.selectedDevice to that device.
    this.setState({ selectedDevice: this.state.deviceArray.find(e=>e[Object.keys(e)[0]].name===deviceName) });
  }

  render() {
    return (
      <div className="App">
        <DeviceDropDown 
            deviceArray={this.state.deviceArray}
            deviceSelectionHandler={this.deviceSelectionHandler} 
        />
        <hr />
        {
          // if state.selectedDevice not empty (undefined)
          this.state.selectedDevice ?
            <div>
              <DeviceName deviceName={this.state.selectedDevice[Object.keys(this.state.selectedDevice)[0]].name} />
              <DeviceDetails deviceDetails={this.state.selectedDevice[Object.keys(this.state.selectedDevice)[0]]} />
            </div>
            // else
            :
            <div> no device selected</div>
        }
      </div>
    );
  }
}

export default Device;
