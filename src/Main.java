import exerciceone.ExerciceOne;
import exercicetwo.ExerciceTwo;

public class Main {
    public static void main(String[] args) {

        System.out.println("======== EXERCICE 1 ==========\n");
        System.out.println("Affected rows for update: " + ExerciceOne.updateTable());


        System.out.println("\n======== EXERCICE 2 ==========\n");

        System.out.println("Affected rows for delete: " + ExerciceTwo.deleteTable());

    }
}