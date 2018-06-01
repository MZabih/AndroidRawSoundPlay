  var exec = require('cordova/exec') , sound  = {};

  sound.coolMethod = function (arg0, success, error) {
      exec(success, error, 'ResourcesAccess', 'coolMethod', [arg0]);
  };
  sound.listRaw = function ( success, error) {
      exec(success, error, 'ResourcesAccess', 'listRaw', []);
  };
  module.exports = sound;
