
OBJS += startup_stm32f103vetx.o system_stm32f1xx.o main.o helper.o
OBJS += $(FREERTOS_OBJS) $(FREERTOS_PORT_OBJS) $(FREERTOS_MEMMANG_OBJS)
OBJS += $(STM32F1xx_HAL_OBJS)

all: image.bin

image.bin: image.elf
	$(OBJCOPY) -O binary $(word 1,$^) $@

image.elf: $(OBJS)
	$(LD) -nostartfiles $(LDFLAGS) $(OBJS) -lc -o $@
	$(OBJDUMP) -hds $@ > $@.dump 

startup_stm32f103vetx.o: $(VISTRON_VDR_400)/Core/Startup/startup_stm32f103vetx.s
	$(AS) $< -o $@

system_stm32f1xx.o: system_stm32f1xx.c
	$(CC) $< $(CFLAGS) -c -o $@

main.o: main.c
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

clean:
	rm -f *.o image.bin image.elf
