SUMMARY = "FreeRTOS application example based on https://github.com/jkovacic/"

# This app is the same as the one from the above repo,
# the only change is that this example is built locally
# instead of cloning from git

inherit freertos-stm32f103vet6

S="${WORKDIR}"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8f5b865d5179a4a0d9037aebbd00fc2e"

SRC_URI += " \
    file://LICENSE.txt \
    file://Makefile \
    file://helper.c \
"

EXTRA_OEMAKE += "FREERTOS_OBJS=list.o"
EXTRA_OEMAKE += "FREERTOS_OBJS+=tasks.o"
EXTRA_OEMAKE += "FREERTOS_PORT_OBJS=port.o"
EXTRA_OEMAKE += "FREERTOS_MEMMANG_OBJS=heap_4.o"

EXTRA_OEMAKE += "STM32F1xx_HAL_OBJS=stm32f1xx_hal.o"
EXTRA_OEMAKE += "STM32F1xx_HAL_OBJS+=stm32f1xx_hal_cortex.o"
EXTRA_OEMAKE += "STM32F1xx_HAL_OBJS+=stm32f1xx_hal_rcc.o"
EXTRA_OEMAKE += "STM32F1xx_HAL_OBJS+=stm32f1xx_hal_rcc_ex.o"
EXTRA_OEMAKE += "STM32F1xx_HAL_OBJS+=stm32f1xx_hal_gpio.o"
