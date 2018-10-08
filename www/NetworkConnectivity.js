var exec = require('cordova/exec');

exports.isConnected = function ( success, error) {
    exec(success, error, 'NetworkConnectivity', 'isConnected');
};
