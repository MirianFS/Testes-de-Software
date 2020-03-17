import org.joda.time.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class Testes_13_03_2020 {

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
    public void testarMetodoplusDaysQuandoEhAdicionado1(){
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
    public void testarMetodoplusDaysQuandoEhAdicionadoMenos1(){
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
    public void testarMetodoplusMonthsQuandoEhAdicionado1(){
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
    public void testarMetodoplusYearsQuandoEhAdicionado1(){
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
    public void testarMetodoplusplusWeeksQuandoEhAdicionado1(){
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
    public void testarMetodoMinusDaysQuandoEhAdicionado1(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        LocalDate resultado = data.minusDays(1);

        //Result Verification
        assertEquals(LocalDate.parse("2021-02-19"), resultado);
        //Fixture Teardown
    }

    @Test
    public void testarMetodoMinusMonthsQuandoEhAdicionado1(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        LocalDate resultado = data.minusMonths(1);

        //Result Verification
        assertEquals(LocalDate.parse("2021-01-20"), resultado);
        //Fixture Teardown
    }
    @Test
    public void testarMetodoMinusWeeksQuandoEhAdicionado1(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        LocalDate resultado = data.minusWeeks(1);

        //Result Verification
        assertEquals(LocalDate.parse("2021-02-13"), resultado);
        //Fixture Teardown
    }

    @Test
    public void testarMetodoMinusYearsQuandoEhAdicionado1(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        LocalDate resultado = data.minusYears(1);

        //Result Verification
        assertEquals(LocalDate.parse("2020-02-20"), resultado);
        //Fixture Teardown
    }

    @Test
    public void testarMetodoMinusDaysQuandoEhAdicionadoMenos1(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        LocalDate resultado = data.minusDays(-1);

        //Result Verification
        assertEquals(LocalDate.parse("2021-02-21"), resultado);
        //Fixture Teardown
    }

    @Test
    public void testarMetodoMinusMonthsQuandoEhAdicionadoMenos1(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        LocalDate resultado = data.minusMonths(-1);

        //Result Verification
        assertEquals(LocalDate.parse("2021-03-20"), resultado);
        //Fixture Teardown
    }
    @Test
    public void testarMetodoMinusWeeksQuandoEhAdicionadoMenos1(){
        // Fixture Setup
        LocalDate data = new LocalDate(2021,2,20);

        //Exercise SUT
        LocalDate resultado = data.minusWeeks(-1);

        //Result Verification
        assertEquals(LocalDate.parse("2021-02-27"), resultado);
        //Fixture Teardown
    }

    @Test
    public void testarMetodoMinusYearsQuandoEhAdicionadoMenos1(){
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
    public void testCriacaoDeHoras(){
        // Fixture Setup
        LocalTime time = new LocalTime(10,30, 00);

        //Exercise SUT

        //Result Verification
        assertEquals(10, time.getHourOfDay());
        assertEquals(30 , time.getMinuteOfHour());
        assertEquals(00, time.getSecondOfMinute());
        //Fixture Teardown
    }

    @Test (expected = IllegalFieldValueException.class)
    public void testCriacaoDeHoraErrada(){
        // Fixture Setup
        LocalTime time = new LocalTime(24,30, 00);

        //Exercise SUT

        //Result Verification

        //Fixture Teardown
    }

    @Test (expected = IllegalFieldValueException.class)
    public void testCriacaoDeHora_MinutoErrada(){
        // Fixture Setup
        LocalTime time = new LocalTime(10,61, 00);

        //Exercise SUT

        //Result Verification

        //Fixture Teardown
    }

    @Test (expected = IllegalFieldValueException.class)
    public void testCriacaoDeHora_SegundosErrada(){
        // Fixture Setup
        LocalTime time = new LocalTime(10,30, 100);

        //Exercise SUT

        //Result Verification

        //Fixture Teardown
    }

    // Feature 5: Soma de horas
    @Test
    public void testSomaHoras(){
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
    public void testSomaMinutosHoras(){
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
    public void testSomaSegundosHoras(){
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
    public void testMenosHoras(){
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
    public void testMenosMinutosHoras(){
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
    public void testMenosSegundosHoras(){
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
    public void testBeforeDeDataEHora(){
        // Fixture Setup
        DateTime dataTime1 = new DateTime(2020, 03, 13, 10, 30, 00);
        DateTime dataTime2 = new DateTime(2020, 03, 13, 11, 30, 00);
        //Exercise SUT
        Boolean resultado = dataTime1.isBefore(dataTime2);
        //Result Verification
        assertTrue(resultado);
        //Fixture Teardown
    }
    //______________

    @Test
    public void CriacaoDeDataEHoraCerta(){
        // Fixture Setup
        DateTime dataTime = new DateTime(2020, 03, 13, 10, 30, 00);

        //Exercise SUT

        //Result Verification
        assertEquals(2020, dataTime.getYear());
        assertEquals(03, dataTime.getMonthOfYear());
        assertEquals(13, dataTime.getDayOfMonth());
        assertEquals(10, dataTime.getHourOfDay());
        assertEquals(30, dataTime.getMinuteOfHour());
        assertEquals(00, dataTime.getMillisOfSecond());
        //Fixture Teardown
    }




    // _____________________
    @Test
    public void testarMetodoIsAfterQuandoData1EhIgualAData2(){
        // Fixture Setup
        LocalDate data1 = new LocalDate(2021,2,20);
        LocalDate data2 = new LocalDate(2021,2,20);

        //Exercise SUT
        boolean resultado = data1.isAfter(data2);

        //Result Verification
        assertFalse(resultado);
        //Fixture Teardown
    }

    @Test
    public void testarMetodoIsAfterQuandoData1EhMenorData2(){
        // Fixture Setup
        LocalDate data1 = new LocalDate(2021,2,19);
        LocalDate data2 = new LocalDate(2021,2,20);

        //Exercise SUT
        boolean resultado = data1.isAfter(data2);

        //Result Verification
        assertFalse(resultado);
        //Fixture Teardown
    }

    @Test
    public void testarMetodoIsAfterQuandoData1EhMaiorData2(){
        // Fixture Setup
        LocalDate data1 = new LocalDate(2021,2,21);
        LocalDate data2 = new LocalDate(2021,2,20);

        //Exercise SUT
        boolean resultado = data1.isAfter(data2);

        //Result Verification
        assertTrue(resultado);
        //Fixture Teardown
    }
    // Testes complementares, só para testar todas os metodos
    @Test
    public void testarMetodoIsBefore(){
        // Fixture Setup
        LocalDate data1 = new LocalDate(2021,2,19);
        LocalDate data2 = new LocalDate(2021,2,20);

        //Exercise SUT
        boolean resultado = data1.isBefore(data2);

        //Result Verification
        assertTrue(resultado);
        //Fixture Teardown
    }

    @Test
    public void testarMetodoCenturyOfEra(){
        //Obs.: Padrao americano é começar a contagem no valor 0
        // Fixture Setup
        LocalDate data1 = new LocalDate(2021,2,19);

        //Exercise SUT
        LocalDate.Property resultado = data1.centuryOfEra();

        //Result Verification
        assertEquals(20 , resultado.get());
        //Fixture Teardown
    }

    @Test
    public void testarMetodoDayOfMonth(){
        //Obs.: Padrao americano é começar a contagem no valor 0
        // Fixture Setup
        LocalDate data1 = new LocalDate(2021,2,19);

        //Exercise SUT
        LocalDate.Property resultado = data1.dayOfMonth();

        //Result Verification
        assertEquals(19 , resultado.get());
        //Fixture Teardown
    }

    @Test
    public void testarMetodoDayOfWeek(){
        // Fixture Setup
        LocalDate data1 = new LocalDate(2021,2,21);

        //Exercise SUT
        LocalDate.Property resultado = data1.dayOfWeek();

        //Result Verification
        assertEquals(7 , resultado.get());
        //Fixture Teardown
    }

    //________________________________________________________________


    @Test
    public void testBeforeDeHoras(){
        // Fixture Setup
        LocalTime time1 = new LocalTime(10,30, 00);
        LocalTime time2 = new LocalTime(12,30, 00);
        //Exercise SUT
        Boolean resultado = time1.isBefore(time2);
        //Result Verification
        assertTrue(resultado);
        //Fixture Teardown
    }

    @Test
    public void testAfterDeHoras(){
        // Fixture Setup
        LocalTime time1 = new LocalTime(12,30, 00);
        LocalTime time2 = new LocalTime(10,30, 00);
        //Exercise SUT
        Boolean resultado = time1.isAfter(time2);
        //Result Verification
        assertTrue(resultado);
        //Fixture Teardown
    }


    @Test
    public void Intervalo(){
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
    // Testes do Método GetWeekOfWeekyear para LocalDate
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