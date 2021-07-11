package com.nghinv.beddingsellintroduce.viewmodel.implement;

import com.nghinv.beddingsellintroduce.viewmodel.interfaces.Outfit;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("naked")
@Primary
public class Naked implements Outfit {
    @Override
    public void wear() {
        System.out.println("Đang không mặc gì");
    }
}
