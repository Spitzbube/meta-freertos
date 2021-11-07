# FreeRTOS LPC2148 bsp class
#
# This class contains code that could potentially change depending
# on the specific PORT for which FreeRTOS is being built for, but
# it still inherits the freertos-image class which contains the
# "image" wiring for oe-core to work properly.
# If other PORTs were to be used, a class similar to this one
# should potentially be used.

inherit freertos-image

SRC_URI_append = " \
    gitsm://github.com/Spitzbube/lpc2148_demo;name=lpc2148-demo;destsuffix=lpc2148_demo;branch=master; \
"

SRCREV_lpc2148-demo ?= "dc74e30d49c5daa334acede349d0a2dc76f19ebf"

LPC2148_DEMO = "${WORKDIR}/lpc2148_demo"

# CFLAGS required for this specific PORT
CFLAGS_append = " -I${LPC2148_DEMO} -DCFG_CONSOLE_UART0"
LDFLAGS_append = " -T ${LPC2148_DEMO}/lpc2148-rom.ld"

# Define the PORT we are using
EXTRA_OEMAKE_append = " PORT=ARM7_LPC2000 'LDFLAGS=${LDFLAGS}'"
EXTRA_OEMAKE_append = " LPC2148_DEMO=${LPC2148_DEMO}/"
