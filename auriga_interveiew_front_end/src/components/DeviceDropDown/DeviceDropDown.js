import React from 'react'

const deviceDropDown = (p) => (  
    <div>
        {
            <select onChange={(e) => {p.deviceSelectionHandler(e.target.value) }}>
                <option> </option>
                {
                    // we go over the 'deviceArray' to get all the devices names and show them to the user
                    p.deviceArray.map((elemnt, index) => (
                        // like 'elemnt[0].name' because we have object inside object
                        <option value={elemnt[Object.keys(elemnt)[0]].name} key={index} >
                            {elemnt[Object.keys(elemnt)[0]].name}
                        </option>
                    ))
                }
            </select>      
        }
        
    </div>
);

export default deviceDropDown;