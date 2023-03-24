package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")

public class CalculatorController {

    private CalculatorService calculatorService;
    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String answerPlus(@RequestParam String num1, @RequestParam String num2){
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()){
            return "Введите два параметра";
        }
        return num1 + " + " + num2 + " = " + calculatorService.plus(Integer.parseInt(num1), Integer.parseInt(num2));
    }
    @GetMapping("/minus")
    public String answerMinus(@RequestParam String num1, String num2){
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()){
            return "Введите два параметра";
        }
        return num1 + " - " + num2 + " = " + calculatorService.minus(Integer.parseInt(num1), Integer.parseInt(num2));
    }
    @GetMapping("/multiply")
    public String answerMultiply(@RequestParam String num1, String num2){
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()){
            return "Введите два параметра";
        }
        return num1 + " * " + num2 + " = " + calculatorService.multiply(Integer.parseInt(num1), Integer.parseInt(num2));
    }
    @GetMapping("/divide")
    public String answerDivide(@RequestParam String num1, String num2){

        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()){
        return "Введите два параметра";
        }

        if (Integer.parseInt(num2) == 0) {
          return "На ноль делить нельзя! Введите второй параметр отличный от нуля";
        }
        return num1 + " / " + num2 + " = " + calculatorService.divide(Integer.parseInt(num1), Integer.parseInt(num2));
    }
}
