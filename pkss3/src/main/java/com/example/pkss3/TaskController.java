package com.example.pkss3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class TaskController {
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/task11", method = RequestMethod.POST
            , consumes = "application/json"
            , produces = "application/json")
    public ResponseEntity<?> task11(@RequestBody String A){
        int parameter = Integer.parseInt(A);
        String y = "";
        for(double x = 2; x<8; x+=0.75){
            y = y + "For x = " + x + " y = " + (4 * x - 3 * x + Math.cos(x)) / parameter + "\n";
        }
        return new ResponseEntity<String>(y, HttpStatus.OK);
    }

    @RequestMapping(value = "/task14", method = RequestMethod.GET)
    public ResponseEntity<?> task14(){
        String z = "";
        for(double x = -3; x<=11; x+=0.9){
            z = z + "For x = " + x + " z = " + (Math.cos(x) - 5 * Math.sin(x-2)) + "\n";
        }
        return new ResponseEntity<String>(z, HttpStatus.OK);
    }

    @RequestMapping(value = "/task17", method = RequestMethod.POST)
    public ResponseEntity<?> task17(@RequestBody String digits){
        String[] nums = digits.split(" ");
        int n = Integer.parseInt(nums[0]);
        String res = "";
        for(int i=1;i<n+1;i++){
            if(Integer.parseInt(nums[i]) == 0 || Integer.parseInt(nums[i])%2==0){
                return new ResponseEntity<String>("Введен 0 или кратное 2 число. Введенные до этого числа: " + res + ", ", HttpStatus.OK);
            } else res += nums[i];
        }
        return new ResponseEntity<String>("Ввод не был остановлен. Введенные  числа: " + res + ", ", HttpStatus.OK);
    }

    @RequestMapping(value = "/task20", method = RequestMethod.POST)
    public ResponseEntity<?> task20(@RequestBody String digits){
        String[] nums = digits.split(" ");
        int n = Integer.parseInt(nums[0]);
        String res = "";
        for(int i=1;i<n+1;i++){
            int current = Integer.parseInt(nums[i]);
            if(current > 0 && current + 12 / current > 0){
                res = res + "For x = " + current + " y = " + Math.log(current + 12 / current) +  ", " + "\n";
            }else return new ResponseEntity<String>("Введено число, не входящее в область определения функции, вычисления прекращены. Предыдущие значения: " + res + ", ", HttpStatus.OK);


        }
        return new ResponseEntity<String>(res + ", ", HttpStatus.OK);
    }

    @RequestMapping(value = "/task23", method = RequestMethod.GET)
    public ResponseEntity<?> task23(){
        String res = "";
        for(double x = -4; x<=6; x+=0.91){
            double z = Math.sin(x) + Math.cos(x);
            if(z >-0.3 && z < 0.7) res = res + "For x = " + x + " z = " + z + "\n";
        }
        return new ResponseEntity<String>(res, HttpStatus.OK);
    }
}
