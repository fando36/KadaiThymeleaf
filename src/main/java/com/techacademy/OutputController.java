package com.techacademy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class OutputController {

    @PostMapping("/output")
    public String postOutput(@RequestParam(name = "value", required = false) String value,
                              @RequestParam(name = "previous", required = false) String previous,
                              Model model) {
        model.addAttribute("currentValue", value);
        model.addAttribute("previousValue", previous);
        model.addAttribute("returnLink", "/input?previous=" + (value != null ? value : ""));
        String resultMessage = String.format("入力された値は「%s」です。", value != null ? value : "未入力");
        model.addAttribute("formattedMessage", resultMessage);
        return "output"; // output.htmlを表示
    }
}