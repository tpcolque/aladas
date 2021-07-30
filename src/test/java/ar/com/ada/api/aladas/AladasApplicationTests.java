package ar.com.ada.api.aladas;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.ada.api.aladas.entities.Vuelo;
import ar.com.ada.api.aladas.services.VueloService;

@SpringBootTest
class AladasApplicationTests {

	@Autowired
	VueloService vueloService;
	
	@Test
	void vueloPrecio(){

		Vuelo vueloConPrecioNegativo = new Vuelo();
		vueloConPrecioNegativo.setPrecio(new BigDecimal(-100));
		//Assert: afirmar
		//afirmar que sea verdadero
		assertTrue(vuelo)
	}
}
