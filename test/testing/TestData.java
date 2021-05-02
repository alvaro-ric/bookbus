/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Philip
 */
public class TestData {

    static java.sql.Date sqlDate;
    static java.sql.Timestamp sqlTime;
    java.sql.Timestamp now;
    
    public TestData() {
        java.util.Date date = new java.util.Date();
        sqlDate = new java.sql.Date(date.getTime());
        sqlTime = new java.sql.Timestamp(date.getTime());
    }

    static java.util.Date date = new java.util.Date();
    static Timestamp ts = new Timestamp(date.getTime());
    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Operation INSERT_ADMIN_ACCOUNT
            = Operations.insertInto("adminaccount")
                    .columns("id", "account_role", "accountstatus", "email", "password")
                    .values(1, "SUPER_ADMIN", "APPROVED", "super@gmail.com", "super@pass")
                    .build();

    public static Operation INSERT_MANAGER
            = Operations.insertInto("manager")
                    .columns("id", "firstname", "lastname", "phonenumber    ")
                    .values(1, "karenzi", "jack", "07888868768")
                    .values(2, "isimbi", "sonia", "0676768")
                    .build();

    public static Operation INSERT_COMPANY
            = Operations.insertInto("company")
                    .columns("id", "companysize", "companystatus", "createdon", "name", "manager_id")
                    .values(1, "11-50", "CREATED", new Date(), "sample", 1)
                    .values(2, "11-50", "CREATED", new Date(), "anothersample", 2)
                    .build();

    public static Operation INSERT_MANAGER_ACCOUNT
            = Operations.insertInto("manageraccount")
                    .columns("id", "account_role", "accountstatus", "email", "password", "company_id", "manager_id")
                    .values(1, "COMPANY", "CREATED", "kabadany25@gmail.com", "123456789", 1, 1)
                    .values(2, "COMPANY", "CREATED", "jackmu@gmail.com", "murenzi123", 2, 2)
                    .build();

    public static Operation INSERT_COMPANY_STATE
            = Operations.insertInto("companystate")
                    .columns("id", "companystatus", "updateon", "company_id", "doneby_id")
                    .values(1, "CREATED", new Date(), 1, 1)
                    .values(2, "CREATED", new Date(), 2, 1)
                    .build();

    public static Operation INSERT_ACCOUNT_STATE
            = Operations.insertInto("accountstate")
                    .columns("id", "accountstatus", "updateon", "doneby_id", "manageraccount_id")
                    .values(1, "CREATED", Timestamp.valueOf(formatter.format(ts)), 1, 1)
                    .build();

    public static Operation INSERT_ROUTE
            = Operations.insertInto("route")
                    .columns("id", "destination", "source", "status")
                    .values(100, "kigali", "rwamagana", "ACTIVE")
                    .values(200, "kigali", "huye", "ACTIVE")
                    .values(300, "kigali", "kayonza", "ACTIVE")
                    .build();
    public static Operation INSERT_COMPANY_ROUTE
            = Operations.insertInto("companyroute")
                    .columns("company_route_id", "registered_date", "routestatus", "company_id", "route_id")
                    .values(1, new Date(), "APPROVED", 1, 100)
                    .values(2, new Date(), "APPROVED", 1, 200)
                    .build();

    public static Operation INSERT_JOURNEY
            = Operations.insertInto("journey")
                    .columns("id", "createdat", "departuredate", "departuretime", "journeystatus", "plateno", "price", "seats", "taken", "version", "company_id", "route_id")
                    .values(1, Timestamp.valueOf(formatter.format(ts)),sqlDate , sqlTime, "BOOKING", "RAB 312 C", 3000, 40, 0, 1, 1, 100)
                    .values(2, Timestamp.valueOf(formatter.format(ts)),sqlDate , sqlTime, "BOOKING", "RAB 219 C", 2000, 40, 0, 1, 1, 200)
                    .build();
    
    public static Operation INSERT_PASSENGER
            = Operations.insertInto("passenger")
                    .columns("id", "firstname", "lastname", "phonenumber")
                    .values(100, "mihigo", "yves", "07877689")
                    .values(200, "shyaka", "patrick", "07897089")
                    .values(300, "iradukunda", "alvaro", "088799")
                    .build();
    
    public static Operation INSERT_TICKET
            = Operations.insertInto("ticket")
                    .columns("id", "boughton", "amount", "ticketstatus", "company_id", "journey_id", "passenger_id")
                    .values(1, Timestamp.valueOf(formatter.format(ts)), 3000, 1, 1, 1, 100)
                    .values(2, Timestamp.valueOf(formatter.format(ts)), 2000, 1, 1, 2, 200)
                    .build();

    public static Operation DELETE_ADMIN_ACCOUNT
            = Operations.deleteAllFrom("adminaccount");

    public static Operation DELETE_MANAGER
            = Operations.deleteAllFrom("manager");

    public static Operation DELETE_COMPANY
            = Operations.deleteAllFrom("company");
    
    public static Operation DELETE_MANAGER_ACCOUNT
            = Operations.deleteAllFrom("manageraccount");
    
    public static Operation DELETE_COMPANY_STATE
            = Operations.deleteAllFrom("companystate");
    
    public static Operation DELETE_ACCOUNT_STATE
            = Operations.deleteAllFrom("accountstate");
    
    public static Operation DELETE_ROUTE
            = Operations.deleteAllFrom("route");
    
    public static Operation DELETE_COMPANY_ROUTE
            = Operations.deleteAllFrom("companyroute");
    
    public static Operation DELETE_JOURNEY
            = Operations.deleteAllFrom("journey");
    
    public static Operation DELETE_PASSENGER
            = Operations.deleteAllFrom("passenger");
    
    public static Operation DELETE_TICKET
            = Operations.deleteAllFrom("ticket");
    
    
}
