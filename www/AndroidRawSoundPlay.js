  var exec = require('cordova/exec') , sound  = {};

  sound.coolMethod = function (arg0, success, error) {
      exec(success, error, 'AndroidRawSoundPlay', 'coolMethod', [arg0]);
  };
  sound.listRaw = function ( success, error) {
      exec(success, error, 'AndroidRawSoundPlay', 'listRaw', []);
  };
  module.exports = sound;
