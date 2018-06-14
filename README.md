# ResourcesAccess
This plugin will help you play sound from raw folder of android native platform

**Installation**

Run `cordova plugin add https://github.com/MZabih/ResourcesAccess` in your terminal

**Configuration**

Open `project/platforms/android/src/cordova-plugin-resources-access/ResourcesAccess/ResourcesAccess.java` and change `import com.myApp.starter.R` with `com.YOUR_APP_PACKAGE_NAME.R` and sync project.

To get list of sounds present in Raw folder 

```javascript
  cordova.plugins.ResourcesAccess.listRaw(function(soundList) {
      angular.forEach(soundList, function(tuneName) {
          $scope.tunesList.push({
              name: tuneName
          });
      });
 ```
 To Play sounds from android media player 
 
 ```javascript
 cordova.plugins.ResourcesAccess.coolMethod(name_of_the_tune_in_raw_folder);
 ```
