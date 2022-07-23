
#include "FreeRTOS.h"
#include "task.h"
#include "lpc214x.h"

void cpuSetupHardware (void);


void syscallsInit (void)
{
}


void vLED1Task( void *pvParameters )
{
	int off = 1;

	GPIO0_FIOSET = GPIO_IO_P13;

	for( ;; )
	{
		vTaskDelay(( TickType_t ) 1000 / portTICK_PERIOD_MS );

		if (off)
		{
			GPIO0_FIOCLR = GPIO_IO_P13;
			off = 0;
		}
		else
		{
			GPIO0_FIOSET = GPIO_IO_P13;
			off = 1;
		}
	}
}

void vLED2Task( void *pvParameters )
{
	int off = 1;

	GPIO0_FIOCLR = GPIO_IO_P16;

	for( ;; )
	{
		vTaskDelay(( TickType_t ) 500 / portTICK_PERIOD_MS );

		if (off)
		{
			GPIO0_FIOSET = GPIO_IO_P16;
			off = 0;
		}
		else
		{
			GPIO0_FIOCLR = GPIO_IO_P16;
			off = 1;
		}
	}
}


int main()
{
	cpuSetupHardware();

	//Power for Timer0 (ticks for FreeRTOS)
	SCB_PCONP |= SCB_PCONP_PCTIM0;

	GPIO0_FIODIR |= (GPIO_IO_P13 | GPIO_IO_P16);
	GPIO0_FIOSET = GPIO_IO_P13; //Low-active
	GPIO0_FIOCLR = GPIO_IO_P16; //High-active

	xTaskCreate( vLED1Task, "LED1Task", /*configMINIMAL_STACK_SIZE*/100, NULL, tskIDLE_PRIORITY+1, NULL );
	xTaskCreate( vLED2Task, "LED2Task", /*configMINIMAL_STACK_SIZE*/100, NULL, tskIDLE_PRIORITY+1, NULL );

	vTaskStartScheduler();

	while (1);

	return 0;
}

