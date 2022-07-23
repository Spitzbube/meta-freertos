FREERTOS_VERSION = "FreeRTOSv10.4.3"
SRCBRANCH = "202012-LTS"

LICENSE = "MIT"

# FreeRTOS License, careful here, the gitsm fetcher does not work properly with license checking
# double check this manually after an upgrade
LIC_FILES_CHKSUM = "file://freertos/LICENSE.md;md5=7ae2be7fb1637141840314b51970a9f7"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = " \
    gitsm://github.com/FreeRTOS/FreeRTOS-LTS.git;name=freertos;destsuffix=freertos;branch=${SRCBRANCH} \
"

SRCREV_FORMAT ?= "freertos_bsp"
SRCREV_freertos ?= "1bb18c8dfbf8f0445e873b20cec7d6091771f9e9"

PV = "${FREERTOS_VERSION}+git${SRCPV}"

FREERTOS_KERNEL_SRC = "${WORKDIR}/freertos/FreeRTOS/FreeRTOS-Kernel/"

#inherit rootfs-postcommands
IMGDEPLOYDIR ?= "${WORKDIR}/deploy-${PN}-image-complete"
DEPLOYDIR = "${IMGDEPLOYDIR}"
do_rootfs[dirs] = "${DEPLOYDIR} ${DEPLOY_DIR_IMAGE}"
IMAGE_LINK_NAME ?= "freertos-image-${MACHINE}"
IMAGE_NAME_SUFFIX ?= ""

S="${WORKDIR}"

SRC_URI += " \
    file://Makefile \
    file://FreeRTOSConfig.h  \
    file://lpc214x.h \
    file://sysdefs.h \
"

# QEMU crashes when FreeRTOS is built with optimizations, disable those for now
CFLAGS_remove = "-O2"

# Extra CFLAGS required for FreeRTOS include files
CFLAGS_append = " -I${FREERTOS_KERNEL_SRC} -I${FREERTOS_KERNEL_SRC}/include/"

# We need to define the FreeRTOS source code location, the port we'll be using
# should be defined on the specific bsp class
EXTRA_OEMAKE = " FREERTOS_SRC=${FREERTOS_KERNEL_SRC} 'CFLAGS=${CFLAGS}'"

EXTRA_OEMAKE_append = " PORT=ARM7_LPC2000"

EXTRA_OEMAKE += "FREERTOS_OBJS=list.o"
EXTRA_OEMAKE += "FREERTOS_OBJS+=tasks.o"
EXTRA_OEMAKE += "FREERTOS_OBJS+=queue.o"
EXTRA_OEMAKE += "FREERTOS_OBJS+=timers.o"
EXTRA_OEMAKE += "FREERTOS_PORT_OBJS=port.o"
EXTRA_OEMAKE += "FREERTOS_PORT_OBJS+=portISR.o"
EXTRA_OEMAKE += "FREERTOS_MEMMANG_OBJS=heap_1.o"
 
do_compile(){
  oe_runmake ${EXTRA_OEMAKE}
}

do_install(){
  install -d ${D}${includedir}/freertos
  install -m 0644 ${FREERTOS_KERNEL_SRC}/include/FreeRTOS.h ${D}${includedir}/freertos
  install -m 0644 ${S}/FreeRTOSConfig.h ${D}${includedir}/freertos
  install -m 0644 ${S}/lpc214x.h ${D}${includedir}/freertos
  install -d ${D}${libdir}
  install -m 0644 libfreertos.a ${D}${libdir}
}

FILES_${PN} += "${libdir}/*"
FILES_${PN}-dev = "${libdir}/* ${includedir}"
FILES_${PN}-staticdev = "${libdir}/* ${includedir}"

#  install -m 0644 ${FREERTOS_KERNEL_SRC}/include/projdefs.h ${D}${includedir}/freertos
#  install -m 0644 ${S}/sysdefs.h ${D}${includedir}/freertos
