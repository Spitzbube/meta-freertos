
OBJS += freertos_test.o helper.o
OBJS += $(FREERTOS_OBJS) $(FREERTOS_PORT_OBJS) $(FREERTOS_MEMMANG_OBJS)
OBJS += $(STM32F1xx_HAL_OBJS)
OBJS += $(VISTRON_VDR_400_OBJS)

all: image.bin

image.bin: image.elf
	$(OBJCOPY) -O binary $(word 1,$^) $@

image.elf: $(OBJS)
	$(LD) -nostartfiles $(LDFLAGS) $(OBJS) -lc -o $@
	$(OBJDUMP) -hds $@ > $@.dump 

startup_stm32f103vetx.o: $(VISTRON_VDR_400)/Core/Startup/startup_stm32f103vetx.s
	$(AS) $< -o $@

system_stm32f1xx.o: $(VISTRON_VDR_400)/Core/Src/system_stm32f1xx.c
	$(CC) $< $(CFLAGS) -c -o $@

stm32f1xx_hal_msp.o: $(VISTRON_VDR_400)/Core/Src/stm32f1xx_hal_msp.c
	$(CC) $< $(CFLAGS) -c -o $@

stm32f1xx_it.o: $(VISTRON_VDR_400)/Core/Src/stm32f1xx_it.c
	$(CC) $< $(CFLAGS) -D FREE_RTOS -c -o $@

main.o: $(VISTRON_VDR_400)/Core/Src/main.c
	$(CC) $< $(CFLAGS) -D FREE_RTOS -c -o $@

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
	
clean:
	rm -f *.o image.bin image.elf
