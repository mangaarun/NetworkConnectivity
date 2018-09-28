var exec = require('cordova/exec');

exports.network = function (arg0, success, error) {
    exec(success, error, 'NetworkConnectivity', 'network', [arg0]);
};
