package ru.intensive.dz4;

public class LocalInnerUser {
    void myMethod() {
        String login = "TestUser";
        String password = "TestPassword";
        class Query {
            public void printToLog() {
                System.out.printf("User %s, %s send a query.%n", login, password);
            }
        }
        void createQuery() {
            Query query = new Query();
            query.printToLog(login, password);
        }
        Query query = new Query();
        query.printToLog();


    }

    public static void main(String[] args) {
        LocalInnerUser localInnerUser = new LocalInnerUser();
        localInnerUser.myMethod();

    }

}
