import React from 'react'

// if we have other devices in the future, we just add them to new <option>. this way it's generic
const deviceDropDown = (p) => (  
    <div>
        <p> select device to see it's information </p>
        {
            // onChange - we activate 'deviceSelectionHandler' Function in 'Device' with the value of the optin the user choose(URL). 
            <select onChange={(e) => {p.deviceSelectionHandler(e.target.value) }}>
                <option value="">None</option>
                {
                    // i value we wrote the doviceID we added
                    <option value="2b727991-5ddb-4a42-82eb-13bbb2876a28">
                        AurigaDC01
                    </option>
                }
            </select>      
        }
        
    </div>
);

export default deviceDropDown;