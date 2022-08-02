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
    file://IRQHandler.patch \
    file://FreeRTOSConfig.h \
    file://helper.c \
"
SRCREV_vistron_vdr_400 ?= "d4653ffcb3252c0a3a975e86a43b5c49d61b48db"

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
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_pwr.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_tim.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_tim_ex.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_dma.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_rtc.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_rtc_ex.o"

EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS=startup_stm32f103vetx.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=system_stm32f1xx.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=stm32f1xx_hal_msp.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=stm32f1xx_it.o"

CFLAGS_append = " -I$(VISTRON_VDR_400)/Core/Inc"
CFLAGS_append = " -I$(VISTRON_VDR_400)/."
CFLAGS_append = " -I."

LDFLAGS_append = " -T ${VISTRON_VDR_400}/STM32F103VETX_FLASH.ld"
