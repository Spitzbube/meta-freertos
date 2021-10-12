#DEFAULTTUNE ?= "armv4t"
#DEFAULTTUNE ?= "armv4t"

require conf/machine/include/arm/arch-armv4.inc

TUNEVALID[arm7tdmi] = "Enable arm7tdmi specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'arm7tdmi', ' -mcpu=arm7tdmi', '', d)}"
MACHINEOVERRIDES =. "${@bb.utils.contains('TUNE_FEATURES', 'arm7tdmi', 'armv4:', '' ,d)}"

AVAILTUNES += "arm7tdmi"
ARMPKGARCH_tune-arm7tdmi = "arm7tdmi"
# mcpu is used so don't use armv4t as we don't want march
#TUNE_FEATURES_tune-arm7tdmi = "arm thumb arm7tdmi"
TUNE_FEATURES_tune-arm7tdmi = "arm arm7tdmi"
#PACKAGE_EXTRA_ARCHS_tune-arm7tdmi = "${PACKAGE_EXTRA_ARCHS_tune-armv4t} arm7tdmit"
PACKAGE_EXTRA_ARCHS_tune-arm7tdmi = "${PACKAGE_EXTRA_ARCHS_tune-armv4} arm7tdmi"
