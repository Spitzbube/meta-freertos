SUMMARY = "FreeRTOS application example based on https://github.com/jkovacic/"

# This app is the same as the one from the above repo,
# the only change is that this example is built locally
# instead of cloning from git

inherit freertos-stm32f103vet6

S="${WORKDIR}"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8f5b865d5179a4a0d9037aebbd00fc2e" 

SRC_URI_append = " \
    git://github.com/Spitzbube/vistron_vdr_400;name=vistron_vdr_400;destsuffix=vistron_vdr_400;branch=usb \
    file://LICENSE.txt \
    file://Makefile \
    file://SystemCoreClock.patch \
    file://main.c.patch \
    file://IRQHandler.patch \
    file://freertos_test.c \
    file://FreeRTOSConfig.h \
    file://helper.c \
"
#SRCREV_vistron_vdr_400 ?= "dc9268afaa0a32e56fa5ab89cbf9bba0c48e3d82"
SRCREV_vistron_vdr_400 ?= "dcafbed86a035607c49596ef976e0b6ef50f6464"

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
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_i2c.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_spi.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_uart.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_sram.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_ll_fsmc.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_ll_usb.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_pcd.o"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_OBJS+=stm32f1xx_hal_pcd_ex.o"

EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS=startup_stm32f103vetx.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=system_stm32f1xx.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=stm32f1xx_hal_msp.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=stm32f1xx_it.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=syscalls.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=sysmem.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=main.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=data.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=font1.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=ili9341.o"

EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=usb_device.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=usbd_cdc_if.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=usbd_desc.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=usbd_conf.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=usbd_core.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=usbd_ctlreq.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=usbd_ioreq.o"
EXTRA_OEMAKE_append = " VISTRON_VDR_400_OBJS+=usbd_cdc.o"

CFLAGS_append = " -I$(VISTRON_VDR_400)/Core/Inc"
CFLAGS_append = " -I$(VISTRON_VDR_400)/Middlewares/ST/STM32_USB_Device_Library/Core/Inc"
CFLAGS_append = " -I$(VISTRON_VDR_400)/Middlewares/ST/STM32_USB_Device_Library/Class/CDC/Inc"
CFLAGS_append = " -I$(VISTRON_VDR_400)/USB_DEVICE/App"
CFLAGS_append = " -I$(VISTRON_VDR_400)/USB_DEVICE/Target"
CFLAGS_append = " -I$(VISTRON_VDR_400)/."
CFLAGS_append = " -I."

LDFLAGS_append = " -T ${VISTRON_VDR_400}/STM32F103VETX_FLASH.ld"
