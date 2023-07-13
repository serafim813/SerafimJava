package ru.intensive.dz4;

public class StaticInnerUser {
    static void createQuery(String login, String password) {
        Query query = new Query();
        query.printToLog(login, password);
    }
    static class Query {
        public static void printToLog(String login, String password) {
            System.out.printf("User %s, %s send a query.%n", login, password);
        }
    }

    public static void main(String[] args) {
        StaticInnerUser staticInnerUser = new StaticInnerUser();
        staticInnerUser.createQuery("TestUser","TestPassword");
        Query query = new Query();
        query.printToLog("TestUser","TestPassword");
    }

}