import org.joda.time.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class exercicio_1_junit_09_09_2020 {

    //Feature 1: Criação de data
    @Test
    public void criarData24_12_2020(){
        // Fixture Setup

        //Exercise SUT
        LocalDate data = new LocalDate(2020,12,24);

        //Result Verification
        assertEquals(24, data.getDayOfMonth());
        assertEquals(12, data.getMonthOfYear());
        assertEquals(2020, data.getYear());
        //Fixture Teardown
    }

    @Test(expected = IllegalFieldValueException.class)
    public void dataComDiaNegativo(){
        // Fixture Setup

        //Exercise SUT
        LocalDate data = new LocalDate(2020,12,-24);

        //Result Verification
    }

    @Test(expected = IllegalFieldValueException.class)
    public void dataComMesNegativo(){
        // Fixture Setup

        //Exercise SUT
        LocalDate data = new LocalDate(2020,-12,24);

        //Result Verification
    }

    @Test
    public void dataComAnoNegativo(){
        // Fixture Setup

        //Exercise SUT
        LocalDate data = new LocalDate(-2020,12,24);

        //Result Verification
        assertEquals(-2020, data.getYear());
    }

    @Test
    public void dataEmAnoBissexto(){
        // Fixture Setup

        //Exercise SUT
        LocalDate data = new LocalDate(2020,2,29);

        //Result Verification
        assertEquals(LocalDate.parse("2020-02-29"), data);

    }

    @Test(expected = IllegalFieldValueException.class)
    public void dataEmNaoAnoBissexto(){
        // Fixture Setup

        //Exercise SUT
        LocalDate data = new LocalDate(2021,2,29);
        //Result Verification
    }
    //Feature 2: Soma de datas
    @Test
    public void adicionarDiaPositivo(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        data = data.plusDays(1);

        //Result Verification
        assertEquals(21, data.getDayOfMonth());
        assertEquals(2, data.getMonthOfYear());
        assertEquals(2021, data.getYear());

        //Fixture Teardown
    }

    @Test
    public void adicionarDiaNegativo(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        data = data.plusDays(-1);

        //Result Verification
        assertEquals(19, data.getDayOfMonth());
        assertEquals(2, data.getMonthOfYear());
        assertEquals(2021, data.getYear());

        //Fixture Teardown
    }
    @Test
    public void adicionarMesPositivo(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        data = data.plusMonths(1);

        //Result Verification
        assertEquals(3, data.getMonthOfYear());
        assertEquals(2021, data.getYear());
        assertEquals(20, data.getDayOfMonth());

        //Fixture Teardown
    }

    @Test
    public void adicionarAnoPositivo(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        data = data.plusYears(1);

        //Result Verification
        assertEquals(2022, data.getYear());
        assertEquals(2, data.getMonthOfYear());
        assertEquals(20, data.getDayOfMonth());

        //Fixture Teardown
    }

    @Test
    public void adicionarSemanaPositiva(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        data = data.plusWeeks(1);

        //Result Verification
        assertEquals(27, data.getDayOfMonth());
        assertEquals(2, data.getMonthOfYear());
        assertEquals(2021, data.getYear());

        //Fixture Teardown
    }

    // Feature 3: Subtração de datas
    @Test
    public void diminuirUmDia(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        LocalDate resultado = data.minusDays(1);

        //Result Verification
        assertEquals(LocalDate.parse("2021-02-19"), resultado);

        //Fixture Teardown
    }

    @Test
    public void diminuirUmMes(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        LocalDate resultado = data.minusMonths(1);

        //Result Verification
        assertEquals(LocalDate.parse("2021-01-20"), resultado);

        //Fixture Teardown
    }
    @Test
    public void diminuirUmaSemana(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        LocalDate resultado = data.minusWeeks(1);

        //Result Verification
        assertEquals(LocalDate.parse("2021-02-13"), resultado);

        //Fixture Teardown
    }

    @Test
    public void diminuirUmAno(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        LocalDate resultado = data.minusYears(1);

        //Result Verification
        assertEquals(LocalDate.parse("2020-02-20"), resultado);

        //Fixture Teardown
    }

    @Test
    public void diminuirUmDiaNegativo(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        LocalDate resultado = data.minusDays(-1);

        //Result Verification
        assertEquals(LocalDate.parse("2021-02-21"), resultado);

        //Fixture Teardown
    }

    @Test
    public void diminuirUmMesNegativo(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        LocalDate resultado = data.minusMonths(-1);

        //Result Verification
        assertEquals(LocalDate.parse("2021-03-20"), resultado);

        //Fixture Teardown
    }
    @Test
    public void diminuirUmSemanaNegativo(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        LocalDate resultado = data.minusWeeks(-1);

        //Result Verification
        assertEquals(LocalDate.parse("2021-02-27"), resultado);

        //Fixture Teardown
    }

    @Test
    public void diminuirUmAnoNegativo(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        LocalDate resultado = data.minusYears(-1);

        //Result Verification
        assertEquals(LocalDate.parse("2022-02-20"), resultado);

        //Fixture Teardown
    }
    // _____________________
    //Feature 4: Criação de horas
    @Test
    public void criarHora(){
        // Fixture Setup

        //Exercise SUT
        LocalTime time = new LocalTime(10,30, 00);
        //Result Verification
        assertEquals(10, time.getHourOfDay());
        assertEquals(30 , time.getMinuteOfHour());
        assertEquals(00, time.getSecondOfMinute());

        //Fixture Teardown
    }

    @Test (expected = IllegalFieldValueException.class)
    public void criarHoraComHoraErrada(){
        // Fixture Setup

        //Exercise SUT
        LocalTime time = new LocalTime(24,30, 00);

        //Result Verification

        //Fixture Teardown
    }

    @Test (expected = IllegalFieldValueException.class)
    public void criarHoraComMinutoErrada(){
        // Fixture Setup

        //Exercise SUT
        LocalTime time = new LocalTime(10,61, 00);
        //Result Verification

        //Fixture Teardown
    }

    @Test (expected = IllegalFieldValueException.class)
    public void criarHoraComSegundosErrada(){
        // Fixture Setup

        //Exercise SUT
        LocalTime time = new LocalTime(10,30, 100);

        //Result Verification

        //Fixture Teardown
    }

    // Feature 5: Soma de horas
    @Test
    public void somaUmaHora(){
        // Fixture Setup
        LocalTime time = new LocalTime(10,30, 00);

        //Exercise SUT
        LocalTime resultado  = time.plusHours(1);

        //Result Verification
        assertEquals(11, resultado.getHourOfDay());
        assertEquals(30 , resultado.getMinuteOfHour());
        assertEquals(00, resultado.getSecondOfMinute());

        //Fixture Teardown
    }

    @Test
    public void somaUmMinuto(){
        // Fixture Setup
        LocalTime time = new LocalTime(10,30, 00);

        //Exercise SUT
        LocalTime resultado = time.plusMinutes(1);

        //Result Verification
        assertEquals(10, resultado.getHourOfDay());
        assertEquals(31 , resultado.getMinuteOfHour());
        assertEquals(00, resultado.getSecondOfMinute());

        //Fixture Teardown
    }

    @Test
    public void somaUmSegundo(){
        // Fixture Setup
        LocalTime time = new LocalTime(10,30, 00);

        //Exercise SUT
        LocalTime resultado = time.plusSeconds(1);

        //Result Verification
        assertEquals(10, resultado.getHourOfDay());
        assertEquals(30 , resultado.getMinuteOfHour());
        assertEquals(01, resultado.getSecondOfMinute());

        //Fixture Teardown
    }

    // Feature 6: Subtração de horas
    @Test
    public void DiminuirUmaHora(){
        // Fixture Setup
        LocalTime time = new LocalTime(10,30, 00);

        //Exercise SUT
        LocalTime resultado  = time.minusHours(1);

        //Result Verification
        assertEquals(9, resultado.getHourOfDay());
        assertEquals(30 , resultado.getMinuteOfHour());
        assertEquals(00, resultado.getSecondOfMinute());

        //Fixture Teardown
    }

    @Test
    public void DiminuirUmaMinuto(){
        // Fixture Setup
        LocalTime time = new LocalTime(10,30, 00);

        //Exercise SUT
        LocalTime resultado = time.minusMinutes(1);

        //Result Verification
        assertEquals(10, resultado.getHourOfDay());
        assertEquals(29 , resultado.getMinuteOfHour());
        assertEquals(00, resultado.getSecondOfMinute());
        //Fixture Teardown
    }

    @Test
    public void DiminuirUmaSegundo(){
        // Fixture Setup
        LocalTime time = new LocalTime(10,30, 01);

        //Exercise SUT
        LocalTime resultado = time.minusSeconds(1);

        //Result Verification
        assertEquals(10, resultado.getHourOfDay());
        assertEquals(30 , resultado.getMinuteOfHour());
        assertEquals(00, resultado.getSecondOfMinute());

        //Fixture Teardown
    }

    // Feature 7: Before e After de data/hora
    @Test
    public void testAfterDeDataEHora(){
        // Fixture Setup
        DateTime dataTime1 = new DateTime(2020, 03, 13, 11, 30, 00);
        DateTime dataTime2 = new DateTime(2020, 03, 13, 10, 30, 00);

        //Exercise SUT
        Boolean resultado = dataTime1.isAfter(dataTime2);

        //Result Verification
        assertTrue(resultado);

        //Fixture Teardown
    }
    @Test
    public void testAfterDeDataEHoraQuandoDataTime1forMenorQueDataTime2(){
        // Fixture Setup
        DateTime dataTime1 = new DateTime(2020, 03, 13, 10, 30, 00);
        DateTime dataTime2 = new DateTime(2020, 03, 13, 11, 30, 00);

        //Exercise SUT
        Boolean resultado = dataTime1.isAfter(dataTime2);

        //Result Verification
        assertFalse(resultado);

        //Fixture Teardown
    }

    @Test
    public void testAfterDeDataEHoraQuandoDataTime1forIgualDataTime2(){
        // Fixture Setup
        DateTime dataTime1 = new DateTime(2020, 03, 13, 10, 30, 00);
        DateTime dataTime2 = new DateTime(2020, 03, 13, 10, 30, 00);

        //Exercise SUT
        Boolean resultado = dataTime1.isAfter(dataTime2);

        //Result Verification
        assertFalse(resultado);

        //Fixture Teardown
    }
    // Feature 8: Criação de data/hora
    @Test
    public void criarDataEHoraCerta(){
        // Fixture Setup

        //Exercise SUT
        DateTime dataTime = new DateTime(2020, 03, 13, 10, 30, 00);

        //Result Verification
        assertEquals(2020, dataTime.getYear());
        assertEquals(03, dataTime.getMonthOfYear());
        assertEquals(13, dataTime.getDayOfMonth());
        assertEquals(10, dataTime.getHourOfDay());
        assertEquals(30, dataTime.getMinuteOfHour());
        assertEquals(00, dataTime.getMillisOfSecond());

        //Fixture Teardown
    }
    @Test (expected = IllegalFieldValueException.class)
    public void criarDataEHoraComMesErrado(){
        // Fixture Setup

        //Exercise SUT
        DateTime dataTime = new DateTime(2020, 03, 13, 25, 30, 00);

        //Result Verification

        //Fixture Teardown
    }

    @Test (expected = IllegalFieldValueException.class)
    public void criarDataEHoraComDiaErrado(){
        // Fixture Setup

        //Exercise SUT
        DateTime dataTime = new DateTime(2020, 03, 34, 3, 30, 00);

        //Result Verification

        //Fixture Teardown
    }

    @Test (expected = IllegalFieldValueException.class)
    public void criarDataEHoraComDiaHora(){
        // Fixture Setup

        //Exercise SUT
        DateTime dataTime = new DateTime(2020, 03, 1, 33, 30, 00);

        //Result Verification

        //Fixture Teardown
    }

    @Test (expected = IllegalFieldValueException.class)
    public void criarDataEHoraComMinutosErrado(){
        // Fixture Setup

        //Exercise SUT
        DateTime dataTime = new DateTime(2020, 03, 1, 3, 90, 00);

        //Result Verification

        //Fixture Teardown
    }

    @Test (expected = IllegalFieldValueException.class)
    public void criarDataEHoraComSegundosErrado(){
        // Fixture Setup

        //Exercise SUT
        DateTime dataTime = new DateTime(2020, 03, 1, 3, 30, 90);

        //Result Verification

        //Fixture Teardown
    }
    //Feature 9: Intervalo de datas (Interval)
        @Test
    public void testIntervaloDoMetodoGetEnd(){
        // Fixture Setup
        DateTime dataTime1 = new DateTime(2020, 03, 13, 10, 30, 00);
        DateTime dataTime2 = new DateTime(2020, 03, 13, 10, 30, 00);
        Interval interval = new Interval(dataTime1, dataTime2);

        //Exercise SUT
        DateTime resultado =  interval.getEnd();

        //Result Verification
        assertEquals(dataTime2, resultado);

        //Fixture Teardown
    }

    @Test
    public void testIntervaloDoMetodoGetStart(){
        // Fixture Setup

        DateTime dataTime1 = new DateTime(2020, 03, 13, 10, 30, 00);
        DateTime dataTime2 = new DateTime(2020, 03, 13, 10, 30, 00);
        Interval interval = new Interval(dataTime1, dataTime2);

        //Exercise SUT
        DateTime resultado =  interval.getStart();

        //Result Verification
        assertEquals(dataTime1, resultado);

        //Fixture Teardown
    }

    @Test
    public void testMetodoIsAfterParaIntervalo(){
        // Fixture Setup
        DateTime dataTime1 = new DateTime(2020, 03, 13, 10, 30, 00);
        DateTime dataTime2 = new DateTime(2020, 03, 13, 10, 30, 00);
        Interval interval1 = new Interval(dataTime1, dataTime2);

        DateTime dataTime3 = new DateTime(2020, 03, 14, 10, 30, 00);
        DateTime dataTime4 = new DateTime(2020, 03, 14, 10, 30, 00);
        Interval interval2 = new Interval(dataTime1, dataTime2);

        //Exercise SUT
        boolean resultado =  interval1.isAfter(interval2);
        //Result Verification
        assertTrue(resultado);

        //Fixture Teardown
    }

    @Test
    public void testMetodoIsBeforeParaIntervalo(){
        // Fixture Setup
        DateTime dataTime1 = new DateTime(2020, 03, 13, 10, 30, 00);
        DateTime dataTime2 = new DateTime(2020, 03, 13, 10, 30, 00);
        Interval interval1 = new Interval(dataTime1, dataTime2);

        DateTime dataTime3 = new DateTime(2020, 03, 14, 10, 30, 00);
        DateTime dataTime4 = new DateTime(2020, 03, 14, 10, 30, 00);
        Interval interval2 = new Interval(dataTime1, dataTime2);

        //Exercise SUT
        boolean resultado =  interval1.isBefore(interval2);
        //Result Verification
        assertTrue(resultado);

        //Fixture Teardown
    }

    // Feature 10: Outros testes
    // Testes do Método Equals para LocalDate
    @Test
    public void testarMetodoEqualsQuandoDatasSaoIguais(){
        // Fixture Setup
        LocalDate data1 = new LocalDate(2021,2,20);
        LocalDate data2 = new LocalDate(2021,2,20);

        //Exercise SUT
        boolean resultado = data1.equals(data2);

        //Result Verification
        assertTrue(resultado);

        //Fixture Teardown
    }

    @Test
    public void testarMetodoEqualsQuandoDatasTemDiasDifierentes(){
        // Fixture Setup
        LocalDate data1 = new LocalDate(2021,2,20);
        LocalDate data2 = new LocalDate(2021,2,21);

        //Exercise SUT
        boolean resultado = data1.equals(data2);

        //Result Verification
        assertFalse(resultado);

        //Fixture Teardown
    }

    @Test
    public void testarMetodoEqualsQuandoDatasTemMesDifierentes(){
        // Fixture Setup
        LocalDate data1 = new LocalDate(2021,2,20);
        LocalDate data2 = new LocalDate(2021,12,20);

        //Exercise SUT
        boolean resultado = data1.equals(data2);

        //Result Verification
        assertFalse(resultado);

        //Fixture Teardown
    }

    @Test
    public void testarMetodoEqualsQuandoDatasTemAnoDifierentes(){
        // Fixture Setup
        LocalDate data1 = new LocalDate(2021,2,20);
        LocalDate data2 = new LocalDate(2022,2,20);

        //Exercise SUT
        boolean resultado = data1.equals(data2);

        //Result Verification
        assertFalse(resultado);
        //Fixture Teardown
    }

    // Testes do Método CompareTo para LocalDate
    @Test
    public void testarMetodoCompareToQuandoData1EhMaiorQueData2(){
        // Fixture Setup
        LocalDate data1 = new LocalDate(2021,2,20);
        LocalDate data2 = new LocalDate(2021,2,19);
        //Exercise SUT
        int resultado = data1.compareTo(data2);

        //Result Verification
        assertEquals(1, resultado);

        //Fixture Teardown
    }

    @Test
    public void testarMetodoCompareToQuandoData1EhMenorQueData2(){
        // Fixture Setup
        LocalDate data1 = new LocalDate(2021,2,18);
        LocalDate data2 = new LocalDate(2021,2,19);

        //Exercise SUT
        int resultado = data1.compareTo(data2);

        //Result Verification
        assertEquals(-1, resultado);
        //Fixture Teardown
    }

    @Test
    public void testarMetodoCompareToQuandoData1EhIgualQueData2(){
        // Fixture Setup
        LocalDate data1 = new LocalDate(2021,2,20);
        LocalDate data2 = new LocalDate(2021,2,20);

        //Exercise SUT
        int resultado = data1.compareTo(data2);

        //Result Verification
        assertEquals(0, resultado);

        //Fixture Teardown
    }
    // Testes do Metodo GetWeekOfWeekyear para LocalDate
    @Test
    public void testarMetodoGetWeekOfWeekyearQuandoDataEhNaOitavaSemana(){
        //Obs.: Padrao americano é começar a contagem no valor 0
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        data.getWeekOfWeekyear();

        //Result Verification
        assertEquals(7, data.getWeekOfWeekyear());

        //Fixture Teardown
    }

    // Testes do Método GetYearOfCentury para LocalDate
    @Test
    public void testarMetodoGetYearOfCentury(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        int era = data.getYearOfCentury();

        //Result Verification
        assertEquals(21, era);

        //Fixture Teardown
    }

}