
#include <stdint.h>

#define RCC_GPIO_REG_ENABLE ((uint32_t *)0x40023830)
#define RCC_GPIO_REG_RESET ((uint32_t *)0x40023810)

#define RCC_GPIO_A_RESET (1 << 0)
#define RCC_GPIO_B_RESET (1 << 1)
#define RCC_GPIO_C_RESET (1 << 2)
#define RCC_GPIO_D_RESET (1 << 3)
#define RCC_GPIO_E_RESET (1 << 4)
#define RCC_GPIO_F_RESET (1 << 5)

#define RCC_GPIO_A_ENABLE (1 << 0)
#define RCC_GPIO_B_ENABLE (1 << 1)
#define RCC_GPIO_C_ENABLE (1 << 2)
#define RCC_GPIO_D_ENABLE (1 << 3)
#define RCC_GPIO_E_ENABLE (1 << 4)
#define RCC_GPIO_F_ENABLE (1 << 5)

#define GPIO_C_REG_BASE ((uint32_t *)0x40020800)
#define GPIO_C_REG_OUTPUT ((uint32_t *)0x40020814)
#define GPIO_C_REG_BSRR ((uint32_t *)0x40020818)

#define GPIO_C_MODER GPIO_C_REG_BASE

#define GPIO_PIN_12_MODE_GPO (0x1 << 24)
#define GPIO_PIN_12_DATA_BIT (0x1 << 12)
#define GPIO_PIN_12_RESET_BIT (0x1 << 28)


/* Write value to register address */
static inline
void reg_set(volatile uint32_t *reg_ptr, uint32_t val)
{
        *reg_ptr = val;
}

/* Copy register OR bits in and write back */
static inline
void reg_set_bits(volatile uint32_t *reg_ptr, uint32_t val)
{
        uint32_t reg;
        reg = *reg_ptr;
        reg |= val;
        *reg_ptr = reg;
}

/* Copy register OR bits in and write back */
static inline
void reg_unset_bits(volatile uint32_t *reg_ptr, uint32_t val)
{
        uint32_t reg;
        reg = *reg_ptr;
        reg &= ~val;
        *reg_ptr = reg;
}

int gpio_setup(void)
{
        reg_set_bits(RCC_GPIO_REG_ENABLE, RCC_GPIO_C_ENABLE);
        reg_set_bits(GPIO_C_MODER, GPIO_PIN_12_MODE_GPO);

        return 0;
}


int gpio_flash_led(int led_delay)
{
#if 0
        reg_set_bits(GPIO_C_REG_OUTPUT, GPIO_PIN_12_DATA_BIT);
        delay(led_delay);
        reg_set(GPIO_C_REG_OUTPUT, 0);
#else
	reg_set(GPIO_C_REG_BSRR, GPIO_PIN_12_DATA_BIT);
        delay(led_delay);
        reg_set(GPIO_C_REG_BSRR, GPIO_PIN_12_RESET_BIT);
#endif
        delay(led_delay);
        return 0;
}


#define LED_DELAY (6000000)


void delay(int cycles)
{
        while(cycles) {
                cycles--;
        }

}

