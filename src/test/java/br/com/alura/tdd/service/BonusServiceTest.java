package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionariosComSalarioAlto() {
        BonusService service = new BonusService();
//        assertThrows(IllegalArgumentException.class,
//        () -> service.calcularBonus(new Funcionario("Wagner", LocalDate.now(), new BigDecimal("18000"))));
        try {
            service.calcularBonus(new Funcionario("Wagner", LocalDate.now(), new BigDecimal("18000")));
            fail("Falhou!");
        } catch (IllegalArgumentException ex) {
            assertEquals("Funcionário com salário superior à R$10.000,00 não pode receber bonus!", ex.getMessage());
        }
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Wagner", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Wagner", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}