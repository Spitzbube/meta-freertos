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
    git://github.com/Spitzbube/vistron_vdr_400;name=vistron_vdr_400;destsuffix=vistron_vdr_400;branch=freertos \
"

#Use HAL for GPIO functions 
SRCREV_vistron_vdr_400 ?= "2c7c13ad1d4826b92823b72689ce191004c8839e"

VISTRON_VDR_400 = "${WORKDIR}/vistron_vdr_400"

CFLAGS_append = " -I$(VISTRON_VDR_400)/Drivers/CMSIS/Device/ST/STM32F1xx/Include"
CFLAGS_append = " -I$(VISTRON_VDR_400)/Drivers/CMSIS/Include"
CFLAGS_append = " -I$(VISTRON_VDR_400)/Drivers/STM32F1xx_HAL_Driver/Inc"
CFLAGS_append = " -I$(VISTRON_VDR_400)/Core/Inc"
CFLAGS_append = " -I$(VISTRON_VDR_400)/."
CFLAGS_append = " -I${FREERTOS_PORT_SRC}"
CFLAGS_append = " -DSTM32F103xE"

LDFLAGS_remove = "-Wl,-O1 -Wl,--hash-style=gnu -Wl,--as-needed"
LDFLAGS_append = " -T ${VISTRON_VDR_400}/STM32F103VETX_FLASH.ld"
LDFLAGS_append = " -L ${STAGING_LIBDIR} -L ${STAGING_LIBDIR}/arm-oe-eabi/9.3.0/"

EXTRA_OEMAKE_append = " FREERTOS_PORT_SRC=${FREERTOS_KERNEL_SRC}portable/GCC/ARM_CM3/ 'LDFLAGS=${LDFLAGS}'"
EXTRA_OEMAKE_append = " VISTRON_VDR_400=${VISTRON_VDR_400}/"
EXTRA_OEMAKE_append = " STM32F1xx_HAL_SRC=${VISTRON_VDR_400}/Drivers/STM32F1xx_HAL_Driver/Src/"

