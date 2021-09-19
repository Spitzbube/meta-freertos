SUMMARY = "FreeRTOS application example based on https://github.com/jkovacic/"

# This app is the same as the one from the above repo,
# the only change is that this example is built locally
# instead of cloning from git

#inherit freertos-armv5
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8f5b865d5179a4a0d9037aebbd00fc2e"
S="${WORKDIR}"
EXTRA_OEMAKE_append = " PORT=ARM_CM4F"

inherit freertos-image

SRC_URI += " \
    file://LICENSE.txt \
    file://Makefile \
    file://stm32_flash.ld \
    file://startup.s \
    file://system_stm32f4xx.c \
    file://system_stm32f4xx.h \
    file://stm32f4xx.h \
    file://core_cm4.h \
    file://core_cmFunc.h \
    file://core_cmInstr.h \
    file://core_cmSimd.h \
    file://FreeRTOSConfig.h  \
    file://main.c  \
    file://led.c  \
"

EXTRA_OEMAKE += "APP_SRC=${WORKDIR}/ DRIVERS_OBJS= FREERTOS_PORT_OBJS=port.o LINKER_SCRIPT=stm32_flash.ld  'STAGING_LIBDIR=${STAGING_LIBDIR}'"
EXTRA_OEMAKE += "CFLAGS+=-DSTM32F4XX"
EXTRA_OEMAKE += "CFLAGS+=-DSTM32F40_41xxx"
EXTRA_OEMAKE += "CFLAGS+=-DHSE_VALUE=8000000"

EXTRA_OEMAKE += "FREERTOS_OBJS=tasks.o"
EXTRA_OEMAKE += "FREERTOS_OBJS+=list.o"
EXTRA_OEMAKE += "FREERTOS_OBJS+=queue.o"
EXTRA_OEMAKE += "FREERTOS_OBJS+=timers.o"
