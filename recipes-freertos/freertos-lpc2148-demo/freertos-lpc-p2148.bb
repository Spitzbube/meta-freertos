SUMMARY = "FreeRTOS application example based on https://github.com/jkovacic/"

# This app is the same as the one from the above repo,
# the only change is that this example is built locally
# instead of cloning from git

#inherit freertos-armv5
S="${WORKDIR}"
EXTRA_OEMAKE_append = " PORT=ARM7_LPC2000"

inherit freertos-image

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8f5b865d5179a4a0d9037aebbd00fc2e"

SRC_URI += " \
    file://LICENSE.txt \
    file://Makefile \
    file://lpc2148-rom.ld \
    file://startup.s \
    file://swiDispatch.s \
    file://main.c \
    file://cpu.c \
    file://led.c \
    file://lpc214x.h \
    file://sysdefs.h \
    file://FreeRTOSConfig.h  \
"

EXTRA_OEMAKE += "'STAGING_LIBDIR=${STAGING_LIBDIR}'"
EXTRA_OEMAKE += "FREERTOS_OBJS=list.o"
EXTRA_OEMAKE += "FREERTOS_OBJS+=tasks.o"
EXTRA_OEMAKE += "FREERTOS_OBJS+=queue.o"
EXTRA_OEMAKE += "FREERTOS_OBJS+=timers.o"
EXTRA_OEMAKE += "FREERTOS_PORT_OBJS=port.o"
EXTRA_OEMAKE += "FREERTOS_PORT_OBJS+=portISR.o"
EXTRA_OEMAKE += "FREERTOS_MEMMANG_OBJS=heap_1.o"

