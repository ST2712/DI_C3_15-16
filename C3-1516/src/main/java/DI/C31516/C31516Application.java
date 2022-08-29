package DI.C31516;

import DI.C31516.domain.Empleado;
import DI.C31516.domain.Empresa;
import DI.C31516.domain.MovimientoDinero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class C31516Application {

	public static void main(String[] args) {
		SpringApplication.run(C31516Application.class, args);

		Empresa empresaDI = new Empresa();
		empresaDI.setNombre("Empresa Desarroladores integrales");
		empresaDI.setDireccion("Medellin, Cra 1 Calle 10 #20-30");
		empresaDI.setNit(987654321);
		empresaDI.setTelefono(123456);

		System.out.println("-------------------------------------------------------");
		System.out.println("Nombre de la empresa: " + empresaDI.getNombre());
		System.out.println("Direccion de la empresa: " + empresaDI.getDireccion());
		System.out.println("Nit de la empresa: " + empresaDI.getNit());
		System.out.println("Telefono de la empresa: " + empresaDI.getTelefono());

		Empleado empleadoJuan = new Empleado();
		empleadoJuan.setNombre("Juan");
		empleadoJuan.setNumCedula(93390000);
		empleadoJuan.setCorreo("juan9@gmail.com");
		empleadoJuan.setEmpresaPertenece(empresaDI);
		empleadoJuan.setRolEmpleado(Empleado.Rol.ADMINISTRADOR);

		System.out.println("-------------------------------------------------------");
		System.out.println("Nombre del empleado: " + empleadoJuan.getNombre());
		System.out.println("Cedula del empleado: " + empleadoJuan.getNumCedula());
		System.out.println("Correo del empleado: " + empleadoJuan.getCorreo());
		System.out.println("Empresa a la que pertence el empleado: " + empresaDI.getNombre());
		System.out.println("Rol del empleado: " + empleadoJuan.getRolEmpleado());

		MovimientoDinero movimientoDinero = new MovimientoDinero();
		movimientoDinero.setConceptoMovimiento("Pago nomina");
		movimientoDinero.setMontoMovimientoDinero(3500000);
		movimientoDinero.setEmpleado(empleadoJuan);

		System.out.println("-------------------------------------------------------");
		System.out.println("Concepto del movimiento: " + movimientoDinero.getConceptoMovimiento());
		System.out.println("Monto del movimiento: " + movimientoDinero.getMontoMovimientoDinero());
		System.out.println("Empleado que realizo el movimiento: " + movimientoDinero.getEmpleado().getNombre());

	}

}
