package ru.intensive.dz4;

public class NonStaticInnerUser {
    private String login;
    private String password;

    private NonStaticInnerUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    private void createQuery() {
        Query.printToLog(login, password);
    }

    private static class Query {
        public static void printToLog(String login, String password) {
            System.out.println("User with login " + login + " and password " + password + " sent a query.");
        }
    }

    public static void main(String[] args) {
        NonStaticInnerUser user = new NonStaticInnerUser("example_login", "example_password");
        user.createQuery();

        Query.printToLog("another_login", "another_password");
    }
}