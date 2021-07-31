package ar.com.ada.api.aladas;

import static org.junit.jupiter.api.Assertions.*;

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
	void vueloTestPrecioNegativo(){

		Vuelo vueloConPrecioNegativo = new Vuelo();
		vueloConPrecioNegativo.setPrecio(new BigDecimal(-100));
		//Assert: afirmar
		//afirmar que sea verdadero
		assertFalse(vueloService.validarPrecio(vueloConPrecioNegativo));
	}
	void vueloTestPrecioOk(){

		Vuelo vueloConPrecioOk = new Vuelo();
		vueloConPrecioOk.setPrecio(new BigDecimal(100));
		//Assert: afirmar
		//afirmar que sea verdadero
		assertTrue(vueloService.validarPrecio(vueloConPrecioOk));
	}
}
