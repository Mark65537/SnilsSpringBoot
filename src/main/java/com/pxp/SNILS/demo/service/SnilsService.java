package com.pxp.SNILS.demo.service;

import org.apache.commons.lang3.StringUtils;
import com.pxp.SNILS.demo.entity.Snils;
import com.pxp.SNILS.demo.repository.SnilsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SnilsService {

    @Autowired
    private SnilsRepository snilsRepository;

    @Transactional
    public String createSnils(Snils snils) {
        try {
            String Number = snils.getNumber().trim();
            if (snilsRepository.findByNumber(Number).isEmpty()) {
                if (Number.length() != 11 || !StringUtils.isNumeric(Number))
                {
                    return "СНИЛС введен не корректно.";
                }
                if (testSnils(snils.getNumber())){
                    snilsRepository.save(snils);
                    return "redirect:/index";
                }
                return "СНИЛС не может быть создан так как контрольная сумма не валидна!";
            } else {
                return "СНИЛС уже есть в базе.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Snils> readSnils() {
        return snilsRepository.findAll();
    }

    @Transactional
    public String updateSnils(Snils snils) {
        return null;
    }

    @Transactional
    public String deleteSnils(Snils snils) {
        return null;
    }

    private boolean testSnils(String number)
    {
        //проверка на длину строк
        if (number.length() == 11)
        {

            String checknum = number.substring(9);
            byte k = 9;
            int sum = 0;
            for (byte i=0;i<9;i++)
            {
                sum += k * (number.charAt(i)-'0');
                k--;
            }

            if (sum<100)
            {
                if ( checknum.equals(String.format("%02d", String.valueOf(sum))) )
                    return true;
                else
                    return false;
            }
            else if (sum==100 || sum==101)
            {
                if (checknum.equals("00"))
                    return true;
                else
                    return false;
            }
            else
            {
                int ost=sum % 101;
                if ( checknum.equals(String.format("%02d", String.valueOf(ost))) )
                    return true ;
                else if (ost == 100 && checknum.equals("00"))
                    return true;
                else
                    return false;

            }
        }
        return false;
    }
}
