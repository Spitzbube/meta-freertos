
PORT_COMP_TARG = GCC/$(PORT)/
FREERTOS_PORT_SRC = $(FREERTOS_SRC)portable/$(PORT_COMP_TARG)
FREERTOS_MEMMANG_SRC = $(FREERTOS_SRC)portable/MemMang/

OBJS = boot.o swidispatch.o swi.o fiqISR.o cpu.o
OBJS += $(FREERTOS_OBJS) $(FREERTOS_PORT_OBJS) $(FREERTOS_MEMMANG_OBJS)
OBJS += main.o

all: image.bin

image.bin: image.elf
	$(OBJCOPY) -O binary $(word 1,$^) $@

image.elf: $(OBJS) lpc2148-rom.ld
	$(LD) -nostartfiles -nostdlib  -T lpc2148-rom.ld $(OBJS) -L ${STAGING_LIBDIR} -lc -o $@
	$(OBJDUMP) -hds $@ > $@.dump 

boot.o: $(LPC2148_DEMO)boot.s
	$(AS) $< -o $@

swidispatch.o: $(LPC2148_DEMO)swi/swidispatch.s
	$(AS) $< -o $@

swi.o: $(LPC2148_DEMO)swi/swi.c
	$(CC) $(CFLAGS) -marm -DTHUMB_INTERWORK -I$(FREERTOS_SRC)/../../.. -I$(FREERTOS_PORT_SRC) -c $< -o $@

fiqISR.o: $(LPC2148_DEMO)fiq/fiqISR.c
	$(CC) $(CFLAGS) -marm -DTHUMB_INTERWORK -I$(FREERTOS_SRC)/../../.. -I$(FREERTOS_PORT_SRC) -c $< -o $@

cpu.o: $(LPC2148_DEMO)cpu/cpu.c
	$(CC) $(CFLAGS) -I$(FREERTOS_SRC)/../../.. -I$(FREERTOS_PORT_SRC) -c $< -o $@

list.o: $(FREERTOS_SRC)list.c
	$(CC) $(CFLAGS) -I$(FREERTOS_SRC)/../../.. -I$(FREERTOS_PORT_SRC) -c $< -o $@

tasks.o: $(FREERTOS_SRC)tasks.c
	$(CC) $(CFLAGS) -marm -DTHUMB_INTERWORK -I$(FREERTOS_SRC)/../../.. -I$(FREERTOS_PORT_SRC) -c $< -o $@

queue.o : $(FREERTOS_SRC)queue.c
	$(CC) $(CFLAGS) -I$(FREERTOS_SRC)/../../.. -I$(FREERTOS_PORT_SRC) -c $< -o $@

timers.o : $(FREERTOS_SRC)timers.c
	$(CC) $(CFLAGS) -I$(FREERTOS_SRC)/../../.. -I$(FREERTOS_PORT_SRC) -c $< -o $@

heap_1.o : $(FREERTOS_MEMMANG_SRC)heap_1.c
	$(CC) $(CFLAGS) -I$(FREERTOS_SRC)/../../.. -I$(FREERTOS_PORT_SRC) -c $< -o $@

port.o: $(FREERTOS_PORT_SRC)port.c
	$(CC) $(CFLAGS) -I$(FREERTOS_SRC)/../../.. -I$(FREERTOS_PORT_SRC) -c $< -o $@

portISR.o: $(FREERTOS_PORT_SRC)portISR.c
	$(CC) $(CFLAGS) -marm -DTHUMB_INTERWORK -I$(FREERTOS_SRC)/../../.. -I$(FREERTOS_PORT_SRC) -c $< -o $@

main.o: main.c
	$(CC) $(CFLAGS) -I$(FREERTOS_SRC)/../../.. -I$(FREERTOS_PORT_SRC) -c $< -o $@

clean:
	rm -f *.o 
