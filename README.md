I hope I understood you correctly:
You wanted me to "Construct a HTTP Endpoint" in server-side, "which retrieves the data from the URL I gave you above and returns a response to the client which will be: { ׳’ג‚¬ן¿½name׳’ג‚¬ן¿½: "AurigaDC01"....." (return String, Not an object[Because ׳’ג‚¬ן¿½name׳’ג‚¬ן¿½ has apostrophes that are not suitable for regular Object]), Then fetch that string in React project and show it in a simple table.
For that project, Use these files: 'auriga_interveiew_front_end1' and 'AurigaInterviewBackEnd'.
If in the future, The long data will add another Device to the array, Then: Just add it's ID to to the '@JsonAlias' in  'com.nati.aurigainterviewsbackend.beans.Device', And its name and ID to new <option> in auriga_interveiew_front_end1\src\components\DeviceDropDown\DeviceDropDown.js'.


Just in case, I also 'Construct a HTTP Endpoint' in Front-End in other project.
For that project, Use this file: 'auriga_interveiew_front_end'
If in the future, The long data will add another Device to the array: Just add its ID to the '@JsonAlias' in  'com.nati.aurigainterviewsbackend.beans.Device'. That's it!. (That way it's more generic then the first project)


For server-side i used eclipse.
For client-side i used visualStudio.
How to run my app:
Just 'run on server' the Main class in 'AurigaInterviewBackEnd' project,
Then wrote the command 'npm i' in 'auriga_interveiew_front_end1' project, To install the NodeModules and 				                 'package-lock.json', Then npm 'start'.

 				  
Please read my commends - Especially in com.nati.logic.DeviceLogic 



	



