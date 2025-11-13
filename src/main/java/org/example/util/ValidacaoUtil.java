package org.example.util;

import java.util.Calendar;
import java.util.Date;

public class ValidacaoUtil {
    public boolean vaziaOuNula(String entrada){
        return entrada == null || entrada.trim().isEmpty();
    }

    public boolean vaziaOuNula(Double valor){
        return  valor == null ||valor.doubleValue() == 0.0 || valor.isInfinite() || valor.isNaN();
    }

    public boolean vaziaOuNula(Date data){
        if(data == null){
            return true;
        }

        Calendar limiteInferior = Calendar.getInstance();
        limiteInferior.set(2015, Calendar.JANUARY, 1, 0, 0, 0);
        if(data.before(limiteInferior.getTime())){
            return true;
        }

        return false;

    }

}
