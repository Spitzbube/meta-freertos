
#include "FreeRTOS.h"
#include "task.h"
#include "lpc214x.h"

void cpuSetupHardware (void);


void vLED1Task( void *pvParameters )
{
	int off = 1;

	GPIO0_FIOCLR = GPIO_IO_P10;

	for( ;; )
	{
		vTaskDelay(( TickType_t ) 1000 / portTICK_PERIOD_MS );

		if (off)
		{
			GPIO0_FIOSET = GPIO_IO_P10;
			off = 0;
		}
		else
		{
			GPIO0_FIOCLR = GPIO_IO_P10;
			off = 1;
		}
	}
}

void vLED2Task( void *pvParameters )
{
	int off = 1;

	GPIO0_FIOCLR = GPIO_IO_P11;

	for( ;; )
	{
		vTaskDelay(( TickType_t ) 2000 / portTICK_PERIOD_MS );

		if (off)
		{
			GPIO0_FIOSET = GPIO_IO_P11;
			off = 0;
		}
		else
		{
			GPIO0_FIOCLR = GPIO_IO_P11;
			off = 1;
		}
	}
}


int main()
{
	cpuSetupHardware();

	GPIO0_FIODIR |= (GPIO_IO_P10 | GPIO_IO_P11);
	GPIO0_FIOSET  = (GPIO_IO_P10 | GPIO_IO_P11);

	xTaskCreate( vLED1Task, "LED1Task", /*configMINIMAL_STACK_SIZE*/100, NULL, tskIDLE_PRIORITY+1, NULL );
	xTaskCreate( vLED2Task, "LED2Task", /*configMINIMAL_STACK_SIZE*/100, NULL, tskIDLE_PRIORITY+1, NULL );

	vTaskStartScheduler();

	while (1);

	return 0;
}

