SUMMARY = "FreeRTOS application example based on https://github.com/jkovacic/"

#DEPENDS = "freertos-lib"

# This app is the same as the one from the above repo,
# the only change is that this example is built locally
# instead of cloning from git

LDFLAGS = ""

inherit freertos-lpc2148

S="${WORKDIR}"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8f5b865d5179a4a0d9037aebbd00fc2e"

SRC_URI += " \
    file://LICENSE.txt \
    file://Makefile \
    file://main.c \
    file://freertos-config.patch  \
    file://cpu-setup-hardware.patch  \
"

EXTRA_OEMAKE += "'STAGING_INCDIR=${STAGING_INCDIR}'"
EXTRA_OEMAKE += "'STAGING_LIBDIR=${STAGING_LIBDIR}'"
EXTRA_OEMAKE += "FREERTOS_OBJS=list.o"
EXTRA_OEMAKE += "FREERTOS_OBJS+=tasks.o"
EXTRA_OEMAKE += "FREERTOS_OBJS+=queue.o"
EXTRA_OEMAKE += "FREERTOS_OBJS+=timers.o"
EXTRA_OEMAKE += "FREERTOS_PORT_OBJS=port.o"
EXTRA_OEMAKE += "FREERTOS_PORT_OBJS+=portISR.o"
EXTRA_OEMAKE += "FREERTOS_MEMMANG_OBJS=heap_1.o"

