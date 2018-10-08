# NetworkConnectivity
Checks whether device connected to network or not

Works for only Android

Usage
--------------
install plugin using following command
<pre>
ionic cordova plugin add git://github.com/mangaarun/NetworkConnectivity
</pre>

<pre>
// create a global variable in your component
declare var NetworkConnectivity: any;

//checking network connectivity
NetworkConnectivity.isConnected(function(success){
  if(success)
    console.log("Connected to network");
  else
    console.log("Device not connected to network");
},function(error){
    console.log(error);
});

</pre>
