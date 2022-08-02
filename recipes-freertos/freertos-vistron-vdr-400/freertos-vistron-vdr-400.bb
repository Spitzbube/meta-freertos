SUMMARY = "FreeRTOS application example based on https://github.com/jkovacic/"

# This app is the same as the one from the above repo,
# the only change is that this example is built locally
# instead of cloning from git

inherit freertos-stm32f103vet6

S="${WORKDIR}"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8f5b865d5179a4a0d9037aebbd00fc2e"

SRC_URI_append = " \
    git://github.com/Spitzbube/vistron_vdr_400;name=vistron_vdr_400;destsuffix=vistron_vdr_400;branch=master \
    file://LICENSE.txt \
    file://Makefile \
    file://main.c.patch \
    file://SystemCoreClock.patch \
    file://FreeRTOSConfig.h \
    file://helper.c \
"
SRCREV_vistron_vdr_400 ?= "0fda837c002f04f04958228321bcb02801af5fcc"

VISTRON_VDR_400 = "${WORKDIR}/vistron_vdr_400"

EXTRA_OEMAKE_append = " VISTRON_VDR_400=${VISTRON_VDR_400}/"

EXTRA_OEMAKE_append = " FREERTOS_OBJS=list.o"
EXTRA_OEMAKE_append = " FREERTOS_OBJS+=tasks.o"
EXTRA_OEMAKE_append = " FREERTOS_PORT_OBJS=port.o"
EXTRA_OEMAKE_append = " FREERTOS_MEMMANG_OBJS=heap_4.o"

EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS=stm32f1xx_hal.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_cortex.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_rcc.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_rcc_ex.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_gpio.o"

CFLAGS_append = " -I$(VISTRON_VDR_400)/Core/Inc"
CFLAGS_append = " -I$(VISTRON_VDR_400)/."
CFLAGS_append = " -I."

LDFLAGS_append = " -T ${VISTRON_VDR_400}/STM32F103VETX_FLASH.ld"
