# meta-freertos
FreeRTOS distro layer compatible with OpenEmbedded

## Build Status

| master  | [![Build Status][masterbadge]][masterpipeline]   |
|:-------:|--------------------------------------------------|
| dunfell | [![Build Status][dunfellbadge]][dunfellpipeline] |


[masterbadge]: https://dev.azure.com/aehs29/meta-freertos/_apis/build/status/FreeRTOS?branchName=master
[masterpipeline]: https://dev.azure.com/aehs29/meta-freertos/_build/latest?definitionId=9&branchName=master
[dunfellbadge]: https://dev.azure.com/aehs29/meta-freertos/_apis/build/status/FreeRTOS?branchName=dunfell
[dunfellpipeline]: https://dev.azure.com/aehs29/meta-freertos/_build/latest?definitionId=9&branchName=dunfell


## Dependencies

This layer depends on:

     URI: git://git.yoctoproject.org/poky
     branch: master


## License
This layer has an MIT license (see LICENSE) and it fetches code from FreeRTOS that has its own License
(MIT as of the day of writing this README), along with code taken from [jkovacic](https://github.com/jkovacic/FreeRTOS-GCC-ARM926ejs) which also has its own license.


## FreeRTOS build setup

1.- Clone the required repositories
```bash
$ git clone https://git.yoctoproject.org/git/poky -b dunfell
$ cd poky
$ git clone https://github.com/Spitzbube/meta-freertos.git -b dunfell
```
2.- Add meta-freertos to your bblayers.conf
```bash
$ source oe-init-build-env
$ bitbake-layers add-layer ../meta-freertos
```
3.- Add the required variables to your local.conf
```bash
$ echo "MACHINE = \"stm32-p405\"" >> ./conf/local.conf
$ echo "DISTRO = \"freertos\"" >> ./conf/local.conf
```

## Build a FreeRTOS demo as a standalone application:
4.- Build a sample FreeRTOS standalone application:
```bash
$ bitbake freertos-stm32-p405
```
