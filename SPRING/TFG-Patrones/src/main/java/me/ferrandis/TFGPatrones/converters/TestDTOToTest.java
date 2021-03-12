package me.ferrandis.TFGPatrones.converters;

import me.ferrandis.TFGPatrones.DTO.DTOTest;
import me.ferrandis.TFGPatrones.Encapsulaciones.InfoTest;
import me.ferrandis.TFGPatrones.modelo.Test;
import org.springframework.core.convert.converter.Converter;

public class TestDTOToTest implements Converter<Test, DTOTest> {

    @Override
    public DTOTest convert(Test test) {
        DTOTest info;

        return null;
    }
}
