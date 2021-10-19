package br.inatel.c207;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        database.connect();
        User user = new User("Matheus", "111.111.111-11");
        User user1 = new User("Arthur", "222.222.222-22");
        User user2 = new User("Gabriel", "333.333.333-33");
        database.insertUser(user);
        database.insertUser(user1);
        database.insertUser(user2);

        database.researchUser();
        System.out.println("+#################CPF#################+");
        database.researchUserCpf("111.111.111-11");
        System.out.println("#####################################");
        database.updateUser(1, "Matheusinho");

        database.researchUser();

        System.out.println("#####################################");
        database.deleteUser(1);
        database.researchUser();
    }

}
