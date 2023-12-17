package krakedev.entidades;

import java.util.ArrayList;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String cedula;
	private ArrayList<Nota> listaNotas;

	public Estudiante(String nombre, String apellido, String cedula) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.listaNotas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public ArrayList<Nota> getListaNotas() {
		return listaNotas;
	}

	public void setListaNotas(ArrayList<Nota> listaNotas) {
		this.listaNotas = listaNotas;
	}

	public void agregarNota(Nota nuevaNota) {

		boolean notaExiste = false;
		if (listaNotas != null) {
			for (Nota nota : listaNotas) {
				if (nota.getMateria().getCodigo().equals(nuevaNota.getMateria().getCodigo())
						&& nuevaNota.getCalificacion() >= 0 && nuevaNota.getCalificacion() <= 10) {
					notaExiste = true;
					System.out.println("El codigo de la nota ya existe ! Calificacion duplicada");
				}
			}

			if (notaExiste == false) {
				listaNotas.add(nuevaNota);
			}
		}
	}

	public void modificarNota(String codigo, double nuevaNota) {
		if (listaNotas != null) {
			boolean codigoEncontrado = false;
			for (Nota nota : listaNotas) {
				if (nota.getMateria().getCodigo().equals(codigo)) {
					codigoEncontrado = true;
					if (nuevaNota >= 0 && nuevaNota <= 10) {
						nota.setCalificacion(nuevaNota);
					} else {
						System.out.println("La calificacion no valida (0 - 10)");
					}
				}
			}

			if (!codigoEncontrado) {
				System.out.println("Codigo no econtrado !");
			}
		}
	}

	public double calcularPromedioNotasEstudiante() {
		double sumarNotas = 0;
		double promedio = 0;

		ArrayList<Materia> listaMaterias = new ArrayList<Materia>();
		if (listaNotas != null) {
			for (Nota nota : listaNotas) {
				Materia materia = nota.getMateria();
				sumarNotas += nota.getCalificacion();

				// verifica si la materia esta en la lista de materias si no la agrega
				if (!listaMaterias.contains(materia)) {
					listaMaterias.add(materia);
				}
			}
		}
		int cantidadMaterias = listaMaterias.size();
		if (cantidadMaterias > 0) {
			promedio = sumarNotas / cantidadMaterias;
			System.out.print("Promedio: ");
			return promedio;
		} else {
			System.out.println("La cantidad de materias es menor a 0 o no existen materias");
		}
		return 0;

	}

	public void mostrar() {
		System.out.println("--- Informacion del Estudiante ---");
		if (listaNotas != null) {
			for (Nota nota : listaNotas) {
				System.out.println("Estudiante [Nombre=" + nombre + ", Apellido=" + apellido + ", Cedula=" + cedula
						+ ", Nota=" + nota.getCalificacion() + "]");

			}
		}
	}
}
