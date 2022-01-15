package com.raf.emailservice.mapper;
import com.raf.emailservice.domain.Tip;
import com.raf.emailservice.dto.TipDto;
import org.springframework.stereotype.Component;

@Component
public class TipMapper {

    public TipDto commentToTipDto(Tip tip) {
        TipDto tipDto = new TipDto();
        tipDto.setName(tip.getName());
        tipDto.setText(tip.getText());
        tipDto.setParameters(tip.getParameters());
        return tipDto;
    }

    public Tip tipDtoToTip(TipDto tipDto) {
        Tip tip = new Tip();
        tip.setName(tipDto.getName());
        tip.setText(tipDto.getText());
        tip.setParameters(tipDto.getParameters());
        return tip;
    }

}
