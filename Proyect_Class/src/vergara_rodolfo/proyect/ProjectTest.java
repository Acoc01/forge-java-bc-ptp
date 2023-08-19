package vergara_rodolfo.proyect;

public class ProjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Project pj = new Project();
		pj.setName("proyecto1");
		pj.setDescription("test");
		Project pj2 = new Project("proyecto2");
		Project pj3 = new Project("proyecto3","sobre carga de constructor");
		System.out.println(pj.elevatorPitch());
		System.out.println(pj2.elevatorPitch());
		System.out.println(pj3.elevatorPitch());
	}

}
