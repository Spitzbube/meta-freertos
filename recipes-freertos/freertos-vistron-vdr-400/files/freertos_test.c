
#include "FreeRTOS.h"
#include "task.h"
#include "main.h"


#define LED_TASK_STACK_SIZE 256
void LED1_Task(void* p)
{
    // PE5 = Output for LED D2
    GPIO_InitTypeDef GPIO_InitStruct = {0};
    GPIO_InitStruct.Pin = GPIO_PIN_5;
    GPIO_InitStruct.Mode = GPIO_MODE_OUTPUT_PP;
    GPIO_InitStruct.Pull = GPIO_NOPULL;
    GPIO_InitStruct.Speed = GPIO_SPEED_FREQ_LOW;
    HAL_GPIO_Init(GPIOE, &GPIO_InitStruct);
	HAL_GPIO_WritePin(GPIOE, GPIO_PIN_5, GPIO_PIN_RESET);

	while (1)
	{
	    vTaskDelay(pdMS_TO_TICKS(250));
		HAL_GPIO_TogglePin(GPIOE, GPIO_PIN_5);
	}
}

void LED2_Task(void* p)
{
    // PE6 = Output for LED D3
    GPIO_InitTypeDef GPIO_InitStruct = {0};
    GPIO_InitStruct.Pin = GPIO_PIN_6;
    GPIO_InitStruct.Mode = GPIO_MODE_OUTPUT_PP;
    GPIO_InitStruct.Pull = GPIO_NOPULL;
    GPIO_InitStruct.Speed = GPIO_SPEED_FREQ_LOW;
    HAL_GPIO_Init(GPIOE, &GPIO_InitStruct);
	HAL_GPIO_WritePin(GPIOE, GPIO_PIN_6, GPIO_PIN_RESET);

	ili9341_init();

   ili9341_fill_screen(0xffff);
   ili9341_draw_hor_line(0, 320, 48, 0);
   ili9341_set_font(&Data_2000004c);
   ili9341_set_text_color(0, 0xffff);
   ili9341_set_cursor(20, 50);
   ili9341_draw_format_string("Hello FreeRTOS");

   //Pull up USB D+ to indicate the USB host our presence on the bus
   HAL_GPIO_WritePin(GPIOA, GPIO_PIN_10, GPIO_PIN_SET);

   int i = 0;
	while (1)
	{
	    vTaskDelay(pdMS_TO_TICKS(500));
		HAL_GPIO_TogglePin(GPIOE, GPIO_PIN_6);
		printf("i=%d\n", i++);
	}
}

void freertos_main(void)
{
  TaskHandle_t led1Task;
  (void) xTaskCreate( LED1_Task, "LED1", LED_TASK_STACK_SIZE,
  		NULL/*pvParameters*/, 1/*uxPriority*/, &led1Task);

  TaskHandle_t led2Task;
  (void) xTaskCreate( LED2_Task, "LED2", LED_TASK_STACK_SIZE,
  		NULL/*pvParameters*/, 1/*uxPriority*/, &led2Task);

  vTaskStartScheduler();  // should never return
}


void button_gpio_check(void)
{
   if (0 == HAL_GPIO_ReadPin(Button_Yellow_GPIO_Port, Button_Yellow_Pin))
   {
	   HAL_GPIO_TogglePin(GPIOE, GPIO_PIN_6);
   }

   if (0 == HAL_GPIO_ReadPin(Button_Red_GPIO_Port, Button_Red_Pin))
   {
   }

   if (0 == HAL_GPIO_ReadPin(Button_Green_GPIO_Port, Button_Green_Pin))
   {
   }

   if (0 == HAL_GPIO_ReadPin(Button_Blue_GPIO_Port, Button_Blue_Pin))
   {
   }
}

