
clean:

all: libstm32cubef1.a

libstm32cubef1.a: $(STM32F1xx_HAL_OBJS) $(STM32_USB_DEVICE_LIB_OBJS)
	${AR} rcs ../$@ $^

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
		
usbd_core.o: $(STM32_USB_DEVICE_LIB)/Core/Src/usbd_core.c
	$(CC) $< $(CFLAGS) -c -o $@

usbd_ctlreq.o: $(STM32_USB_DEVICE_LIB)/Core/Src/usbd_ctlreq.c
	$(CC) $< $(CFLAGS) -c -o $@

usbd_ioreq.o: $(STM32_USB_DEVICE_LIB)/Core/Src/usbd_ioreq.c
	$(CC) $< $(CFLAGS) -c -o $@

usbd_cdc.o: $(STM32_USB_DEVICE_LIB)/Class/CDC/Src/usbd_cdc.c
	$(CC) $< $(CFLAGS) -c -o $@

