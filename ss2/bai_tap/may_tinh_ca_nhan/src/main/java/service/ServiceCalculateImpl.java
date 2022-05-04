package service;

import org.springframework.stereotype.Service;

@Service
public class ServiceCalculateImpl implements ServiceCalculate {

    @Override
    public String calculate(Double first, Double second, String calculate) {

        String result = "";
        switch (calculate) {
            case "Addition(+)":
                result = String.valueOf((first + second));
                break;
            case "Subtraction(-)":
                result = String.valueOf((first - second));
                break;
            case "Multiplication(x)":
                calculate = "Multiplication";
                result = String.valueOf((first * second));
                break;
            case "Division(/)":
                if (second == 0) {
                    result = "Không dc là số 0";
                    break;
                } else {
                    result = String.valueOf((first / second));
                    break;
                }
        }
        return result;
    }
}