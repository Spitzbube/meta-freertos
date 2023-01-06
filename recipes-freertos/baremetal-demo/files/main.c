
#include "lm3s/lm3s_cmsis.h"


void print_uart0(const char *s)
{
	while(*s != '\0')
	{ /* Loop until end of string */
		UART0->DR = (unsigned int)(*s); /* Transmit char */
		s++; /* Next char */
	}
}


void main(void)
{
	SystemInit();

    print_uart0("Hellow World?\n");

    //
    // Loop forever.
    //

//    while(1)
    {
    }
}
