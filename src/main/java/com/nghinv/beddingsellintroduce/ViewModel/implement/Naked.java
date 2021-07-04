package com.nghinv.beddingsellintroduce.viewModel.implement;

import com.nghinv.beddingsellintroduce.viewModel.interfaces.Outfit;
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
