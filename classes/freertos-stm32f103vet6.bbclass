# FreeRTOS STM32F103VET6 bsp class
#
# This class contains code that could potentially change depending
# on the specific PORT for which FreeRTOS is being built for, but
# it still inherits the freertos-image class which contains the
# "image" wiring for oe-core to work properly.
# If other PORTs were to be used, a class similar to this one
# should potentially be used.

inherit freertos-image

SRC_URI_append = " \
    git://github.com/STMicroelectronics/STM32CubeF1;name=stm32cubef1;destsuffix=stm32cubef1;branch=master \
"
SRCREV_stm32cubef1 ?= "c750eab6990cac35ab05020793b0221ecc1a8ce5"

STM32CUBEF1 = "${WORKDIR}/stm32cubef1"

EXTRA_OEMAKE_append = " FREERTOS_PORT_SRC=${FREERTOS_KERNEL_SRC}portable/GCC/ARM_CM3/ 'LDFLAGS=${LDFLAGS}'"
EXTRA_OEMAKE_append = " STM32CUBEF1=${STM32CUBEF1}/"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_SRC=${STM32CUBEF1}/Drivers/STM32F1xx_HAL_Driver/Src/"

CFLAGS_append = " -I$(STM32CUBEF1)/Drivers/CMSIS/Device/ST/STM32F1xx/Include"
CFLAGS_append = " -I$(STM32CUBEF1)/Drivers/CMSIS/Include"
CFLAGS_append = " -I$(STM32CUBEF1)/Drivers/STM32F1xx_HAL_Driver/Inc"
CFLAGS_append = " -I${FREERTOS_PORT_SRC}"
CFLAGS_append = " -DSTM32F103xE"

LDFLAGS_remove = "-Wl,-O1 -Wl,--hash-style=gnu -Wl,--as-needed"
LDFLAGS_append = " -L ${STAGING_LIBDIR} -L ${STAGING_LIBDIR}/arm-oe-eabi/9.3.0/"

