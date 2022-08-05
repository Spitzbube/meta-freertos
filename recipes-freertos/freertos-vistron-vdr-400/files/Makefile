
OBJS = freertos_test.o helper.o
OBJS += $(VISTRON_VDR_400_OBJS)

LIBS = $(STM32CUBEF1_LIB) $(FREERTOS_LIB)

all: image.bin

image.bin: image.elf
	$(OBJCOPY) -O binary $(word 1,$^) $@

image.elf: $(OBJS) $(LIBS)
	$(LD) -nostartfiles $(LDFLAGS) $^ -lc -lgcc -o $@
	$(OBJDUMP) -hds $@ > $@.dump 

$(STM32CUBEF1_LIB): $(STM32CUBEF1)
	$(MAKE) -C $< -f Makefile.stm32cubef1 $(MAKECMDGOALS)

$(FREERTOS_LIB): $(FREERTOS_SRC)
	$(MAKE) -C $< -f Makefile.freertos $(MAKECMDGOALS)

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

freertos_test.o: freertos_test.c
	$(CC) $< $(CFLAGS) -c -o $@

helper.o: helper.c
	$(CC) $< $(CFLAGS) -c -o $@

clean:
	rm -f *.a *.o image.bin image.elf

	