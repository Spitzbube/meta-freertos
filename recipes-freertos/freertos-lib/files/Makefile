
PORT_COMP_TARG = GCC/$(PORT)/
FREERTOS_PORT_SRC = $(FREERTOS_SRC)portable/$(PORT_COMP_TARG)
FREERTOS_MEMMANG_SRC = $(FREERTOS_SRC)portable/MemMang/

$(info CC="$(CC)")
$(info LD="$(LD)")
$(info CFLAGS="$(CFLAGS)")
$(info AFLAGS="$(AFLAGS)")
$(info LDFLAGS="$(LDFLAGS)")
$(info OBJS="$(OBJS)")
$(info FREERTOS_SRC="$(FREERTOS_SRC)")
$(info FREERTOS_PORT_SRC="$(FREERTOS_PORT_SRC)")

OBJS = $(FREERTOS_OBJS) $(FREERTOS_PORT_OBJS) $(FREERTOS_MEMMANG_OBJS)

all: libfreertos.a

libfreertos.a: $(OBJS)
	${AR} rcs libfreertos.a $(OBJS)

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

clean:
	rm -f *.o 
