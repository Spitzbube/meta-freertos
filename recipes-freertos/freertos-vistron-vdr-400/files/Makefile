
OBJS += freertos_test.o helper.o
OBJS += $(FREERTOS_OBJS) $(FREERTOS_PORT_OBJS) $(FREERTOS_MEMMANG_OBJS)
OBJS += $(STM32F1xx_HAL_OBJS)
OBJS += $(VISTRON_VDR_400_OBJS)

all: image.bin

image.bin: image.elf
	$(OBJCOPY) -O binary $(word 1,$^) $@

image.elf: $(OBJS)
	$(LD) -nostartfiles $(LDFLAGS) $(OBJS) -lc -lgcc -o $@
	$(OBJDUMP) -hds $@ > $@.dump 

startup_stm32f103vetx.o: $(VISTRON_VDR_400)/Core/Startup/startup_stm32f103vetx.s
	$(AS) $< -o $@

system_stm32f1xx.o: $(VISTRON_VDR_400)/Core/Src/system_stm32f1xx.c
	$(CC) $< $(CFLAGS) -c -o $@

stm32f1xx_hal_msp.o: $(VISTRON_VDR_400)/Core/Src/stm32f1xx_hal_msp.c
	$(CC) $< $(CFLAGS) -c -o $@

stm32f1xx_it.o: $(VISTRON_VDR_400)/Core/Src/stm32f1xx_it.c
	$(CC) $< $(CFLAGS) -D FREE_RTOS -c -o $@

syscalls.o: $(VISTRON_VDR_400)/Core/Src/syscalls.c
	$(CC) $< $(CFLAGS) -D FREE_RTOS -c -o $@

sysmem.o: $(VISTRON_VDR_400)/Core/Src/sysmem.c
	$(CC) $< $(CFLAGS) -D FREE_RTOS -c -o $@

main.o: $(VISTRON_VDR_400)/Core/Src/main.c
	$(CC) $< $(CFLAGS) -D FREE_RTOS -c -o $@

data.o: $(VISTRON_VDR_400)/User/data.c
	$(CC) $< $(CFLAGS) -D FREE_RTOS -c -o $@

ili9341.o: $(VISTRON_VDR_400)/User/ili9341.c
	$(CC) $< $(CFLAGS) -D FREE_RTOS -c -o $@

font1.o: $(VISTRON_VDR_400)/User/font1.c
	$(CC) $< $(CFLAGS) -c -o $@

usb_device.o: $(VISTRON_VDR_400)/USB_DEVICE/App/usb_device.c
	$(CC) $< $(CFLAGS) -c -o $@

usbd_cdc_if.o: $(VISTRON_VDR_400)/USB_DEVICE/App/usbd_cdc_if.c
	$(CC) $< $(CFLAGS) -c -o $@

usbd_desc.o: $(VISTRON_VDR_400)/USB_DEVICE/App/usbd_desc.c
	$(CC) $< $(CFLAGS) -c -o $@

usbd_conf.o: $(VISTRON_VDR_400)/USB_DEVICE/Target/usbd_conf.c
	$(CC) $< $(CFLAGS) -c -o $@

usbd_core.o: $(VISTRON_VDR_400)/Middlewares/ST/STM32_USB_Device_Library/Core/Src/usbd_core.c
	$(CC) $< $(CFLAGS) -c -o $@

usbd_ctlreq.o: $(VISTRON_VDR_400)/Middlewares/ST/STM32_USB_Device_Library/Core/Src/usbd_ctlreq.c
	$(CC) $< $(CFLAGS) -c -o $@

usbd_ioreq.o: $(VISTRON_VDR_400)/Middlewares/ST/STM32_USB_Device_Library/Core/Src/usbd_ioreq.c
	$(CC) $< $(CFLAGS) -c -o $@

usbd_cdc.o: $(VISTRON_VDR_400)/Middlewares/ST/STM32_USB_Device_Library/Class/CDC/Src/usbd_cdc.c
	$(CC) $< $(CFLAGS) -c -o $@

freertos_test.o: freertos_test.c
	$(CC) $< $(CFLAGS) -c -o $@

helper.o: helper.c
	$(CC) $< $(CFLAGS) -c -o $@

list.o: $(FREERTOS_SRC)list.c
	$(CC) $< $(CFLAGS) -c -o $@

tasks.o: $(FREERTOS_SRC)tasks.c
	$(CC) $< $(CFLAGS) -c -o $@

port.o: $(FREERTOS_PORT_SRC)port.c
	$(CC) $< $(CFLAGS) -c -o $@

heap_4.o: $(FREERTOS_MEMMANG_SRC)heap_4.c
	$(CC) $< $(CFLAGS) -c -o $@
	
stm32f1xx_hal.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal.c
	$(CC) $< $(CFLAGS) -c -o $@

stm32f1xx_hal_cortex.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_cortex.c
	$(CC) $< $(CFLAGS) -c -o $@

stm32f1xx_hal_rcc.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_rcc.c
	$(CC) $< $(CFLAGS) -c -o $@

stm32f1xx_hal_rcc_ex.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_rcc_ex.c
	$(CC) $< $(CFLAGS) -c -o $@

stm32f1xx_hal_gpio.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_gpio.c
	$(CC) $< $(CFLAGS) -c -o $@

stm32f1xx_hal_pwr.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_pwr.c
	$(CC) $< $(CFLAGS) -c -o $@
	
stm32f1xx_hal_tim.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_tim.c
	$(CC) $< $(CFLAGS) -c -o $@
	
stm32f1xx_hal_tim_ex.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_tim_ex.c
	$(CC) $< $(CFLAGS) -c -o $@
	
stm32f1xx_hal_dma.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_dma.c
	$(CC) $< $(CFLAGS) -c -o $@
	
stm32f1xx_hal_rtc.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_rtc.c
	$(CC) $< $(CFLAGS) -c -o $@
	
stm32f1xx_hal_rtc_ex.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_rtc_ex.c
	$(CC) $< $(CFLAGS) -c -o $@
	
stm32f1xx_hal_i2c.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_i2c.c
	$(CC) $< $(CFLAGS) -c -o $@
	
stm32f1xx_hal_spi.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_spi.c
	$(CC) $< $(CFLAGS) -c -o $@
	
stm32f1xx_hal_uart.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_uart.c
	$(CC) $< $(CFLAGS) -c -o $@
	
stm32f1xx_hal_sram.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_sram.c
	$(CC) $< $(CFLAGS) -c -o $@
	
stm32f1xx_ll_fsmc.o: $(STM32F1xx_HAL_SRC)stm32f1xx_ll_fsmc.c
	$(CC) $< $(CFLAGS) -c -o $@
	
stm32f1xx_ll_usb.o: $(STM32F1xx_HAL_SRC)stm32f1xx_ll_usb.c
	$(CC) $< $(CFLAGS) -c -o $@
		
stm32f1xx_hal_pcd.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_pcd.c
	$(CC) $< $(CFLAGS) -c -o $@
		
stm32f1xx_hal_pcd_ex.o: $(STM32F1xx_HAL_SRC)stm32f1xx_hal_pcd_ex.c
	$(CC) $< $(CFLAGS) -c -o $@
		
clean:
	rm -f *.o image.bin image.elf
