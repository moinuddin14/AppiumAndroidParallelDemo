# AppiumAndroidParallelDemo

### Steps to run this Demo

1. Clone this repository with `git clone https://github.com/moinuddin14/AppiumAndroidParallelDemo.git` and ensure all the dependencies are downloaded (as mentioned in pom.xml)
2. `cd AppiumAndroidParallelDemo`
3. Download Android Studio from this [here](https://developer.android.com/studio)
4. Follow the steps mentioned [here](https://developer.android.com/studio/install) to setup Andriod Studio with Android Command line tools like adb, aapt etc., 
5. Start appium server from command line/terminal window with this command `appium --address 127.0.0.1 --port 4727` and press enter
6. Start any two emulators, follow the steps mentioned in this [tutorial](https://www.dummies.com/web-design-development/mobile-apps/how-to-set-up-an-emulator-in-android-studio/) for setting up Android Emulators, you can also use Genymotion or other Emulator providers
7. Now, right click on the `testng.xml` file and click on Run
8. You should now see the apps running in parallel

Note: You can download any sample .apk from this location and update the path in this capability paramter `capabilities.setCapability(MobileCapabilityType.APP, "/Users/moin/Downloads/demo.apk");`
