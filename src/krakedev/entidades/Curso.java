package krakedev.entidades;

import java.util.ArrayList;

public class Curso {

	private ArrayList<Estudiante> listaEstudiantes;

	public Curso() {
		this.listaEstudiantes = new ArrayList<>();
	}

	public Curso(ArrayList<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	public Estudiante buscarPorCedula(Estudiante estudiante) {
		if (listaEstudiantes != null) {
			for (Estudiante estudiante1 : listaEstudiantes) {
				if (estudiante.getCedula().equals(estudiante1.getCedula())) {
					return estudiante1;
				}
			}
		}
		return null;
	}

	public void matricularEstudiantes(Estudiante estudiante) {
		if (listaEstudiantes != null) {
			if (buscarPorCedula(estudiante) != null) {
				System.out.println("El estudiante ya se encuentra matriculado !");
			} else {
				listaEstudiantes.add(estudiante);
			}
		}
	}

	public double calcularPromedioCurso() {
		double sumaPromedios = 0;
		int aux = 0;
		if (listaEstudiantes != null) {
			for (Estudiante estudiante : listaEstudiantes) {
				double promedioEstudiantes = estudiante.calcularPromedioNotasEstudiante();
				if (promedioEstudiantes > 0) {
					sumaPromedios += promedioEstudiantes;
					aux++;
				}
			}
		}

		if (aux > 0) {
			double promedioCurso = sumaPromedios / aux;
			return promedioCurso;
		} else {
			System.err.println("No hay estudiantes !");
			return 0;
		}
	}

	public void mostrar() {
		System.out.println("--- Informacion del Curso ---");
		if (listaEstudiantes != null) {
			for (Estudiante estudiante : listaEstudiantes) {
				if (estudiante.getListaNotas() != null && !estudiante.getListaNotas().isEmpty()) {
					System.out.println("Curso [Nombre=" + estudiante.getNombre() + ", Apellido="
							+ estudiante.getApellido() + ", Cedula=" + estudiante.getCedula() + ", Notas="
							+ estudiante.getListaNotas().size() + ", Materia="
							+ estudiante.getListaNotas().get(0).getMateria().getNombre() + "]");
				} else {
					System.out.println(
							"Curso [Nombre=" + estudiante.getNombre() + ", Apellido=" + estudiante.getApellido()
									+ ", Cedula=" + estudiante.getCedula() + ", Notas=0" + ", Materia=N/A]");
				}
			}
		}
	}

}
