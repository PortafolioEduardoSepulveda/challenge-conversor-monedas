package com.aluracursos.challenge;


import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public record Moneda(String result,
                     String documentation,
                     String terms_of_use,
                     String time_last_update_unix,
                     String time_last_update_utc,
                     String time_next_update_unix,
                     String time_next_update_utc,
                     String base_code,
                     List<Monedas> conversion_rates
                     ) {


}
