# RadioWaWa

An Xposed module to use LineageOS FMRadio without headphones connected, on legacy Android versions.

---

## **Based on the following sources:**

- https://github.com/LineageOS/android_vendor_qcom_opensource_fm-commonsys/blob/lineage-20.0/fmapp2/src/com/caf/fmradio/FMRadioService.java
  
- https://github.com/LineageOS/android_vendor_qcom_opensource_fm-commonsys

## What's new:

* Addressed compatibility with LineageOS 20.0, LineageOS 20.0

* Added support for LSPosed,

* Fixed compilation,

* Upgraded dependencies,

* Fixed LSPosed Manager log spam.

* Tested on beryllium with LineageOS 20.0 and mido with LineageOS 20.0

## Considerations:

If this will be merged, we probably won't need this module anymore:

https://github.com/LineageOS/android_vendor_qcom_opensource_fm-commonsys/commit/f9400c9ce0c31d624a25aa55ff0a3e61e8ef5c89

So we can downgrade the minSDK version for abandoned versions.

## Hardware peripheral:

The usage of microphone antenna is suggested:

![image](https://user-images.githubusercontent.com/7214961/173235387-505979da-d92d-4356-b090-e37e265ffba3.png)

## Issues:

* MinSDK need to be upgraded to the LineageOS version that started using CAF radio, currently is on 24.

## Credits:

* [sequielo](https://github.com/sequielo/LFRWH) Original project
